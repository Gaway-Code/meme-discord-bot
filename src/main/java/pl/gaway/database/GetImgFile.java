package pl.gaway.database;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GetImgFile {
    public static List<String> memikiImg = new ArrayList<>();
    public static void listFilesForFolder(final File folder) {

        System.out.print("Wczytane memy: \n");
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                memikiImg.add(fileEntry.getName());
                System.out.println(fileEntry.getName());
            }
        }
    }
}
