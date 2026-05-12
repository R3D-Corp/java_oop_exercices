package labs.algo.labo3.set;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class PracticeSetTests {

	public static final Set<Integer> EMPTY_SET = Collections.emptySet();

	@Test
	void symmetricDiffHandleNull() {
		Set<Integer> initial = Set.of(17, 26, 89, -8);
		assertEquals(initial, PracticeSet.symetricDifference(initial, null));
		assertEquals(initial, PracticeSet.symetricDifference(null, initial));
	}
	
	@Test
	void symmetricDiffSameSetIsEmpty() {
		Set<Integer> initial = Set.of(17, 26, 89, -8);
		assertEquals(EMPTY_SET, PracticeSet.symetricDifference(initial, initial));
	}
	
	@Test
	void symmetricDiffExample1() {
		Set<Integer> s1 = Set.of(17, 26, 89, -8);
		Set<Integer> s2 = Set.of(18, 26, 25, -8);
		Set<Integer> res = Set.of(89, 18, 25, 17);
		assertEquals(res, PracticeSet.symetricDifference(s1, s2));
		assertEquals(res, PracticeSet.symetricDifference(s2, s1));
	}
	
	@Test
	void symmetricDiffExample2() {
		Set<Integer> s1 = Set.of(1,3,5,7);
		Set<Integer> s2 = Set.of(2,4,6);
		Set<Integer> res = Set.of(1,2,3,4,5,6,7);
		assertEquals(res, PracticeSet.symetricDifference(s1, s2));
		assertEquals(res, PracticeSet.symetricDifference(s2, s1));
	}
	
	@Test
	void ultimateFizzBuzzNoFizzNoBuzz() {
		List<Integer> before = List.of(1, 2, 3, 4, 5);
		List<String> result = List.of("1", "2", "3", "4", "5");
		assertEquals(result, PracticeSet.ultimateFizzBuzz(before, EMPTY_SET, EMPTY_SET));
	}
	
	@Test
	void ultimateFizzBuzzNoList() {
		List<Integer> before = List.of();
		List<String> result = List.of();
		
		Set<Integer> fizz = Set.of(1,3,5,7);
		Set<Integer> buzz = Set.of(4,8,12);
		
		assertEquals(result, PracticeSet.ultimateFizzBuzz(before, fizz, buzz));
	}
	
	@Test
	void ultimateFizzBuzzExample() {
		List<Integer> before = List.of(8, 1, 2, 3, 6, 5, 4, 12);
		List<String> result = List.of("buzz", "fizz", "2", "fizz", "6", "fizz", "fizzbuzz", "buzz");
		
		Set<Integer> fizz = Set.of(1,3,5,7,4);
		Set<Integer> buzz = Set.of(4,8,12);
		
		assertEquals(result, PracticeSet.ultimateFizzBuzz(before, fizz, buzz));
	}
	
	@Test
	void longestWordsNullisEmptySet() {
		assertEquals(Set.of(""), PracticeSet.longestWords(null));;
	}

	@Test
	void longestWordsEmptyStringIsEmptySet() {
		assertEquals(Set.of(""), PracticeSet.longestWords(""));
	}

	@Test
	void longestWordsSingleWordIsSingleton() {
		assertEquals(Set.of("Covfefe"), PracticeSet.longestWords("Covfefe"));
	}

	@Test
	void longestWordsExample1() {
		assertEquals(Set.of("understand", "commitment"), PracticeSet.longestWords("""
				We're no strangers to love
				You know the rules and so do I (do I)
				A full commitment's what I'm thinking of
				You wouldn't get this from any other guy
				I just wanna tell you how I'm feeling
				Gotta make you understand
				Never gonna give you up
				Never gonna let you down
				Never gonna run around and desert you
				Never gonna make you cry
				Never gonna say goodbye
				Never gonna tell a lie and hurt you
				We've known each other for so long
				Your heart's been aching, but you're too shy to say it (say it)
				Inside, we both know what's been going on (going on)
				We know the game and we're gonna play it
				And if you ask me how I'm feeling
				Don't tell me you're too blind to see
				Never gonna give you up
				Never gonna let you down
				Never gonna run around and desert you
				Never gonna make you cry
				Never gonna say goodbye
				Never gonna tell a lie and hurt you
				Never gonna give you up
				Never gonna let you down
				Never gonna run around and desert you
				Never gonna make you cry
				Never gonna say goodbye
				Never gonna tell a lie and hurt you
				We've known each other for so long
				Your heart's been aching, but you're too shy to say it (to say it)
				Inside, we both know what's been going on (going on)
				We know the game and we're gonna play it"""));
	}

	@Test
	void longestWordsWorksTooWithStrangeWords() {
		// Votre responsable de labo ne sait pas ce que veut dire « tchouffer », inutile de demander.
		assertEquals(Set.of("tchouffer", "problèmes"), PracticeSet.longestWords("""
				Hello papi, mais qué pasa? (Mais qué pasa?)
				J'entends des bails atroces sur moi
				À c'qu'il paraît, j'te cours après? (Oh yeah, yeah, yeah)
				Mais ça va pas? mais t'es taré, oh ouais
				Mais comment ça, le monde est tit-pe? (Eh)
				Tu croyais quoi, qu'on s'verrait plus jamais?
				J'pourrais t'afficher mais c'est pas mon délire
				D'après les rumeurs, tu m'as eue dans ton lit
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Tu penses à moi, j'pense à faire de l'argent
				J'suis pas ta daronne, j'te ferai pas la morale
				Tu parles sur moi, y a R
				Crache encore, y a R
				Tu voulais m'avoir, tu savais pas comment faire
				Tu jouais un rôle, tu finiras aux enfers
				"T'façon, Nakamura, je l'ai couchée"
				Le jour où on se croise, faut pas tchouffer
				Tu jouais le grand frère pour me salir
				Tu cherches des problèmes sans faire exprès
				Putain, mais tu déconnes
				C'est pas comme ça qu'on fait les choses
				Putain, mais tu déconnes
				C'est pas comme ça qu'on fait les choses
				Putain, mais tu déconnes
				C'est pas comme ça qu'on fait les choses
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Oh, Djadja
				Y a pas moyen, Djadja
				J'suis pas ta catin, Djadja, genre, en catchana baby, tu dead ça
				Oh, Djadja, j'suis pas ta catin, Djadja, non
				Y a pas moyen, Djadja, ouais, en catchana baby, tu dead ça, yeah
				Oh, Djadja, j'suis pas ta catin, Djadja, non
				Y a pas moyen, Djadja, ouais, en catchana baby, tu dead ça, d'après toi
				En catchana, baby tu dead ça, en catchana, baby
				En catchana, baby tu dead ça, en catchana, baby
				Oh, Djadja
				Oh, Djadja
				Oh, Djadja""")); // Déso pas déso. Génant.
	}
}
