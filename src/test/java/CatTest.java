import com.example.Animal;
import com.example.Cat;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

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
    try {
        Cat cat = new Cat(feline);
        assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    } catch (Exception e) {
        assertEquals ("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
    }
    }



}
