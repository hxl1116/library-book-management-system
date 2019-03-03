package LibrarySystem;

public class Visitor {

    /**
     * unique visitor id
     */
    private String id;

    /**
     * first name of the visitor
     */
    private String firstName;

    /**
     * last name of the visitor
     */
    private String lastName;

    /**
     * address of the visitor
     */
    private String address;

    /**
     * phone number of the visitor
     */
    private String phone;

    /**
     *number of books checked out by the visitor
     */
    private int booksChecked;

    /**
     * Array list to keep track of visitor loans
     */
    //private ArrayList<Loan> loanList;

    /*
     * Constructor to create visitor object
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param phone
     * @param booksChecked
     */
    public Visitor(String id, String firstName, String lastName,
                   String address, String phone, int booksChecked){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.booksChecked = booksChecked;
    }


    /**
     * gets the visitor id
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * sets the visitor id
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * gets the first name of the visitor
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *sets the first name of the visitor
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the last name of the visitor
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the visitor
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the address of the visitor
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *sets the address of the visitor
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the phone number of the visitor
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     * sets the phone number of the visitor
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * gets the number of books checked out
     * @return
     */
    public int getBooksChecked() {
        return booksChecked;
    }

    /**
     * sets the number of books checked out
     * @param booksChecked
     */
    public void setBooksChecked(int booksChecked) {
        this.booksChecked = booksChecked;
    }
}