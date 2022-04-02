package testing.propertybased.teoria;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class SetFromString extends SimpleArgumentConverter {
	@Override
	protected Object convert(Object source, Class<?> targetType) {
		String strSource = ((String)source);
		strSource = strSource.substring(1, strSource.length()-1);
		return new MySet<Integer>(Stream.of(strSource
									.split(","))
									.map(c -> Integer.parseInt(c))
									.collect(Collectors.toSet()));
	}
}
