# Programmers.Level3_Java_2xNTiling

## 프로그래머스 > 연습문제 > 2 x n타일링

### 1. 문제설명

문제: https://programmers.co.kr/learn/courses/30/lessons/12900

input으로 가로의 길이 `n`이 들어온다. 가로길이가 `n`이고 세로길이가 `2`인 바닥을 가로길이`2` 세로길이`1`인 타일로 가득 채우려고 할 때 모든 경우의수를 return하는 문제

* 제한사항
> 경우의 수가 많아 질 수 있으므로, 경우의 수를 `1,000,000,007`로 나눈 나머지를 return

### 2. 풀이

길이 `n`인 바닥에 타일을 채우는 경우의 수는 세로로 길게 타일을 설치하여 `n-1`길이의 바닥을 채우는 경우 + 가로로 길게 타일 두개를 위아래로 설치하여 `n-2`길이의 바닥을 채우는 경우의 합으로 계산할 수 있다.

F(k)를 가로의 길이가 `k`인 바닥에 타일을 채우는 경우의 수 라고 할때, 가로가 `n`일때의 경우의 수를

`F(n) = F(n-1) + F(n-2)` 라는 점화식으로 나타낼 수 있다.

재귀를 이용하여 해결하였으나 시간초과가 나고 효율성 점수가 있어 DP로 배열을 만들어 저장하여 다음 계산에 필요한 값을 가져와 이용하였다.

```java
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
```
