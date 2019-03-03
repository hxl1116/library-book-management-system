package LibrarySystem;


import Model.Visit;
import Model.Visitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class VisitorTracker implements Serializable {

    /**
     * HashMap to hold visitors
     * key is String
     * object is Visitor
     */
    private HashMap<String, Visitor> visitorAccounts = new HashMap<String, Visitor>();

    /**
     * ArrayList to hold visits
     */
    private ArrayList<Visit> visitList = new ArrayList<Visit>();

    /**
     * visitor
     */
    private Visitor visitor;

    /**
     * Constructor for VisitorTracker
     */
    public VisitorTracker() {
        visitorAccounts = new HashMap<>();
        visitList = new ArrayList<>();
    }

    /**
     * creates a new visitor account
     * checks HashMap to see if key is being used
     * if key is not being used creates account
     * if key is being used does not create account
     *
     * @param visitorAccounts
     * @param id
     */
    public void newAccount(HashMap visitorAccounts, String id, String firstName, String lastName, String address,
                           String phone) {
        if (visitorAccounts.containsKey(id)) {
            System.out.println("That username is already being used");
        } else {
            //String visitorObj = id + "Visitor";
            Visitor visitorObj = new Visitor(id, firstName, lastName, address, phone, 0);
            visitorAccounts.put(id, visitorObj);
            System.out.println("You successfully created an account");
        }
    }

    /**
     * adds a visit to the ArrayList of visits
     *
     * @param visitList
     * @param visit
     */
    public void addVisit(ArrayList visitList, Visit visit) {
        visitList.add(visit);
    }

    /**
     * Attempts to login the visitor in
     *
     * @param visitorAccounts
     * @param id
     * @return
     */
    public boolean logIn(HashMap visitorAccounts, String id) {
        if (visitorAccounts.containsKey(id)) {
            System.out.println("Login successful");
            Visit visit = new Visit((Visitor)visitorAccounts.get(id), 00, 00, "date");
            visitList.add(visit);
            return true;
        } else {
            System.out.println("Login failed");
            return false;
        }
    }

    /**
     * logs out the vitor
     */
    public void logOut() {

    }

    /**
     * ends the visitor visit
     * @param visit
     * @param endDate
     */
    public void endVisit(Visit visit, int endDate) {
        visit.setTimeOut(endDate);

    }

    /**
     * starts the visitor viit
     * @param visit
     * @param startDate
     */
    public void startVisit(Visit visit, int startDate) {
        visit.setTimeIn(startDate);
    }

    /**
     * Generates a random string of 10 digits for unique visitor id
     * @return
     */
    public String generateID(){
        int[] numbers = new int[10];
        //Generates 10 Random Numbers in the range 1 -20
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = (int)(Math.random()*20 + 1);
        }//end for loop
        return numbers.toString();
    }


}
