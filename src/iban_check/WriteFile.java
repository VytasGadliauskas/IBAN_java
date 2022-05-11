package iban_check;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

 public class WriteFile {
    synchronized public boolean WriteFileWork(String filename, String ibandata){
         try {
                 FileWriter myWriter = new FileWriter(filename, true);
                 PrintWriter myWriterPr = new PrintWriter(myWriter);
                 myWriterPr.println(ibandata);
                 myWriter.close();
         } catch (IOException e) {
             System.out.println(Main.ANSI_RED+"File "+filename+" write error occurred."+e.getMessage()+Main.ANSI_RESET);
             e.printStackTrace();
             return false;
         } finally {
            return  true;
         }
     }

}
