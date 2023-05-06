package entity;

public class Factory implements InputInfo {

    private int id;
    private String name;
    private String description;
    private float productivity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getProductivity() {
        return productivity;
    }

    public void setProductivity(float productivity) {
        this.productivity = productivity;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", productivity=" + productivity +
                '}';
    }

    @Override
    public void inputInfo() {
        // TODO - tự viết
    }
}
