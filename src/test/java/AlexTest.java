import com.example.Alex;
import com.example.Predator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlexTest {

    @Test
    void alexTestCreation() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);

        assertTrue(alex.doesHaveMane());
        assertEquals("Самец", alex.getSex());

        assertEquals(0, alex.getKittens());
    }

    @Test
    void alexTestGetFriends() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);

        List<String> friends = alex.getFriends();

        assertNotNull(friends);
        assertEquals(3, friends.size());
        assertTrue(friends.contains("Марти"));
        assertTrue(friends.contains("Глория"));
        assertTrue(friends.contains("Мелман"));
        assertEquals(List.of("Марти", "Глория", "Мелман"), friends);
    }

    @Test
    void alexTestGetPlaceOfLiving() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);

        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    void alexTestGetKittensOverride() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        Alex alex = new Alex(predator);

        assertEquals(0, alex.getKittens());
        assertEquals(0, alex.getKittens());
        assertEquals(0, alex.getKittens());
    }

    @Test
    void alexTestInheritedPredatorBehavior() throws Exception {
        Predator predator = Mockito.mock(Predator.class);
        List<String> expectedFood = List.of("мясо");
        Mockito.when(predator.eatMeat()).thenReturn(expectedFood);

        Alex alex = new Alex(predator);
        List<String> food = alex.getFood();

        assertEquals(expectedFood, food);
        Mockito.verify(predator).eatMeat();
    }

}
