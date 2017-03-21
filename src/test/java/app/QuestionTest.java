package app;

import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by jonathanscothorn on 3/17/2017.
 */
public class QuestionTest {

    private Question question;
    private AMA ama;

    @org.junit.Before
    public void setUp() {
        question = new Question();
        ama = new AMA();

    }

    @org.junit.Test
    public void setParent() {

        question.setParent(ama.getId());
        assertNotNull(question.getParent());
    }

    @org.junit.Test
    public void getParent() {

        question.setParent(ama.getId());
        assertEquals(ama.getId(), question.getParent());
    }

    @org.junit.Test
    public void getQuestionText() {

        Question q = new Question("hai", ama.getId());
        assertEquals("hai", q.getDescription());

    }

    @org.junit.Test
    public void setQuestionText() {

        question.setDescription("hello");
        assertEquals("hello", question.getDescription());
    }

    @org.junit.Test
    public void getUpVotes() {

        assertEquals(0, question.getUpVotes());

    }

    @org.junit.Test
    public void addUpVote() {

        question.addUpVote();
        assertEquals(1, question.getUpVotes());

    }

    @org.junit.Test
    public void getDownVotes() {

        assertEquals(0, question.getDownVotes());

    }

    @org.junit.Test
    public void addDownVotes() {

        question.addDownVotes();
        assertEquals(1, question.getDownVotes());

    }

    @org.junit.Test
    public void setListOfVoters() {

        ArrayList<User> users = new ArrayList<User> ();
        question.setListOfVoters(users);
        assertNotNull(question.getListOfVoters());
    }

    @org.junit.Test
    public void getListOfVoters() {

        ArrayList<User> users = new ArrayList<User> ();
        question.setListOfVoters(users);
        assertEquals(users, question.getListOfVoters());

    }

    @org.junit.Test
    public void addVoter() {

        User user = new User();
        question.addVoter(user);
        assertEquals(1, question.getListOfVoters().size());

    }

    @org.junit.After
    public void tearDown() {

    }

}