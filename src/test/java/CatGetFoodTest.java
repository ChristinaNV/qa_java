import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatGetFoodTest {
    @ParameterizedTest
    @MethodSource("foodDataProvider")
    void catTestGetFoodWithDifferentData(List<String> expectedFood) throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedFood);

        Cat cat = new Cat(felineMock);
        List<String> result = cat.getFood();

        assertEquals(expectedFood, result);
    }

    static Stream<List<String>> foodDataProvider() {
        return Stream.of(
                Arrays.asList("курица", "говядина"),
                List.of("рыба"),
                List.of(), // пустой список
                Arrays.asList("кролик", "утка", "индейка")
        );
    }
}
