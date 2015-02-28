
// //List<E> map(List<E>, ListMapper);

// //Figure out what ListMapper should be and what method it should contain. 
// //For this version the map will return a list of the same type as it accepts.

// import java.util.List;
// import java.util.ArrayList;
// interface mapperI{
// 	public Integer mapper();
// }


// class ListMapper implements mapperI{
// 	int elements;
// 	public ListMapper(int elements){
// 		this.elements = elements;
// 	}

// 	public Integer mapper(){
// 		System.out.println(elements);
// 	}
// }


// class collectionUtils {
// 	public static void main(String[] args) {

// 		List<Integer> elements = new ArrayList<Integer>();
// 		for(ListMapper mp : elements){
// 			elements.add(mp);
// 		}

// 		// elements.add(10);
// 		// elements.add(20);
// 		// // ListMapper lp = new ListMapper();
// 		for(ListMapper mp : elements){
// 			mp.mapper();
// 		}
// 		// map(elements,)
// 	}
// }

// // List<Audible> audiblesList = new ArrayList<Audible>();
// // 		for (Audible audible : audibles) {
// // 			audiblesList.add(audible);
// // 		}
// // 		// audiblesList.add("This is a random string"); 
// // 		for(Audible audible: audiblesList) {
// // 			audible.makeSound();
// // 			// ((Audible) audible).makeSoundmakeSoundmakeSound();
// // 		}