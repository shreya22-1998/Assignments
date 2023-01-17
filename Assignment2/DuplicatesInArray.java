package com.ineuron.learn.assignment_two;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class DuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		System.out.println("Enter "+size+" elements to add in array");
		int[] array = new int[size];
		for(int i=0;i<size;i++) {
			array[i]=sc.nextInt();
		}
		
		HashMap hashmap = new HashMap<>();
		for(int i=0;i<size;i++) {
			int cnt=(int)hashmap.getOrDefault(array[i],0);
			hashmap.put(array[i], cnt+1);
		}
		Set hashSet= hashmap.entrySet();
		Iterator ir=hashSet.iterator();
		System.out.println("Duplicates in array");
		System.out.println("Array element==>no. of duplication");
		while(ir.hasNext()) {
			System.out.println(ir.next());
		}
		
		
		

	}

}
