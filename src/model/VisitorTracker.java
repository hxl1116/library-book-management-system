package model;

import java.util.HashMap;
import java.util.List;

public class VisitorTracker {

    private HashMap<String,Visitor> visitorAccounts = new HashMap<String,Visitor>();
    private List<Visitor> visitors;
    private List<Visit> visits;


    public VisitorTracker(Visitor visitor, HashMap visitorAccounts){
        this.visitorAccounts = visitorAccounts;

    }

    public void newAccount(HashMap visitorAccounts,String id, Visitor mVisitor){
        if(visitorAccounts.containsKey(mVisitor.getId())){
            System.out.println("That username is already being used");
        } else {
            visitorAccounts.put(id,mVisitor);
            System.out.println("You successfully created an account");
        }
    }




}
