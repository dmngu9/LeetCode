/**
 * Knapsack 01 Problem
 * Minh Nguyen
 * Created: 12/8/2016
 * 
 * knapsack Capacity = 10kg;
 * noOfItems = 4;
 * values = {$10,$40,$30,$50};
 * weight in kg = {5,4,6,3};
 * 
 * Every item type only has quantity of 1
 * Find combination of each type of item to put in knapsack so that the value of all items in it is max
 * 
 * Formulation:
 * 		Max(bi + B[i-1,w-wi]; B[i-1,w]) when w >= wi
 * 		else fill with values from previous row
 *
 * Reference: https://www.javacodegeeks.com/2014/07/the-knapsack-problem.html
 */

package kanpsack01;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int knapsackWeight = 10;
		int noOfItems = 4;
		int[] values = new int[]{10,40,30,50};
		int[] weight = new int[]{5,4,6,3};
		
		Knapsack knapsack = new Knapsack();
		int[][] matrix = knapsack.getKnapsackMatrix(noOfItems, knapsackWeight, values, weight);
		
		System.out.println(Arrays.toString(matrix[0]));
		System.out.println(Arrays.toString(matrix[1]));
		System.out.println(Arrays.toString(matrix[2]));
		System.out.println(Arrays.toString(matrix[3]));
		System.out.println(Arrays.toString(matrix[4]));
		
		List<Integer> list = knapsack.getItemsSelected(matrix, noOfItems, knapsackWeight, weight);
		System.out.println(list);
	}

	public int[][] getKnapsackMatrix (int noOfItems, int knapsackWeight, int[] values, int[] weight) {
		
		int[][] matrix = new int[noOfItems+1][knapsackWeight+1];
		for (int i = 1; i <= noOfItems; i++) {
			for (int w = 1; w <= knapsackWeight; w++) {
				if (w < weight[i-1]) {
					matrix[i][w] = matrix[i-1][w];
				} else {
					matrix[i][w] = (values[i-1] + matrix[i-1][w-weight[i-1]]) >= matrix[i-1][w] ? values[i-1] + matrix[i-1][w-weight[i-1]] : matrix[i-1][w]; 
				}
			}
		}
		return matrix;
	}
	
	public List<Integer> getItemsSelected (int[][] matrix, int noOfItems, int knapsackWeight, int[] weight) {
		
		List<Integer> list = new ArrayList<>();
		int cursorVal = matrix[noOfItems][knapsackWeight];
		int w = knapsackWeight;
		int i = noOfItems;
		while (i > 0) {
			if (cursorVal != matrix[i-1][w]) {
				w -= weight[i-1];
				cursorVal = matrix[i-1][w];
				list.add(i);				
			} 
			i--;
		}
		return list;
	}
}
