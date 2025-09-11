import com.example.Lion;
import com.example.Predator;
import com.example.Sex;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    void lionTestGetKittensDefault() throws Exception {
        Predator predatorMock = mock(Predator.class);
        Lion lion = new Lion(Sex.FEMALE, predatorMock);
        assertEquals(1, lion.getKittens());
    }

    @Test
    void lionTestGetFood() throws Exception {
        Predator predatorMock = mock(Predator.class);
        List<String> expectedFood = Arrays.asList("мясо1", "мясо2");
        when(predatorMock.eatMeat()).thenReturn(expectedFood);
        Lion lion = new Lion(Sex.MALE, predatorMock);
        List<String> food = lion.getFood();
        assertEquals(expectedFood, food);
        verify(predatorMock).eatMeat();
    }

    @Test
    void lionTestGetFoodThrowsException() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenThrow(new Exception("Hunting failed"));

        Lion lion = new Lion(Sex.MALE, predatorMock);

        Exception exception = assertThrows(Exception.class, lion::getFood);
        assertEquals("Hunting failed", exception.getMessage());
        verify(predatorMock).eatMeat();
    }

    @Test
    void lionTestGetFoodEmptyList() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of());
        Lion lion = new Lion(Sex.MALE, predatorMock);
        List<String> food = lion.getFood();
        assertNotNull(food);
        assertTrue(food.isEmpty());
        verify(predatorMock).eatMeat();
    }

    @Test
    void lionTestMultipleCalls() throws Exception {
        Predator predatorMock = mock(Predator.class);
        when(predatorMock.eatMeat()).thenReturn(List.of("meat"));
        Lion lion = new Lion(Sex.FEMALE, predatorMock, 3);

        assertFalse(lion.doesHaveMane());
        assertEquals(3, lion.getKittens());
        assertEquals("Самка", lion.getSex());
        assertEquals(List.of("meat"), lion.getFood());

        verify(predatorMock).eatMeat();
    }

}
