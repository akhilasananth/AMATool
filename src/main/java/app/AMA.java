package app;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by joelprakash on 3/5/2017.
 */
@Entity
public class AMA {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private User creator;

   private String description;

    public long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(long creatorID) {
        this.creatorID = creatorID;
    }

    private long creatorID;



   @ElementCollection(fetch = FetchType.EAGER)
   private List<String> listOfKeyWords;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Question> listOfQuestions;

   // Default constructor
   public AMA(){

       this("");

   }

    public AMA ( String description){
		this(description, new ArrayList<String>());
    }

   public AMA ( String description, ArrayList<String> listOfKeyWords ){
       this.description = description;
       this.listOfKeyWords = listOfKeyWords;
   }
    // MM/dd/yyyy
    //@NotEmpty(message = "Please enter the date in MM/DD/YYYY format")
   private Date deadlineToVote;

    public long getId() {
        return id;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadlineToVote() {
        return deadlineToVote;
    }

    public void setDeadlineToVote(Date deadlineToVote) {
        this.deadlineToVote = deadlineToVote;
    }
    
    public ArrayList<String> getKeyWords(String s){
    	ArrayList<String> key=new ArrayList<String>();
    	for (String use:s.split(",")){
    		key.add(use);
    	}
    	return key;
    }

    // String has to be in the following format: MM/dd/yyyy, ex: "03/05/2017"
    public Date convertStringToDate( String dateString){

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date = null;
        try {
            date = df.parse(dateString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public List<String> getListOfKeyWords() {
        return listOfKeyWords;
    }

    public void addKeyWordToAMA (String keyword){
        this.listOfKeyWords.add(keyword);
    }

    public void removeKeyWordToAMA (String keyword){
        this.listOfKeyWords.remove(keyword);
    }

    public void setListOfKeyWords(List<String> listOfKeyWords) {
        this.listOfKeyWords = listOfKeyWords;
    }

    @Override
    public String toString(){
        //need to mandate creator, for now not printing it.
        //also need a way to print out the arraylist that works with CommandLineRunner.
        /*String keywords = "";
        for(String s: listOfKeyWords){
            keywords += s+",";
        }*/
        //return String.format("AMA[id=%d, description='%s', keywords='%s']", AMA_ID, description, keywords);
        //return String.format("AMA[id=%d, description='%s']", AMA_ID, description);
        return String.format("AMA[id=%d, description='%s', keywords='%s'']", id, description, Arrays.toString(listOfKeyWords.toArray()));
    }


}
