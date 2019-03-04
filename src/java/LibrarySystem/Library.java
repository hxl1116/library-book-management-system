package LibrarySystem;

import Model.Book;

import Model.Loan;
import Model.Visitor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private String currentDate;

    private static final String BOOK_FILE = "src/resources/book.txt";
    private static final String BOOK_CATALOG_FILE = "src/resources/book_catalog";
    private static final String VISITOR_TRACKER_FILE = "src/resources/visitor_tracker";

    private static List<Book> books = new ArrayList<>();

    private static BookCatalog bookCatalog;
    private static VisitorTracker visitorTracker;

    public static void main(String[] args) {
        try {
            loadBooks();
            saveData();
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer getNumAvailable(Book book) {
        return bookCatalog.getAvailable().get(book);
    }

    public static Integer getNumUnvailable(Book book) {
        return bookCatalog.getUnavailable().get(book);
    }

    public Integer getTotalNumAvailable(Book book) {
        return getNumAvailable(book) + getNumUnvailable(book);
    }

    private static void loadBooks() throws ParseException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(BOOK_FILE))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            String firstPart = line.substring(0, line.indexOf("{") - 1);
            String lastPart = line.substring(line.indexOf("}") + 2);

            long isbn = Long.parseLong(firstPart.substring(0, firstPart.indexOf(",")));
            String title = firstPart
                .substring(firstPart.indexOf("\"") + 1, firstPart.lastIndexOf("\""));
            String authors = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
            String publisher = lastPart
                .substring(lastPart.indexOf("\"") + 1, lastPart.lastIndexOf("\""));
            String publishDate = lastPart
                .substring(lastPart.lastIndexOf("\"") + 2, lastPart.lastIndexOf(","));
            int pageCount = Integer.parseInt(lastPart.substring(lastPart.lastIndexOf(",") + 1));

            books.add(new Book(isbn, title, authors, publisher, publishDate, pageCount));

        }
    }

    private static void saveData() throws IOException {
        try (FileOutputStream bookCatalogOutputStream = new FileOutputStream(BOOK_CATALOG_FILE);
            ObjectOutputStream bookCatalogObjOutputStream = new ObjectOutputStream(
                bookCatalogOutputStream);
            FileOutputStream visitorTrackerOutputStream = new FileOutputStream(
                VISITOR_TRACKER_FILE);
            ObjectOutputStream visitorTrackerObjOutputStream = new ObjectOutputStream(
                visitorTrackerOutputStream)) {
            bookCatalogObjOutputStream.writeObject(bookCatalog);
            visitorTrackerObjOutputStream.writeObject(visitorTracker);
        }
    }

    // TODO - create bookCatalog and visitorTracker from object files
    private static void loadData() throws IOException {
        try (FileInputStream bookCatalogInputStream = new FileInputStream(BOOK_CATALOG_FILE);
            ObjectInputStream bookCatalogObjInputStream = new ObjectInputStream(
                bookCatalogInputStream);
            FileInputStream visitorTrackerInputStream = new FileInputStream(VISITOR_TRACKER_FILE);
            ObjectInputStream visitorTrackerObjInputStream = new ObjectInputStream(
                visitorTrackerInputStream)) {

        }
    }

    public void loan(String visitorID, int bookID, ArrayList<Book> books) throws Exception {
        Book book = books.get(bookID - 1);
        Visitor visitor = visitorTracker.findVisitorByID(visitorID);
        if (!bookCatalog.isAvailable(book) || !visitor.canLoan()) {
            System.out.println("Book unavailable or max loans reached.");
        } else {
            bookCatalog.makeUnavailable(book);
            Date date = DATE_FORMAT.parse(currentDate);
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 7);
            Date dueDate = c.getTime();
            date = DATE_FORMAT.parse(currentDate);
            visitor.loan(book, date, dueDate);
        }
    }

    public void printLoans(String visitorID) {
        ArrayList<Loan> loans = visitorTracker.findVisitorByID(visitorID).getLoanList();
        int i = 0;
        for (Loan loan : loans) {
            i++;
            System.out.println(Integer.toString(i) + "," + loan.toString());
        }
    }

    public void returnBook(String visitorID, int bookID) {
        Visitor visitor = visitorTracker.findVisitorByID(visitorID);
        ArrayList<Loan> loans = visitor.getLoanList();
        try {
            Loan loan = loans.get(bookID - 1);
            Book book = loan.getBook();
            visitor.removeLoan(loan);
            bookCatalog.makeAvailable(book, 1);

        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid ID");
        }

    }
}

