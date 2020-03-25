#include <stdio.h>

void main() {
	char a = '\0';
	printf("getchar() 문자 하나 입력 : ");
	a = getchar();
	printf("문자 출력 : %c \n\n", a);

	char b;
	printf("scanf() 문자 하나 입력 : ");
	scanf(" %c", &b);
	printf("문자 출력 : %c \n\n", b);

	char c;
	printf("scanf_s() 문자 하나 입력 : ");
	scanf_s(" %c", &c, 1);
	printf("문자 출력 : %c \n\n", c);
	
	char str[10];
	printf("scanf() 문자열 입력 : ");
	scanf(" %s", &str);
	printf("문자열 출력 : %s \n\n", str);

	int year, mon, day;
	printf("생년월일 입력 예) 1999-1-10 : ");
	scanf("%d- %d- %d", &year, &mon, &day);
	printf("생년월일 : %d %d %d \n\n", year, mon, day);

	char ch1, ch2;
	printf("구분자를 공백으로 두 문자를 입력 : ");
	scanf(" %c %c", &ch1, &ch2);
	printf("ch1 = %c / ch2 = %c \n", ch1, ch2);
}