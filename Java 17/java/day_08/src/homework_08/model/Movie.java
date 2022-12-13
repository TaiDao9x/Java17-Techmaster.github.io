package homework_08.model;

public class Movie extends Film {
    private int time;

    public Movie() {
    }

    public Movie(int id, String title, String category, String director, int premiereDate, int time) {
        super(id, title, category, director, premiereDate);
        this.time = time;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", derector='" + getDirector() + '\'' +
                ", premiereDate=" + getPremiereDate() +
                ", time=" + time +
                '}';
    }
}
