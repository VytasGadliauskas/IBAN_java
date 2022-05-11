package iban_check;

import java.io.File;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



    public static void main(String[] args) {
        ListFiles filesListInput = new ListFiles();
        ListFiles filesListOutput = new ListFiles();
        Scanner in = new Scanner(System.in);
        System.out.println(ANSI_BLUE+"Entered input directory path [for default './input' pres ENTER]"+ANSI_RESET);
        String inputDirectory = in.nextLine();
        if (inputDirectory.equals("")){ inputDirectory = "./input";}
        System.out.println(ANSI_PURPLE+"Looking in directory " +inputDirectory+ANSI_RESET);

        System.out.println(ANSI_BLUE+"Entered output directory path [for default './output' pres ENTER]"+ANSI_RESET);
        String outputDirectory = in.nextLine();
        if (outputDirectory.equals("")){ outputDirectory = "./output";}

        System.out.println(ANSI_PURPLE+"Looking in directory " +outputDirectory+ANSI_RESET);

        ArrayList<File> inputFiles = filesListInput.ListFiles(inputDirectory);
        ArrayList<File> outputFiles = filesListOutput.ListFiles(outputDirectory);
        if(outputFiles.isEmpty()) {
            if(!inputFiles.isEmpty()) {
                int MAX_THREDS = 4;
                System.out.println(ANSI_CYAN+"PROGRESS |=                                |\r"+ANSI_RESET);
                inputFiles.forEach(el -> System.out.println(ANSI_GREEN + "Founded file " + el + ANSI_RESET));
                ExecutorService pool = Executors.newFixedThreadPool(MAX_THREDS);
                for (int i = 0; i < inputFiles.size(); i++) {
                    Work work = new Work(String.valueOf(i), inputFiles.get(i), outputDirectory);
                    pool.execute(work);
                }
                pool.shutdown();
            } else {
                System.out.println(ANSI_RED+"Input direcroty "+inputDirectory+" is empty."+ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED+"Output direcroty "+outputDirectory+" is not empty."+ANSI_RESET);
            outputFiles.forEach(el -> System.out.println(ANSI_RED + "Founded file " + el + ANSI_RESET));
        }
    }

}
