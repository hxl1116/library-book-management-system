package LibrarySystem;


import Model.Visit;
import Model.Visitor;

import java.util.ArrayList;
import java.util.HashMap;
public class VisitorTracker {

    /**
     * HashMap to hold visitors
     * key is String
     * object is Visitor
     */
    private HashMap<String, Visitor> visitorAccounts;

    /**
     * Arraylist to hold visits
     */
    private ArrayList<Visit> visitList;

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
    public void newAccount(HashMap visitorAccounts,String id, String firstName, String lastName, String address,
                           String phone){
        if(visitorAccounts.containsKey(id)){
            System.out.println("That username is already being used");
        } else {
            //String visitorObj = id + "Visitor";
            Visitor visitorObj = new Visitor(id,firstName,lastName,address,phone,0);
            visitorAccounts.put(id,visitorObj);
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

    /**
     * Attempts to login the visitor in
     *
     * @param visitorAccounts
     * @param id
     * @return
     */
    public boolean logIn(HashMap visitorAccounts,String id, Visitor mVisitor){
        if(visitorAccounts.containsKey(id)){
            System.out.println("Login successful");
            Visit visit = new Visit(mVisitor,2,2,"09");
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }
    }

    public void logOut(){

    }

    public void endVisit(Visit visit,int endDate){
        visit.setTimeOut(endDate);

    }

    public void startVisit(Visit visit,int startDate){
        visit.setTimeIn(startDate);
    }


}
