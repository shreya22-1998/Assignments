package com.ineuron.learn.assignment_two;

import java.util.Scanner;

public class QuickSort {

	public int partition(int arr[], int begin, int end) {
	    int pivot = arr[end];
	    int i = (begin-1);

	    for (int j = begin; j < end; j++) {
	        if (arr[j] <= pivot) {
	            i++;

	            int t = arr[i];
	            arr[i] = arr[j];
	            arr[j] = t;
	        }
	    }

	    int t = arr[i+1];
	    arr[i+1] = arr[end];
	    arr[end] = t;

	    return i+1;
	}
	
	public void quickSortRecurrsion(int arr[], int begin, int end) {
	    if (begin < end) {
	        int pivot = partition(arr, begin, end);
	        quickSortRecurrsion(arr, begin, pivot-1);
	        quickSortRecurrsion(arr, pivot+1, end);
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
		QuickSort qs= new QuickSort();
		qs.quickSortRecurrsion(array,0,size-1);
		
		System.out.println("Result after QuickSort:");
		for(int i=0;i<size;i++) {
			System.out.print(array[i]+", ");
		}

	}

}
