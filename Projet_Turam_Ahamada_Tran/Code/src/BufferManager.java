package manager;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferManager {

	private Frame[] frames;
	private BufferManager() {
		frames = new Frame[Constants.frameCount];
		for(int i=0;i<Constants.frameCount;i++){
			frames[i]= new Frame();
		}
	}
	private static BufferManager INSTANCE = new BufferManager();
	
	public static BufferManager getInstance() {
		return INSTANCE;
    }
	
	public byte[] GetPage(PageId pageId) {
		byte[] buff = new byte[(int)Constants.pageSize];
		boolean modifie = true;
		for (int i=0; (i<frames.length);i++){
				if (frames[i].getPageId() == pageId) {
					frames[i].setPinCount(frames[i].getPinCount()+1);
					modifie = false;
			}
			if(frames[i].getPageId()==null){
				frames[i].setPinCount(1);
				DiskManager.getInstance().ReadPage(pageId,buff);
				frames[i].setBuff(buff);
				frames[i].setPageId(pageId);
				modifie = false;
			}
		}
		if(modifie){
			// faire la clock ou lru mdr pour remplacer une page dans le frames

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
