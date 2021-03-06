# 프로그래머스 N개의 최소공배수

### 문제 설명
두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

### 풀이 방법
수학적으로 소인수분해하여 최대 공약수, 최소 공배수를 구하는 방법은 알고 있었지만 유클리드 호제법 알고리즘은 알고 있지 않아서 어려웠다.

#### 첫 번째 오류
```
2 | 4 6 8
2 | 2 3 4
2 | 1 3 2

2 * 2 * 3 * 4 = 48이 최소공배수로 알고 있었는데 잘못됐었다.
2 * 1 * 3 * 2 = 24가 최소공배수이다.
```

#### 두 번째 오류
[최소 공배수 구하는 공식](https://blog.naver.com/pqpqv135/221911684523)  
[유클리드 호제법](https://ko.wikipedia.org/wiki/%EC%9C%A0%ED%81%B4%EB%A6%AC%EB%93%9C_%ED%98%B8%EC%A0%9C%EB%B2%95)
```
4 6의 최대 공약수는 2이고, 최소 공배수는 12이다.
여기서 알 수 있는 공식은 (4 * 6 / 최대 공약수) 이다.

4 6 8 세 개의 최대 공약수는 8이고, 최소 공배수는 24이다.
여기서도 알 수 있는 공식은 (4 * 6 * 8 / 최대 공약수) 이다.

유클리드 호제법은 두 수의 최대 공약수를 구하는 알고리즘이고
2개 이상의 수의 최대 공약수를 구하는 방법이 어려웠다.
```

```java
public static int solution(int[] arr) {
    int answer = 0;
    for (int i = 0; i < arr.length; i++) {
        answer *= arr[i];    
    }
    for (int i = 1; i < arr.length; i++) {
        for (int j = i + 1; j < arr.length; j++) {
            answer /= gcm(arr[i], arr[j]);
        }
    }

    return answer;
}
```

한참을 헤매고 있다가 다음과 같은 방법을 찾을 수 있었다.  
`4, 6, 8의 최소 공배수를 구할 때,`  
`4, 6 의 최소 공배수는 12이다.`  
`12, 8의 최소 공배수는 24이다.`  
라는 방법을 찾고나서야 쉽게 풀 수 있었다.
