import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;
    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", feline);
    }
    @Test
    public void testWithInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", feline));
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        List<String> actual = lion.getFood();
        assertEquals(expectedFood, actual);
    }
    @Test
    public void testGetKittens() {
        int expectedKittensCount = 3;
        Mockito.when(feline.getKittens()).thenReturn(expectedKittensCount);
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
        Mockito.verify(feline).getKittens();
    }
}
