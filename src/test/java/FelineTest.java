import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class FelineTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    Feline feline = new Feline();

    @Spy
    private Feline felineSpy;

    @Test
    public void getKittenTest() {
       // felineSpy.getKittens(5);
        assertEquals(5, felineSpy.getKittens(5));
    }

    @Test
    public void getKittenTestNoInt() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getFamilyTest() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }


}
