import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class FelineParameterizedTest {
    private Feline feline;
    private int expectedKittens;
    public FelineParameterizedTest(int expectedKittens) {
        this.expectedKittens = expectedKittens;
    }
    @Before
    public void setUp() {
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
    public void testGetKittensWithParam() {
        int actualKittens = feline.getKittens(expectedKittens);
        assertEquals(expectedKittens, actualKittens);
    }
}