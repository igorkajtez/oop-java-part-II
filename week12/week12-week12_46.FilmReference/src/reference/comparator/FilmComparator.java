package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }    

    @Override
    public int compare(Film o1, Film o2) {
        int averageO1 = getAverage(o1);
        int averageO2 = getAverage(o2);
        
        if(averageO1 == averageO2){
            return 0;                        
        }else if(averageO1 > averageO2){
            return -1;
        }else{
            return 1;
        }
        
    }
    
    public int getAverage(Film film){
        double average = 0;
        
        for(Rating rating : this.ratings.get(film)){
            average += rating.getValue();
        }
        
        average /= this.ratings.get(film).size();
        return (int)average;
    }

}
