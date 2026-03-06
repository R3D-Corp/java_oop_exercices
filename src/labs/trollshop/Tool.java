package labs.trollshop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import util.Contract;

/**
 * Représente un outil composé d'un manche et d'une tête fabriqués à partir de matériaux.
 * <p>
 * La durabilité de l'outil est fonction des matériaux utilisés pour le manche et la tête.
 * 
 * @see trollshop.Material
 */
public class Tool implements Items {

  private final String name;
  private Material head;
  private Material handle;

  public Tool(String name, Material head, Material handle) {
    if(name == null || name.isBlank()) {
      throw new IllegalArgumentException();
    }
    this.name = name;
    this.setHead(head);
    this.setHandle(handle);
  }  

  public Tool(String name, Material headAndHandle) {
    this(name, headAndHandle, headAndHandle);
  }

  @Override
  public String getName() {
    return this.name;
  }

  public Material getHead() {
    return this.head;
  }

  public Material getHandle() {
    return this.handle;
  }

  public void setHead(Material head) {
    Contract.require(head != null, "Head doit être non null");
    this.head = head;
  }

  public void setHandle(Material handle)  {
    Contract.require(handle != null, "Handle doit être non null");
    this.handle = handle;
  }

  @Override
  public String toString() {
    return String.format("%s - head : %s - handle : %s", 
      this.getName(),
      this.getHead().toString(),
      this.getHandle().toString()
    );
  }

  @Override
  public float getDurability() {

    Material head = getHead();
    Material handle = getHandle();

    if(head == Material.OBSIDIAN || handle == Material.OBSIDIAN) {
      return Material.OBSIDIAN.getDurability();
    }

    float durability = head.getDurability() + handle.getDurability();
    return head == handle ? durability * 2 : durability;
  }

  @Override
  public String getMaterials() {
    return String.format("Tête : %s - Manche : %s", this.getHead().toDisplayString(), this.getHandle().toDisplayString());
  }

  @Override
  public int getComponentNumber() {
      return 2;
  }

  @Override
  public void update(Material... materials) {
      this.setHead(materials[0]);
      this.setHandle(materials[1]);
  }
}
