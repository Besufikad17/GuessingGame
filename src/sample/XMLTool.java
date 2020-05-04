package sample;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLTool {
    /*public static void main(String[] args){
         encodeXML();
         decodeXML();
    }*/

    public void encodeXML(){
        try {
            Player p = new Player();
            FileOutputStream fi = new FileOutputStream(".//number.xml");
            XMLEncoder enc = new XMLEncoder(fi);
            enc.writeObject(Computer.getComputers_number());
            enc.writeObject(p.getPlayers_number());
            enc.close();
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int decodeXML(){
         int result = 0;
         Player p = new Player();
        try {
            FileInputStream fi = new FileInputStream(".//number.xml");
            XMLDecoder enc = new XMLDecoder(fi);
            Computer.setComputers_number((Integer) enc.readObject());
            p.setPlayers_number((Integer)enc.readObject());
            enc.close();
            fi.close();
            result = Computer.getComputers_number();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void encodeXML2(){
        try {
            Player p1 = new Player(),p2 = new Player();
            FileOutputStream fi = new FileOutputStream(".//number.xml");
            XMLEncoder enc = new XMLEncoder(fi);
            enc.writeObject(p1.getPlayers_number());
            enc.writeObject(p2.getPlayers_number());
            enc.close();
            fi.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int[] decodeXML2(){
        int result[] = new int[2];
        try {
            Player p1 = new Player(),p2 = new Player();
            FileInputStream fi = new FileInputStream(".//number.xml");
            XMLDecoder enc = new XMLDecoder(fi);
            p1.setPlayers_number((Integer) enc.readObject());
            p2.setPlayers_number((Integer) enc.readObject());
            enc.close();
            fi.close();
            result[0] = p1.getPlayers_number();
            result[1] = p2.getPlayers_number();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
