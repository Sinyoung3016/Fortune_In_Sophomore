#include <stdio.h>
#include <string.h>

void pro01();
void pro02();
void pro03();
void pro04();

int main() {

	//pro01();
	//pro02();
	pro03();

	return 0;
}

void pro03() {
	void toUpperCase(char* src, char* dst);
	void subString(char* src, char* dst, int start, int end);

	static char src[30];
	static char dst[30];
	//scanf("%s", src);
	gets(src);
	toUpperCase(src, dst);
	puts("");
	subString(src, dst, 0,7);
	puts("");
	subString(src, dst, 5,10);
}

void toUpperCase(char* src, char* dst) {
	int i = 0;
	char s[30];
	while(src[i] != '\0')
		s[i] = toupper(src[i++]);

	s[++i] = '\0';
	dst = s;
	printf("%s", dst);
}
void subString(char* src, char* dst, int start, int end) {
	int n = end - start + 1;
	char s[30];
	for (int i = 0; i < n-1; i++)
		s[i] = src[i + start];

	s[end] = '\0';
	dst = s;
	printf("%s", dst);
}




void pro02() {
	char name[5][20];
	for (int i = 0; i < 5; i++)
		scanf_s("%s", name[i], 20);

	for (int i = 0; i < 5; i++)
		printf("[%d]번째 학생 이름 : %s\n",i, name[i]);

	char search[20];
	printf("찾는 학생 이름 : ");
	scanf("%s", &search);

	for (int i = 0; i < 5; i++) {
		if (strcmp(search, name[i]) == 0) {
			printf("존재함\n");
			break;
		}
		if (i == 4)
			printf("존재하지 않음\n");
	}

}

void pro01() {
	int i;
	int* pi = &i;
	int** dpi = &pi;

	*pi = 5;
	*pi += 1;
	printf("%d\n", i); //6
	printf("%d\n", (*pi)++); //6
	printf("%d\n", *pi);//7

	*pi = 10;
	printf("%d\n", ++*pi);//11
	printf("%d\n", ++**dpi);//12
	printf("%d\n", i);//12

}
