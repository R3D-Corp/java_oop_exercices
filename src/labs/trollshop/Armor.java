package labs.trollshop;

import java.util.HashMap;
import java.util.Map;

import util.Contract;

/**
 * Représente une armure composée d'un plastron, de deux jambières et de deux
 * protège-bras.
 * <p>
 * Les jambières et les protège-bras sont toujours faits dans le même matériau
 * respectivement.
 */
public class Armor implements Items {
  // TODO : faire l'exercice 3

  private String name;
  private Material chestplate;
  private Material leggings;
  private Material armguards;

  public Armor(String name, Material chestplate, Material leggings, Material armguards) {
    setName(name);
    setChestplate(chestplate);
    setLeggings(leggings);
    setArmguards(armguards);
  }

  public Armor(String name, Material components) {
    this(name, components, components, components);
  }

  public String getName() {
    return this.name;
  }

  public Material getChestplate() {
    return this.chestplate;
  }

  public Material getLeggings() {
    return this.leggings;
  }

  public Material getArmguards() {
    return this.armguards;
  }

  public void setName(String name) {
    Contract.require(name != null && !name.isBlank(), "Nom doit être non null et non blanc");
    this.name = name;
  }

  public void setChestplate(Material chestplate) {
    if (chestplate == null)
      throw new IllegalArgumentException();
    this.chestplate = chestplate;
  }

  public void setLeggings(Material leggings) {
    if (leggings == null)
      throw new IllegalArgumentException();
    this.leggings = leggings;
  }

  public void setArmguards(Material armguards) {
    if (armguards == null)
      throw new IllegalArgumentException();
    this.armguards = armguards;
  }

  @Override
  public String toString() {
    return String.format("%s - chestplate : %s - leggings : %s - armguards : %s",
        this.getName(),
        this.getChestplate().toString(),
        this.getLeggings().toString(),
        this.getArmguards().toString());
  }

  @Override
  public float getDurability() {

    // Variables pour limiter la verbosité des prochaines lignes.
    Material chestplate = this.getChestplate();
    Material leggings = this.getLeggings();
    Material armguards = this.getArmguards();

    float response = 0.5f * chestplate.getDurability() + 0.25f * leggings.getDurability()
        + 0.25f * armguards.getDurability();

    if (chestplate != Material.OBSIDIAN) {
      // Tous les élements du même materiaux.
      if (chestplate == leggings && chestplate == armguards) {
        return response * 2; // retour forcé pour eviter que la logique du 2eme matériaux récrive celle de la
                             // 3 matériaux.
      }

      // 2 élements du même matériaux.
      if ((chestplate == leggings || chestplate == armguards || leggings == armguards)) {
        response = response * 1.5f;
      }

    }

    return response;
  }

  @Override
  public String getMaterials() {
    return String.format("Plastron : %s - Jambières : %s - Coudières : %s",
        this.getChestplate().toDisplayString(),
        this.getLeggings().toDisplayString(), 
        this.getArmguards().toDisplayString()
      );
  }

  @Override
  public int getComponentNumber() {
      return 3;
  }

  @Override
  public void update(Material... materials) {
      this.setChestplate(materials[0]);
      this.setLeggings(materials[1]);
      this.setArmguards(materials[2]);
  }
}
