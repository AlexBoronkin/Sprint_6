import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CatTest {

    @Before
    public void init() {
    MockitoAnnotations.initMocks(this);
}

    @Mock
    Feline feline;


    Cat cat = new Cat(feline);

    @Test
    public void getSoundTest() {
        String expected = "Мяу";
        String actual = cat.getSound();
        assertEquals(expected,actual);
    }



    @Test
    public void getFoodTestCat() throws Exception {
    Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
          Cat cat = new Cat(feline);
        assertEquals(feline.eatMeat(), cat.getFood());

    }


}
