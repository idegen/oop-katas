package composition;

import org.joda.time.LocalDate;

public abstract class Book {
    private LocalDate returnDueDate;

    public void lend() {
        returnDueDate = LocalDate.now().plusMonths(1);
    }

    public LocalDate returnDueDate() {
        return returnDueDate;
    }

    public void returnBook() {
        this.returnDueDate = null;
    }
}
