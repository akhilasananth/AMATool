package app;

import app.AMA;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joelprakash on 3/5/2017.
 */
@Entity
public class User {

    public long getId() {
        return id;
    }

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String handle;

    private String name;



    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AMA> listOfAMAsCreated;

    public User(){
	    listOfAMAsCreated = new ArrayList<AMA>();
    }

    public User (String handle, String name){
        this.handle = handle;
        this.name = name;
		listOfAMAsCreated = new ArrayList<AMA>();
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AMA> getListOfAMAsCreated() {
        return listOfAMAsCreated;
    }

    public void setListOfAMAsCreated(List<AMA> listOfAMAsCreated) {
        this.listOfAMAsCreated = listOfAMAsCreated;
    }

    public void addAMAToUserList( AMA ama){
        this.listOfAMAsCreated.add(ama);
    }

    @Override
    public String toString(){
        // need a way to print out the arraylist that works with CommandLineRunner.
            return  name;
//        return String.format("User[id=%d, handle='%s', name='%s', amas='%s']", id, handle, name, Arrays.toString(listOfAMAsCreated.toArray()))+ "\n";
        //return String.format("User[id=%d, handle='%s', name='%s']", id, handle, name);
        //return Arrays.toString(listOfAMAsCreated.toArray());
    }


}
