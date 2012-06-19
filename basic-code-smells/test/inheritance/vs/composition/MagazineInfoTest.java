package inheritance.vs.composition;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class MagazineInfoTest {
    @Test
    public void testThatMagazineReturnsNullIfNotLend() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(100, "Some Magazine");

        //WHEN
        LocalDate returnDate = MagazineInfo.returnDueDate();

        //THEN
        assertThat(returnDate, is(nullValue()));
    }

    @Test
    public void testThatMagazineReturnsReturnDueDateInOneMonthsFromNowIfLend() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(100, "Some Magazine");
        LocalDate inAMonthsTime = DateTime.now().plusMonths(1).toLocalDate();

        //WHEN
        MagazineInfo.lend();

        //THEN
        assertThat(MagazineInfo.returnDueDate(), is(inAMonthsTime));
    }

    @Test
    public void testMagazineLoosesReturnDateWhenReturned() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(100, "Some Magazine");
        MagazineInfo.lend();

        //WHEN
        MagazineInfo.bringLentItemBack();

        //THEN
        assertThat(MagazineInfo.returnDueDate(), is(nullValue()));
    }

    @Test
    public void testMagazineWithMoreThan1000PagesIsHuge() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(1001, "Some Magazine");
        //WHEN & THEN
        assertThat(MagazineInfo.volumeToRead(), is(VolumeSize.huge));
    }

    @Test
    public void testMagazineWithMoreThan300PagesButLessThan1000PagesIsBig() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(1000, "Some Magazine");
        MagazineInfo anotherMagazineInfo = new MagazineInfo(301, "Some Magazine");
        //WHEN & THEN
        assertThat(MagazineInfo.volumeToRead(), is(VolumeSize.big));
        assertThat(anotherMagazineInfo.volumeToRead(), is(VolumeSize.big));
    }

    @Test
    public void testMagazineWithMoreThan100PagesButLessThan300PagesIsMedium() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(101, "Some Magazine");
        MagazineInfo anotherMagazineInfo = new MagazineInfo(300, "Some Magazine");
        //WHEN & THEN
        assertThat(MagazineInfo.volumeToRead(), is(VolumeSize.medium));
        assertThat(anotherMagazineInfo.volumeToRead(), is(VolumeSize.medium));
    }

    @Test
    public void testMagazineWithLessThan100PagesIsSmall() throws Exception {
        //GIVEN
        MagazineInfo MagazineInfo = new MagazineInfo(0, "Some Magazine");
        MagazineInfo anotherMagazineInfo = new MagazineInfo(100, "Some Magazine");
        //WHEN & THEN
        assertThat(MagazineInfo.volumeToRead(), is(VolumeSize.small));
        assertThat(anotherMagazineInfo.volumeToRead(), is(VolumeSize.small));
    }

    @Test
    public void testTwoMagazinesWithSameTitleAreEqual() throws Exception {
        //GIVEN
        MagazineInfo aMagazineInfo = new MagazineInfo(0, "Science");
        MagazineInfo anotherMagazineInfo = new MagazineInfo(100, "Science");
        //WHEN & THEN
        assertThat(aMagazineInfo, is(anotherMagazineInfo));
    }
}
