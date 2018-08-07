import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ArrayTest {

	public static void main(String[] args) {
		/*1 1 1 0 0 0
		  0 1 0 0 0 0
		  1 1 1 0 0 0
		  0 0 2 4 4 0
		  0 0 0 2 0 0
		  0 0 1 2 4 0*/
		int arr[][] = new int[6][6];
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File("input.txt"));
			br = new BufferedReader(fr);
			for(int i =0 ; i<6 ;i++){
				String[] row = br.readLine().split(" ");
				for(int j=0 ; j<6 ; j++){
					arr[i][j] = Integer.parseInt(row[j]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        
        //take 4x4 approach, 
        int hr1 = 0;
        int hr2 = 1;
        int hr3 = 2;
        int hc1 = 0;
        int hc2 = 1;
        int hc3 = 2;
        int sum = -10;
        for(int i=1 ; i<=4 ; i++){
            for(int j=0 ; j<=3 ; j++){
                int auxSum = arr[hr1][hc1+j]+arr[hr1][hc2+j]+arr[hr1][hc3+j] +
                		arr[hr2][hc2+j] +
                		arr[hr3][hc1+j]+arr[hr3][hc2+j]+arr[hr3][hc3+j];    
                if(auxSum > sum)
                    sum = auxSum;
            }
            hr1++;
            hr2++;
            hr3++;
        }
        System.out.println(sum);
    }
}
