/*
원의 면적을 구하는 프로그램
input : 원의 반지름 float r
output : r*r*원주율
원주율은 상수 3.14로 정의
*/

#include <stdio.h>

#define AREA(r) (r)*(r)*PI 
#define PI 3.14

void main() {
	float r = 0; 
	printf("원의 반지름 r을 입력하세요. : ");
	scanf("%f", &r);
	printf("원의 넓이는 %lf입니다.", AREA(r));
}