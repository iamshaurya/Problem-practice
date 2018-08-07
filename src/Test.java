import java.io.*;
import java.util.*;
public class Test {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine().trim());

		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine().trim());
			long[] arr = new long[n];
			String[] input = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				arr[j] = Long.parseLong(input[j]);
			}

			int startDay = -1;
			int endDay = -1;
			int max = 0;
			HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>(n);
			for(int j=0; j<n; j++) {
				HashSet<Long> set = new HashSet<Long>(n);
				set.add(arr[j]);
				startDay = j;
				for(int k=j+1; k<n; k++) {
					if(! set.contains(arr[k])) {
						set.add(arr[k]);
						if(k==n-1) {
							endDay = n-1;
						}
					}
					else {
						endDay = k-1;
						break;
					}
				} 
				if((max < endDay-startDay + 1)) {
					max = endDay-startDay + 1;
				}
				ArrayList<Integer> list = new ArrayList<Integer>(2);
				list.add(startDay+1);
				list.add(endDay+1);
				if(! map.containsKey(max)) {
					map.put(max, list);
				}

			}
			int resultKey = -1;
			for(int r :map.keySet()) {
				if(r>resultKey) {
					resultKey = r;
				}
			}
			List<Integer> result = map.get(resultKey);
			bw.write(result.get(0) + " " + result.get(1) + "\n" );
		}
		bw.close();
	}
}