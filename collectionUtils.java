import java.util.*;
public class collectionUtils{
	public static List<Integer> map(List<Integer> list,ListMapper listMapper){
		List<Integer> result = new ArrayList<Integer>();
		int index = 0;
		for(Integer element : list){
			index = listMapper.mapper(element,index,list);
			result.add(index);
			index++;
		} 
		return result;
	}

	public static List<Integer> filter(List<Integer> list,ListFilter listFilter){
		List<Integer> result = new ArrayList<Integer>();
		int index = 0;
		for(Integer element : list){
			boolean flag = listFilter.filter(element,index,list);
			if(flag){
				result.add(element);
			}
			index++;
		}
		return result;
	}
}






