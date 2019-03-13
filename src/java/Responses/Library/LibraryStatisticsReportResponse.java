package Responses.Library;

import Responses.LibraryResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
public class LibraryStatisticsReportResponse extends LibraryResponse {
    // YYYY/MM/DD format
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");
    // HH:MM:SS
    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private Date date;
    private int numberOfBooks;
    private int numberOfVisitors;
    private double averageVisitLength;
    private int numberOfBooksPurchased;
    private double finesCollected;
    private double finesOutstanding;

    public LibraryStatisticsReportResponse(Date date, int numberOfBooks, int numberOfVisitors,
                                           double averageVisitLength, int numberOfBooksPurchased,
                                           double finesCollected, double finesOutstanding) {
        this.date = date;
        this.numberOfBooks = numberOfBooks;
        this.numberOfVisitors = numberOfVisitors;
        this.averageVisitLength = averageVisitLength;
        this.numberOfBooksPurchased = numberOfBooksPurchased;
        this.finesCollected = finesCollected;
        this.finesOutstanding = finesOutstanding;
    }

    public String toString() {
        return String.format("report,%s%n" +
                "Number of Books:%d%n" +
                "Number of Visitors: %d%n" +
                "Average Length of Visit: %.2f%n" +
                "Number of Books Purchased: %d%n" +
                "Fines Collected: %.2f%n" +
                "Fines Outstanding: %.2f%n",
                numberOfBooks,
                numberOfVisitors,
                averageVisitLength,
                numberOfBooksPurchased,
                finesCollected,
                finesOutstanding);
    }
}
