package java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class VisitorTrackerTest {

    private ArrayList<Visit> visitList = new ArrayList<Visit>();

    private HashMap<String,Visitor> visAccounts = new HashMap<String,Visitor>();

    Visitor visitor1 = new Visitor("Ryan11","Ryan","Doe",
            "Global Village","000000000",0);

    Visitor visitor2 = new Visitor("Ryan11","John","Apple",
            "UC","111111111",2);

    VisitorTracker visTrack = new VisitorTracker(visitList,visitor1,visAccounts);

    Visit visit = new Visit(visitor1,10,1,"02/28/2019");

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void newAccount() {
        visTrack.newAccount(visAccounts,visitor1.getId(),visitor1);
        assertEquals(1,visAccounts.size());
        visTrack.newAccount(visAccounts,visitor2.getId(),visitor2);
        assertEquals(1,visAccounts.size());
    }

    @Test
    public void addVisit(){
        visTrack.addVisit(visitList,visit);
        assertEquals(1,visitList.size());
    }
}