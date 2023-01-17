package com.ineuron.learn.assignment_two;

import java.util.Scanner;

public class SelectionSort {

	 public static void sort(final int[] arr) {
	        for (int i = 0; i < arr.length - 1; i++) {
	            int min = i;
	            for (int j = i + 1; j < arr.length; j++) {
	                if (arr[min] > arr[j]) {
	                	min = j;
	                }
	            }

	            if (min != i) {
	                int temp = arr[i];
	                arr[i] = arr[min];
	                arr[min] = temp;
	            }
	        }
	    }
	 
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		System.out.println("Enter "+size+" elements to add in array");
		int[] array = new int[size];
		for(int i=0;i<size;i++) {
			array[i]=sc.nextInt();
		}
		sort(array);
		for(int i:array)
		{
			System.out.print(i+" ");
		}

	}

}
