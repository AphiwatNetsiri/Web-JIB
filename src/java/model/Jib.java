package model;

public class Jib {

    private String name;
    private String type;
    private int price;
    private String[] filter;
    private String popularity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String[] getFilter() {
        return filter;
    }
    
    public void setFilter(String[] filter) {
        this.filter = filter;
    }
    
    public String getPopularity() {
        return popularity;
    }
    
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
