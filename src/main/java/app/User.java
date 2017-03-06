package app;

import app.AMA;

import java.util.List;

/**
 * Created by joelprakash on 3/5/2017.
 */
public class User {

    private String handle;

    private String name;

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

    public List<AMA> getListOfAMAsCreated() {
        return listOfAMAsCreated;
    }

    public void setListOfAMAsCreated(List<AMA> listOfAMAsCreated) {
        this.listOfAMAsCreated = listOfAMAsCreated;
    }

    public void addAMAToUserList( AMA ama){
        this.listOfAMAsCreated.add(ama);
    }
}
