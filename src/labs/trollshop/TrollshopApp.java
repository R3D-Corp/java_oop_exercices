package labs.trollshop;

import java.util.ArrayList;

public class TrollshopApp {
  private static final int ADD_TOOL = 1;
  private static final int LIST_TOOLS = 2;
  private static final int UPDATE_TOOL = 3;
  private static final int TAKE_TOOL = 4;
  private static final int COMPACT_TOOLS = 5;
  private static final int QUIT = 6;

  public static void main(String[] args) {
    boolean quitRequested = false;

    Console.println("POO - Labo 3 - Troll's tools shop");
    Console.println("=".repeat(33));
    Console.println();

    // TODO: créer un présentoire vide
    Toolrack rack = new Toolrack(5, new Tool[] {
        new Tool("Trident", Material.SILVER),
        null,
        new Tool("Mjölnir", Material.OBSIDIAN),
    });

    ArmorRack armorRack = new ArmorRack(5, new Armor[] {
      new Armor("Diams", Material.DIAMOND),
      null,
      new Armor("L'armure du dragon pas sacré", Material.SILVER, Material.SILVER, Material.GOLD)
    });

    // TODO : gérer le menu
    while (!quitRequested) {
      

      printMainMenu();
      int rackChoice = Console.readInt("Quel étagère ? ", 1, 2);
      
      printMenu();
      switch (rackChoice) {
        case 1 -> {
          int userChoice = Console.readInt("Votre choix ?", 1, 6);
          Console.println();
          switch (userChoice) {
            case ADD_TOOL -> executeAddTool(rack);
            case LIST_TOOLS -> executeListTool(rack);
            case UPDATE_TOOL -> executeUpdateTool(rack);
            case TAKE_TOOL -> executeTakeTool(rack);
            case COMPACT_TOOLS -> executeCompact(rack);
            case QUIT -> quitRequested = true;
          }
        }
        case 2 -> {
          int userChoice = Console.readInt("Votre choix ?", 1, 6);
          Console.println();
          switch (userChoice) {
            case ADD_TOOL -> executeAddArmor(armorRack);
            case LIST_TOOLS -> executeListTool(armorRack);
            case UPDATE_TOOL -> executeUpdateTool(armorRack);
            case TAKE_TOOL -> executeTakeTool(armorRack);
            case COMPACT_TOOLS -> executeCompact(armorRack);
            case QUIT -> quitRequested = true;
          }
        }
      }


    }

    Console.printf("Au revoir%n");
  }

  private static void printMainMenu() {
    Console.println("1. Outils");
    Console.println("2. Armures");
  }

  private static void printMenu() {
    Console.println("1. Ajouter un outil");
    Console.println("2. Consulter l'état du présentoire");
    Console.println("3. Améliorer un outil");
    Console.println("4. Retirer un outil");
    Console.println("5. Ranger le présentoire");
    Console.println("6. Quitter");
  }

  private static void printMaterials() {
    int index = 1;
    for (Material material : Material.values()) {
      Console.println(String.format("%s) %s", index, material.toDisplayString()));
      index++;
    }
  }

  private static void executeAddTool(Toolrack rack) {
    if (!rack.isFull()) {
      printMaterials();

      String toolName = Console.readLine("Nom de l'outil ? ");
      int headMaterial = Console.readInt("Matérau pour la tête ? ", 1, Material.values().length);
      int handleMaterial = Console.readInt("Matérau pour le manche ? ", 1, Material.values().length);

      Tool newTool = new Tool(toolName, Material.values()[headMaterial - 1], Material.values()[handleMaterial - 1]);

      Tool[] allTools = rack.getItems();
      for (int i = 0; i < allTools.length; i++) {
        if (allTools[i] == null) {
          rack.setAt(i, newTool);
          break;
        }
      }
    } else {
      Console.println("Plus de place dans le Rack");
    }
  }

  private static void executeAddArmor(ArmorRack rack) {
    Material[] allMaterials = Material.values(); 
    if (!rack.isFull()) {
      printMaterials();

      String toolName = Console.readLine("Nom de l'armure ? ");
      Material chestplateMaterial = allMaterials[Console.readInt("Matérau pour le plastron ? ", 1, allMaterials.length) - 1];
      Material leggingsMaterial = allMaterials[Console.readInt("Matérau pour les jambières ? ", 1, allMaterials.length) - 1];
      Material armguardMaterial = allMaterials[Console.readInt("Matérau pour les coudières ? ", 1, allMaterials.length) - 1];

      Armor newArmor = new Armor(toolName, chestplateMaterial, leggingsMaterial, armguardMaterial);

      Armor[] allTools = rack.getItems();
      for (int i = 0; i < allTools.length; i++) {
        if (allTools[i] == null) {
          rack.setAt(i, newArmor);
          break;
        }
      }
    } else {
      Console.println("Plus de place dans le Rack");
    }
  }

  private static <T extends Items> void executeUpdateTool(Rack<T> rack) {
    if (!rack.isEmpty()) {
      T[] allItems = rack.getItems();

      int i = 0;
      for (i = 0; i < allItems.length; i++) {
        if (allItems[i] != null) {
          Console.println(String.format("%d) %s", i + 1, allItems[i].getName()));
        }
      }

      T item = allItems[Console.readInt("Votre choix", 1, rack.getCapacity() + 1) - 1];

      printMaterials();

      Material[] newMaterials = new Material[item.getComponentNumber()];
      Material[] allMaterials = Material.values();
      for (int materialIndex = 0; materialIndex < item.getComponentNumber(); materialIndex++) {
        int userChoice = Console.readInt("Matérau pour la tête ? ", 1, allMaterials.length);
        newMaterials[materialIndex] = allMaterials[userChoice - 1];
      }
      item.update(newMaterials);
    }
  }

  private static <T extends Items> void executeListTool(Rack<T> rack) {
    T[] items = rack.getItems();

    Console.println("Etat du présentoir");
    Console.println("------------------");
    Console.println("");

    Console.println(String.format("Capacité %d", rack.getCapacity()));
    Console.println(String.format("Encoches libres %d", rack.countAvailableSlots()));
    Console.println(String.format("Occupé à %d", (rack.countOccupiedSlots() * 100) / rack.getCapacity()) + "%");
    Console.println(String.format("%-40s|%-5s|%-100s|", "Objet", "Prix", "Composants"));
    Console.println("=".repeat(148));

    for (T item : items) {
      if (item != null) {
        Console.println(
            String.format("%-40s|%-5s|%-100s|",
                item.getName(),
                PriceLevel.ofFloat(item.getDurability()).toDisplayString(),
                item.getMaterials()));
      }
    }
  }

  private static <T extends Items> void executeTakeTool(Rack<T> belt) {
    int i = 0;

    for (T tool : belt.getItems()) {
      String message = String.format("%d) %s", i + 1, tool == null ? "Libre" : tool.getName());
      Console.println(message);
      i++;
    }

    int userChoice = Console.readInt("votre choix ? ", 1, belt.getCapacity());
    belt.takeAt(userChoice - 1);
  }

  private static <T> void executeCompact(Rack<T> rack) {
    rack.compact();
  }

}
