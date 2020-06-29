#include <stdio.h>
#include <stdlib.h> //for exit();

void pro01();
void pro02();
void pro03();
void pro04();

int main() {

	//pro01();
	//pro02();
	//pro03();
	pro04();

	return 0;
}

#include <ctype.h>
void pro04() {
	FILE* f1;
	FILE* f2; //존나 헷갈리니 따로 쓰라구~

	if ((f1 = fopen("file01.txt", "w")) == NULL) {
		printf("파일 안열림.");
		exit(1);
	}
	char c[50];
	fscanf(stdin, "%s", c);
	fprintf(f1, "%s" ,c);
	fclose(f1);


	if ((f1 = fopen("file01.txt", "r")) == NULL) {
		printf("파일 안열림.");
		exit(1);
	}

	if (fopen_s(&f2, "file02.txt", "w") != 0) {
		printf("파일 안열림.");
		exit(1);
	}

	char a;
	while ((a = getc(f1)) != EOF) {
		if (isalpha(a))
			if (islower(a)) a = toupper(a);
			else if (isupper(a)) a = tolower(a);
		
		putc(a, f2);
	}

	fclose(f1);
	fclose(f2);

	if (fopen_s(&f2, "file02.txt", "r") != 0) {
		printf("파일 안열림.");
		exit(1);
	}

	char b;
	while (!feof(f2)) {
		b = fgetc(f2);
		printf("%c ", b);
	}
	fclose(f2);
}

void pro03() {
	char* fname = "grade.txt";
	FILE* f;
	char name[80];
	int cnt = 0;

	if (fopen_s(&f, fname, "w") != 0) {
		printf("연결안됨ㅠ");
		exit(1);
	}

	printf("이름과 성적(중간, 기말)을 입력하시오.");
	fgets(name, 80, stdin);

	while (!feof(stdin)) {
		fprintf(f, "%d ", ++cnt);
		fputs(name, f);
		fgets(name, 80, stdin);
	}
	fclose(f);

	if (fopen_s(&f, fname, "r") != 0) {
		printf("연결안됨ㅠ");
		exit(1);
	}

	fgets(name, 80, f);

	while (!feof(f)) {
		fputs(name, stdout);
		fgets(name, 80, f);
	}
	fclose(f);
}

void pro02() {
	char fname[] = "grade.txt";
	FILE* f;
	char name[30];
	int point1, point2, cnt = 0;

	if ((f = fopen(fname, "w")) == NULL) {
		printf("파일이 열리지 않습니다.\n");
		exit(1);
	}

	printf("이름과 성적(중간, 기말)을 입력하세요.\n");
	scanf("%s %d %d", name, &point1, &point2);

	fprintf(f, "%d %s %d %d\n", ++cnt, name, point1, point2);
	fclose(f);

	if (fopen_s(&f, fname, "r") != 0) {
		printf("파일이 열리지 않습니다.\n");
		exit(1);
	}

	fscanf(f, "%d %s %d %d\n", &cnt, name, &point1, &point2);

	fprintf(stdout, "번호  이름  중간  기말 \n");
	fprintf(stdout, "%d %s %d %d", cnt, name, point1, point2);

	fclose(f);
}

void pro01() {
	char* fname = "pro01.txt";
	FILE* f;

	char name[30] = "abc";
	int point = 99;

	if ((f = fopen(fname, "w")) == NULL) {
		//fopen_s(&f, fname, "w") != 0
		printf("파일이 열리지 않습니다.\n");
		exit(1);
	}

	fprintf(f, "이름이 %s인 학생의 성적은 %d 입니다.\n", name, point);
	fclose(f);

	printf("이름이 %s인 학생의 성적은 %d 입니다.\n", name, point);
	puts("메모장으로 열어보랜다.");

}