
public class BufferManager {
	
	private BufferManager() {
	}
	private static BufferManager INSTANCE = new BufferManager();
	
	public static BufferManager getInstance()
    {   return INSTANCE;
    }
	
	public byte[] GetPage(PageId pageId) {
		
	}
	
	public void FreePage(PageId pageId,boolean valdirty) {
		
		if (valdirty) {
			pageId.setPinCount(pageId.getPinCount()--);
			pageId.setFlagDirty(0);
		}
		else {
			/////////////// A REMPLIR
		}
	}
	public void FlushAll() {
		
	}
}
