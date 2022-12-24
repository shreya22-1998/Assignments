package com.ineuron.learn.assignment_one;

//W.A.P to print INEURON using pattern program.

public class PatternProgramOne {

	public static void main(String[] args) {
		int n=7;
		for(int i=0;i<n;i++) {  // to iterate over columns
			
			for(int j=0; j<n ;j++) { //to iterate over rows (I)
				if((i==0 ) || (i==(n-1)) || (j==(n)/2) ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.print(" ");
			for(int j=0; j<n ;j++) { //to iterate over rows (N)
				if((j==0 || j==(3*n)/4 || (i==j && i!=(n-1) && j!=(n-1)) ) ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.print(" ");
			for(int j=0; j<n ;j++) { //to iterate over rows (E)
				if((i==0 && j<(3*n)/4) || (i==(n-1)/2 && j<(3*n)/4) || (i==n-1 && j<(3*n)/4) || j==0 ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			
			for(int j=0; j<n ;j++) { //to iterate over rows (U)
				if((j==0 && i<(n-1))|| (j==(3*n)/4&&i<(n-1)) || (i==(n-1)&& j>0 && j<(3*n)/4)) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			
			for(int j=0; j<n ;j++) { //to iterate over rows (R)
				if((i==0 && j<(3*n)/4)|| (i==(n-1)/2 && j<(3*n)/4) ||(j==0) || (j == (3*n)/4 && i > 0 && i< (n-1)/2) || (i-j==(n-1)/2) ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			for(int j=0; j<n ;j++) { //to iterate over rows (O)
				if((i==0 && j>0 &&j<(3*n)/4) || i==(n-1)&& j>0 &&j<(3*n)/4 || (j==0 && i>0 &&i<(n-1)) || j==(3*n)/4 && i>0 &&i<(n-1)) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			for(int j=0; j<n ;j++) { //to iterate over rows (N)
				if((j==0 || j==(3*n)/4 || (i==j && i!=(n-1) && j!=(n-1)) ) ) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
	
	}

}
