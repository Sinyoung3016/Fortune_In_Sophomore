/*
�Ǽ� ���� �޾� �� ���� ������ �������� ����ϴ� ���α׷�
input : float x
output : x^2 , x^3
��½� ��ȣ�� ������ ������ ����, �ε��Ҽ���
*/

#include <stdio.h>

#define SQUARE(x) (x)*(x)
#define CUBE(x) (x)*(x)*(x)

void main() {
	float x = 0;
	printf("�Ǽ����� �Է��Ͻÿ�. : ");
	scanf("%f", &x);
	printf("���� : %+10e\n", SQUARE(x)); 
	printf("������ : %+10e\n", CUBE(x));
}