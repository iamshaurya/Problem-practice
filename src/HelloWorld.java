import java.util.ArrayList;
import java.util.List;

public class HelloWorld{

     public static void main(String []args){
         /*char a = 'x';
         char b = 'y';
         char c = ' ';
         System.out.println((int)a);
         System.out.println((int)b);
         System.out.println((int)c);*/
         String[] input = {"hello", "ass","world", "shaurya", "hi", "shaurya"};
         List<String> in = new ArrayList<String>();
         for(String s: input){
        	in.add(s);
         }
         String[] alt = in.toArray(new String[0]);
         lexicographicSorting(alt);
         
         for(String s: alt){
        	 System.out.println(s);
         }
         
         System.out.println(getParentRuleOrder("2.2.2"));
     }
     
     //lets do bubble sort first
     public static void lexicographicSorting(String[] arr){
    	 for(int i=1 ; i< arr.length ; i++){
    		 for(int j=0 ; j< (arr.length-i) ; j++){
    			 int comparisionVal = compare(arr[j], arr[j+1]);
    			 if(comparisionVal>0){
    				 String temp = arr[j];
    				 arr[j] = arr[j+1];
    				 arr[j+1] = temp;
    			 }
    		 }
    	 }
     }
     
     //do a check for substring before calling it
     public static int compare(String a, String b){
    	 char[] arrA = a.toCharArray();
    	 char[] arrB = b.toCharArray();
    	 int lenA = arrA.length;
    	 int lenB = arrB.length;
    	 int lim = Math.min(lenA, lenB);
    	 int k=0;
    	 int diff = 0;
    	 while(k<lim){
    		 if(arrA[k] != arrB[k]){
    			 diff = arrA[k] - arrB[k];
    			 break;
    		 }
    		 k++;
    	 }
    	 return diff;
     }
     
     private static String getParentRuleOrder(String order) {
 		String[] orderArr = order.split("\\.");
 		Integer currentOrder = Integer.parseInt(orderArr[orderArr.length - 1]);
 		Integer parentOrder = --currentOrder;
 		StringBuilder sb = null;
 		if (parentOrder == 0) {
 			return orderArr.length == 1 ? null : order.substring(0, order.length() - 2);
 		}
 		else {
 			sb = new StringBuilder(order);
 			sb.deleteCharAt(order.length() - 1);
 			sb.append(Integer.toString(parentOrder));
 		}
 		return sb.toString();
 	}
}
