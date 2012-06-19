package inheritance.vs.composition;

import org.joda.time.LocalDate;

public abstract class LendableItem {
    private LocalDate returnDueDate;
    private Integer pages;
    private String title;
    private final Integer hugePages = 1000;
    private final Integer bigPages = 300;
    private final Integer mediumPages = 100;

    public LendableItem(int pages, String title) {
        this.pages = pages;
        this.title = title;
    }

    public void lend() {
        returnDueDate = LocalDate.now().plusMonths(1);
    }

    public LocalDate returnDueDate() {
        return returnDueDate;
    }

    public void bringLentItemBack() {
        this.returnDueDate = null;
    }

    public VolumeSize volumeToRead(){
        if (pages.compareTo(hugePages) > 0) return VolumeSize.huge;
        if (pages.compareTo(bigPages) > 0) return VolumeSize.big;
        if (pages.compareTo(mediumPages) > 0) return VolumeSize.medium;
        return VolumeSize.small;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LendableItem that = (LendableItem) o;

        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    public String getTitle(){
        return title;
    }
}
