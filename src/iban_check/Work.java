package iban_check;

import java.io.File;
import java.lang.reflect.Executable;
import java.util.ArrayList;

public class Work implements Runnable {
    private File inputFile;
    private String outputDirectory;
    private String name;

    public Work(String name, File inputFile, String outputDirectory) {
        this.name = name;
        this.inputFile = inputFile;
        this.outputDirectory = outputDirectory;
    }

    @Override
    public void run() {
        if (inputFile != null && outputDirectory !="") {
            ReadFile readFile = new ReadFile(inputFile, outputDirectory);
            ArrayList<String> failoStatistika = readFile.ReadFileWork(inputFile);
            failoStatistika.forEach(el -> System.out.println(Main.ANSI_GREEN+el+Main.ANSI_PURPLE));
        } else {
            System.out.println(Main.ANSI_RED+"ERROR no file"+name+" or empty output directory "+outputDirectory+Main.ANSI_RESET);
        }
    }

}
