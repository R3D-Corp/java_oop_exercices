package labs.poo.tcg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FormatTest {

	@Test
	void format_should_returns_a_string_with_card_data_1() {
        TCGCard dragon = TCGCardSample.makeDragonCard();
        
        String[] actual = TCGCardApp.format(dragon).split("\n");
        
        assertEquals(5, actual.length);
        assertEquals("Carte : Dragon", actual[0].strip());
        assertEquals("Une créature légendaire qui crache du feu et domine le champ de bataille.", actual[1].strip());
        assertEquals("PV : ▮▮▮▮▮▮▮▮▮▮ 150/150", actual[2].strip());
        assertEquals("PM : ▮▮▮▮▮ 20/20", actual[3].strip());
        assertEquals("ATK : 9 - DEF : 7", actual[4].strip());
	}
	
	//TODO: ajouter un second test validant la fonction format
	
	@Test
	void format_should_reject_null_arg() {
        assertThrows(IllegalArgumentException.class, 
        		() -> TCGCardApp.format(null));
	}

}
