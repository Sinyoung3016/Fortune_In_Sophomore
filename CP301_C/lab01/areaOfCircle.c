/*
���� ������ ���ϴ� ���α׷�
input : ���� ������ float r
output : r*r*������
�������� ��� 3.14�� ����
*/

#include <stdio.h>

#define AREA(r) (r)*(r)*PI 
#define PI 3.14

void main() {
	float r = 0; 
	printf("���� ������ r�� �Է��ϼ���. : ");
	scanf("%f", &r);
	printf("���� ���̴� %lf�Դϴ�.", AREA(r));
}