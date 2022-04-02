package testing.propertybased.teoria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class EjemplosPBT {

	static Stream<Arguments> setProvider() {
	    return Stream.of(
	    		Arguments.of(new MySet<>(Arrays.asList(1,2,3))),
	    		Arguments.of(new MySet<>(Arrays.asList(1))),
	    		Arguments.of(new MySet<>(Arrays.asList(2))),
	    		Arguments.of(new MySet<>(Arrays.asList(1,3)))
	    );
	}
	
	@ParameterizedTest
	@MethodSource("setProvider")
	void addRemoveCancelEachOther(MySet<Integer> set) {
		MySet<Integer> orig = new MySet<>(set);
		assumeThat(set).doesNotContain(2);
		set.add(2);
		set.remove(2);
		assertThat(set).isEqualTo(orig);
	}
	
	@ParameterizedTest
	@MethodSource("setProvider")
	void addExtendsSet(MySet<Integer> set) {
		assumeThat(set).doesNotContain(2);
		int origSize = set.size();
		set.add(2);
		assertThat(set.size()).isEqualTo(origSize + 1);
	}
	
	@ParameterizedTest
	@MethodSource("setProvider")
	void addDoesNotExtendsSet(MySet<Integer> set) {
		assumeThat(set).contains(2);
		int origSize = set.size();
		set.add(2);
		assertThat(set.size()).isEqualTo(origSize);
	}
	
	@ParameterizedTest
	@CsvSource({
	    "'{1,2,3}'",
	    "'{1}'",
	    "'{2}'",
	    "'{1,3}'"
	})
	void addExtendsSetCSV(
			@ConvertWith(SetFromString.class) MySet<Integer> set) {
		assumeThat(set).doesNotContain(2);
		int origSize = set.size();
		set.add(2);
		assertThat(set.size()).isEqualTo(origSize + 1);
	}	
	
	static Stream<Arguments> findLastPropProvider() {
	    return Stream.of(
	    		Arguments.of(new int[] {1,2,3}, 3),
	    		Arguments.of(new int[] {1,3,3}, 3),
	    		Arguments.of(new int[] {1,2,3}, 0)
	    );
	}

	@ParameterizedTest()
	@MethodSource("findLastPropProvider")
	void findLastProperty(int [] arr, int elem) {
		assumeThat(arr).contains(elem);
		int result = EjemplosArray.findLast(arr, elem);
		assertThat(arr[result]).isEqualTo(elem);
		IntStream fromResult = Arrays.stream(arr).skip(result);
		assertThat(fromResult).containsOnlyOnce(elem);
	}

}

class MySet<T> extends HashSet<T> {
	
	public MySet(Collection<T> other) {
		this.addAll(other);
	}
	
}

