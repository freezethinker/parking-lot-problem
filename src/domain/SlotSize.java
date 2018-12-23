package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public enum SlotSize {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large"),
    EXTRA_LARGE("extra_large");

    private String size;

    SlotSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }
}
