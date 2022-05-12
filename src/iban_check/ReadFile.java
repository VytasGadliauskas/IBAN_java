package iban_check;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile  {
    private final File inputFile;
    private final String outputDirectory;
    private ArrayList<String> failoStatistika ;

    public ReadFile(File inputFile, String outputDirectory) {
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
        failoStatistika = new ArrayList<>();
    }

    public ArrayList<String> ReadFileWork(File file) {
        ArrayList<String> failoStatistika = new ArrayList<>();
        Scanner myReader;
        int linesCount = 0;
        int goodIbanCount = 0;
        int badIbanCount = 0;
        int writeSucess = 0;
        int writeError = 0;
        try {
            myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                if (!line.equals("")) {
                    linesCount++;
                    IbanCustomValidator ibaNcustomValidator = new IbanCustomValidator(line);
                    String outputFile = this.outputDirectory+"/"+ibaNcustomValidator.getCountry();
                    if (ibaNcustomValidator.isValid()) {
                        line = line+";true";
                        goodIbanCount++;
                    } else {
                        line = line+";false";
                        badIbanCount++;
                    }
                    WriteFile writeFile = new WriteFile();
                    if(writeFile.WriteFileWork(outputFile,line)){
                          writeSucess++;
                    } else {
                          writeError++;
                    }
                }
            }
            failoStatistika.add("File name: "+file.getName()+" lines count: "+linesCount);
            failoStatistika.add("File name: "+file.getName()+" good IBAN count: "+goodIbanCount);
            failoStatistika.add("File name: "+file.getName()+" bad IBAN count: "+badIbanCount);
            failoStatistika.add("File name: "+file.getName()+" write success: "+writeSucess);
            failoStatistika.add("File name: "+file.getName()+" write error: "+writeError);
            myReader.close();
        } catch (Exception e) {
            System.out.println(CollorCodes.ANSI_RED.ansiCode+"File "+file.getName()+" read error occurred. At line "+linesCount+" Error: "+e.getMessage()+CollorCodes.ANSI_RESET.ansiCode);
        }
        return failoStatistika;
    }

    public ArrayList<String> getFailoStatistika() {
        return failoStatistika;
    }

    public File getInputFile() {
        return inputFile;
    }
}
