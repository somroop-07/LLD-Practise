package core_java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FilterEvenNumbers {
	
	public static void solve() {
	List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6)); 
	list1.stream().filter(x -> x % 2 == 0).forEach(System.out:: println);
	}
}

class CountFreq {
	public static void solve() {
		List<String> list1 = new ArrayList<>(Arrays.asList("abc", "xyz", "abc")); 
		Map<String, Integer> map = new HashMap<>();
		for(String wordString : list1) {
			map.put(wordString, map.getOrDefault(wordString, 0) + 1);
		}
		for(String wordString : map.keySet()) {
			System.out.println(wordString + map.get(wordString));
		}
	}
	public static void solveUsingStream() {
		List<String> list1 = new ArrayList<>(Arrays.asList("abc", "xyz", "abc")); 
		Map<String, Long> map = list1.stream().collect(Collectors.groupingBy(word -> word, Collectors.counting()));
		map.forEach((key, value) -> System.out.println(key + " " + value)) ;
	}
}

class RemoveDuplicates {
	
	public static void solve() {
	List<Integer> list1 = new ArrayList<>(Arrays.asList(1,6,2,3,1,6,4,5,6)); 
	list1.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
	}
}
class Employee {
	private String name;
	private int salary;
	public Employee(String name, int salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
		
}

class Employee2 {
	private String name;
	String department;
	private int salary;
	
	public Employee2(String name, String department, int salary) {
		super();
		this.name = name;
		this.department = department;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
		
}

class EmployeeSort {
	public static void solve() {
		List<Employee> list1 = new ArrayList<>(Arrays.asList(new Employee("Rahul", 100000), new Employee("Rahul", 80000),new Employee("Rahul", 90000))); 
		Comparator<Employee> cmpBySalary = (e1, e2) -> 
		{
			if(e1.getSalary() < e2.getSalary()) {
				return -1;
			}
			else if(e1.getSalary() > e2.getSalary()) {
				return 1;
			}
			else {
				return 0;
			}
		};
		Collections.sort(list1, cmpBySalary);
		list1.forEach(e -> System.out.println(e.getName() + " " + e.getSalary()));
}
}

class UpperCaseFunction {
	public static void solve() {
		List<String> list = Arrays.asList("Afdf", "sdfs", "kJkd");
		list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
	}
}
class Sum {
	public static void solve() {
		List<Integer> list = Arrays.asList(5,6,3,17);
		int sum = list.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sum);
	}
}
class JoinByComma {
	public static void solve() {
		List<String> list = Arrays.asList("Afdf", "sdfs", "kJkd");
		String reString = list.stream().collect(Collectors.joining(","));
		System.out.println(reString);
	}
}
class SortMapByValue {
	public static void solve() {
		List<Employee> list1 = new ArrayList<>(Arrays.asList(new Employee("Rahul", 100000), new Employee("dfsdf", 80000),new Employee("fgfdg", 90000))); 
		Map<String, Integer> map = list1.stream().collect(Collectors.toMap(
				item -> item.getName(), 
				item -> item.getSalary(),
				(e1, e2) -> e1));
		//Sort by value
		Map<String, Integer> map2 = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry ::getKey, Map.Entry ::getValue,
				(e1,  e2) -> e1, LinkedHashMap::new));
						
		Map<String, Integer> mp3 = map.entrySet().stream().sorted((e1,e2) -> e1.getValue().compareTo(e2.getValue())).collect(Collectors.toMap(
				item -> item.getKey(),
				item -> item.getValue(),
				(e1, e2) -> e1,
				LinkedHashMap :: new
				
				));
		System.out.println(mp3);
	}
}
class MapDepartmentWise {
	public static void solve() {
	    List<Employee2> employeeList = Arrays.asList(new Employee2("Rahul", "IT", 1000000), new Employee2("Rohan", "HR", 500000),
	    		new Employee2("Sdfdaf", "IT", 120000),new Employee2("Ssfdaf", "HR", 760000),new Employee2("Ddfdf", "MKT", 200000));
	    Map<String, List<Employee2>> mp = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
	    System.out.println(mp);
	}
}
class FindAvgSalary {
	public static void solve() {
	    List<Employee2> employeeList = Arrays.asList(new Employee2("Rahul", "IT", 1000000), new Employee2("Rohan", "HR", 500000),
	    		new Employee2("Sdfdaf", "IT", 120000),new Employee2("Ssfdaf", "HR", 760000),new Employee2("Ddfdf", "MKT", 200000));
	    Map<String, Double> mp = employeeList.stream().collect(Collectors.groupingBy(Employee2 :: getDepartment, Collectors.averagingDouble(Employee2 :: getSalary)));
	    System.out.println(mp);
	}
}

public class StreamAPI {
  public static void main(String[] args) {
	
	// 1)Filter even numbers
	   //FilterEvenNumbers.solve();
	
	// 2) a) Count frequency of string
	   // CountFreq.solve();
	
	// 2b) Count frequency of string using streamAPI
	     //CountFreq.solveUsingStream();
	  
	// 3. Remove duplicates from list
	     //RemoveDuplicates.solve();
	     
	 //4.Sort employees by salary using Comparator + lambda
	     //EmployeeSort.solve();
	     
	 //5. Convert a list of strings to uppercase
	     //UpperCaseFunction.solve();
	 
	 //6. Sum all numbers in a list using reduce()
	     //Sum.solve();
	 
	 //7. Join strings into a comma-separated value
	     // JoinByComma.solve();
	  
	 //8. Sort map by Value
	    //SortMapByValue.solve();
	  
	 //9. Find avg salary department wise
	     // FindAvgSalary.solve();
	 //10.create a map  where key is dept and values are employees wiht same dept.
	    MapDepartmentWise.solve();
}        
}
