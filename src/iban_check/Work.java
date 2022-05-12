package iban_check;

import java.io.File;
import java.util.ArrayList;

public class Work implements Runnable {
    private final File inputFile;
    private final String outputDirectory;
    private final String name;

    public Work(String name, File inputFile, String outputDirectory) {
        this.name = name;
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
    }

    @Override
    public void run() {
        if (inputFile != null &&  !"".equals(outputDirectory)) {
            ReadFile readFile = new ReadFile(inputFile, outputDirectory);
            ArrayList<String> failoStatistika = readFile.ReadFileWork(inputFile);
            failoStatistika.forEach(el -> System.out.println(CollorCodes.ANSI_GREEN.ansiCode + el + CollorCodes.ANSI_PURPLE.ansiCode));
        } else {
            System.out.println(CollorCodes.ANSI_RED.ansiCode + "ERROR no file" + name + " or empty output directory " + outputDirectory + CollorCodes.ANSI_RESET.ansiCode);
        }
    }

}
