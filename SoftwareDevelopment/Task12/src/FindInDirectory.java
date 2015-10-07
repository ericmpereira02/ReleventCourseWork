/*
 * Author: Austin Haggard, ahaggard2013@my.fit.edu
 * Course: CSE 1002, Section 002, Spring
 * Project: filesearch
 */



import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Files;

public class FindInDirectory {

    public static void getFileName (final String directory, final String searchTerm) {

        try (DirectoryStream<Path> ds = Files.newDirectoryStream
                (FileSystems.getDefault().getPath(directory))) {
            for (Path p: ds) { //For each loop goes through path
                if (Files.isDirectory(p)) { //continues if there is a directory
                    getFileName(p.toString(), searchTerm);
                } else if (p.toString().contains(searchTerm)) { //Finds search term
                      System.out.println(p);
                  }
            }
        } catch (final IOException e) {
            e.printStackTrace();
          }
    }

    public static void main (final String[] args) {

        final String directory = args[0]; //Takes directory
        final String searchTerm = args[1]; // takes search term

        getFileName(directory, searchTerm); //calls method

    }
}
