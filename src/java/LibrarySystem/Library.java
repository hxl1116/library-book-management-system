package LibrarySystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Library {
    private static final String BOOKS_FILE = "books.txt";

    public static void main(String[] args) {

    }

    private void loadBooks() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(BOOKS_FILE))) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
