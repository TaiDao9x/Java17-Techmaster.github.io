package homework_08.database;

import homework_08.model.Movie;
import homework_08.model.Serial;

public class FilmDatabase {
    public static Movie[] movies = {
            new Movie(1, "Batman", "Action", "Matt Reeves", 2022, 175),
            new Movie(2, "Điện thoại đen", "Horrified", "Scott Derrickson", 2021, 102),
            new Movie(3, "Gia đình Addams", "Cartoon", "Conrad Vernon", 2019, 87)
    };
    public static Serial[] serials = {
            new Serial(4, "Breaking Bad", "Criminal", "Vince Gilligan", 2008, 62, 25),
            new Serial(5, "Game Of Thrones", "Fiction", "David Beniof", 2011, 73, 50),
            new Serial(6, "Friends", "Comedy", "David Cranef", 1994, 236, 20),
    };
}