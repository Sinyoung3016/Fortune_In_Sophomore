/*
���ڸ� �Է� �ް� �����Ͽ� ���
input : char x
output : 
*/

#include <stdio.h>

void main() {
	printf("���� �ϳ��� �Է��ϼ���. : ");
	char x = getchar();
	printf("Left   : %c\n", x);
	printf("Middle : %5c\n", x);
	printf("Right  : %10c\n", x);
}