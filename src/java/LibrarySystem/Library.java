package LibrarySystem;

import Model.Book;

import Model.Loan;
import Model.Visitor;
import Requests.Book.BookPurchaseRequest;
import Requests.Book.BookStoreSearchRequest;

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

/**
 * Top layer of the LBMS.
 * All subsystems converge at this class and interact with each other through this class.
 *
 * @author Jimmy Dugan, Henry Larson
 */
public class Library {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private static final String BOOK_FILE = "src/resources/book.txt";
    private static final String BOOK_CATALOG_FILE = "src/resources/book_catalog";
    private static final String VISITOR_TRACKER_FILE = "src/resources/visitor_tracker";

    private static final int SOCKET_PORT = 8888;

    private static ArrayList<Book> books = new ArrayList<>();

    private static String currentDate;
    private static Receptionist receptionist;
    private static BookCatalog bookCatalog;
    private static VisitorTracker visitorTracker;

    /**
     * Loads book data, BookCatalog object data, and VisitorTracker object data.
     *
     * @param args Runtime arguments
     */
    public static void main(String[] args) {
        receptionist = new Receptionist();

        try {
            loadBooks();
            loadData();
            receptionist.openDoors(SOCKET_PORT);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Reads and parses books.txt
     */
    private static void loadBooks() {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(BOOK_FILE))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        int tempIDCounter = 100;
        for (String line : lines) {
            String firstPart = line.substring(0, line.indexOf("{") - 1);
            String lastPart = line.substring(line.indexOf("}") + 2);

            long isbn = Long.parseLong(firstPart.substring(0, firstPart.indexOf(",")));
            String title = firstPart.substring(firstPart.indexOf("\"") + 1, firstPart.lastIndexOf("\""));
            String authors = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
            String publisher = lastPart.substring(lastPart.indexOf("\"") + 1, lastPart.lastIndexOf("\""));
            String publishDate = lastPart.substring(lastPart.lastIndexOf("\"") + 2, lastPart.lastIndexOf(","));
            int pageCount = Integer.parseInt(lastPart.substring(lastPart.lastIndexOf(",") + 1));

            Book book = new Book(isbn, title, authors, publisher, publishDate, pageCount);
            book.setTempID(tempIDCounter);
            books.add(book);

            tempIDCounter++;
        }
    }

    /**
     * Saves BookCatalog and VisitorTracker object states to an object file.
     *
     * @throws IOException
     */
    private static void saveData() throws IOException {
        try (FileOutputStream bookCatalogOutputStream = new FileOutputStream(BOOK_CATALOG_FILE);
             ObjectOutputStream bookCatalogObjOutputStream = new ObjectOutputStream(bookCatalogOutputStream);
             FileOutputStream visitorTrackerOutputStream = new FileOutputStream(VISITOR_TRACKER_FILE);
             ObjectOutputStream visitorTrackerObjOutputStream = new ObjectOutputStream(visitorTrackerOutputStream)) {
            bookCatalogObjOutputStream.writeObject(bookCatalog);
            visitorTrackerObjOutputStream.writeObject(visitorTracker);
        }
    }

    /**
     * Loads previous BookCatalog and VisitorTracker object data from an object file
     *
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static void loadData() throws IOException, ClassNotFoundException {
        try (FileInputStream bookCatalogInputStream = new FileInputStream(BOOK_CATALOG_FILE);
             ObjectInputStream bookCatalogObjInputStream = new ObjectInputStream(bookCatalogInputStream);
             FileInputStream visitorTrackerInputStream = new FileInputStream(VISITOR_TRACKER_FILE);
             ObjectInputStream visitorTrackerObjInputStream = new ObjectInputStream(visitorTrackerInputStream)) {

            bookCatalog = (BookCatalog) bookCatalogObjInputStream.readObject();
            visitorTracker = (VisitorTracker) visitorTrackerObjInputStream.readObject();
        }
    }

    /**
     * Gets the number of available books from the BookCatalog
     *
     * @param book queried book
     * @return amount of queried book
     */
    public static Integer getNumAvailable(Book book) {
        return bookCatalog.getNumberOfAvailableCopies(book);
    }

    /**
     * Loans a book to a given Visitor, book list, and location of book
     *
     * @param visitorID Unique ID of the visitor being loaned to
     * @param bookID location of the book in the list
//     * @param books list of books yielded from the book search
     * @throws Exception
     */
    public static void loan(String visitorID, int bookID) throws Exception {
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

    /**
     * Returns a book from a visitor to the library
     *
     * @param visitorID unique ID of the returning visitor
     * @param bookID location of the loan in the visitor's loan list
     */
    public static void returnBook(String visitorID, int bookID) {
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


    public static void initiateSearchAndSort(BookStoreSearchRequest bookStoreSearchRequest){
        BookCatalog bookCatalog = new BookCatalog(books, bookStoreSearchRequest);
        bookCatalog.executeSearchAndSortRequest();
    }

    public static void initiatePurchase(BookPurchaseRequest bookPurchaseRequest){
        BookCatalog bookCatalog = new BookCatalog(books, bookPurchaseRequest);
        bookCatalog.makePurchase();
    }

}
