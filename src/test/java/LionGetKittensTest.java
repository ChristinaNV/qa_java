import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LionGetKittensTest {

    static Stream<Object[]> provideKittensData() {
        return Stream.of(
                new Object[]{0},
                new Object[]{1},
                new Object[]{3},
                new Object[]{10}
        );
    }

    @ParameterizedTest(name = "Lion should return {0} kittens")
    @MethodSource("provideKittensData")
    void lionTestKittensCount(int kittensCount) throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(kittensCount);

        Lion lion = new Lion("Самец", felineMock);
        int actualKittens = lion.getKittens();

        assertEquals(kittensCount, actualKittens);
    }

}
