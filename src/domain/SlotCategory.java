package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum SlotCategory {

    GENERAL("general", 2),
    GOLD("occupied", 4),
    PLATINUM("maintenance", 6);

    String category;

    Integer price;

    SlotCategory(String category, Integer price) {
        this.category = category;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
