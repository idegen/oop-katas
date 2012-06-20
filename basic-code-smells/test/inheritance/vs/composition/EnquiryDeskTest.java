package inheritance.vs.composition;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class EnquiryDeskTest {
    @Test
    public void testCanFindLendableItemsByTitle() throws Exception {
        //GIVEN
        String bookTitle = "Gulliver's Travel";
        String magazineTitle = "Nature";
        BookInfo gulliverInfo = new BookInfo(1005, bookTitle);
        MagazineInfo natureInfo = new MagazineInfo(50, magazineTitle);
        List<LendableItem> lendableItems = Arrays.asList(gulliverInfo, new BookInfo(2, "The brother Karamazov"), natureInfo);
        EnquiryDesk enquiryDesk = new EnquiryDesk(lendableItems);

        //WHEN
        LendableItem gulliversTravels = enquiryDesk.find(bookTitle);
        LendableItem natureMagazine = enquiryDesk.find(magazineTitle);

        //Then
        assertThat(gulliversTravels, is((LendableItem) gulliverInfo));
        assertThat(natureMagazine, is((LendableItem) natureInfo));
    }

    @Test
    public void testFindsAllLendableItemsThatAreAvailable() throws Exception {
        //GIVEN
        BookInfo aLentBook = new BookInfo(1005, "Gulliver's Travel");
        BookInfo availableBook = new BookInfo(2, "The brother Karamazov");
        MagazineInfo availableMagazin = new MagazineInfo(50, "Nature");
        MagazineInfo lentMagazin = new MagazineInfo(50, "Science");
        aLentBook.lend();
        lentMagazin.lend();

        List<LendableItem> lendableItems = Arrays.asList(aLentBook, availableBook, lentMagazin, availableMagazin);
        EnquiryDesk enquiryDesk = new EnquiryDesk(lendableItems);

        //WHEN
        List<LendableItem> availableItems = enquiryDesk.findAvailableItems();

        //THEN
        assertThat(availableItems.size(), is(2));
        assertThat(availableItems.contains(availableMagazin), is(true));
        assertThat(availableItems.contains(availableBook), is(true));
    }

    @Test
    public void testCanFindBooksByVolume() throws Exception {
        //GIVEN
        BookInfo hugeBook = new BookInfo(1005, "Gulliver's Travel");
        BookInfo anOtherHugeBook = new BookInfo(2000, "The brother Karamazov");
        BookInfo smallBook = new BookInfo(50, "Some other book");
        MagazineInfo hugeMagazin = new MagazineInfo(1009, "Nature");
        MagazineInfo smallMagazin = new MagazineInfo(50, "A small magazin");

        List<LendableItem> lendableItems = Arrays.asList(hugeBook, anOtherHugeBook, smallMagazin, hugeMagazin, smallBook);
        EnquiryDesk enquiryDesk = new EnquiryDesk(lendableItems);

        //WHEN
        List<LendableItem> hugeLitrature = enquiryDesk.find(VolumeSize.huge);

        //THEN
        assertThat(hugeLitrature.size(), is(3));
        assertThat(hugeLitrature.contains(hugeBook), is(true));
        assertThat(hugeLitrature.contains(anOtherHugeBook), is(true));
        assertThat(hugeLitrature.contains(hugeMagazin), is(true));
    }
}
