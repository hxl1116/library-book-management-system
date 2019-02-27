package java;

public class Visit {
    private Visitor visitor;
    private int timeIn;
    private int timeOut;
    private String date;



    public Visit (Visitor visitor,int TimeIn,
                  int timeOut, String date){
        this.visitor = visitor;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.date = date;


    }
}
