import java.nio.ByteBuffer;
import java.io.IOException;
import java.io.RandomAccessFile;
public class DiskManager {

	public void CreateFile(int fileIdx) {
		String nomfichier = "Data_"+fileIdx;
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
	public PageId AddPage(int fileIdx) {
		
		String nomfichier = "Data_"+fileIdx;
		PageId pageid  = null;
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
		
			long taille = rf.length();
			rf.setLength(taille+Constants.pageSize);
			// .seek si besoin
			pageid = new PageId(fileIdx,(taille/Constants.pageSize)-1);
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
		return pageid;
	}
	
	public void ReadPage(PageId PageId,byte[] buff) {
		String nomfichier = PageId.getFileName();
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			for(int i=0;i<buff.length;i++) {
				buff[i] = rf.readByte();
			}
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
	public void WritePage(PageId PageId,byte[] buff) {
		String nomfichier = PageId.getFileName();
		try { 
			RandomAccessFile rf = new RandomAccessFile(nomfichier,"rw");
			rf.seek(Constants.pageSize*PageId.getPageIdx());
			rf.write(buff);
			rf.close();
		}
	    catch(IOException e) {e.printStackTrace();}
	}
}
