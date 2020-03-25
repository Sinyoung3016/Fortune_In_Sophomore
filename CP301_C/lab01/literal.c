#include <stdio.h>

void main() {
	puts("=====문자 상수=====");
	printf("%casic \n", 'B');
	printf("A\tB\tC\tD\n");
	printf("hi %c hi \n", '\t');
	printf("\"C언어\" 프로그래밍\n\n");

	puts("=====정수 상수=====");
	printf("%d \n", 30); //10진수
	printf("%d \n", 030); //8진수
	printf("%d \n", 0x2f); //16진수

	puts("=====실수 상수=====");
	printf("%+10.2f \n", 3.14f);
	printf("%.4f \n", 3.14e+2);
	printf("%.5f \n", 3.14e-2);

}