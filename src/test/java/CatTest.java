import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class CatTest {

    @Mock
    private Feline felineMock;
    private Cat cat;

    @BeforeEach
    void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    void catTestGetSoundMay() {
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void catTestGetSound() {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void catTestGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Птица", "Животные");
        when(felineMock.eatMeat()).thenReturn(expectedFood);
        List<String> result = cat.getFood();
        assertEquals(expectedFood, result);
        verify(felineMock).eatMeat();
    }

    @Test
    public void catTestGetFoodDelegatesToPredator() throws Exception {
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.eatMeat()).thenReturn(List.of("Птица"));
        Cat cat = new Cat(felineMock);
        List<String> result = cat.getFood();
        assertEquals(List.of("Птица"), result);
    }

    @Test
    void catTestGetFoodReturnsEmptyList() throws Exception {
        when(felineMock.eatMeat()).thenReturn(List.of());
        List<String> result = cat.getFood();
        assertNotNull(result);
        assertTrue(result.isEmpty());
        verify(felineMock).eatMeat();
    }
}



