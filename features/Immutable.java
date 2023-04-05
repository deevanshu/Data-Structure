package com.java.features;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class Immutable {

	// fields of the Immutable class
	private final int id;

	private final String name;

	private final HashMap<String,String> testMap;


	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// Getter function for mutable objects

	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone();
	}

	// Constructor method performing deep copy

	public Immutable(int id, String name, HashMap<String,String> testMap){      
		System.out.println("Performing Deep Copy for Object initialization");

		// "this" keyword refers to the current object
		this.id=id;
		this.name=name;

		HashMap<String,String> tempMap1=new HashMap<String,String>();

		for (Map.Entry<String, String> entry : testMap.entrySet()) {

			tempMap1.put(entry.getKey(), entry.getValue());
		}
		this.testMap = tempMap1;
	//	this.testMap = testMap;
	}

	// Test the immutable class

	public static void main(String[] args) {
		HashMap<String, String> h1 = new HashMap<String,String>();
		h1.put("1", "first");
		h1.put("2", "second");

		String s = "original";

		int i=10;

		Immutable ce = new Immutable(i,s,h1);

		// print the ce values
		System.out.println("ce id: "+ce.getId());
		System.out.println("ce name: "+ce.getName());
		System.out.println("ce testMap: "+ce.getTestMap());
		// change the local variable values
		i=20;
		s="modified";
		h1.put("3", "third");
		// print the values again
		System.out.println("ce id after local variable change: "+ce.getId());
		System.out.println("ce name after local variable change: "+ce.getName());
		System.out.println("ce testMap after local variable change: "+ce.getTestMap());

		HashMap<String, String> hmTest = ce.getTestMap();
		hmTest.put("4", "new");

		System.out.println("ce testMap after changing variable from getter methods: "+ce.getTestMap());

	}
}
