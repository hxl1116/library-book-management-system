package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class VisitorTrackerTest {

    private HashMap<String,Visitor> visAccounts = new HashMap<String,Visitor>();
    Visitor visitor1 = new Visitor("Ryan11","Ryan","Doe",
            "Global Village","000000000",0);
    Visitor visitor2 = new Visitor("Ryan11","John","Apple",
            "UC","111111111",2);
    VisitorTracker visTrack = new VisitorTracker(visitor1,visAccounts);

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newAccount() {
        visTrack.newAccount(visAccounts,visitor1.getId(),visitor1);
        visTrack.newAccount(visAccounts,visitor2.getId(),visitor2);


    }
}