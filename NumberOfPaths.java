package com.learning.dynamic;

/*
 *  The problem is to count all the possible paths from top left to bottom right of a MxN matrix 
    with the constraints that from each cell you can either move to right or down.
   
    Example 1:
    	Input:
			M = 3 and N = 3
		Output: 6
		Explanation:
			Let the given input 3*3 matrix is filled as such:
			A B C
			D E F
			G H I
			
			The possible paths which exists to reach 'I' from 'A' following above conditions are as follows:
			ABCFI, ABEHI, ADGHI, ADEFI, ADEHI, ABEFI
			
	Our Task:  
		You don't need to read input or print anything. 
		Your task is to complete the function numberOfPaths() which takes the integer M and integer N 
		as input parameters and returns the number of paths..

	Expected Time Complexity: O(m + n - 1))
	Expected Auxiliary Space: O(1)
	
 */

import java.util.ArrayList;

public class NumberOfPaths {
	char[] alphabets = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	char[][] arr = null;
	
	public void prepareMatrix(int n, int m) {
		int counter = 0;
		arr = new char[n][m];
		
		for (int i = 0; i < n; ++ i) {
			for (int j = 0; j < m; ++j) {
				arr[i][j] = alphabets[counter];
				++counter;
			}
		}
	}
	
	public void print(char[][] arr) {
		for (int i = 0; i < arr.length; ++ i) {
			System.out.println();
			for (int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[i][j] + " | ");
			}
		}
	}
	
	public ArrayList<String> possiblePaths(char[][] arr, int n, int m) {
		ArrayList<String> result = new ArrayList<>();
		String tmp = "";
		helper(arr, n, m, 0, 0, result, tmp);
		return result;
	}

	private void helper(char[][] arr2, int n, int m, int i, int j, ArrayList<String> result, String tmp) {
		if (n == i && m == j) {			
			return;
		}
		
		if (i >= n) {
			i--;
			return ;
		}
		
		if (j >= m) {
			j--;
			return ;
		}
		
		
		
		char ch1 = arr2[i][j];		
		tmp += ch1;
		
		helper(arr2, n, m, i, j + 1, result, tmp);		
		helper(arr2, n, m, i + 1, j, result, tmp);
		if (tmp.length() == (n + m - 1)) {
			result.add(tmp);
		}
		tmp = tmp.substring(0, tmp.length() - 1);
		
	}

	public static void main(String[] args) {
		NumberOfPaths paths = new NumberOfPaths();
		paths.prepareMatrix(3, 3);
		paths.print(paths.arr);
		System.out.println();
		System.out.println("Unique Path: " + paths.possiblePaths(paths.arr, 3, 3));
	}

}
