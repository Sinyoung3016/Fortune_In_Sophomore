#include <stdio.h>

#define PI 3.14
#define PRT printf("메크로 상수 예제 종료 \n")
#define msg "\n define 선언된 매크로는 전처리기에서 \n 해당 매크로상수를 그대로 코드에 치환한다. \n"
#define SQUARE(x) ((x)*(x))
#define CUBE(x) (SQUARE(x) * (x))
#define MULT(x,y) ((x)*(y))

void main() {
	
	//const 상수
	puts("const 상수");
	const double RATE = 0.03;
	int deposit = 800000;
	printf("이자율 : %f \n", RATE);
	printf("계좌잔고 : %d \n", deposit);
	printf("이자액 : %f \n\n", deposit * RATE);

	//매크로 상수
	puts("매크로 상수");
	double r = 7.58;
	printf("%.2f의 제곱 : %.2f \n", 4.32, SQUARE(4.32));
	printf("%d의 제곱 : %d \n", 3, CUBE(3));
	printf("%.2f * %d = %.2f \n", 4.32, 3, MULT(4.32, 3));
	printf("원의 면적 : %.2f \n", r * r * PI);
	puts(msg);
	PRT;

	//열거형 enum 상수
	puts("ENUM 상수");
	enum DAY { SUN, MON, TUE, WED, THU, FRI, SAT };
	printf("일요일 상수 : %d \n", SUN);
	printf("수요일 상수 : %d \n", WED);

	enum pl {c = 1972, cpp = 1983, java = 1995, csharp = 2000};
	printf("java : %d, cpp : %d, csharp : %d, c : %d \n", java, cpp, csharp, c);

}