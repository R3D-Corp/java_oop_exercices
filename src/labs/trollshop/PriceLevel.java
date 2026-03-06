package labs.trollshop;

import util.Contract;

/**
 * Représente les différents niveaux de prix pour un article ou un service.
 * <p>
 * Chaque niveau est déterminé par le nombre de chiffres dans la valeur numérique associée.
 * </p>
 * 
 * <p>
 * Exemple d'utilisation :
 * 
 * <pre>
 * PriceLevel level = PriceLevel.ofFloat(99.99f); // Retourne REASONABLE
 * String display = level.toDisplayString(); // Retourne "$$"
 * </pre>
 * </p>
 */
public enum PriceLevel {
  BUDGET, REASONABLE, PRICEY, EXPENSIVE, UNAFFORDABLE;

  /**
   * Détermine le niveau de prix en fonction d'une valeur numérique.
   *
   * @param value la valeur numérique à évaluer (doit être positive)
   * @return le niveau de prix correspondant au nombre de chiffres dans la valeur
   * @throws IllegalArgumentException si la valeur est inférieure ou égale à zéro
   */
  public static PriceLevel ofFloat(float value) {
    Contract.require(value >= 0, "Arg. value doit être >= 0. Reçu " + value);

    int digitCount = 1 + (int) Math.log10(value);
    return switch (digitCount) {
      case 1 -> BUDGET;
      case 2 -> REASONABLE;
      case 3 -> PRICEY;
      case 4 -> EXPENSIVE;
      default -> UNAFFORDABLE;
    };
  }

  /**
   * Retourne une représentation visuelle du niveau de prix sous forme de symboles "$".
   * <p>
   * Le nombre de "$" est égal à 1 + l'index ordinal de l'énumération.
   * </p>
   */
  public String toDisplayString() {
    return "$".repeat(1 + ordinal());
  }
}
