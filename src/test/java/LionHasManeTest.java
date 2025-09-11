import com.example.Lion;
import com.example.Predator;
import com.example.Sex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LionHasManeTest {

    static Stream<Object[]> provideSexData() {
        return Stream.of(
                new Object[]{Sex.MALE, true, "Самец"},
                new Object[]{Sex.FEMALE, false, "Самка"}
        );
    }

    @ParameterizedTest(name = "Lion with sex={0} → hasMane={1}, getSex()={2}")
    @MethodSource("provideSexData")
    void lionTestSexAndMane(Sex sex, boolean expectedHasMane, String expectedSex) throws Exception {
        Predator predatorMock = mock(Predator.class);
        Lion lion = new Lion(sex, predatorMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
        assertEquals(expectedSex, lion.getSex());
    }

}
