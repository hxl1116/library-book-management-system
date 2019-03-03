package LibrarySystem;

public class Visit {


    /**
     * visitor
     */
    private Visitor visitor;

    /**
     * time visitor checks in to library
     */
    private int timeIn;

    /**
     * time visitor checks out of the library
     */
    private int timeOut;

    /**
     * date the visitor checked into library
     */
    private String date;


    /**
     *Constructor for visit
     *
     * @param visitor
     * @param timeIn
     * @param timeOut
     * @param date
     */
    public Visit(Visitor visitor,int timeIn,
                  int timeOut, String date){
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
    public int getTimeIn() {
        return timeIn;
    }

    /**
     * sets the time the visitor checked in
     * @param timeIn
     */
    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    /**
     * gets the time visitor checked out
     * @return
     */
    public int getTimeOut() {
        return timeOut;
    }

    /**
     * sets the time visitor checked out
     * @param timeOut
     */
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
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
        this.date = date;
    }

}
