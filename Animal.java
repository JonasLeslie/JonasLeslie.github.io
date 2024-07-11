public class Animal {
    private String name;
    private int thumbnail;
    private String description;

    public Animal(String name, int thumbnail, String description) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public String getDescription() {
        return description;
    }
}
