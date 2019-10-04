
public class Main {

	public static void main(String[] args) {
		int n = 4; // return 5

		System.out.println(new Solution().solution(n));
	}

}

class Solution {
	
	public int solution(int n) {
		int[] numOfCase = new int[n+1];
		numOfCase[1] = 1;
		numOfCase[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			numOfCase[i] = (numOfCase[i-1] + numOfCase[i-2])%1000000007;
		}
		
		return numOfCase[n];
	}

}