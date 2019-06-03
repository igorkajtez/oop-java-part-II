package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class RatingRegister {
    private Map<Film, List<Rating>> ratings;
    private Map<Person, Map<Film, Rating>> personRatings;

    public RatingRegister() {
        this.ratings = new HashMap<Film, List<Rating>>();
        this.personRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating){
        if(!this.ratings.containsKey(film)){
            this.ratings.put(film, new ArrayList<Rating>());
            this.ratings.get(film).add(rating);
        }else{
            this.ratings.get(film).add(rating);
        }        
    }
    
    public void addRating(Person person, Film film, Rating rating){
        if(!this.personRatings.containsKey(person)){
            this.personRatings.put(person, new HashMap<Film, Rating>());
            this.personRatings.get(person).put(film, rating);
            addRating(film, rating);
        }else{
            this.personRatings.get(person).put(film, rating);
            addRating(film, rating);
        }
    }
    
    public Rating getRating(Person person, Film film){
        Rating rating = this.personRatings.get(person).get(film);
        
        if(rating != null){
             return rating;
        }else{
          return Rating.NOT_WATCHED;  
        }            
    }
    
    public List<Rating> getRatings(Film film){
        return this.ratings.get(film);
    }
    
    public Map<Film, List<Rating>> filmRatings(){
        return this.ratings;
    }
    
    public Map<Person, Map<Film, Rating>> getPersonRatingsMap(){
        return this.personRatings;
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person){
        if(!this.personRatings.containsKey(person)){
            return new HashMap<Film, Rating>();
        }
        
        return this.personRatings.get(person);
    }
    
    public List<Person> reviewers(){
        return new ArrayList<Person>(this.personRatings.keySet());
    }

    

}
