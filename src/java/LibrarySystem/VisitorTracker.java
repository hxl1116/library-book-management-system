package LibrarySystem;


import Model.Visit;
import Model.Visitor;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class VisitorTracker implements Serializable {


    /**
     * sets the date and time format
     */
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

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
                           String phone, boolean False, String password) {
        if (visitorAccounts.containsKey(id)) {
            System.out.println("That username is already being used");
        } else {
            //String visitorObj = id + "Visitor";
            Visitor visitorObj = new Visitor(id, firstName, lastName, address, phone, 0, False, password);
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
            Visit visit = new Visit((Visitor)visitorAccounts.get(id), DATE_FORMAT.format(Calendar.getInstance().getTime()),
                    null, DATE_FORMAT.format(Calendar.getInstance().getTime()));
            visitList.add(visit);
            System.out.println("Visit started");
            return true;

        } else {
            System.out.println("Login failed");
            return false;
        }
    }


    /**
     * ends the visitor visit
     * @param visit
     */
    public void endVisit(Visit visit) {
        String endTime = DATE_FORMAT.format(Calendar.getInstance().getTime());
        visit.setTimeOut(endTime);

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

    /**
     * Gets a Visitor object from their unique ID
     * @param ID unique ID of the desired visitor
     * @return Matching visitor (null if none found)
     */
    public Visitor findVisitorByID(String ID) {
        for (String visitorID : visitorAccounts.keySet()) {
            if (visitorID.equals(ID)) {
                return visitorAccounts.get(visitorID);
            }
        }
        return null;
    }


}
