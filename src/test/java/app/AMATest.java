package app;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by jonathanscothorn on 3/22/2017.
 */
public class AMATest {

    private AMA ama;

    @org.junit.Before
    public void setUp() {

        ama = new AMA();

    }



    @org.junit.Test
    public void getId() {

        assertEquals(0, ama.getId());

    }

    @org.junit.Test
    public void setCreator() {

        ama.setCreator(new User());
        assertNotNull(ama.getCreator());

    }

    @org.junit.Test
    public void getCreator() {

        User u = new User();
        ama.setCreator(u);
        assertEquals(u, ama.getCreator());

    }

    @org.junit.Test
    public void getDescription() {
        assertEquals("", ama.getDescription());
    }

    @org.junit.Test
    public void setDescription() {

        ama.setDescription("a description");
        assertEquals("a description", ama.getDescription());

    }

    @org.junit.Test
    public void setDeadlineToVote() {

        ama.setDeadlineToVote(new Date());
        assertNotNull(ama.getDeadlineToVote());

    }

    @org.junit.Test
    public void getDeadlineToVote() {

        Date d = new Date();
        ama.setDeadlineToVote(d);
        assertEquals(d, ama.getDeadlineToVote());

    }


    @org.junit.Test
    public void getKeyWords() {

        String s = "abc,def,ghi";
        //String[] substrings = s.split(",");
        ArrayList<String> a = new ArrayList<String>();
        a.add("abc");
        a.add("def");
        a.add("ghi");

        for(int i=0; i<a.size(); i++){
            //System.out.println(a.get(i));
            //System.out.println(ama.getKeyWords(s).get(i));
            assertEquals(a.get(i), ama.getKeyWords(s).get(i));
        }

    }

    @org.junit.Test
    public void setListOfKeyWords() {

        ama.setListOfKeyWords(null);
        assertNull(ama.getListOfKeyWords());
    }

    @org.junit.Test
    public void getListOfKeyWords() {

        ArrayList<String> a = new ArrayList<String>();
        a.add("something");
        ama.setListOfKeyWords(a);
        assertEquals(a, ama.getListOfKeyWords());

    }

    @org.junit.Test
    public void addKeyWordToAMA() {

        ama.addKeyWordToAMA("something");
        assertEquals("something", ama.getListOfKeyWords().get(0));

    }

    @org.junit.Test
    public void removeKeyWordToAMA() {

        ama.addKeyWordToAMA("something");
        ama.removeKeyWordToAMA("something");
        assertEquals(0, ama.getListOfKeyWords().size());

    }

    @org.junit.After
    public void tearDown() {

    }

}