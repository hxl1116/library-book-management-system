package java;

import java.util.List;

public class VisitorTracker {

    private List<Visitor> visitors;
    private List<Visit> visits;


    public VisitorTracker(Visit visit, Visitor visitor){
        this.visitors.add(visitor);
        this.visits.add(visit);

    }


}
