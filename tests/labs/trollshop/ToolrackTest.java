package labs.trollshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


class ToolrackTest {

  @Test
  void should_construct_toolshelf_with_greater_capacity() {
    Tool[] tools = {
    new Tool("Dwarf axe", Material.DIAMOND, Material.OAK_WOOD),
    new Tool("Silver sword", Material.SILVER),
    new Tool("Clay hammer", Material.CLAY)
    };
    Toolrack shelf = new Toolrack(5, tools);
    
    assertEquals(5, shelf.getCapacity());
    assertEquals(3, shelf.countOccupiedSlots());
    assertEquals(2, shelf.countAvailableSlots());
    assertFalse(shelf.isEmpty());
    assertFalse(shelf.isFull());
  }

  @Test
  void should_construct_empty_toolshelf_with_valid_capacity() {
    Toolrack shelf = new Toolrack(3);

    assertEquals(3, shelf.getCapacity());
    assertEquals(0, shelf.countOccupiedSlots());
    assertEquals(3, shelf.countAvailableSlots());
    assertTrue(shelf.isEmpty());
    assertFalse(shelf.isFull());
  }

  @Test
  void should_construct_full_toolshelf_with_valid_array() {
    Tool[] tools = {
    new Tool("Silver sword", Material.SILVER),
    new Tool("Clay hammer", Material.CLAY)
    };
    Toolrack shelf = new Toolrack(tools);
    
    assertEquals(2, shelf.getCapacity());
    assertEquals(2, shelf.countOccupiedSlots());
    assertEquals(0, shelf.countAvailableSlots());
    assertFalse(shelf.isEmpty());
    assertTrue(shelf.isFull());
  }

  @Test
  void should_reject_construction_with_invalid_args() {
    Tool[] tools = {
    new Tool("Dwarf axe", Material.DIAMOND, Material.OAK_WOOD),
    new Tool("Silver sword", Material.SILVER),
    new Tool("Clay hammer", Material.CLAY)
    };
    
    assertThrows(IllegalArgumentException.class, () -> {
    new Toolrack(-1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
    new Toolrack(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
    new Toolrack(2, tools);
    });
    assertThrows(IllegalArgumentException.class, () -> {
    new Toolrack(2, null);
    });
  }

  @Test
  void should_protect_its_fields_by_copying_array() {
    Tool[] tools = {
    new Tool("Dwarf axe", Material.DIAMOND, Material.OAK_WOOD),
    new Tool("Silver sword", Material.SILVER),
    new Tool("Rubber hammer", Material.RUBBER)
    };
    Toolrack shelf = new Toolrack(tools);
    
    tools[0] = tools[1] = tools[2] = null;
    
    assertEquals(3, shelf.getCapacity());
    assertEquals(3, shelf.countOccupiedSlots());
    assertEquals(0, shelf.countAvailableSlots());
    assertFalse(shelf.isEmpty());
    assertTrue(shelf.isFull());
  }

  @Test
  void should_change_after_take() {
      Tool[] tools = {
        new Tool("Dwarf axe", Material.DIAMOND, Material.OAK_WOOD),
        new Tool("Silver sword", Material.SILVER),
        new Tool("Rubber hammer", Material.RUBBER)
      };
      Toolrack shelf = new Toolrack(tools);

      assertTrue(shelf.isFull());

      assertThrows(IllegalArgumentException.class, () -> {
        shelf.getAt(-1);
      });

      assertThrows(IllegalArgumentException.class, () -> {
        shelf.getAt(15);
      });

      assertThrows(IllegalArgumentException.class, () -> {
        shelf.takeAt(-1);
      });

      assertThrows(IllegalArgumentException.class, () -> {
        shelf.takeAt(15);
      });


      assertEquals(tools[1], shelf.getAt(1));
      assertEquals(tools[1], shelf.takeAt(1));
      assertEquals(null, shelf.getAt(1));

      assertFalse(shelf.isFull());
      assertFalse(shelf.isEmpty());
  }

  @Test
  void should_be_empty() {
      Toolrack shelf = new Toolrack(3);
      assertTrue(shelf.isEmpty());
  }

  @Test
  void shoud_change_after_set() {
    Toolrack shelf = new Toolrack(3);
    shelf.setAt(1, new Tool("Super pioche", Material.OBSIDIAN));

    assertFalse(shelf.isEmpty());
    assertFalse(shelf.isFull());
  }

}
