import java.util.ArrayList;
import java.util.List;

public class StringTest

{
    public static void main(String args[])
    {
    	StringTest g = new StringTest();
        int[] elements = {1,2,3,4};
        ArrayList<List<Integer>> permutations = g.generatePermutations(elements);

        for ( List<Integer> s : permutations)
        {
        	for(int i: s){
        		System.out.print(i);
        	}
        	System.out.println("");
        }
    }

    private ArrayList<List<Integer>> generatePermutations( int[] elements )
    {
        ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();
        if ( elements.length == 2 )
        {

            List<Integer> x1 = new ArrayList<Integer>();
            x1.add(elements[0]);
            x1.add(elements[1]);
            List<Integer> x2 = new ArrayList<Integer>();  
            x2.add(elements[1]);
            x2.add(elements[0]);
            permutations.add(x1);
            permutations.add(x2);

        }
        else {
            for (  int i = 0 ; i < elements.length  ; i++)
            {
                int[] elements2 = new int[elements.length -1];
                int count = 0;
                for( int j =0 ; j< elements2.length ; j++ )
                {
                    if( i == j)
                    {
                        count = 1;
                    }
                    elements2[j] = elements[j+count];
                }
                ArrayList<List<Integer>> k2 = generatePermutations(elements2);
                for( List<Integer> x : k2 )
                {
                	List<Integer> s = new ArrayList<Integer>();
                    s.add(elements[i]);
                    for(int a: x){
                    	s.add(a);
                    }
                    permutations.add(s);
                }
            }
        }

        return permutations;
    }
}