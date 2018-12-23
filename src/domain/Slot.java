package domain;

/**
 * Created by Karan Uppal on 15/12/18.
 */

public class Slot {

    SlotSize slotSize = SlotSize.MEDIUM;

    SlotCategory slotCategory = SlotCategory.GENERAL;

    public SlotSize getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(SlotSize slotSize) {
        this.slotSize = slotSize;
    }

    public SlotCategory getSlotCategory() {
        return slotCategory;
    }

    public void setSlotCategory(SlotCategory slotCategory) {
        this.slotCategory = slotCategory;
    }
}
