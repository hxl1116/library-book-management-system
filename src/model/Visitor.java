package model;

public class Visitor {
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int booksChecked;

    public Visitor(String id, String firstName, String lastName,
                   String address, String phone, int booksChecked){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.booksChecked = booksChecked;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getBooksChecked() {
        return booksChecked;
    }

    public void setBooksChecked(int booksChecked) {
        this.booksChecked = booksChecked;
    }
}
