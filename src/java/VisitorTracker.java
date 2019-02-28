package java;

import java.util.ArrayList;
import java.util.List;

public class VisitorTracker {

    private List<Visitor> visitors;
    private List<Visit> visits;


    public VisitorTracker(){
        this.visitors = new ArrayList<Visitor>();
        this.visits = new ArrayList<Visit>();

    }

    public Visitor findVisitorByID(int ID) {
        for (Visitor visitor : visitors) {
            if (ID == visitor.getID()) {
                return visitor;
            }
        }
        return null;
    }


}
