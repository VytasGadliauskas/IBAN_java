package iban_check;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IbanData {
       // 2022-03-12 dienos duomenys https://en.wikipedia.org/wiki/International_Bank_Account_Number
       public static String[] getIbanDataByCountryCode (String countryCode)  {
            ArrayList<String> ibanData = new ArrayList<>();
            try {
                 File ibanDatFile = new File("src/iban_check/ibandata.txt");
                 Scanner fileReader = new Scanner(ibanDatFile);
                 while (fileReader.hasNextLine()) {
                      String data = fileReader.nextLine();
                      ibanData.add(data);
                 }
                 fileReader.close();
            } catch (FileNotFoundException e) {
                 throw new RuntimeException(e);
            } catch (IOException e) {
                 throw new RuntimeException(e);
            }

            for(int i=0; i<ibanData.size();i++){
                  String[] line = ibanData.get(i).split(",");
                  String code = line[3].substring(0,2);
                  if (code.equals(countryCode)){
                      return line;
                  }
            }
            String[] lineOther = {"OTHER","0","0","OTHER"};
            return  lineOther;
       }
}
