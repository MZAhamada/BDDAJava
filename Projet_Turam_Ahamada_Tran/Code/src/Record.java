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
                float f = (int)values[i];
                buffer.putInt(pos,f);
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
        int compteur = 0;
        String s;
        Integer j;
        Float f;
        RelDef[] reldef = DBDef.getInstance().getReldef();
////// pas fini 
        for(int i=0;i<reldef.length;i++){
            if(reldef[compteur].getTypeCol()[compteur].charAt(0)=='i'){
                // compteur et compteur ?
                j = buffer.getInt();
                pos = buffer.position();
                values[compteur]=j;
            }
            if(reldef[compteur].getTypeCol()[compteur].charAt(0)=='f'){
                f = buffer.getFloat();
                pos = buffer.position();
                values[compteur]=f;
            }

        }

        if(reldef[compteur].getTypeCol()[compteur].charAt(0)=='f'){
            String si = reldef[compteur].getTypeCol()[compteur];
            int w = si.charAt(si.length());
            for(int i=0;i<w;i++){
            StringBuffer sb = new StringBuffer();
            sb.append(buffer.getChar());
            si = sb.toString();
            }
            pos = buffer.position();
            values[compteur]=s;
        }


    }
}
