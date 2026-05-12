package labs.algo.labo3.queue;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


public class PracticeQueue {

	/**
	 * Renvoie vrai si les deux files q1 et q2 ont le même contenu (mêmes éléments dans le même ordre)
	 * 
	 * N'oubliez pas d'implémenter les propriétés suivantes (de java.lang.Object) :
	 * - Réflexivité  (une file est égale à elle-même)
	 * - Transitivité (deux files égales à une même troisième sont égales entre elles)
	 * - Symétrie (une file égale à une autre 
	 * - Consistence (l'égalité ne doit pas changer tant qu'une des deux files n'est pas modifiée) 
	 * - Inégalité à null (une file et null ne sont pas égales)
	 * 
	 * @see Object Rappel des propriétés générales de equals
	 * @see java.util.Queue Pourquoi q1.equals(q2) ne fonctionnera pas ici ?
	 * @param q1 une première file
	 * @param q2 une seconde file
	 * @return vrai si la file 1 et la file 2 ont le même contenu.
	 * 🌟 : 1
	 */
	public static boolean equals(final Queue<Integer> q1, final Queue<Integer> q2) {

		if(q1 == q2) return true; // Same address?
		if(q1 == null || q2 == null) return false; // Is null? 
		if(q1.size() != q2.size()) return false; // Same size?

		Iterator<Integer> it1 = q1.iterator();
		Iterator<Integer> it2 = q2.iterator();

		while(it1.hasNext()) {
			Integer e1 = it1.next();
			Integer e2 = it2.next();
			if(!Objects.equals(e1, e2)) return false; // Same value?;
		}

		return true;
	}
	
	/**
	 * Filtre tous les éléments de la file et ne laisse que les éléments pairs.
	 * Ces éléments doivent rester dans le même ordre.
	 * @param input
	 * @return
	 * 🌟 : 1
	 */
	public static Queue<Integer> even(final Queue<Integer> queue) {
		Queue<Integer> temp = new ArrayDeque<Integer>();
		Iterator<Integer> iterator = queue.iterator();

		while(iterator.hasNext()) {
			// Remove if odd
			Integer e = iterator.next();

			if(e!= null && e % 2 == 0) temp.add(e);
		}
		return temp;
	}
	
	/**
	 * Filtre tous les éléments de la file et ne laisse qu'une seule occurrence des éléments.
	 * @param queue
	 * @return
	 * 🌟 : 2
	 */
	public static Queue<String> unique(final Queue<String> queue) {
		Queue<String> temp = new ArrayDeque<String>();
		Set<String> seen = new HashSet<String>();

		Iterator<String> iterator = queue.iterator();

		while(iterator.hasNext()) {
			String e = iterator.next();
			if(seen.add(e)) { // Return false if couldn't be added because already exist in the Set.
				temp.add(e); // Add to the corrected queue.
			}
		}
		return temp;
	}
}
