package com.ineuron.learn.assignment_two;

import java.util.Scanner;

public class SubsetOfArray {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter size of parent array");
		int size = sc.nextInt();
		System.out.println("Enter "+size+" elements to add in parent array");
		int[] parent_arr = new int[size];
		for(int i=0;i<size;i++) {
			parent_arr[i]=sc.nextInt();
		}
		
		System.out.println("Enter size of subset array");
		int sub_size = sc.nextInt();
		System.out.println("Enter "+sub_size+" elements to add in subset array");
		int[] sub_arr = new int[sub_size];
		for(int i=0;i<sub_size;i++) {
			sub_arr[i]=sc.nextInt();
		}
		
		
		
		boolean flag = false;
		for (int i=0; i<sub_arr.length; i++) {
			flag=false;
			for (int j=0; j<parent_arr.length; j++) {
				if (parent_arr[j] == sub_arr[i]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				break;
			}
			
		}
		
		if (flag) {
			System.out.print("Yes! It is subset of array");
		}	else {
			System.out.print("No! It is not subset of array");
		}
		
	}

}
