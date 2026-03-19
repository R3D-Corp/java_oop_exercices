package labs.starwars;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class MeleeTest {

  @Test
  public void returnsAnEmptyFightersArrayOnInit() {
    Melee melee = new Melee();

    String[][] actual = melee.getFightersArray();

    assertNotNull(actual);
    assertEquals(0, actual.length);
  }

  @Test
  public void returnsAnEmptyMessageOnInit() {
    Melee melee = new Melee();

    String actual = melee.getLastMessage();

    assertEquals("", actual);
  }

  @Test
  public void returnsAtLeast2KindOfFighters() {
    Melee melee = new Melee();

    String[] actual = melee.getFightersKind();

    assertNotNull(actual);
    assertTrue(2 <= actual.length);
  }

  @Test
  public void addsForceUserRequest() {
    Melee melee = new Melee();
    AddFighterRequest request = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);

    melee.addFighter(request);

    String[][] actual = melee.getFightersArray();
    String[] expected = {
        "Obi Wan Kenobi", "Jedi", "HP: 200", "DP: 40"
    };

    assertEquals(1, actual.length);
    assertArrayEquals(expected, actual[0]);
  }

  @Test
  public void addsManyForceUserRequest() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    AddFighterRequest request2 = new AddFighterRequest(
        "Sith", "Darth Sidious", 300, 35);
    melee.addFighter(request2);

    String[][] actual = melee.getFightersArray();
    String[] expectedRow0 = {
        "Obi Wan Kenobi", "Jedi", "HP: 200", "DP: 40"
    };
    String[] expectedRow1 = {
        "Darth Sidious", "Sith", "HP: 300", "DP: 35"
    };

    assertEquals(2, actual.length);
    assertArrayEquals(expectedRow0, actual[0]);
    assertArrayEquals(expectedRow1, actual[1]);
  }

  @Test
  public void getsAliveCount() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    AddFighterRequest request2 = new AddFighterRequest(
        "Sith", "Darth Sidious", 300, 35);
    melee.addFighter(request2);

    assertEquals(2, melee.getAlivesCount());
  }

  @Test
  public void updatesLastMessageOnActionMade() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    AddFighterRequest request2 = new AddFighterRequest(
        "Sith", "Darth Sidious", 300, 35);
    melee.addFighter(request2);

    melee.makeNextAction();

    assertNotEquals("", melee.getLastMessage());
  }

  @Test
  public void updatesFightersArrayOnActionMade() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    AddFighterRequest request2 = new AddFighterRequest(
        "Sith", "Darth Sidious", 300, 35);
    melee.addFighter(request2);

    melee.makeNextAction();

    String[][] actual = melee.getFightersArray();
    String[] expectedRow0 = {
        "Obi Wan Kenobi", "Jedi", "HP: 200", "DP: 40"
    };
    String[] expectedRow1 = {
        "Darth Sidious", "Sith", "HP: 300", "DP: 35"
    };

    assertEquals(2, actual.length);
    assertTrue(
        (Arrays.equals(expectedRow0, actual[0]) && !Arrays.equals(expectedRow1, actual[1])) ||
            (!Arrays.equals(expectedRow0, actual[0])
                && Arrays.equals(expectedRow1, actual[1])));
  }

  @Test
  public void ignoresActionWhenOnlyOneFighterIsAlive() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    String expected = melee.getLastMessage();

    melee.makeNextAction();

    assertEquals(expected, melee.getLastMessage());
  }

  @Test
  public void makeActionUntilOnlyOneFighterIsAlive() {
    Melee melee = new Melee();

    AddFighterRequest request1 = new AddFighterRequest(
        "Jedi", "Obi Wan Kenobi", 200, 40);
    melee.addFighter(request1);

    AddFighterRequest request2 = new AddFighterRequest(
        "Sith", "Darth Sidious", 300, 35);
    melee.addFighter(request2);

    while (melee.getAlivesCount() > 1) {
      melee.makeNextAction();
    }

    assertTrue(melee.getLastMessage().contains("est mort !"));
    assertTrue(melee.getLastMessage().contains("Le vainqueur est "));
  }
}
