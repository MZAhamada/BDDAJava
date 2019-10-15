package manager;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferManager {

	private Frame[] frames = new Frame[Constants.frameCount];
	private BufferManager() {
	}
	private static BufferManager INSTANCE = new BufferManager();
	
	public static BufferManager getInstance()
    {   return INSTANCE;
    }
	
	public byte[] GetPage(PageId pageId) {
		boolean modifie = false;
		byte[] buff = new byte[(int)Constants.pageSize];

		for (int i=0; (i<frames.length)&&(modifie==false);i++) {
			if (pageId.getPageIdx() == frames[i].getPageId().getPageIdx()) {
				frames[i].setPinCount(frames[i].getPinCount() + 1);
				DiskManager.getInstance().ReadPage(pageId,buff);
				frames[0].setBuff(buff);
				modifie = true;
			}
		}
		if (modifie == false){
			/*
			Changer intelligement en fonction de flag dirty avec les algorithmes LRU ou Clock
			 */
			frames[0].setPageId(pageId);
			frames[0].setPinCount(1);
			DiskManager.getInstance().ReadPage(pageId,buff);
			frames[0].setBuff(buff);
		}

		return buff;
	}
	
	public void FreePage(PageId pageId,boolean valdirty) {

		for (int i=0; (i<frames.length);i++) {
			if (pageId.getPageIdx() == frames[i].getPageId().getPageIdx()) {
				if (valdirty) {
					frames[i].setPinCount(frames[i].getPinCount()-1);
					frames[i].setFlagDirty(true);
				}
				else {
					frames[i].setPinCount(frames[i].getPinCount()-1);
				}

			}
		}


	}
	public void FlushAll() {
		for(int i = 0; i<frames.length; i++)
		{
			if(!frames[i].isFlagDirty()) {
				frames[i].setPinCount(0);
				frames[i].setFlagDirty(true);
				frames[i].setBuff(null);
			}
		}
	}

}
