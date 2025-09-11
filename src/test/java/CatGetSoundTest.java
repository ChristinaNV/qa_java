import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatGetSoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2", "test3", "test4", "test5"})
    void catTestGetSoundParameterized(String iteration) {
        Cat cat = new Cat(new Feline());
        assertEquals("Мяу", cat.getSound());
    }

}
