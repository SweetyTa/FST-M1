package Activities;

import org.apache.commons.io.FileUtils;
import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;

public class Activity14 {
    public static void main(String[] args) throws IOException {
        try {
            File file = new File("src/main/resources/test.txt");
            boolean fstatus = file.createNewFile();
            if (fstatus) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already exist at this path");
            }
            File fileUtil = FileUtils.getFile("src/main/resources/test.txt");
            System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
            File destDir = new File("resources");
            FileUtils.copyFileToDirectory(file, destDir);
            File newFile = FileUtils.getFile(destDir, "test.txt");
            String newFileData = FileUtils.readFileToString(newFile, "UTF8");
            System.out.println("Data in new file: " + newFileData);

        } catch (IOException errMessage) {
            System.out.println(errMessage);
        }
    }
}

