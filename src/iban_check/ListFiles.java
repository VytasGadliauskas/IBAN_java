package iban_check;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFiles {
    private String directory;
    private int fileCount = 0;
    ArrayList<File> fileList = new ArrayList<>();

    public ArrayList<File> ListFiles(String directory) {
        this.directory = directory;
        try {
            List<File> files = Files.list(Paths.get(this.directory))
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .collect(Collectors.toList());

            files.forEach(el -> fileList.add(el) );
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileCount = fileList.size();
        return  fileList;
    }

    public int getFileCount() {
        return fileCount;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }

    @Override
    public String toString() {
        return "fileList= "+ fileList;
    }
}
