package labs.algo.labo3.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PracticeQueueTests {

	@Test
	void evenNullThrowsException() {
		assertThrows(NullPointerException.class, () -> {PracticeQueue.even(null);});
	}

	@Test
	void uniqueNullThrowsException() {
		assertThrows(NullPointerException.class, () -> {PracticeQueue.unique(null);});
	}
	
	@ParameterizedTest
	@MethodSource("provideQueueForEven")
	void evenExamples(Queue<Integer> expected, Queue<Integer> input) {
		/* Notez que pour tester l'ordre des éléments, il faut passer par une liste. Pourquoi ?
		 * Vous pensez que c'est un indice pour equals que vous devez implémenter ? Vous avez raison. */
		assertEquals(List.copyOf(expected), List.copyOf(PracticeQueue.even(input)));
	}
	
	@ParameterizedTest
	@MethodSource("provideQueueForUnique")
	void uniqueExamples(Queue<String> expected, Queue<String> input) {
		assertEquals(List.copyOf(expected), List.copyOf(PracticeQueue.unique(input)));
	}

	private static Stream<Arguments> provideQueueForEven() {
		return Stream.of(
				Arguments.of(new ArrayDeque<>(List.of(2,4,6)), new ArrayDeque<>(List.of(1,2,3,4,5,6))),
				Arguments.of(new ArrayDeque<>(List.of(2,4)), new ArrayDeque<>(List.of(1,2,3,4,5))),
				Arguments.of(new ArrayDeque<>(List.of(2,4)), new ArrayDeque<>(List.of(1,2,3,4))),
				Arguments.of(new ArrayDeque<>(List.of(2)), new ArrayDeque<>(List.of(1,2,3))),
				Arguments.of(new ArrayDeque<>(List.of(2)), new ArrayDeque<>(List.of(1,2))),
				Arguments.of(new ArrayDeque<>(List.of(0)), new ArrayDeque<>(List.of(0))),
				Arguments.of(new ArrayDeque<>(), new ArrayDeque<>())
				);
	}
	
	private static Stream<Arguments> provideQueueForUnique() {
		return Stream.of(
				Arguments.of(new ArrayDeque<>(List.of("2","4","6")), new ArrayDeque<>(List.of("2","4","4","6","4","2","4","6"))),
				Arguments.of(new ArrayDeque<>(List.of("2")), new ArrayDeque<>(List.of("2","2","2","2","2","2","2","2"))),
				Arguments.of(new ArrayDeque<>(List.of("0")), new ArrayDeque<>(List.of("0"))),
				Arguments.of(new ArrayDeque<String>(), new ArrayDeque<String>())
				);
	}
}
