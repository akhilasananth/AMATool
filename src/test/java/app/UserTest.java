package app;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by jonathanscothorn on 3/29/2017.
 */
public class UserTest {

    private User user;

    @org.junit.Before
    public void setUp() {

        user = new User("myhandle", "myname");

    }

    @org.junit.Test
    public void getHandle() {

        assertEquals("myhandle", user.getHandle());

    }

    @org.junit.Test
    public void setHandle() {

        String newHandle = "something new";
        user.setHandle(newHandle);
        assertEquals(newHandle, user.getHandle());

    }

    @org.junit.Test
    public void getName() {

        assertEquals("myname", user.getName());

    }

    @org.junit.Test
    public void setName() {

        String newName = "a new name";
        user.setName(newName);
        assertEquals(newName, user.getName());

    }

    @org.junit.Test
    public void getListOfAMAsCreated() {

        assertNotNull(user.getListOfAMAsCreated());

    }

    @org.junit.Test
    public void setListOfAMAsCreated() {

        ArrayList<AMA> newAMAs = new ArrayList<AMA>();
        user.setListOfAMAsCreated(newAMAs);
        assertEquals(newAMAs, user.getListOfAMAsCreated());

    }

    @org.junit.Test
    public void addAMAToUserList() {

        AMA ama = new AMA();
        user.addAMAToUserList(ama);
        assertEquals(ama, user.getListOfAMAsCreated().get(0));

    }

    @org.junit.After
    public void tearDown() {

    }

}