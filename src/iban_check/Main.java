package iban_check;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println(CollorCodes.ANSI_BLUE.ansiCode + "Entered input directory path [for default './input' pres ENTER]"
                + CollorCodes.ANSI_RESET.ansiCode);
        String inputDirectory = in.nextLine();
        if ("".equals(inputDirectory)) {
            inputDirectory = "./input";
        }
        ListFiles filesListInput = new ListFiles(inputDirectory);
        ArrayList<File> inputFiles = filesListInput.ListFilesWork();
        System.out.println(CollorCodes.ANSI_PURPLE.ansiCode + "Looking in directory " + inputDirectory +
                " founded " + filesListInput.getFileCount() + " files" + CollorCodes.ANSI_RESET.ansiCode);

        System.out.println(CollorCodes.ANSI_BLUE.ansiCode + "Entered output directory path [for default './output' pres ENTER]"
                + CollorCodes.ANSI_RESET.ansiCode);
        String outputDirectory = in.nextLine();
        if ("".equals(outputDirectory)) {
            outputDirectory = "./output";
        }

        File outputFolder = new File(outputDirectory);
        if (!outputFolder.exists()) {
            System.out.print(CollorCodes.ANSI_YELLOW.ansiCode + outputDirectory + " do not exist " + CollorCodes.ANSI_RESET.ansiCode);
            if (outputFolder.mkdir()) {
                System.out.println(CollorCodes.ANSI_YELLOW.ansiCode + outputDirectory + " created " + CollorCodes.ANSI_RESET.ansiCode);
            }
        }

        ListFiles filesListOutput = new ListFiles(outputDirectory);
        ArrayList<File> outputFiles = filesListOutput.ListFilesWork();
        if (outputFiles.isEmpty()) {
            if (!inputFiles.isEmpty()) {
                int MAX_THREDS = 4;
                ExecutorService pool = Executors.newFixedThreadPool(MAX_THREDS);
                for (int i = 0; i < inputFiles.size(); i++) {
                    Work work = new Work(String.valueOf(i), inputFiles.get(i), outputDirectory);
                    pool.execute(work);
                }
                pool.shutdown();
            } else {
                System.out.println(CollorCodes.ANSI_RED.ansiCode + "Input directory " + inputDirectory + " is empty." + CollorCodes.ANSI_RESET.ansiCode);
            }
        } else {
            System.out.println(CollorCodes.ANSI_RED.ansiCode + "Output directory " + outputDirectory + " is not empty." + CollorCodes.ANSI_RESET.ansiCode);
            outputFiles.forEach(el -> System.out.println(CollorCodes.ANSI_RED.ansiCode + "Founded file " + el + CollorCodes.ANSI_RESET.ansiCode));
        }
        System.out.println(CollorCodes.ANSI_GREEN.ansiCode + "----------------------- Work Stats ---------------------- " + CollorCodes.ANSI_RESET.ansiCode);
        System.out.println(CollorCodes.ANSI_GREEN.ansiCode + "Input "+filesListInput.getFileCount()+" files "+CollorCodes.ANSI_RESET.ansiCode);

    }
}
