package testing.parameterized.teoria;

import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ArrayFromString extends SimpleArgumentConverter {

	@Override
	protected Object convert(Object source, Class<?> targetType) {
		String strSource = ((String)source);
		strSource = strSource.substring(1, strSource.length()-1);
		String [] strArray = strSource.split(",");
		int [] res = new int [strArray.length];
		for (int i = 0; i < strArray.length; i++) 
			res[i] = Integer.parseInt(strArray[i]);
		return res;
	}
}
