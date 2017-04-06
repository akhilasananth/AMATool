package app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonathanscothorn on 3/17/2017.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue
    private long id;

    private long parent;

    @OneToMany
    private List<User> listOfVoters;

    private int upVotes;
    private int downVotes;

    private String description;



    public Question(){
        this(0);
    }

    public Question(long parent){
        this("", parent);
    }

    public Question(String question, long parentId){
        listOfVoters = new ArrayList<User>();
        this.description = question;
        this.parent = parent;
        upVotes = 0;
        downVotes = 0;
    }

    public void setParent(long amaId){
        this.parent = amaId;
    }

    public long getParent(){
        return parent;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String question){
        this.description = question;
    }

    public int getUpVotes(){
        return upVotes;
    }

    public void addUpVote(){
        upVotes++;
    }

    public int getDownVotes(){
        return downVotes;
    }

    public void addDownVotes(){
        downVotes++;
    }

    public void setListOfVoters(List<User> users){
        listOfVoters = users;
    }

    public List<User> getListOfVoters(){
        return listOfVoters;
    }

    public void addVoter(User voter){
        listOfVoters.add(voter);
    }

    @Override
    public String toString(){
        return "Question "+id+": "+description+"\n Up votes: "+upVotes+"; Down votes: "+downVotes+".\n";
    }

}
