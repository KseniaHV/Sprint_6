import com.example.Feline;
import com.example.Lion;
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
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionTest {
    @Mock
    private Feline feline;
    private Lion lion;
    private boolean doesHaveMane;
    private  String sex;
    private List<String> expectedFood;

    public LionTest(String sex, boolean doesHaveMane) {
        this.sex = sex;
        this.doesHaveMane = doesHaveMane;
    }
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        lion = new Lion(sex, feline);
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "Самец", true },
                { "Самка", false }
        });
    }
    @Test
    public void testDoesHaveMane() {
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(doesHaveMane, actualHasMane);
    }
    @Test
    public void testWithInvalidSex() {
        assertThrows(Exception.class, () -> new Lion("InvalidSex", Mockito.mock(Feline.class)));
    }
    @Test
    public void testGetFood() throws Exception {
        Mockito.when(feline.getFood(Mockito.eq("Хищник"))).thenReturn(expectedFood);
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
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
