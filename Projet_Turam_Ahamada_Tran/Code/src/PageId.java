
public class PageId {
	private long FileIdx;
	private long PageIdx;
	
	
	public PageId(long FileIdx,long PageIdx) {
		this.PageIdx = PageIdx;
		this.FileIdx = FileIdx;
	}




	public long getFileIdx() {
		return FileIdx;
	}

	public String getFileName() {
		String nomfichier = "Data_"+FileIdx;
		return nomfichier;
	}


	public void setFileIdx(long fileIdx) {
		FileIdx = fileIdx;
	}




	public long getPageIdx() {
		return PageIdx;
	}




	public void setPageIdx(long pageIdx) {
		PageIdx = pageIdx;
	}




	public void setPageIdx(int pageIdx) {
		PageIdx = pageIdx;
	}


	public void setFileIdx(int fileIdx) {
		FileIdx = fileIdx;
	}
}