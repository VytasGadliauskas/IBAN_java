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
    private final String directory;
    private int fileCount = 0;
    ArrayList<File> fileList = new ArrayList<>();

    public ListFiles(String directory) {
        this.directory = directory;
    }

    public ArrayList<File> ListFilesWork() {
        try {
            List<File> files = Files.list(Paths.get(this.directory))
                    .map(Path::toFile)
                    .filter(File::isFile).toList();
            fileList.addAll(files);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileCount = fileList.size();
        return fileList;
    }

    public int getFileCount() {
        return fileCount;
    }

    public ArrayList<File> getFileList() {
        return fileList;
    }
}
