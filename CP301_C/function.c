#include <stdio.h>

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

#include <ctype.h>
void pro08() {
	void printchar08(char);
	char ch;
	printf("알파벳 입력(x를 입력하면 종료)\n");

	do {
		printf("\n문자 입력후 엔터 : ");
		scanf("%c", &ch);
		getchar();
		if (isalpha(ch)) printchar08(ch);
		else printf("\n입력 :%c\n", ch);

	} while (ch != 'x' && ch != 'X');

}
void printchar08(char a) {
	if (isupper(a)) printf("입력 : %c, 변환 : %c", a, tolower(a));
	else printf("입력 : %c, 변환 : %c", a, toupper(a));
}




#define MAX 100
#include <stdlib.h>
#include <time.h>
void pro07() {
	srand((long)time(NULL));
	printf("0~%5d 사이의 난수 5개 : rand()\n",MAX);
	for (int i = 0; i < 5; i++) {
		printf("%5d ", rand()%MAX + 1);
	}

	puts("");

}

void pro06() {
	int fac(int);

	for (int i = 0; i < 10; i++) {
		printf("%d! = %d\n", i+1, fac(i+1));
	}
}
int fac(int n) {
	if (n <= 1) return 1;
	else return (n * fac(n - 1));
}

void pro05() {
	void incrementary(int *ary, int n, int SIZE);
	void printary(int *data, int SIZE);
	
	int data[] = {4, 7, 2, 3, 5};
	int aryLength = sizeof(data) / sizeof(int);

	printary(data, aryLength);
	incrementary(data, 3, aryLength);
	printf("\n배열 원소에 각각 3을 더한 결과\n");
	printary(data, aryLength);

}

void incrementary(int* ary, int n, int SIZE) {
	for (int i = 0; i < SIZE; i++)
		*(ary + i) += n;
}
void printary(int* data, int SIZE) {
	for (int i = 0; i < SIZE; i++)
		printf("%d ", *(data + i));
}


void pro04() {
	double sum(double data[][3], int, int); //이차원 배열을 전부 더함
	void printarray(double data[][3], int, int); //이차원 배열을 모두 출력

	double x[][3] = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};

	int rowsize = sizeof(x) / sizeof(x[0]);
	int colsize = sizeof(x[0]) / sizeof(x[0][0]);

	printf("2차원 배열의 자료값\n");
	printarray(x, rowsize, colsize);
	printf("2차원 배열 원소합은 %.3lf입니다.\n", sum(x, rowsize, colsize));
	
}

double sum(double (*data)[3], int a, int b) {
	//(*data) 1차원 배열을 참조
	//(*data)[int] 2차원 배열을 참조
	double sum = 0;
	for (int i = 0; i < a; i++)
		for (int j = 0; j < b; j++)
			sum += data[i][j];

	return sum;
}

void printarray(double data[][3], int a, int b) {
	for (int i = 0; i < a; i++) {
		printf("%d행 원소 : ", i);
		for (int j = 0; j < b; j++)
			printf(" x[%d][%d] = %.2lf ", i, j, data[i][j]);
		puts("");
	}
}

void pro03() {
	int add(int a, int b);
	int findMax(int, int);
	void printMin(int, int);

	int a = 3, b = 5;
	int max = findMax(a, b);
	printf("최대 : %d\n", max);
	printf("합 : %d\n", add(a, b));
	printMin(2, 5);

}

int findMax(int a, int b) {
	int max = a > b ? a : b;
	return max;
}

void printMin(int a, int b) {
	int min = a < b ? a : b;
	printf("최소 : %d",min);
}


void pro01() {
	int a = 3, b = 5;
	int add(int a, int b);
	int sum = add(a, b);
	printf("합 : %d\n", sum);
}

int add(int a, int b) {
	return (a + b);
}

void pro02() {
	int getAdd(int n);
	int max = 0;
	printf("1에서 n까지의 합을 구하세요. >>");
	scanf("%d",&max);

	printf("1에서 %d까지의 합 : %d", max, getAdd(max));
}

int getAdd(int n) {
	if (n == 1) return 1;
	else return (n + getAdd(n - 1));
}