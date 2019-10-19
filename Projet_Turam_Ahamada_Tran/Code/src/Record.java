package manager;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class Record {
    private RelDef relDef;
    private Object [] values;

    public Record(RelDef relDef, Object[] values) {
        this.relDef = relDef;
        this.values = values;
    }

    public void writeToBuffer(byte[] buff,int position) {
        ByteBuffer buffer = ByteBuffer.wrap(buff);
        int pos = position;
        for(int i=0; i<values.length;i++){
            if(values[i] instanceof Integer) {
                int j = (int)values[i];
                buffer.putInt(pos,j);
                pos = buffer.position();
                }
            if (values[i] instanceof String) {
                for(int j=0;j<values.length;j++){
                    String s = (String)values[i];
                    char c;
                    c = s.charAt(j);
                    buffer.putChar(pos,c);
                    pos = buffer.position();
                }
            if (values[i] instanceof Float){
                float f = (float)values[i];
                buffer.putFloat(pos,f);
                pos = buffer.position();
                }
            }
        }

        buff = buffer.array();
    }
    public void readFromBuffer(byte[] buff,int position) {
        ByteBuffer buffer = ByteBuffer.wrap(buff);
        int pos = position;
        String s;
        Integer j;
        Float f;
        String[] typeCol= this.relDef.getTypeCol();

        for(int i=0;i<typeCol.length;i++) {
            if (typeCol[i].charAt(0) == 'i') {
                j = buffer.getInt(pos);
                pos = buffer.position();
                values[i] = j;
            }
            if (typeCol[i].charAt(0) == 'f') {
                f = buffer.getFloat(pos);
                pos = buffer.position();
                values[i] = f;
            }

            if (typeCol[i].charAt(0) == 's') {
                String si = typeCol[i];
                int w = si.charAt(si.length() - 1);
                for (int k = 0; k < w; k++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(buffer.getChar(pos));
                    pos = buffer.position();
                    si = sb.toString();
                }
                values[i] = si;
            }

        }


    }

    // Peut etre qu'ils seront pas placé dans cette classe.
    public static int recordSize(String[] s){
        int recordSize = 0;
        for(int i =0;i<s.length;i++){

            if (s[i].charAt(0) == 'i') {
                recordSize+=4;
            }
            if (s[i].charAt(0) == 'f') {
                int w = s[i].charAt(s[i].length() - 1);
                recordSize+=4*w;
            }
            if (s[i].charAt(0) == 's') {
                recordSize+=4;
            }
        }
        return recordSize;
    }
    // ??????
    public static int slotCount(String[] s){
        return Constants.pageSize*slotCount(s);
    }
}
