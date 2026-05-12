package labs.algo.labo3.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Note: dans ces exercices, vous pouvez créer une nouvelle liste vide modifiable avec
 * {@code List<TypeConcret> votreVariable = new ArrayList<>()}
 */
public class PracticeList {

	/**
	 * Retourne une nouvelle liste qui contient les éléments de la liste de départ aux 
	 * position paires (pour rappel, 0 est pair)
	 * 
	 * Si la liste est une référence nulle, renvoyer une liste vide.
	 * list ne doit pas être modifiée.
	 * 
	 * Ex : (0, 18, 25, 17, 43) -> (0, 25, 45)
	 * @param list la liste à traiter
	 * @return
	 * 🌟 : 1
	 */
	public static List<Integer> even(final List<Integer> list){
		if(list == null) return new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>(list.size());

		for(int i=0; i<list.size(); i++) {
			if(i==0 || i % 2 == 0) {
				temp.add(list.get(i));
			}
		}
		return temp;
	}
	
	/**
	 * Retourne une copie de la liste passée en argument dont les éléments apparaissent en ordre inverse
	 * Ex : (1, 2, 3) devient (3, 2, 1)
	 * @param toReverse une chaine à inverser. Ne sera pas modifié.
	 * @return une copie de la chaine paramètre en ordre inverse.
	 * @throws NullPointerException si toReverse est null
	 * 🌟 : 1
	 */
	public static List<Integer> reverse(final List<Integer> toReverse){
		if(toReverse == null) throw new NullPointerException("Arg. toReverse != null excepted");
		List<Integer> temp = new ArrayList<Integer>(toReverse.size());

		for(int i=0, j=toReverse.size() - 1; i<toReverse.size(); i++, j--) {
			temp.add(toReverse.get(j));
		}

		return temp;
	}
		
	/**
	 * Retourne une liste qui est la somme des deux listes passées en argument.
	 * Dans les deux listes, on additionne les entiers aux mêmes positions. On ne tient
	 * pas compte des entiers supplémentaires si une des deux liste est plus longue :
	 * 
	 * Ex : (1, 3, 5) + (2, 4, -6, 8) = (3, 7, -1) 
	 * 
	 * Une référence nulle équivaut à une liste vide.
	 * 
	 * @implNote il n'est pas demandé que la liste résultat soit nécessairement modifiable 
	 * @param src1 la première liste à additionner
	 * @param src2 la seconde liste à additionner
	 * @return l'addition des deux listes (différente de src1 et src2)
	 * 🌟 : 1
	 */
	public static List<Integer> add(final List<Integer> src1, final List<Integer> src2){
		List<Integer> a = (src1 != null ? src1 : new ArrayList<Integer>()); 
		List<Integer> b = (src2 != null ? src2 : new ArrayList<Integer>()); 

		int longest_size = Math.min(a.size(), b.size());
		List<Integer> temp = new ArrayList<Integer>(longest_size);

		for(int i=0; i<longest_size; i++) {
			if(a.get(i) != null && b.get(i) != null) {
				temp.add(a.get(i) + b.get(i));
			}
		}
		return temp;
	}

	/**
	 * Analyse la liste passée en argument et produit la liste
	 * (table[entree], table[table[entree]], table[table[table[entree]]], ..., -1)
	 * en s'arrêtant en quand on trouve un -1.
	 * 
	 * On considèrera que la liste table est correctement formatée et que le parcours
	 * est toujours possible.
	 * 
	 * Exemple : (-1, 2, 4, 17, 0), 1 -> (2, 4, 0, -1)
	 *           (), 2 -> IndexOfBoundsException
	 *           (-1) , 0 -> (-1)
	 * 
	 * Note : je donne un cours d'OS aux cybersécu, la fonction a ce nom exactement pour
	 * ce à quoi vous pensez, si vous y pensez.
	 * @param table une table ne devant pas être corrompue (càd modifiée)
	 * @throws IndexOfBoundsException si entree n'est pas dans les positions possibles
	 * 🌟 : 2
	 */
	public static List<Integer> fat(final List<Integer> table, int index) {
		if(index >= table.size() || index < 0) throw new IndexOutOfBoundsException("Tu le fait exprès.");
		
		List<Integer> temp = new ArrayList<Integer>(table.size()); // Pour être sur de ne pas se manger un index.

		while(index != -1) {
			index = table.get(index);
			temp.add(index);
		}
		return temp;
	}
	
	/**
	 * Retourne une liste qui est la fusion de src1 et src2 dont les éléments sont
	 * pris alternativement dans src1 et src2.
	 * Ex : fusion((1, 3, 5),(2, 4, 6, 8)) = (1, 2, 3, 4, 5, 6, 8)
	 * Si une des liste est nulle, retourne une copie de l'autre.
	 * Si les deux sont nulles, renvoie une liste vide.
	 * 
	 * @implNote il n'est pas demandé que la liste résultat soit nécessairement modifiable 
	 * @param src1 la première liste à fusionner
	 * @param src2 la seconde liste à fusionner
	 * @return la fusion des deux listes (différente de src1 et src2)
	 * 🌟 : 2
	 */
	public static List<Integer> fusion(final List<Integer> src1, final List<Integer> src2){
		if(src1 == null && src2 != null) return List.copyOf(src2);
		if(src1 != null && src2 == null) return List.copyOf(src1);
		if(src1 == null && src2 == null) return new ArrayList<Integer>();

		List<Integer> temp = new ArrayList<Integer>(src1.size() + src2.size());
		int longest_size = Math.max(src1.size(), src2.size());
		for(int i=0; i<longest_size; i++) {
			if(i<src1.size() && src1.get(i) != null) {
				temp.add(src1.get(i));
			}

			if(i<src2.size() && src2.get(i) != null) {
				temp.add(src2.get(i));
			}
		};
		return temp;
	}
}
