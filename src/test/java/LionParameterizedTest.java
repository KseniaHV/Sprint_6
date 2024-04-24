import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class LionParameterizedTest {
    @Mock
    private Feline feline;
    private Lion lion;
    private boolean doesHaveMane;
    private  String sex;
    public LionParameterizedTest(String sex, boolean doesHaveMane) {
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
}


