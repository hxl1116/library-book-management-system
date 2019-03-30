package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Visit implements Serializable {


    /**
     * sets the date and time format
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");


    /**
     * visitor
     */
    private Visitor visitor;

    /**
     * time visitor checks in to library
     */

    private static String timeIn;

    /**
     * time visitor checks out of the library
     */
    private static String timeOut;

    /**
     * date the visitor checked into library
     */
    private static String date;


    /**
     *Constructor for visit
     *
     * @param visitor
     * @param timeIn
     * @param timeOut
     * @param date
     */
    public Visit(Visitor visitor,String timeIn,
                  String timeOut, String date){
        this.visitor = visitor;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.date = date;


    }

    /**
     * gets the visitor
     * @return
     */
    public Visitor getVisitor() {
        return visitor;
    }

    /**
     * sets the visitor
     * @param visitor
     */
    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    /**
     * gets the time visitor checked in
     * @return
     */
    public String getTimeIn() {
        return timeIn;
    }

    /**
     * sets the time the visitor checked in
     * @param timeIn
     */
    public void setTimeIn(String timeIn) {
        this.timeIn = TIME_FORMAT.format(Calendar.getInstance().getTime());
    }

    /**
     * gets the time visitor checked out
     * @return
     */
    public String getTimeOut() {
        return timeOut;
    }

    /**
     * sets the time visitor checked out
     * @param timeOut
     */
    public void setTimeOut(String timeOut) {
        this.timeOut = TIME_FORMAT.format(Calendar.getInstance().getTime());
    }

    /**
     *gets the date the visitor visits the library
     * @return
     */
    public String getDate() {
        return date;
    }

    /**
     *sets the date the visitor visits the library
     * @param date
     */
    public void setDate(String date) {
        this.date = DATE_FORMAT.format(Calendar.getInstance().getTime());
    }

}
