package homework_08.database;

import homework_08.model.Movie;
import homework_08.model.Serial;

public class FilmDatabase {
    public static Movie[] movies = {
            new Movie(1, "Batman", "Action", "Matt Reeves", 2022, 175),
            new Movie(2, "Điện thoại đen", "Horrified", "Scott Derrickson", 2021, 102),
            new Movie(3, "Gia đình Addams", "Cartoon", "Conrad Vernon", 2019, 87),
            new Movie(4, "Harry Potter và Chiếc cốc lửa", "Magic", " Mike Newell", 2005, 157),
            new Movie(5, "Thor: Tình Yêu Và Sấm Sét", "Action", " Taika Waititi", 2022, 118)

    };
    public static Serial[] serials = {
            new Serial(6, "Breaking Bad", "Criminal", "Vince Gilligan", 2008, 62, 25),
            new Serial(7, "Game Of Thrones", "Fiction", "David Beniof", 2011, 73, 50),
            new Serial(8, "Friends", "Comedy", "David Cranef", 1994, 236, 20),
            new Serial(9, "VPrison Break", "Action", "Paul Scheuring", 2005, 90, 45),
            new Serial(10, "The Walking Dead", "Horrified", "Frank Darabont", 2010, 169, 50),
    };
}