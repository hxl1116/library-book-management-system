package model;

public class Visit {
    private Visitor visitor;
    private int timeIn;
    private int timeOut;
    private String date;



    public Visit(Visitor visitor,int TimeIn,
                  int timeOut, String date){
        this.visitor = visitor;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.date = date;


    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }

    public int getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(int timeIn) {
        this.timeIn = timeIn;
    }

    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
