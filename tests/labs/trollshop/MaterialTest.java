package labs.trollshop;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaterialTest {

  @BeforeAll
  public static void setupLocale() {
    // Prévient les soucis de mises en forme selon la langue
    // (Ex: 10.0f --> 10,0 en français, mais --> 10.0 en anglais).
    Locale.setDefault(Locale.ENGLISH);
  }

  @Test
  void should_have_a_positive_durability() {
    for (Material m : Material.values()) {
      assertTrue(m.getDurability() > 0.0f,
          "%s doit avoir une solidité > 0.0f. Reçu " + m.getDurability());
    }
  }

  @Test
  void should_format_display_string_properly() {
    for (Material m : Material.values()) {
      String displayString = m.toDisplayString();
      assertTrue(Character.isUpperCase(displayString.charAt(0)),
          displayString + " devrait commencer par une majuscule");
      assertFalse(displayString.contains("_"),
          displayString + " ne devrait pas avoir de soulignement");
    }
  }

  @Test
  void should_include_name_and_durability_in_to_string() {
    for (Material m : Material.values()) {
      String string = m.toString();
      assertTrue(string.startsWith(m.name()),
          string + " devrait commencer par l'identifiant de l'élément");
      assertTrue(string.matches(".*durability.*\\d+.*"));
    }
  }


}
