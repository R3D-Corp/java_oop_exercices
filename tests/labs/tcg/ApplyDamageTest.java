package labs.tcg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ApplyDamageTest {

	
	@Test
	void should_pass_the_happy_path() {
		TCGCard golem = TCGCardSample.makeStoneGolemCard();
		TCGCard knight = TCGCardSample.makeRoyalKnightCard();
		
		final int expectedDamage = 8;
		final int expectedManaConsumed = 3;		
		final int expectedHp = golem.getHealthPoints() - expectedDamage;
		final int expectedMp = knight.getManaPoints() - expectedManaConsumed;
		
		int actualDamage = TCGCardApp.applyDamage(knight, golem);
		
		assertEquals(expectedDamage, actualDamage);
		assertEquals(expectedHp, golem.getHealthPoints());
		assertEquals(expectedMp, knight.getManaPoints());
	}
	
	// TODO écrire un second cas de test simple
	// TODO écrire des cas de test pour des cas particuliers
}
