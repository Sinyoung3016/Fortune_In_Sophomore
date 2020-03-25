#include <stdio.h> // �����
#include <limits.h> // ���� �ڷ����� �ּ�, �ִ밪 ��ũ�ΰ� �ִ� ���̺귯��
#include <float.h> // �Ǽ� �ڷ����� �ּ�, �ִ밪 ��ũ�ΰ� �ִ� ���̺귯��

/* 
unsigned Ű����� int char���� ��밡��, �̶� ���������ڴ� %u, unsigned long int�� %lu, unsigned long long int�� %llu 
sizeof()�� �Ű������� �޸� ũ�⸦ byte ������ �˷��ִ� �Լ�
String�� char������ �迭�� ����� ����
str[n], �̶� n�� n����Ʈ�� �ǹ�
*/

void main() {
	int in;
	unsigned int uint;

	float fl;
	double db;

	char ch = 'A';
	unsigned char uch = 'A';
	char str[5] = "abc";

	puts("===== ���� �ڷ��� =====");
	puts("int ");
	printf("int ũ�� : %d byte \n", sizeof(in));
	printf("int ���� : %d ~ %d \n", INT_MIN, INT_MAX);
	printf("int ǥ�� : %%d \n\n");

	puts("unsigned int "); 
	printf("unsigned int ũ�� : %d byte \n", sizeof(uint));
	printf("unsigned int ���� : 0 ~ %d \n", UINT_MAX);
	printf("unsigned int ǥ�� : %%u \n\n");

	puts("===== �Ǽ� �ڷ��� =====");
	puts("float ");
	printf("float ũ�� : %d byte \n", sizeof(fl));
	printf("float ���� : %f ~ %f \n", FLT_MIN, FLT_MAX);
	printf("float ǥ�� : %%f \n\n");

	puts("double ");
	printf("double ũ�� : %d byte \n", sizeof(db));
	printf("double ���� : %lf ~ %lf \n", DBL_MIN, DBL_MAX);
	printf("double ǥ�� : %%if \n\n");

	puts("===== ���� �ڷ��� =====");
	puts("char ");
	printf("char ũ�� : %d byte \n", sizeof(ch));
	printf("char ���� : %d ~ %d \n", CHAR_MIN, CHAR_MAX);
	printf("char ǥ�� : %%c \n\n");

	puts("unsigned char ");
	printf("unsigned  char ũ�� : %d byte \n", sizeof(uch));
	printf("unsigned  char ���� : 0 ~ %d \n", UCHAR_MAX);
	printf("unsigned  char ǥ�� : %%u \n\n");

	printf("���ڿ� str�� ũ�� : %d byte \n", sizeof(str));
	printf("���ڿ� ǥ��: %%s \n\n");

	printf("char �� : %c = %d \n", ch, ch);
	printf("str �� : %s \n", str);
}

