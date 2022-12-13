package homework_08.model;

public class Serial extends Film {
    private int episodes;
    private int avgTime;

    public Serial() {
    }

    public Serial(int id, String title, String category, String director, int premiereDate, int episodes, int avgTime) {
        super(id, title, category, director, premiereDate);
        this.episodes = episodes;
        this.avgTime = avgTime;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", derector='" + getDirector() + '\'' +
                ", premiereDate=" + getPremiereDate() +
                ", episodes=" + episodes +
                ", avgtime=" + avgTime +
                '}';
    }
}
