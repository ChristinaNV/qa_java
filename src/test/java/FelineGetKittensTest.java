import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineGetKittensTest {

    @ParameterizedTest
    @MethodSource("kittensDataProvider")
    void felineTestGetKittensWithParameter(int kittensCount, int expected) {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittensCount);
        assertEquals(expected, actual);
    }

    static Stream<Object[]> kittensDataProvider() {
        return Stream.of(
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{3, 3},
                new Object[]{7, 7},
                new Object[]{10, 10}
        );
    }
}
