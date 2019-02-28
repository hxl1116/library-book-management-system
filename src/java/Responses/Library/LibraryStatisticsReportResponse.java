package Responses.Library;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Reports various statistics about library usage for a period covering a specified number of days.
 *
 * @author Henry Larson
 */
public class LibraryStatisticsReportResponse {
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

    public Date getDate() {
        return date;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public int getNumberOfVisitors() {
        return numberOfVisitors;
    }

    public double getAverageVisitLength() {
        return averageVisitLength;
    }

    public int getNumberOfBooksPurchased() {
        return numberOfBooksPurchased;
    }

    public double getFinesCollected() {
        return finesCollected;
    }

    public double getFinesOutstanding() {
        return finesOutstanding;
    }

    // TODO - create response format
    public String toString() {
        return "";
    }
}
