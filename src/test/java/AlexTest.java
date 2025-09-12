import com.example.Alex;
import com.example.Feline;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlexTest {

    @Test
    void alexTestHasMane() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Alex alex = new Alex(feline);

        assertTrue(alex.doesHaveMane());
    }

    @Test
    void alexTestKittensAlwaysZero() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Alex alex = new Alex(feline);

        assertEquals(0, alex.getKittens());
    }

    @Test
    void alexTestGetFriends() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Alex alex = new Alex(feline);

        List<String> friends = alex.getFriends();

        assertNotNull(friends);
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
    }

    @Test
    void alexTestGetPlaceOfLiving() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Alex alex = new Alex(feline);

        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void alexTestGetKittensOverride() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        Mockito.when(feline.getKittens()).thenReturn(5);

        Alex alex = new Alex(feline);

        assertEquals(0, alex.getKittens());
        assertEquals(0, alex.getKittens());
    }

    @Test
    void alexTestInheritedPredatorBehavior() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        List<String> expectedFood = List.of("мясо");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);

        Alex alex = new Alex(feline);
        List<String> food = alex.getFood();

        assertEquals(expectedFood, food);
        Mockito.verify(feline).getFood("Хищник");
    }

}
