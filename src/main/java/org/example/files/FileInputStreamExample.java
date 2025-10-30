package org.example.files;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {
    public static void main(String[] args) {
        // try-with-resources: FileInputStream will be closed automatically
        try (FileInputStream input = new FileInputStream("/Users/awadheshkumar/Documents/git/java-core/src/main/java/org/example/files/filename.txt")) {

            int i;  // variable to store each byte that is read

            // Read one byte at a time until end of file (-1 means "no more data")
            while ((i = input.read()) != -1) {
                // Convert the byte to a character and print it to the console
                System.out.print((char) i);
            }

        } catch (IOException e) {
            // If an error happens (e.g. file not found), print an error message
            System.out.println("Error reading file.");
        }
}
}