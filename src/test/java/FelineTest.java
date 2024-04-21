import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class FelineTest {
    @Mock
    private Animal animal;
    private Feline feline;
    private int expectedKittens;

    public FelineTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
    }
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        feline = new Feline();
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5 },
                { 3 },
                { 1 }
        });
    }
    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
       Mockito.when(animal.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }
    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
    }
    @Test
    public void testGetKittens() {
        assertEquals(1, feline.getKittens());
    }
    @Test
    public void testGetKittensWithParam() {
        int actualKittens = feline.getKittens(expectedKittens);
        assertEquals(expectedKittens, actualKittens);
    }
}