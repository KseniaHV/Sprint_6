import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Mock
    private Animal animal;
    private Feline feline;
    @Before
    public void setUp() {
        feline = new Feline();
    }
    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.lenient().when(animal.getFood("Хищник")).thenReturn(expectedFood);
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
}
