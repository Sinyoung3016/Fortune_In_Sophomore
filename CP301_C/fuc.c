#include <stdio.h>
#include <stdlib.h>
#include <time.h>

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
	int resursion(int n);
	int n;
	scanf("%d", &n);
	for(int i = 0; i< n; i++)
		printf("%d ", recursion(i));
}
int recursion(int n) {
	if (n == 0) return 0;
	else if (n == 1) return 1;
	else return recursion(n-2) + recursion(n - 1);
}


void pro02() {
	void sumofrow(int*[]);
	void sumofcol(int*[]);
	void sumofary(int*[]);

	static int ary[5][5];

	srand((long)time(NULL));
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			ary[i][j] = rand() % 100 + 1;
		}
	}

	sumofrow(ary);
	sumofcol(ary);
	sumofary(ary);

}

void sumofrow(int ary[][5]) {
	printf("가로의 합\n");
	for (int i = 0; i < 5; i++) {
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			sum += ary[j][i];
		}
		printf("[%d] %d\n", i, sum);
	}
}
void sumofcol(int ary[][5]) {
	printf("세로의 합\n");
	for (int i = 0; i < 5; i++) {
		int sum = 0;
		for (int j = 0; j < 5; j++) {
			sum += ary[i][j];
		}
		printf("[%d] %d\n", i, sum);
	}
}
void sumofary(int ary[][5]) {
	printf("전체 배열의 합\n");
	int sum = 0;
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			sum += ary[i][j];
		}
	}
	printf("[ ] %d\n", sum);
}

void pro01() {
	int* setArray();
	int* sortArray(int*);

	int* ary = setArray();
	for (int i = 0; i < 10; i++)
		printf("%d \n", ary[i]);
	puts("");
	ary = sortArray(ary, 10);
	for (int i = 0; i < 10; i++)
		printf("%d \n", ary[i]);

}

int* sortArray(int * ary, int n){
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n-1; j++) {
			if (ary[j] > ary[j + 1]) {
				int a = ary[j];
				ary[j] = ary[j+1];
				ary[j+1] = a;
			}
		}
	}
	return ary;
}

int* setArray() {
	static int ary[10] = { 0 };
	srand((long)time(NULL));

	for (int i = 0; i < 10; i++)
		ary[i] = rand() % 100 + 1;

	return ary;
}


