package labs.trollshop;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ArmorTest {

  @BeforeAll
  public static void setupLocale() {
    Locale.setDefault(Locale.ENGLISH);
  }

  @Test
  public void should_construct_armor_with_valid_args() {
  Armor armor = new Armor("Test Armor", Material.GOLD, Material.IRON, Material.SILVER);
  assertEquals("Test Armor", armor.getName());
  assertEquals(Material.GOLD, armor.getChestplate());
  assertEquals(Material.IRON, armor.getLeggings());
  assertEquals(Material.SILVER, armor.getArmguards());
  }
  
  @Test
  public void should_construct_armor_with_single_material() {
  Armor armor = new Armor("Uniform Armor", Material.DIAMOND);
  assertEquals("Uniform Armor", armor.getName());
  assertEquals(Material.DIAMOND, armor.getChestplate());
  assertEquals(Material.DIAMOND, armor.getLeggings());
  assertEquals(Material.DIAMOND, armor.getArmguards());
  }
  
  @Test
  public void should_reject_armor_with_null_or_blank_name() {
  assertThrows(IllegalArgumentException.class,
  () -> new Armor(null, Material.OAK_WOOD, Material.IRON, Material.GOLD));
  
  assertThrows(IllegalArgumentException.class,
  () -> new Armor(" ", Material.OAK_WOOD, Material.IRON, Material.GOLD));
  }
  
  @Test
  public void should_reject_armor_with_null_component() {
  assertThrows(IllegalArgumentException.class,
  () -> new Armor("Test Armor", null, Material.IRON, Material.GOLD));
  assertThrows(IllegalArgumentException.class,
  () -> new Armor("Test Armor", Material.OAK_WOOD, null, Material.GOLD));
  assertThrows(IllegalArgumentException.class,
  () -> new Armor("Test Armor", Material.OAK_WOOD, Material.IRON, null));
  assertThrows(IllegalArgumentException.class,
  () -> new Armor("Test Armor", null));
  }
  
  @Test
  public void reject_setter_with_null() {
  Armor armor = new Armor("Test Armor", Material.OAK_WOOD, Material.IRON, Material.GOLD);
  assertThrows(IllegalArgumentException.class, () -> armor.setChestplate(null));
  assertThrows(IllegalArgumentException.class, () -> armor.setLeggings(null));
  assertThrows(IllegalArgumentException.class, () -> armor.setArmguards(null));
  }
  
  @Test
  public void should_override_to_string() {
  Armor armor = new Armor("Test Armor", Material.OAK_WOOD, Material.IRON, Material.GOLD);
  
  String actual = armor.toString();
  
  assertTrue(actual.startsWith("Test Armor"));
  assertTrue(actual.contains("OAK_WOOD"));
  assertTrue(actual.contains("IRON"));
  assertTrue(actual.contains("GOLD"));
  }
  
  @Test
  public void should_compute_durability_for_simple_case() {
  Armor armor = new Armor("Test Armor", Material.IRON, Material.SILVER, Material.GOLD);
  
  float expected = 48.75f;
  
  assertEquals(expected, armor.getDurability(), 0.01f);
  }
  
  @Test
  public void should_compute_durability_for_two_same() {
  Armor armor = new Armor("Test Armor", Material.COPPER,
  Material.COPPER, Material.GOLD);
  
  float expected = 65.625f;
  
  assertEquals(expected, armor.getDurability(), 0.001f);
  }
  
  @Test
  public void should_compute_durability_for_all_same() {
  Armor armor = new Armor("Test Armor", Material.PAPER);
  
  float expected = 2f;
  
  assertEquals(expected, armor.getDurability(), 0.001f);
  }
  
  @Test
  public void should_handle_quasi_unbreakable_cases() {
  Armor armor1 = new Armor("Test Armor", Material.OBSIDIAN,
  Material.GLASS, Material.IRON);
  Armor armor2 = new Armor("Test Armor", Material.GLASS,
  Material.OBSIDIAN, Material.OBSIDIAN);
  Armor armor3 = new Armor("Test Armor", Material.OBSIDIAN, Material.IRON, Material.OBSIDIAN);
  Armor armor4 = new Armor("Test Armor", Material.OBSIDIAN);
  
  assertEquals(1.7014117331926443E38, armor1.getDurability());
  assertEquals(2.5521175490829424E38, armor2.getDurability());
  assertEquals(2.5521175490829424E38, armor3.getDurability());
  assertEquals(Material.OBSIDIAN.getDurability(), armor4.getDurability());
  }

}

