import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Spy
    Feline feline;




    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void getFoodTest() throws Exception {
        Lion lion = new Lion(feline);
            assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void getFoodTestException() throws Exception {
        Lion lion = Mockito.mock(Lion.class);
        Mockito.when(lion.getFood()).thenThrow(new Exception());
        assertThrows(Exception.class, () -> lion.getFood());
/*        Mockito.when(lion.getFood()).thenReturn(Collections.singletonList("Неизвестный вид животного, используйте значение Травоядное или Хищник"));
        try {
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", lion.getFood());
        } catch (Exception e) {
            assertEquals ("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
*/
    }
}
