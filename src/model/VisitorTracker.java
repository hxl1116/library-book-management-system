package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class VisitorTracker {

    private HashMap<String,Visitor> visitorAccounts = new HashMap<String,Visitor>();
    private ArrayList<Visit> visitList = new ArrayList<Visit>();
    private Visitor visitor;


    public VisitorTracker(ArrayList visitList, Visitor visitor, HashMap visitorAccounts){
        this.visitorAccounts = visitorAccounts;
        this.visitList = visitList;
        this.visitor = visitor;

    }

    public void newAccount(HashMap visitorAccounts,String id, Visitor mVisitor){
        if(visitorAccounts.containsKey(mVisitor.getId())){
            System.out.println("That username is already being used");
        } else {
            visitorAccounts.put(id,mVisitor);
            System.out.println("You successfully created an account");
        }
    }

    public void addVisit(ArrayList visitList,Visit visit){
        visitList.add(visit);

    }






}
