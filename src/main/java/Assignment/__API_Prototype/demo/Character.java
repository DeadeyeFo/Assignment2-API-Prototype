package Assignment.__API_Prototype.demo;

public class Character {
    public String name;
    private String status;
    private String[] origin;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = new String[] {origin};
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
