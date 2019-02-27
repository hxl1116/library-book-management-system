package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class VisitorTracker {

    /**
     * Hashmap to hold visitors
     * key is String
     * object is Visitor
     */
    private HashMap<String,Visitor> visitorAccounts = new HashMap<String,Visitor>();

    /**
     * Arraylist to hold visits
     */
    private ArrayList<Visit> visitList = new ArrayList<Visit>();

    /**
     * visitor
     */
    private Visitor visitor;

    /**
     * Constructor for VisitorTracker
     *
     * @param visitList
     * @param visitor
     * @param visitorAccounts
     */
    public VisitorTracker(ArrayList visitList, Visitor visitor, HashMap visitorAccounts){
        this.visitorAccounts = visitorAccounts;
        this.visitList = visitList;
        this.visitor = visitor;

    }

    /**
     * creates a new visitor account
     * checks hashmap to see if key is being used
     * if key is not being used creates account
     * if key is being used does not create account
     *
     * @param visitorAccounts
     * @param id
     * @param mVisitor
     */
    public void newAccount(HashMap visitorAccounts,String id, Visitor mVisitor){
        if(visitorAccounts.containsKey(mVisitor.getId())){
            System.out.println("That username is already being used");
        } else {
            visitorAccounts.put(id,mVisitor);
            System.out.println("You successfully created an account");
        }
    }

    /**
     * adds a visit to the ArrayList of visits
     *
     * @param visitList
     * @param visit
     */
    public void addVisit(ArrayList visitList,Visit visit){
        visitList.add(visit);

    }

}
