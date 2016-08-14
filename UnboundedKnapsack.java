/**
 * Unbounded Knapsack Problem
 * Minh Nguyen
 * Created: 14/8/2016
 * 
 * knapsack Capacity = 10kg;
 * noOfItems unlimited
 * values = {$10,$40,$30,$50};
 * weight in kg = {5,4,6,3};
 * 
 * Every item type only has quantity of infinity
 * Find combination of each type of item to put in knapsack so that the value of all items in it is max
 */

package kanpsack01;

import java.util.*;

public class UnboundedKnapsack {
	private HashMap<Integer,Integer> map = new HashMap<>();
	
	public int getMaxValue(int capacity, int[] v, int[] w) {
		
		if (capacity <= 0)
			return 0;
		if (map.containsKey(capacity))
			return map.get(capacity);
		
		int length = v.length;
		int[] values = new int[length];
		for (int i = 0; i < length; i++) {
			if (capacity >= w[i]) {
				values[i] = getMaxValue(capacity-w[i], v, w);
			} else {
				values[i] = 0;
			}
		}
		
		int maxVal = 0;

		for (int i = 0; i < length; i++) {
			if (capacity >= w[i])
				values[i] += v[i];
			if (maxVal < values[i]) {
				maxVal = values[i];
			}
		}
		
		map.put(capacity, maxVal);

		return maxVal;
	}
}
