package mapcarHW;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.Arrays;

	public class MapcarHW {
		public static void main (String[] args) {
			List<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 6, 9));
			System.out.println("The inital list is: " + list);
			//Multiply each element by 4
			list = mapcar(list, i -> i*4);
			System.out.println("The changed list is: " + list);
		}
		
		//General Method for mapcar method
		//mapcar takes a function and a list, and implements that function on that list (similar to a foreach loop)
		public static <LIST_TYPE, ELEM_TYPE> List<LIST_TYPE> mapcar(Collection<ELEM_TYPE> list, Function<ELEM_TYPE, LIST_TYPE> function)
		{
			return list.stream().map(function).collect(Collectors.toList());
		}
	}
