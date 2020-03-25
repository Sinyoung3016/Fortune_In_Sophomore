/*
실수 값을 받아 그 값의 제곱과 세제곱을 출력하는 프로그램
input : float x
output : x^2 , x^3
출력시 부호를 포함한 오른쪽 정렬, 부동소수점
*/

#include <stdio.h>

#define SQUARE(x) (x)*(x)
#define CUBE(x) (x)*(x)*(x)

void main() {
	float x = 0;
	printf("실수값을 입력하시오. : ");
	scanf("%f", &x);
	printf("제곱 : %+10e\n", SQUARE(x)); 
	printf("세제곱 : %+10e\n", CUBE(x));
}