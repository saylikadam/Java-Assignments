import java.util.*;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

// List<K> map(List<E>, ListMapper<E,K>);

// Figure out what ListMapper should be and what method it should contain. 
//For this version the map will return a list of any type. 




interface ListMapper <Integer>{
	Integer mapper(Integer element, int index, List<Integer> list);
}

class IntegerMapping implements ListMapper<Integer>{
	public Integer mapper(Integer element ,int index, List<Integer> list){
		return element.intValue() * element.intValue();
	}
}

interface ListFilter<Integer>{
	boolean filter(Integer element , int index,List<Integer> list);
}

class evenNoFilter implements ListFilter<Integer>{
	public boolean filter(Integer element , int index,List<Integer> list){
		return (element.intValue() % 2 == 0);
	}
}

public class collectionUtilsTest{
	@Test
	public void map_returns_integer_list_after_squaring_the_elements_in_the_list(){
		ListMapper<Integer> listMapper = new IntegerMapping();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(10);
		elements.add(20);
		elements.add(30);

		List<Integer> result = collectionUtils.<Integer>map(elements,listMapper);
		assertEquals(result.get(0),(Integer)100);
		assertEquals(result.get(1),(Integer)400);	
		assertEquals(result.get(2),(Integer)900);	

	}

	@Test
	public void filter_returns_list_after_checking_elements_are_greater_than_1(){
		ListFilter<Integer> listFilter = new evenNoFilter();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(0);
		elements.add(10);
		elements.add(20);

		List<Integer> result = collectionUtils.filter(elements,listFilter);
		assertEquals(result.get(0),(Integer)0);
	}
}