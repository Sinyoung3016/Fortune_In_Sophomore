/*
문자를 입력 받고 정렬하여 출력
input : char x
output : 
*/

#include <stdio.h>

void main() {
	printf("문자 하나를 입력하세요. : ");
	char x = getchar();
	printf("Left   : %c\n", x);
	printf("Middle : %5c\n", x);
	printf("Right  : %10c\n", x);
}