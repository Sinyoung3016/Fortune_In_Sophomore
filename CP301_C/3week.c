#include <stdio.h>

void pro01();
void pro02();
void pro03();
void pro04();

int main() {

	//pro01();
	//pro02();
	//pro03();
	pro04();

	return 0;
}

void pro04() {
	int alpha[26][2];
	for (int i = 0; i < 26; i++) {
		alpha[i][0] = (i + 97);
		alpha[i][1] = 0;
	}

	char ch;
	printf("소문자 알파벳을 입력 : ");
	ch = getchar();
	while (ch != EOF){
		getchar();
		if (isupper(ch)) printf("소문자 알파벳이 아님\n");
		else {
			alpha[(int)ch - 97][1]++;
		}
		printf("소문자 알파벳을 입력 : ");
		ch = getchar();
	} 
	for (int i = 0; i < 26; i++)
		printf("[%c] = %d\n", alpha[i][0], alpha[i][1]);
}

void pro03() {
	
	char name[10];
	printf("사용할 변수의 이름을 입력하시오 :");
	for (int i = 0; i < 7; i++) {
		scanf(" %c", name + i);//연속되는 입력에는 띄어쓰기
		printf("[%d] 번째 문자 : %c\n", i, name[i]);
	}
	name[7] = '\0'; //마지막 처리
	printf("입력된 변수명은 %s", name);
}

void pro02() {
	int money;
	int coin[] = {500, 100, 50, 10, 1};
	int numofcoin[5] = { 0 };
	printf("금액 입력 :");
	scanf("%d", &money);

	for (int i = 0; i < 5; i++) {
		numofcoin[i] = money / coin[i];
		money %= coin[i];
	}

	for (int i = 0; i < 5; i++) {
		printf("%d원짜리는 %d개\n",coin[i],numofcoin[i]);
	}
}

void pro01() {//소수 찾기
	int n;
	printf("2보다 큰 수 입력 :");
	scanf("%d", &n);

	for (int i = 2; i <= n; i++) {
		for (int j = 2; j <= i; j++) {
			if (i % j != 0) continue;
			else {
				if (i == j) printf("%d는 소수\n", j);
				else break;
			}
		}
	}
}

