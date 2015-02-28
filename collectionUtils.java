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
}





