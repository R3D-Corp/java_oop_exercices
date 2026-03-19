package labs.starwars;

import java.util.Objects;

/**
 * Classe de données rassemblant les données décrivant
 * une demande de création d'un utilisateur de la Force.
 * 
 * @author Nicolas Hendrikx
 * */
public final class AddFighterRequest {
	private final String kind;
	private final String name;
	private final int hitPoints;
	private final int damagePoints;
	
	/**
	 * Construit une demande à partir du type, du nom et des points.
	 * */
	public AddFighterRequest(String kind, String name, int hitPoints, int damagePoints) {
		this.kind = kind == null || kind.isBlank() ? "" : kind;
		this.name = name == null || name.isBlank() ? "" : name;
		this.hitPoints = Math.abs(hitPoints);
		this.damagePoints = Math.abs(damagePoints);
	}
	
	public String getKind() {		
		return kind;
	}

	public String getName() {
		return name;
	}

	public int getHitPoints() {
		return hitPoints;
	}
	
	public int getDamagePoints() {
		return damagePoints;
	}

	@Override
	public int hashCode() {
		return Objects.hash(damagePoints, hitPoints, kind, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AddFighterRequest))
			return false;
		AddFighterRequest other = (AddFighterRequest) obj;
		return damagePoints == other.damagePoints && hitPoints == other.hitPoints && Objects.equals(kind, other.kind)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return String.format("AddFighterRequest (kind: %s, name: %s, hitPoints: %s, damagePoints: %s)", kind, name,
				hitPoints, damagePoints);
	}
	
	
}
