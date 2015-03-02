import java.util.*;
public class collectionUtils{
	public static <E> List<E> map(List<E> list,ListMapper listMapper){
		List<E> result = new ArrayList<E>();
		int i = 0;
		for(E element : list){
			E index = (E)listMapper.mapper(element,i,list);
			result.add(index);
			i++;
		} 
		return result;
	}

	public static <E> List<E> filter(List<E> list,ListFilter listFilter){
		List<E> result = new ArrayList<E>();
		int index = 0;
		for(E element : list){
			boolean flag = listFilter.filter(element,index,list);
			if(flag){
				result.add(element);
			}
			index++;
		}
		return result;
	}

	public static<E,K> K reduce(List<E> list, ListReducer<E,K> reducer, K initial){
		K pv = initial;
		for(E element : list){
			pv = reducer.add(pv,element);
		}
		return pv;
	}
}

// K reduce(List<E>, ListReducer<E,K>, K initial);





