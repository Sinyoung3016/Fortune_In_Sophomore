#include <stdio.h> // 입출력
#include <limits.h> // 정수 자료형의 최소, 최대값 메크로가 있는 라이브러리
#include <float.h> // 실수 자료형의 최소, 최대값 메크로가 있는 라이브러리

/* 
unsigned 키워드는 int char에만 사용가능, 이때 형식지정자는 %u, unsigned long int는 %lu, unsigned long long int는 %llu 
sizeof()는 매개변수의 메모리 크기를 byte 단위로 알려주는 함수
String은 char변수의 배열을 사용해 저장
str[n], 이때 n은 n바이트를 의미
*/

void main() {
	int in;
	unsigned int uint;

	float fl;
	double db;

	char ch = 'A';
	unsigned char uch = 'A';
	char str[5] = "abc";

	puts("===== 정수 자료형 =====");
	puts("int ");
	printf("int 크기 : %d byte \n", sizeof(in));
	printf("int 범위 : %d ~ %d \n", INT_MIN, INT_MAX);
	printf("int 표현 : %%d \n\n");

	puts("unsigned int "); 
	printf("unsigned int 크기 : %d byte \n", sizeof(uint));
	printf("unsigned int 범위 : 0 ~ %d \n", UINT_MAX);
	printf("unsigned int 표현 : %%u \n\n");

	puts("===== 실수 자료형 =====");
	puts("float ");
	printf("float 크기 : %d byte \n", sizeof(fl));
	printf("float 범위 : %f ~ %f \n", FLT_MIN, FLT_MAX);
	printf("float 표현 : %%f \n\n");

	puts("double ");
	printf("double 크기 : %d byte \n", sizeof(db));
	printf("double 범위 : %lf ~ %lf \n", DBL_MIN, DBL_MAX);
	printf("double 표현 : %%if \n\n");

	puts("===== 문자 자료형 =====");
	puts("char ");
	printf("char 크기 : %d byte \n", sizeof(ch));
	printf("char 범위 : %d ~ %d \n", CHAR_MIN, CHAR_MAX);
	printf("char 표현 : %%c \n\n");

	puts("unsigned char ");
	printf("unsigned  char 크기 : %d byte \n", sizeof(uch));
	printf("unsigned  char 범위 : 0 ~ %d \n", UCHAR_MAX);
	printf("unsigned  char 표현 : %%u \n\n");

	printf("문자열 str의 크기 : %d byte \n", sizeof(str));
	printf("문자열 표현: %%s \n\n");

	printf("char 값 : %c = %d \n", ch, ch);
	printf("str 값 : %s \n", str);
}

