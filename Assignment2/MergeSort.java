package com.ineuron.learn.assignment_two;

import java.util.Scanner;

public class MergeSort {

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }

        while (i < left)
            a[k++] = l[i++];

        while (j < right)
            a[k++] = r[j++];

}

    public static void mergeSort(int[] a, int n) {
        if (n < 2)
            return;
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
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
		
        mergeSort(array, array.length);
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i]+" ");
    }

 }
