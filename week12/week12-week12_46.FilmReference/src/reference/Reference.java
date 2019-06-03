package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

public class Reference {
    private RatingRegister ratingRegister;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }
    
    public Film recommendFilm(Person person){
        
        if(this.ratingRegister.getPersonalRatings(person).keySet().isEmpty()){
            return filmWithHighestAverageRating();
        }
        return filmWithHighestSimilarityRating(person);
    }
    

    
    public Film filmWithHighestAverageRating(){
        Map<Film, List<Rating>> filmRatings = this.ratingRegister.filmRatings();
        List<Film> films = new ArrayList<Film>(filmRatings.keySet());
        
        Collections.sort(films, new FilmComparator(filmRatings));
        return films.get(0);
    }
    
    public Film filmWithHighestSimilarityRating(Person person){
        
        Set<Film> seen = this.ratingRegister.getPersonalRatings(person).keySet();        
        Map<Person, Integer> similarityScores = new HashMap<Person, Integer>();        
        Map<Person, Map<Film, Rating>> personalRegisters = this.ratingRegister.getPersonRatingsMap();
        
        int maxSimilarityScore = -1000000;
        Person maxPerson = null;
        
        for (Person p : personalRegisters.keySet()){
            
            if (p.equals(person)){
                continue; 
            }
               
            Map<Film, List<Rating>> filmRatings = this.ratingRegister.filmRatings();
            int similarityScore = 0;
            
            for (Film film : filmRatings.keySet()){
                similarityScore += this.ratingRegister.getRating(person, film).getValue() * this.ratingRegister.getRating(p, film).getValue();
            }
            
            if (similarityScore > maxSimilarityScore){
                maxSimilarityScore = similarityScore;
                maxPerson = p;
            }            
        }        
        
        Film bestChoice = null;
        int maxRating = -10;
        Map<Film, Rating> maxPersonRatings = this.ratingRegister.getPersonalRatings(maxPerson);
        
        for (Film film : maxPersonRatings.keySet()){
            if (!seen.contains(film)){
                if (maxPersonRatings.get(film).getValue() > maxRating){                    
                    bestChoice = film;
                    maxRating = maxPersonRatings.get(film).getValue();
                }
            }
        }       
        
        if (maxRating > 0 && maxPerson != null){
            return bestChoice;
        }  
        
        return null;
    }
}
