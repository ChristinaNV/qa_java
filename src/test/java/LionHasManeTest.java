import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LionHasManeTest {

    static Stream<Object[]> provideSexData() {
        return Stream.of(
                new Object[]{"Самец", true},
                new Object[]{"Самка", false}
        );
    }

    @ParameterizedTest(name = "Lion with sex={0} → hasMane={1}")
    @MethodSource("provideSexData")
    void lionTestSexAndMane(String sex, boolean expectedHasMane) throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion(sex, felineMock);

        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

}
