#include <stdio.h>

void main() {
	puts("=====���� ���=====");
	printf("%casic \n", 'B');
	printf("A\tB\tC\tD\n");
	printf("hi %c hi \n", '\t');
	printf("\"C���\" ���α׷���\n\n");

	puts("=====���� ���=====");
	printf("%d \n", 30); //10����
	printf("%d \n", 030); //8����
	printf("%d \n", 0x2f); //16����

	puts("=====�Ǽ� ���=====");
	printf("%+10.2f \n", 3.14f);
	printf("%.4f \n", 3.14e+2);
	printf("%.5f \n", 3.14e-2);

}