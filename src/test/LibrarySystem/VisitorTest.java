package LibrarySystem;//import static org.junit.Assert.*;

import Model.Visitor;

public class VisitorTest {

    Visitor visitor1 = new Visitor("Ryan11", "Ryan", "Doe",
            "Global Village", "000000000", 0);


    //    @org.junit.Before
    public void setUp() throws Exception {


    }

    //    @org.junit.After
    public void tearDown() throws Exception {
    }

    //    @org.junit.Test
    public void getId() {

//        assertEquals("Ryan11",visitor1.getId());
    }

    //    @org.junit.Test
    public void setId() {
        visitor1.setId("Ryan12");
//        assertEquals("Ryan12",visitor1.getId());
    }

    //    @org.junit.Test
    public void getFirstName() {
//        assertEquals("Ryan",visitor1.getFirstName());
    }

    //    @org.junit.Test
    public void setFirstName() {
        visitor1.setFirstName("Bob");
//        assertEquals("Bob",visitor1.getFirstName());
    }

    //    @org.junit.Test
    public void getLastName() {
//        assertEquals("Doe",visitor1.getLastName());
    }

    //    @org.junit.Test
    public void setLastName() {
        visitor1.setLastName("Apple");
//        assertEquals("Apple",visitor1.getLastName());
    }

    //    @org.junit.Test
    public void getAddress() {
//        assertEquals("Global Village",visitor1.getAddress());
    }

    //    @org.junit.Test
    public void setAddress() {
        visitor1.setAddress("University Commons");
//        assertEquals("University Commons",visitor1.getAddress());
    }

    //    @org.junit.Test
    public void getPhone() {
//        assertEquals("000000000",visitor1.getPhone());
    }

    //    @org.junit.Test
    public void setPhone() {
        visitor1.setPhone("111111111");
//        assertEquals("111111111",visitor1.getPhone());
    }

    //    @org.junit.Test
    public void getBooksChecked() {
//        assertEquals(0,visitor1.getBooksChecked());
    }

    //    @org.junit.Test
    public void setBooksChecked() {
        visitor1.setBooksChecked(2);
//        assertEquals(2,visitor1.getBooksChecked());
    }
}