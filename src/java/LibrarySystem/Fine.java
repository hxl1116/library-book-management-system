package java.LibrarySystem;

public class Fine {

    /**
     *Fine amount for a one day loan
     */
    private final double oneDayLoan = 10.00;

    /**
     * fine increment amount
     */
    private final double fineIncrement = 2.00;

    /**
     *max fine amount
     */
    private final double maxFine = 30.00;

    /**
     * current date
     */
    private String currentDate;


    /**
     * gets the current date
     * @return
     */
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * sets the current date
     * @param currentDate
     */
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }
}
