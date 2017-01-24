package practice.coding.recursion;

/*
Question: For given encoding that {a,b,c,...,z}<->{1,2,3,...,26}
Example: If given a list of digit e.g. [1,2,3], this may represent {1,2,3}->{a,b,c} or {12,3}->{l,c} or {1,23}->{a,w}.
 			so there are 3 possible interpretations for list [1,2,3]
so, given a list of digit, calculate the number of possible interpretations for the list.
 */

import java.util.*;

/*
Approach: Similar to Powerset lil bit
Assume there is a map[(1,a), (2,b),(3,c)...(10,j)...(26,z)]
f(m) = map(m) if m=1
f(m) = {map(m)+f(m-1) , map(m[+]m-1)+f(m-2) if m+m-1 i.e. concatenation is less than 27 }
* */
public class PossibleCharInterpretations {

	public List<List> possibleWays(int[] array){
		int m = array.length-1;
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"a"); map.put(2,"b"); map.put(3,"c"); map.put(4,"d"); map.put(5,"e");
		map.put(6,"f"); map.put(7,"g"); map.put(8,"h"); map.put(9,"i"); map.put(10,"j");
		map.put(11,"k"); map.put(12,"l"); map.put(13,"m"); map.put(14,"n"); map.put(15,"o");
		map.put(16,"p"); map.put(17,"q"); map.put(18,"r"); map.put(19,"s"); map.put(20,"t");
		map.put(21,"u"); map.put(22,"v"); map.put(23,"w"); map.put(24,"x"); map.put(25,"y");
		map.put(26,"z");

		return possibleWays(array, m, map);
	}

	private List<List> possibleWays(int[] array, int m, Map<Integer,String> map){
		List<List> results = new ArrayList<>();

		if(m<0){
			List<String> s = new LinkedList<>();
			s.add("");
			results.add(s);
			return results;
		}
		if(m==0){
			List<String> s = new LinkedList<>();
			s.add(map.get(array[m]));
			results.add(s);
		}else{
			//map(m)+f(m-1)
			String head = map.get(array[m]);
			for(List curr: possibleWays(array,m-1,map)){
				List<String> temp = new ArrayList<>();
				temp.addAll(curr);
				temp.add(head);
				results.add(temp);
			}

			//map(m[+]m-1),f(m-2)
			int secondHead = Integer.parseInt(array[m-1] + "" + array[m]);

			if(map.containsKey(secondHead)){
				String secondHeadStr = map.get(secondHead);
				for(List curr: possibleWays(array,m-2,map)){
					List<String> temp = new ArrayList<>();
					temp.addAll(curr);
					temp.add(secondHeadStr);
					results.add(temp);
				}
			}
		}
		return results;
	}

	public void testcase2(){
		System.out.println("\n\n**** Testcase2 Results *****");
		int[] input = {1,2,3,4};
		List<List> results = possibleWays(input);
		for(List curr: results){
			for(Object o: curr){
				System.out.print(" "+o.toString());
			}
			System.out.println("\n------");
		}
	}


	public void testcase1(){
		System.out.println("**** Testcase1 Results *****");
		int[] input = {1,2,3};
		List<List> results = possibleWays(input);
		for(List curr: results){
			for(Object o: curr){
				System.out.print(" "+o.toString());
			}
			System.out.println("\n------");
		}
	}

	public void testbed(){
		testcase1();
		testcase2();
	}

	public static void main(String[] args){
		PossibleCharInterpretations p = new PossibleCharInterpretations();
		p.testbed();
	}

}
