package inheritance.vs.composition;

import java.util.ArrayList;
import java.util.List;

public class EnquiryDesk {
    private List<LendableItem> lendableItems;

    public EnquiryDesk(List<LendableItem> lendableItems) {
        this.lendableItems = lendableItems;
    }

    public LendableItem find(String title) {
        for (LendableItem item : lendableItems) {
            if(item.getTitle() == title ) return item;
        }
        return null;
    }

    public List<LendableItem> findAvailableItems() {
        ArrayList<LendableItem> results = new ArrayList<LendableItem>();
        for (LendableItem item : lendableItems) {
            if(item.returnDueDate() == null) results.add(item);
        }
        return results;
    }
}
