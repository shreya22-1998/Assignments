package com.ineuron.learn.assignment_two;

import java.util.Scanner;

public class BubbleSort {
	
	public static void bubblesort(int[] arr) {
		for(int i=0;i<arr.length;i++)
		{
			for(int j=1;j<arr.length-i;j++)
			{
				if(arr[j]<arr[j-1])
				{
					int t=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=t;
				}
			}
		}
		
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
	}
	
	public static void main(String args[]) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = sc.nextInt();
		System.out.println("Enter "+size+" elements to add in array");
		int[] array = new int[size];
		for(int i=0;i<size;i++) {
			array[i]=sc.nextInt();
		}
		
		bubblesort(array);
	}
}
