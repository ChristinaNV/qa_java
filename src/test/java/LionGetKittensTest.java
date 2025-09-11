import com.example.Lion;
import com.example.Predator;
import com.example.Sex;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class LionGetKittensTest {

    static Stream<Object[]> provideKittensData() {
        return Stream.of(
                new Object[]{0},
                new Object[]{1},
                new Object[]{3},
                new Object[]{10}
        );
    }

    @ParameterizedTest(name = "Lion with kittens={0} → getKittens()={0}")
    @MethodSource("provideKittensData")
    void lionTestKittensCount(int kittensCount) throws Exception {
        Predator predatorMock = mock(Predator.class);
        Lion lion = new Lion(Sex.MALE, predatorMock, kittensCount);

        assertEquals(kittensCount, lion.getKittens());
    }

}
