import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
class Combinations {
	public static List<List<Integer>> ret = new ArrayList<List<Integer>>();
	/* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r)
    {
        // Current combination is ready to be printed, print it
        if (index == r)
        {
        	List<Integer> d = new ArrayList<Integer>();
            for (int j=0; j<r; j++){
            	d.add(data[j]);
            }
            ret.add(d);
            return;
        }
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }
 
    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[]=new int[r];
 
        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }
 
    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr1[] = {1,2};
        int arr2[] = {4,5};
        int r = 2;
        int s = 2;
        int n1 = arr1.length;
        int n2 = arr2.length;
        for(int i=1 ; i<=r ; i++){
        	printCombination(arr1, n1, i);
        }
        List<Integer> sumS = new ArrayList<Integer>();
        sumS.add(0);
        for(List<Integer> a: ret){
        	sumS.add(findSum(a));
        }
        ret.clear();
        for(int i=1 ; i<=r ; i++){
        	printCombination(arr2, n2, i);
        }
        List<Integer> sumK = new ArrayList<Integer>();
        sumK.add(0);
        for(List<Integer> a: ret){
        	sumK.add(findSum(a));
        }
        ret.clear();

        printAns(sumS, sumK, s);
    }
    
    public static void printAns(List<Integer> sumS, List<Integer> sumK, int s){
    	int count = 0;
    	for(int a: sumS){
    		for(int b: sumK){
    			if(a>b){
    				if((a-b)<=s)
        				count++;
    			}else{
    				if((b-a)<=s)
        				count++;
    			}
    		}
    	}
    	System.out.print(count);
    }
    
    public static int findSum(List<Integer> list){
    	int sum = 0;
    	for(int a: list){
    		sum += a;
    	}
    	return sum;
    }
}