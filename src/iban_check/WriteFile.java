package iban_check;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
    synchronized public boolean WriteFileWork(String filename, String ibandata) {
        try {
            FileWriter myWriter = new FileWriter(filename, true);
            PrintWriter myWriterPr = new PrintWriter(myWriter);
            myWriterPr.println(ibandata);
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println(CollorCodes.ANSI_RED.ansiCode + "File " + filename + " write error occurred." + e.getMessage() + CollorCodes.ANSI_RESET.ansiCode);
            e.printStackTrace();
            return false;
        }
    }
}
