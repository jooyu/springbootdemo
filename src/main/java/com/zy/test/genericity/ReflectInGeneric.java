package com.zy.test.genericity;

public class ReflectInGeneric {
public static void main(String[] args) {
	
	Pair<Integer> pair=new Pair<Integer> ();  
	pair.setValue(3);  
	Integer integer=pair.getValue();  
	System.out.println(integer);  
	
}
}
