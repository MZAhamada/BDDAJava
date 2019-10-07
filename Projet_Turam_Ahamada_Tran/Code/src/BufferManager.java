import java.io.IOException;
import java.io.RandomAccessFile;

public class BufferManager {
	
	private BufferManager() {
	}
	private static BufferManager INSTANCE = new BufferManager();
	
	public static BufferManager getInstance()
    {   return INSTANCE;
    }
	
	public byte[] GetPage(PageId pageId) {

		byte[] buff = new byte[(int)Constants.pageSize];
		DiskManager.getInstance().ReadPage(pageId,buff);
		return buff;


	}
	
	public void FreePage(PageId pageId,boolean valdirty) {
		
		if (valdirty) {
			pageId.setPinCount(pageId.getPinCount()-1);
			pageId.setFlagDirty(1);
		}
		else {
			pageId.setPinCount(pageId.getPinCount()-1);
		}
	}
	public void FlushAll() {
		
	}
}
