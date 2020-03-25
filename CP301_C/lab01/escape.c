#include <stdio.h>

void main() {
	printf("alert \a \n");
	printf("back\bspace \n"); //커서를 한문자 뒤로 이동
	printf("폼피드 \f \n");//새 페이지의 처음으로 이동(프린트시)
	printf("개행문자 \n \n"); //커서를 다음 줄로 이동
	printf("캐리지\r리턴  \n"); //현재 커서를 줄의 처음으로 이동
	printf("\t 수평 탭 \n"); //수평으로 탭 이동
	printf("\v 수직 탭 \n"); // 수직으로 탭 이동(프린트시)
	printf("\\ 백슬래시 \\ \n"); // /문자 표기
	printf("\'작은 따옴표\' \n"); // '문자 표기 
	printf("\"큰 따옴표\" \n"); // "문자 표기
	printf("물음표 \? \n"); // ?문자 표기
	printf("8진수 아스키코드 \141 \n"); //\(8진수)
	printf("16진수 아스키코드 \x61 \n"); //\x(16진수)
	printf("\0 Null \n"); //Null 포인트
}