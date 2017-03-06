package app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by joelprakash on 3/5/2017.
 */

public class AMA {


    private int AMA_ID;

    private User creator;

   private String description;
   private List<String> listOfKeyWords;

   // Default constructor
   public AMA(){

   }

    public AMA ( String description){
        this.description = description;
    }

   public AMA ( String description, List<String> listOfKeyWords ){
       this.description = description;
       this.listOfKeyWords = listOfKeyWords;
   }
    // MM/dd/yyyy
   private Date deadlineToVote;

    public int getAMA_ID() {
        return AMA_ID;
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
        description = description;
    }

    public Date getDeadlineToVote() {
        return deadlineToVote;
    }

    public void setDeadlineToVote(Date deadlineToVote) {
        this.deadlineToVote = deadlineToVote;
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
}
