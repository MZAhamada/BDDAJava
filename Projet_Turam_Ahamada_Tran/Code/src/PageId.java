package manager;

public class PageId {
	private int FileIdx;
	private int PageIdx;

	
	
	public PageId(int FileIdx, int PageIdx) {
		this.PageIdx = PageIdx;
		this.FileIdx = FileIdx;
	}

	public long getFileIdx() {
		return FileIdx;
	}

	public String getFileName() {
		String nomfichier = "Data_"+FileIdx+".rf";
		return nomfichier;
	}


	public long getPageIdx() {
		return PageIdx;
	}



	public void setPageIdx(int pageIdx) {
		PageIdx = pageIdx;
	}


	public void setFileIdx(int fileIdx) {
		FileIdx = fileIdx;
	}
}