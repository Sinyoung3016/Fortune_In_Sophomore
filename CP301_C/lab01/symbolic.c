#include <stdio.h>

#define PI 3.14
#define PRT printf("��ũ�� ��� ���� ���� \n")
#define msg "\n define ����� ��ũ�δ� ��ó���⿡�� \n �ش� ��ũ�λ���� �״�� �ڵ忡 ġȯ�Ѵ�. \n"
#define SQUARE(x) ((x)*(x))
#define CUBE(x) (SQUARE(x) * (x))
#define MULT(x,y) ((x)*(y))

void main() {
	
	//const ���
	puts("const ���");
	const double RATE = 0.03;
	int deposit = 800000;
	printf("������ : %f \n", RATE);
	printf("�����ܰ� : %d \n", deposit);
	printf("���ھ� : %f \n\n", deposit * RATE);

	//��ũ�� ���
	puts("��ũ�� ���");
	double r = 7.58;
	printf("%.2f�� ���� : %.2f \n", 4.32, SQUARE(4.32));
	printf("%d�� ���� : %d \n", 3, CUBE(3));
	printf("%.2f * %d = %.2f \n", 4.32, 3, MULT(4.32, 3));
	printf("���� ���� : %.2f \n", r * r * PI);
	puts(msg);
	PRT;

	//������ enum ���
	puts("ENUM ���");
	enum DAY { SUN, MON, TUE, WED, THU, FRI, SAT };
	printf("�Ͽ��� ��� : %d \n", SUN);
	printf("������ ��� : %d \n", WED);

	enum pl {c = 1972, cpp = 1983, java = 1995, csharp = 2000};
	printf("java : %d, cpp : %d, csharp : %d, c : %d \n", java, cpp, csharp, c);

}