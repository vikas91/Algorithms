package javaAlgorithms.Search;

public class BinarySearch {
	public int binarySearch(int sortedArray[], int n){
		// Note: Should Check if array is sorted before performing binary search
		int low = 0;
		int high = sortedArray.length-1;
		while (low<=high){
			int mid = low + (high-low) / 2;
			if (sortedArray[mid] < n) low = mid +1;
			else if (sortedArray[mid] > n) high = mid-1;
			else return mid;
		}
		return 0;
	}
}
