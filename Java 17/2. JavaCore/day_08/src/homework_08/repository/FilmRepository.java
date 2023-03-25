package homework_08.repository;

import homework_08.database.FilmDatabase;
import homework_08.model.Movie;
import homework_08.model.Serial;

public class FilmRepository {
    public Movie[] findMovie(){
        return FilmDatabase.movies;
    }

    public Serial[] findSerial(){
        return FilmDatabase.serials;
    }
}
