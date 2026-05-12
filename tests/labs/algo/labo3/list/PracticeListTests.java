package labs.algo.labo3.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PracticeListTests {

	@Test
	void reverseNullThrowsException() {
		assertThrows(NullPointerException.class, () -> {PracticeList.reverse(null);});
	}

	@Test
	void reverseDoNotModifyItsInput() {
		List<Integer> input = new ArrayList<Integer>(List.of(1,2,3,4,5,6,7));
		List<Integer> copy = List.copyOf(input);
		PracticeList.reverse(input);
		assertEquals(copy, input, "La liste en paramètre ne doit pas être modifiée !");
	}

	@Test
	void reverseEmptyIsEmpty() {
		assertEquals(List.of(), PracticeList.reverse(List.of()));
	}

	/**
	 * J'ai utilisé ici des tests paramétrés. C'est très pratique pour écrire plein de
	 * tests d'un seul coup !
	 * @param input
	 * @param expected
	 */
	@ParameterizedTest
	@MethodSource("provideListForReverse")
	void reverseExamples(List<Integer> input, List<Integer> expected) {
		try {
			assertEquals(expected, PracticeList.reverse(input));
		} catch(UnsupportedOperationException e) {
			fail("La liste en paramètre ne doit pas être modifiée !");
		}
	}

	@Test
	void fusionNullCopiesOther() {
		List<Integer> src1 = List.of(1,3,5,7);
		List<Integer> src2 = List.of(2,4,6);
		List<Integer> src1cpy = List.of(1,3,5,7);
		List<Integer> src2cpy = List.of(2,4,6);

		assertEquals(List.of(), PracticeList.fusion(null, List.of()));
		assertEquals(List.of(), PracticeList.fusion(List.of(), null));

		assertEquals(src2cpy, PracticeList.fusion(src2, null));
		assertEquals(src1cpy, PracticeList.fusion(null, src1));
	}

	@ParameterizedTest
	@MethodSource("provideListForFusion")
	void fusionExamples(List<Integer> src1, List<Integer> src2, List<Integer> expected) {
		try {
			assertEquals(expected, PracticeList.fusion(src1, src2));
		} catch(UnsupportedOperationException e) {
			fail("La liste en paramètre ne doit pas être modifiée !");
		}
	}

	@Test
	void addEmptyIsEmpty() {
		assertEquals(List.of(), PracticeList.add(List.of(), List.of(1,2,3)));
		assertEquals(List.of(), PracticeList.add(List.of(1,2,3), List.of()));
	}

	@Test
	void addNullIsEmpty() {
		assertEquals(List.of(), PracticeList.add(null, List.of(1,2,3)));
		assertEquals(List.of(), PracticeList.add(List.of(1,2,3), null));
	}

	@ParameterizedTest
	@MethodSource("provideListForAdd")
	void addExamples(List<Integer> src1, List<Integer> src2, List<Integer> expected) {
		try {
			assertEquals(expected, PracticeList.add(src1, src2));
		} catch(UnsupportedOperationException e) {
			fail("La liste en paramètre ne doit pas être modifiée !");
		}
	}

	@Test
	void evenEmptyOrNullIsEmpty() {
		assertEquals(List.of(), PracticeList.even(List.of()));
		assertEquals(List.of(), PracticeList.even(null));
	}

	@Test
	void evenExamples() {
		try {
			assertEquals(List.of(1,3,5), PracticeList.even(List.of(1,2,3,4,5)));
			assertEquals(List.of(1,3,5), PracticeList.even(List.of(1,2,3,4,5,6)));
		} catch(UnsupportedOperationException e) {
			fail("La liste en paramètre ne doit pas être modifiée !");
		}	
	}

	@Test
	void fatNullThrowsException() {
		assertThrows(NullPointerException.class, () -> {PracticeList.fat(null, 17);});
	}

	@Test
	void fatOutOfBoundThrowsException() {
		assertThrows(IndexOutOfBoundsException.class, () -> {PracticeList.fat(List.of(), 17);});
	}

	@ParameterizedTest
	@MethodSource("provideListForFAT")
	void fatExamples(List<Integer> expected, List<Integer> input, int start) {
		try {
			assertEquals(expected, PracticeList.fat(input, start));
		} catch(UnsupportedOperationException e) {
			fail("La liste en paramètre ne doit pas être modifiée !");
		}	
	}

	/*
	 * Méthodes d'aide pour implémenter les tests.
	 */
	private static Stream<Arguments> provideListForFusion() {

		List<Integer> src1 = List.of(1,3,5,7);
		List<Integer> src2 = List.of(2,4,6);

		return Stream.of(
				Arguments.of(src1, src2, List.of(1,2,3,4,5,6,7)),
				Arguments.of(src2, src1, List.of(2,1,4,3,6,5,7)),
				Arguments.of(src1, src1, List.of(1,1,3,3,5,5,7,7)),
				Arguments.of(src2, src2, List.of(2,2,4,4,6,6))
				);
	}

	private static Stream<Arguments> provideListForReverse() {
		return Stream.of(
				Arguments.of(List.of(1,2,3,4,5,6), List.of(6,5,4,3,2,1)),
				Arguments.of(List.of(1,2,3,4,5), List.of(5,4,3,2,1)),
				Arguments.of(List.of(1,2,3,4), List.of(4,3,2,1)),
				Arguments.of(List.of(1,2,3), List.of(3,2,1)),
				Arguments.of(List.of(1,2), List.of(2,1)),
				Arguments.of(List.of(1), List.of(1))
				);
	}

	private static Stream<Arguments> provideListForAdd() {
		List<Integer> src1 = List.of(1,3,5,7);
		List<Integer> src2 = List.of(2,4,6);

		return Stream.of(
				Arguments.of(src1, src2, List.of(3, 7, 11)),
				Arguments.of(src2, src1, List.of(3, 7, 11)),
				Arguments.of(src1, src1, List.of(2, 6, 10, 14)),
				Arguments.of(src2, src2, List.of(4, 8, 12))
				);
	}

	private static Stream<Arguments> provideListForFAT() {

		return Stream.of(
				Arguments.of(List.of(-1), List.of(-1), 0),
				Arguments.of(List.of(2, 4, 0, -1), List.of(-1, 2, 4, 17, 0), 1),
				Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, -1), List.of(1, 2, 3, 4, 5, 6, 7, -1), 0),
				Arguments.of(List.of(5, 6, 7, -1), List.of(1, 2, 3, 4, 5, 6, 7, -1), 4),
				Arguments.of(List.of(-1), List.of(1, 2, 3, 4, 5, 6, 7, -1), 7),
				Arguments.of(List.of(7, -1), List.of(19, 26, 38, 7, 52, 69, 7, -1), 3)
				);
	}
}
