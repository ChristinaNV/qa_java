import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Test
    void lionTestDefaultKittens() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion("Самка", felineMock);
        int kittens = lion.getKittens();

        assertEquals(1, kittens);
        verify(felineMock).getKittens();
    }

    @Test
    void lionTestGetFood() throws Exception {
        Feline felineMock = mock(Feline.class);
        List<String> expectedFood = Arrays.asList("мясо1", "мясо2");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertEquals(expectedFood, food);
        verify(felineMock).getFood("Хищник");
    }

    @Test
    void lionTestGetFoodThrowsException() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getFood("Хищник")).thenThrow(new Exception("Hunting failed"));

        Lion lion = new Lion("Самец", felineMock);

        Exception exception = assertThrows(Exception.class, lion::getFood);
        assertEquals("Hunting failed", exception.getMessage());
        verify(felineMock).getFood("Хищник");
    }

    @Test
    void lionTestGetFoodEmptyList() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getFood("Хищник")).thenReturn(List.of());

        Lion lion = new Lion("Самец", felineMock);
        List<String> food = lion.getFood();

        assertNotNull(food);
        assertTrue(food.isEmpty());
        verify(felineMock).getFood("Хищник");
    }

    @Test
    void lionTestDoesHaveMane() throws Exception {
        Feline felineMock = mock(Feline.class);

        Lion maleLion = new Lion("Самец", felineMock);
        Lion femaleLion = new Lion("Самка", felineMock);

        assertTrue(maleLion.doesHaveMane());
        assertFalse(femaleLion.doesHaveMane());
    }

    @Test
    void lionTestGetSex() throws Exception {
        Feline felineMock = mock(Feline.class);

        Lion maleLion = new Lion("Самец", felineMock);
        Lion femaleLion = new Lion("Самка", felineMock);

        assertEquals("Самец", maleLion.doesHaveMane() ? "Самец" : "Самка");
        assertEquals("Самка", femaleLion.doesHaveMane() ? "Самец" : "Самка");
    }

}
