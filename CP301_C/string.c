#include <stdio.h>
#include <string.h>


void pro01();
void pro02();
void pro03();
void pro04();
void pro05();
void pro06();
void pro07();
void pro08();

int main() {

	//pro01();
	//pro02();
	//pro03();
	//pro04();
	//pro05();
	//pro06();
	//pro07();
	pro08();

	return 0;
}
void pro08() {
	void reverse(char []);
	char s[50];

	strcpy(s, "C Programing!");
	printf("%s\n", s);

	reverse(s);
}

void reverse(char *s) {
	if (*s == 0) { //스트링마지막
		return;
	}
	else {
		reverse(s + 1);
		printf("%c", *s);
	}
}


void pro07() {
	char dest[80] = "C";

	printf("%s\n", strcat(dest, " is "));
	printf("%s\n", strncat(dest, "a JAVA",2));//두개까지만 연결
	printf("%s\n", strncat(dest, "a JAVA", 6));//마지막 문자는 자동으로 붙여주나봄 ㅇㅇ
}

void pro06() {
	char dest[80] = "Java";
	char source[80] = "C is a language";

	printf("%s\n", strcpy(dest, source));
	printf("%s\n", strcpy(dest, "C"));
	printf("%s\n", strncpy(dest, "Candy", 3));//앞의 3글자만 바뀜
	printf("%s\n", strncpy(dest, "Candy", 6));//널문자 포함하면 전부 바뀜
}

void pro05() {
	char* s1 = "java";
	char* s2 = "java";
	printf("strcmp(%s, %s) = %d\n", s1, s2, strcmp(s1,s2));

	s1 = "javac";
	s2 = "jav";
	printf("strcmp(%s, %s) = %d\n", s1, s2, strcmp(s1, s2));

	printf("strncmp(%s, %s, %d) = %d\n", s1, s2, 2, strncmp(s1, s2, 2));

}

void pro04() {
	char line[100];
	while (gets(line))
		puts(line);
	puts("");


	while (gets_s(line, 100))
		puts(line);

}

void pro03() {
	char name[30];
	char dept[30];

	printf("%s", "학과 : ");
	scanf("%s", dept);
	printf("%s", "\n이름 : ");
	scanf("%s", name);
	printf("출력 : %10s %10s\n", name, dept);
}

void pro02() {
	char c[] = "C C++ JAVA";
	printf("%s\n", c);
	c[5] = '\0';
	printf("%s\n%s\n", c, c + 6);

	c[5] = ' ';
	char* p = c;//p는 array[0]번을 가리킴
	while (*p) //*p가 '\0'값이 아닐때
		printf("%c", *p++);
	puts("");
}

void pro01() {

	char ch = 'A';
	printf("%c %d\n", ch, ch);

	char java[] = {'J','A','V','A','\0'};
	printf("%s %d\n", java, strlen(java));

	char c[] = "C language";
	printf("%s %d\n", c, strlen(c));

	char csharp[5] = "C#";
	printf("%s %d\n", csharp, strlen(csharp));

	printf("%c%c\n", csharp[0], csharp[1]);

}