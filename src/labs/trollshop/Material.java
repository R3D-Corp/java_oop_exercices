package labs.trollshop;

/**
 * Enum représentant les types de matériau utilisés dans la fabrication d'objets.
 */
public enum Material {
  PAPER(1.0f, "Papier"),
  GLASS(1.5f, "Verre"),
  CERAMIC(6.0f, "Céramique"),
  CLAY(4.0f, "Argile"),
  LEATHER(5.0f, "Cuir"),
  RUBBER(8.0f, "Caoutchouc"),
  PLASTIC(10.0f, "Plastique"),
  ALUMINUM(12.0f, "Aluminium"),
  PINE_WOOD(15.0f, "Bois de pin"),
  BEECH_WOOD(18.0f, "Bois de hêtre"),
  OAK_WOOD(20.0f, "Bois de chêne"),
  COPPER(25.0f, "Cuivre"),
  IRON(30.0f, "Fer"),
  SILVER(35.0f, "Argent"),
  STEEL(50.0f, "Acier"),
  GOLD(100.0f, "Or"),
  DIAMOND(1000.0f, "Diamant"),
  OBSIDIAN(Float.MAX_VALUE, "Obsidienne");

  private float durability;
  private String displayName;

  /**
   * Constructeur pour Material.
   *
   * @param durability solidité du matériau, > 0.0f.
   * @param displayName nom affichable en français.
   */
  Material(float durability, String displayName) {
    this.durability = durability;
    this.displayName = displayName;
  }

  /**
   * Retourne la solidité de ce matériau.
   */
  public float getDurability() {
    return durability;
  }

  /**
   * Retourne le nom affichable de ce matériau.
   *
   * @return Nom du matériau en français.
   */
  public String toDisplayString() {
    return this.displayName;
  }

  @Override
  public String toString() {
    return "%s(durability: %.1f)".formatted(this.name(), this.durability);
  }
}
