#include <stdio.h>

void main() {
	char a = '\0';
	printf("getchar() ���� �ϳ� �Է� : ");
	a = getchar();
	printf("���� ��� : %c \n\n", a);

	char b;
	printf("scanf() ���� �ϳ� �Է� : ");
	scanf(" %c", &b);
	printf("���� ��� : %c \n\n", b);

	char c;
	printf("scanf_s() ���� �ϳ� �Է� : ");
	scanf_s(" %c", &c, 1);
	printf("���� ��� : %c \n\n", c);
	
	char str[10];
	printf("scanf() ���ڿ� �Է� : ");
	scanf(" %s", &str);
	printf("���ڿ� ��� : %s \n\n", str);

	int year, mon, day;
	printf("������� �Է� ��) 1999-1-10 : ");
	scanf("%d- %d- %d", &year, &mon, &day);
	printf("������� : %d %d %d \n\n", year, mon, day);

	char ch1, ch2;
	printf("�����ڸ� �������� �� ���ڸ� �Է� : ");
	scanf(" %c %c", &ch1, &ch2);
	printf("ch1 = %c / ch2 = %c \n", ch1, ch2);
}