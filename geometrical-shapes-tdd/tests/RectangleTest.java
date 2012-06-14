import org.junit.Test;
import tddshapes.Rectangle;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RectangleTest {
    @Test
    public void returnsTheAreaOfTheRectangle() {
        //Given
        Rectangle rectangle = new Rectangle(10, 5);

        //When
        double area = rectangle.calculateArea();

        //Then
        assertThat(area, is(50d));
    }
}
