import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HistogramTest {

    @Test
    public void sortInputNumbers() {
        //given
        List<Integer> input=Arrays.asList(10,3,1,11,13);

        //when
        Histogram.sortInputNumbers(input);

        //verify
        List<Integer> expected=Arrays.asList(1,3,10,11,13);
        assertEquals(expected,input);
    }

    @Test
    public void sortInputNumbersWithDuplicates() {
        //given
        List<Integer> input=Arrays.asList(10,3,3,11,13);

        //when
        Histogram.sortInputNumbers(input);

        //verify
        List<Integer> expected=Arrays.asList(3,3,10,11,13);
        assertEquals(expected,input);
    }
}