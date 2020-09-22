#include <stdio.h>

int main() {

	char string[101];
	printf("문자를 입력하세요.(100자 이내)\n");
	scanf("%s", string);
	printf("입력된 문자는 %s입니다.", string);

	return 0;
}