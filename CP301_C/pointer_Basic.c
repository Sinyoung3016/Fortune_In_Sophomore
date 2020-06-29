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

#define SIZE 3
void pro08() {
	int* pary[SIZE] = {NULL};
	int a = 10, b = 20, c = 30;

	pary[0] = &a;
	pary[1] = &b;
	pary[2] = &c;

	for (int i = 0; i < SIZE; i++)
		printf("*pary[%d] = %d\n", i, *pary[i]);

	for (int i = 0; i < SIZE; i++) {
		scanf("%u", pary[i]);
		printf("%d, %d, %d\n", a, b, c);
	}


}

void pro07() {
	int score[] = {89, 98, 76};
	printf(" score : %u, &score[0] : %u\n", score, &score[0]);
	printf("*score : %d, score[0] : %d\n", *score, score[0]);

	printf("첨자  주소    저장값\n");
	int n = sizeof(score) / sizeof(score[0]);
	for (int i = 0; i < n; i++)
		printf("%2d %10u %6d\n", i, (score + i), *(score + i));
}

void pro06() {
	int i = 10, j = 20;
	const int* p = &i; //이제 수정 금지><
	p = &j; //에러 발생, 그냥 개무시 하자나...
	printf("%d\n", *p);

	double d = 7.8, e = 2.7;
	double* const pd = &d;
	*pd = 4.4;
	printf("%f\n", *pd);

}


void pro05() {
	int i;
	int* pi = &i;
	int** dpi = &pi;

	*pi = 5;
	*pi += 1;
	printf("%d\n", i);//6
	printf("%d\n",(*pi)++);//6
	printf("%d\n", *pi);//7

	*pi = 10;
	printf("%d\n", ++*pi);//11
	printf("%d\n", ++**dpi);//12
	printf("%d\n", i);//12

}


void pro04() {
	char* pc = (char*)100;
	int* pi = (int*)100;
	double* pd = (double*)100;
	//pd = 100; //경고 발생

	printf("%u %u %u\n",(int)(pc-1), (int)pc, (int)(pc+1));
	printf("%u %u %u\n", (int)(pi - 1), (int)pi, (int)(pi + 1));
	printf("%u %u %u\n", (int)(pd - 1), (int)pd, (int)(pd + 1));
}

void pro03() {
	int data = 100;
	char ch = 'A';
	int *ptrint = &data;
	char* ptrchar = &ch;
	printf("간접 참조 출력 : %d %c\n", *ptrint, *ptrchar);

	*ptrint = 200;
	*ptrchar = 'B';
	printf("직접 참조 출력 : %d %c\n", data, ch);

}

void pro02() {
	int* ptr1, * ptr2, data = 10;
	ptr1 = NULL;
	printf("%p\n", ptr1);
	//printf("%p\n", ptr2); //초기값 없으면 컴파일 오류
	printf("%d\n", data);
}

void pro01() {
	int input = 100;
	int* p = &input;

	printf("변수명   주소값   저장값\n");
	printf("input  %p    %8d\n", &input, input);
	printf("  p    %p    %p\n", &p, p);
	
}
