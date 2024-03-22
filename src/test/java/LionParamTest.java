import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionParamTest {



    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    private final String sex;

    private final Boolean hasMane;

    public LionParamTest(String sex, Boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void LionParamTest() throws Exception {
        Feline feline = Mockito.mock((Feline.class));
            Lion lion = new Lion(sex, feline);
            assertEquals(hasMane, lion.doesHaveMane());
    }



}
