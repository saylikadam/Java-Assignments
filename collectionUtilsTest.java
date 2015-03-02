import java.util.*;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;


interface ListMapper <E>{
	public E mapper(E element, int index, List<E> list);
}

class IntegerMapping implements ListMapper<Integer>{
	public Integer mapper(Integer element ,int index, List<Integer> list){
		return element.intValue() * element.intValue();
	}
}

interface ListFilter<E>{
	boolean filter(E element , int index,List<E> list);
}

class EvenNoFilter implements ListFilter<Integer>{
	public boolean filter(Integer element , int index,List<Integer> list){
		return (element.intValue() % 2 == 0);
	}
}

interface ListReducer <E,K>{
	public K add(K pv,E element);
}

class IntegerReducer implements ListReducer<Integer,Integer>{
	public Integer add(Integer pv,Integer element){
		return pv.intValue()+element.intValue();
	}
}

public class CollectionUtilsTest{
	@Test
	public void map_returns_integer_list_after_squaring_the_elements_in_the_list(){
		ListMapper<Integer> listMapper = new IntegerMapping();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(10);
		elements.add(20);
		elements.add(30);

		List<Integer> result = CollectionUtils.<Integer>map(elements,listMapper);
		assertEquals(result.get(0),(Integer)100);
		assertEquals(result.get(1),(Integer)400);	
		assertEquals(result.get(2),(Integer)900);	

	}

	@Test
	public void filter_returns_list_after_checking_elements_are_greater_than_1(){
		ListFilter<Integer> listFilter = new EvenNoFilter();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(0);
		elements.add(10);
		elements.add(20);

		List<Integer> result = CollectionUtils.filter(elements,listFilter);
		assertEquals(result.get(0),(Integer)0);
	}
// K reduce(List<E>, ListReducer<E,K>, K initial);

	@Test 
	public void reduce_returns_list_result_after_adding_elements_in_the_list(){
		ListReducer<Integer,Integer> listReducer = new IntegerReducer();
		List<Integer> elements = new ArrayList<Integer>();
		elements.add(10);
		elements.add(10);
		elements.add(10);
		Integer initVal = new Integer(0);
		Integer result = CollectionUtils.<Integer,Integer>reduce(elements,listReducer,initVal);
		assertEquals(result.intValue(),30);
	}
}