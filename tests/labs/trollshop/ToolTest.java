package labs.trollshop;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ToolTest {

  @Test
  void should_create_tool_when_valid_parameters() {
  // Given
    String name = "Crystal axe";
    Material head = Material.GLASS;
    Material handle = Material.OAK_WOOD;
    
    // When
    Tool tool = new Tool(name, head, handle);
    
    // Then
    assertEquals(name, tool.getName());
    assertEquals(head, tool.getHead());
    assertEquals(handle, tool.getHandle());
    }
    
    @Test
    void should_create_tool_when_single_resource_provided() {
    // Given
    String name = "Wooden Axe";
    Material material = Material.OAK_WOOD;
    
    // When
    Tool tool = new Tool(name, material);
    
    // Then
    assertEquals(name, tool.getName());
    assertEquals(material, tool.getHead());
    assertEquals(material, tool.getHandle());
  }
  
  @Test
  void should_throw_exception_when_name_is_invalid() {
    assertThrows(IllegalArgumentException.class,
    () -> new Tool(null, Material.ALUMINUM, Material.OAK_WOOD),
    "Le nom ne peut être null ou vide.");
    
    assertThrows(IllegalArgumentException.class,
    () -> new Tool(" ", Material.IRON, Material.OAK_WOOD),
    "Le nom ne peut être null ou vide.");
    }
    
    @Test
    void should_throw_exception_when_head_is_null() {
    assertThrows(IllegalArgumentException.class,
    () -> new Tool("Wood hammer", null, Material.OAK_WOOD),
    "La tête ne peut être null.");
    }
    
    @Test
    void should_throw_exception_when_handle_is_null() {
    assertThrows(IllegalArgumentException.class,
    () -> new Tool("Wood hammer", Material.PINE_WOOD, null),
    "Le manche ne peut être null.");
  }
  
  @Test
  void should_throw_exception_when_setters_called_with_null() {
    // Given
    Tool tool = new Tool("Test Tool", Material.BEECH_WOOD, Material.OAK_WOOD);
    
    // When & Then
    assertThrows(IllegalArgumentException.class,
    () -> tool.setHead(null),
    "La tête ne peut être null.");
    // When & Then
    assertThrows(IllegalArgumentException.class,
    () -> tool.setHandle(null),
    "Le manche ne peut être null.");
    }
    
    @Test
    void should_return_correct_to_string() {
    // Given
    Tool tool = new Tool("Diamond Sword", Material.DIAMOND, Material.OAK_WOOD);
    
    // When
    String result = tool.toString();
    
    // Then
    assertTrue(result.contains("Diamond Sword"));
    assertTrue(result.contains("head : DIAMOND"));
    assertTrue(result.contains("handle : OAK_WOOD"));
  }
  
  @Test
  void should_calculate_durability_as_sum_when_different_materials() {
    // Given
    Tool tool = new Tool("Mixed Tool", Material.COPPER, Material.OAK_WOOD);
    
    // When
    float durability = tool.getDurability();
    
    assertEquals(Material.COPPER.getDurability() + Material.OAK_WOOD.getDurability(),
    durability, 0.001f);
    }
    
    @Test
    void should_calculate_durability_as_bedrock_when_head_is_bedrock() {
    // Given
    Tool tool = new Tool("Unbreakable Tool", Material.OBSIDIAN, Material.OAK_WOOD);
    
    // When
    float durability = tool.getDurability();
    
    // Then (OBSIDIAN a une durabilité infinie ou maximale)
    assertEquals(Material.OBSIDIAN.getDurability(), durability);
  }
  
  @Test
  void should_calculate_durability_as_bedrock_when_handle_is_bedrock() {
    // Given
    Tool tool = new Tool("Unbreakable Tool", Material.OBSIDIAN);
    
    // When
    float durability = tool.getDurability();
    
    // Then
    assertEquals(Material.OBSIDIAN.getDurability(), durability);
  }
  
  @Test
  void should_calculate_durability_as_double_sum_when_same_material() {
    // Given
    Tool tool = new Tool("Glass tool", Material.GLASS);
    
    // When
    float durability = tool.getDurability();
    
    assertEquals(
      2 * (2 * Material.GLASS.getDurability()), 
      durability, 0.001f);
  }
  
  @Test
  void should_update_durability_when_head_is_changed() {
    // Given
    Tool tool = new Tool("Test Tool", Material.IRON, Material.OAK_WOOD);
    float initialDurability = tool.getDurability();
    
    // When
    tool.setHead(Material.STEEL);
    float newDurability = tool.getDurability();
    
    // Then
    assertNotEquals(initialDurability, newDurability);
    assertEquals(Material.STEEL.getDurability() + Material.OAK_WOOD.getDurability(),
    newDurability,
    0.001f);
  }
  
  @Test
  void should_update_durability_when_handle_is_changed() {
    // Given
    Tool tool = new Tool("Test Tool", Material.IRON, Material.OAK_WOOD);
    float initialDurability = tool.getDurability();
    
    // When
    tool.setHandle(Material.BEECH_WOOD);
    float newDurability = tool.getDurability();
    
    // Then
    assertNotEquals(initialDurability, newDurability);
    assertEquals(Material.IRON.getDurability() + Material.BEECH_WOOD.getDurability(),
    newDurability,
    0.001f);
    }
}
