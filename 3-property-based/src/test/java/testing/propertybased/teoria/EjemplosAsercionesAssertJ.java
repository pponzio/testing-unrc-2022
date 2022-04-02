package testing.propertybased.teoria;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;


// Advertencia: El código a continuación es sólo para  
// mostrar ejemplos de aserciones en AssertJ. La 
// estructura de los "tests" no es correcta (no hay método 
// bajo test (act)).
public class EjemplosAsercionesAssertJ {
	
	@Test
	void ejemploAserciones1() {
		int [] arr = {1,2,3};

		assertThat(arr).containsExactly(1,2,3);

		assertThat(arr)
			.contains(1, 3)
			.doesNotContain(4 ,5);
		
		assertThatThrownBy(() -> { EjemplosArray.findLast(null, 0); })
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessage("null array");
	}

	@Test
	void ejemploAserciones2() {
		List<Integer> list = Arrays.asList(1,2,3);

		assertThat(list)
			.hasSize(3)
			.allMatch(i -> i > 0);
	}
		
	@Test
	void ejemploAserciones3() {
		Book lordOfTheRings = new Book("The Lord of the Rings", 1000);
		Book harryPotter = new Book("Harry Potter", 450);
		List<Book> booksList = Arrays.asList(lordOfTheRings, harryPotter);
		
		assertThat(booksList)
			.filteredOn(b -> b.getPages() > 500)
			.contains(lordOfTheRings);
		
		assertThat(booksList)
			.extracting(Book::getTitle)
			.contains("The Lord of the Rings", "Harry Potter");
		
		assertThat(booksList)
			.extracting("title", "pages")
			.contains(tuple("The Lord of the Rings", 1000),
						tuple("Harry Potter", 450));
	}
		
}
