import com.example.Animal;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)

public class FelineTest {

    private Feline feline;

    @Mock
    private Animal animalMock;

    @BeforeEach
    void setUp() {
        feline = spy(new Feline());
    }

    @Test
    void felineTestGetFamily() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    void felineTestGetKittensWithoutParameters() {
        int kittens = feline.getKittens();
        assertEquals(1, kittens);
    }

    @Test
    void felineTestGetEatMeatReturnsPredatorFood() throws Exception {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }

    @Test
    void felineTestGetEatMeat() throws Exception {
        List<String> expectedFood = Arrays.asList("мясо1", "мясо2");
        doReturn(expectedFood).when(feline).getFood("Хищник");
        List<String> result = feline.eatMeat();
        assertNotNull(result);
        assertEquals(expectedFood, result);
        verify(feline).getFood("Хищник");
    }


}
