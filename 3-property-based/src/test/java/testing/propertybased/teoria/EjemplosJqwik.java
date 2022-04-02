package testing.propertybased.teoria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.EdgeCasesMode;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.LowerChars;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.StringLength;

public class EjemplosJqwik {

	@Property
	void absoluteValueIsPositiveOrZero(@ForAll int anInteger) {
		assertThat(Math.abs(anInteger)).isGreaterThanOrEqualTo(0);
	}

	@Property
	void lengthOfConcatenationGreaterThanLengthOfEach(
			@ForAll String string1, @ForAll String string2) {
		String conc = string1 + string2;
		assertThat(conc.length()).isEqualTo(string1.length()+string2.length());
	}
	
	@Property(edgeCases = EdgeCasesMode.NONE)
	void findLastPropertyWrong(
			@ForAll int [] arr, 
			@ForAll int elem) {
		assumeThat(arr).contains(elem);
		int result = EjemplosArray.findLast(arr, elem);
		assertThat(arr[result]).isEqualTo(elem);
		IntStream fromResult = Arrays.stream(arr).skip(result);
		assertThat(fromResult).containsOnlyOnce(elem);
	}	
	
	@Property(edgeCases = EdgeCasesMode.NONE)
	void findLastProperty(
			@ForAll @Size(max=10) @IntRange(min=1, max=5) int [] arr, 
			@ForAll @IntRange(min=1, max=5) int elem) {
		assumeThat(arr).contains(elem);
		int result = EjemplosArray.findLast(arr, elem);
		assertThat(arr[result]).isEqualTo(elem);
		IntStream fromResult = Arrays.stream(arr).skip(result);
		assertThat(fromResult).containsOnlyOnce(elem);
	}
	
	@Property
	void addExtendsSetProp(
			@ForAll @Size(max=5) Set<@StringLength(max = 5) @LowerChars String> s,
			@ForAll @StringLength(max = 5) @LowerChars String e) {
		assumeThat(s).doesNotContain(e);
		MySet<String> set = new MySet<>(s);
		int origSize = set.size();
		set.add(e);
		assertThat(set.size()).isEqualTo(origSize + 1);
	}	
	
	
	@Property
	@Report(Reporting.GENERATED)
	void addExtendsSetPropOwnGen(
			@ForAll("mySetsOfStrings") MySet<String> set,
			@ForAll("myStrings") String e) {
		assumeThat(set).doesNotContain(e);
		int origSize = set.size();
		set.add(e);
		assertThat(set.size()).isEqualTo(origSize + 1);
	}	
	
	@Provide
	Arbitrary<MySet<String>> mySetsOfStrings() {	
		Arbitrary<Set<String>> sets = Arbitraries.
				strings().
				withCharRange('a', 'z').
				ofMaxLength(5).
				set().
				ofMaxSize(5);
		return sets.map(s -> new MySet<String>(s));
	}
	
	@Provide
	Arbitrary<String> myStrings() {	
		return Arbitraries.
				strings().
				withCharRange('a', 'z').
				ofMaxLength(5);
	}
	
	
	class MySet<T> extends HashSet<T> {
		
		public MySet(Collection<T> other) {
			this.addAll(other);
		}
		
	}
	
}
