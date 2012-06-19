package inheritance.vs.composition;

import inheritance.vs.composition.BookInfo;
import inheritance.vs.composition.VolumeSize;
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
        BookInfo bookInfo = new BookInfo(100, "Some Book Title");

        //WHEN
        LocalDate returnDate = bookInfo.returnDueDate();

        //THEN
        assertThat(returnDate, is(nullValue()));
    }

    @Test
    public void testThatBookReturnsReturnDueDateInOneMonthsFromNowIfLend() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(100, "Some Book Title");
        LocalDate inAMonthsTime = DateTime.now().plusMonths(1).toLocalDate();

        //WHEN
        bookInfo.lend();

        //THEN
        assertThat(bookInfo.returnDueDate(), is(inAMonthsTime));
    }

    @Test
    public void testBookLoosesReturnDateWhenReturned() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(100, "Some Book Title");
        bookInfo.lend();

        //WHEN
        bookInfo.bringLentItemBack();

        //THEN
        assertThat(bookInfo.returnDueDate(), is(nullValue()));
    }

    @Test
    public void testBookWithMoreThan1000PagesIsHuge() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(1001, "Some Book Title");
        //WHEN & THEN
        assertThat(bookInfo.volumeToRead(), is(VolumeSize.huge));
    }

    @Test
    public void testBookWithMoreThan300PagesButLessThan1000PagesIsBig() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(1000, "Some Book Title");
        BookInfo anotherBookInfo = new BookInfo(301, "Some Book Title");
        //WHEN & THEN
        assertThat(bookInfo.volumeToRead(), is(VolumeSize.big));
        assertThat(anotherBookInfo.volumeToRead(), is(VolumeSize.big));
    }

    @Test
    public void testBookWithMoreThan100PagesButLessThan300PagesIsMedium() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(101, "Some Book Title");
        BookInfo anotherBookInfo = new BookInfo(300, "Some Book Title");
        //WHEN & THEN
        assertThat(bookInfo.volumeToRead(), is(VolumeSize.medium));
        assertThat(anotherBookInfo.volumeToRead(), is(VolumeSize.medium));
    }

    @Test
    public void testBookWithLessThan100PagesIsSmall() throws Exception {
        //GIVEN
        BookInfo bookInfo = new BookInfo(0, "Some Book Title");
        BookInfo anotherBookInfo = new BookInfo(100, "Some Book Title");
        //WHEN & THEN
        assertThat(bookInfo.volumeToRead(), is(VolumeSize.small));
        assertThat(anotherBookInfo.volumeToRead(), is(VolumeSize.small));
    }

    @Test
    public void testTwoBooksWithSameTitleAreEqual() throws Exception {
        //GIVEN
        BookInfo aBookInfo = new BookInfo(0, "Some Book Title");
        BookInfo anotherBookInfo = new BookInfo(100, "Some Book Title");
        //WHEN & THEN
        assertThat(aBookInfo, is(anotherBookInfo));
    }
}
