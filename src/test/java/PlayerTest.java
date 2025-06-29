import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldGetPlayer() {
        Player player = new Player(1, "Алексей", 56);

        int expectedId = 1;
        String expectedName = "Алексей";
        int expectedStrength = 56;

        int actualeId = player.getId();
        String actualeName = player.getName();
        int actualeStrength = player.getStrength();

        Assertions.assertEquals(expectedId, actualeId);
        Assertions.assertEquals(expectedName, actualeName);
        Assertions.assertEquals(expectedStrength, actualeStrength);
    }
}
