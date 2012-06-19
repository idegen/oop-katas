package composition;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class BookInfoTest {
    @Test
    public void testThatBookReturnsNullIfNotLend() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo();

        //WHEN
        LocalDate returnDate = bookInfo.returnDueDate();

        //THEN
        assertThat(returnDate, is(nullValue()));
    }

    @Test
    public void testThatBookReturnsReturnDueDateInOneMonthsFromNowIfLend() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo();
        LocalDate inAMonthsTime = DateTime.now().plusMonths(1).toLocalDate();

        //WHEN
        bookInfo.lend();

        //THEN
        assertThat(bookInfo.returnDueDate(), is(inAMonthsTime));
    }

    @Test
    public void testBookLoosesReturnDateWhenReturned() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo();
        bookInfo.lend();

        //WHEN
        bookInfo.returnBook();

        //THEN
        assertThat(bookInfo.returnDueDate(), is(nullValue()));
    }

    @Test
    public void testBookWithMoreThan1000PagesIsHuge() throws Exception {

    }
}
