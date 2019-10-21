package manager;

import java.nio.Buffer;

public class HeapFile {
    RelDef relDef;


    public void createNewOnDisk(){
        DiskManager.getInstance().CreateFile(relDef.getFileIdx());
        PageId pageid = DiskManager.getInstance().AddPage(relDef.getFileIdx());
        byte[] buff = BufferManager.getInstance().GetPage(pageid);
        for(int i =0;i<Constants.pageSize;i++){
            buff[i]=0;
        }
        BufferManager.getInstance().FreePage(pageid,false);

    }
}
