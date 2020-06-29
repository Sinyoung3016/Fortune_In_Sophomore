#include <stdio.h>
void pro01();
void pro02();
double recursionOfPro02(int n, double score[]);
void pro03();
void pro04();
void pro05();
void pro06();

int main() {

	//pro01();
	//pro02();
	//pro03();
	//pro04();
	//pro05();
	//pro06();

	return 0;
}

#define ROWSIZE 4
#define COLSIZE 2
void pro06() {
	int score[][ROWSIZE][COLSIZE] = {
		{{90, 95},
		 {50, 94},
		 {12, 44},
		 {55, 84}},
		{{56, 75},
		 {85, 94},
		 {80, 15},
		 {55, 67}}
	};

	for (int i = 0; i < 2; i++) {
		printf("강좌 %d      중간  기말  \n", i + 1);
		for (int j = 0; j < ROWSIZE; j++) {
			printf("\n[%d반 %d번] ", i+1, j);
			for (int k = 0; k < COLSIZE; k++) {
				if(k%2 == 1)
					printf("%5d\n ", score[i][j][k]);
				else if (k % 2 == 0)
					printf("%5d", score[i][j][k]);
			}
		}
		puts("");
	}
}


#define ROWSIZE 2
#define COLSIZE 3
void pro05() {
	int td[][3] = { {2},{1,2,3} };

	for (int i = 0; i < ROWSIZE; i++) {
		for (int j = 0; j < COLSIZE; j++) {
			printf(" td[%d][%d] == %d\n", i, j, td[i][j]);
		}
	}

}

void pro04() {
	int td[ROWSIZE][COLSIZE] = { {1,2,3}, {4,5,6} };

	for (int i = 0; i < ROWSIZE; i++) {
		for (int j = 0; j < COLSIZE; j++) {
			printf(" td[%d][%d] == %d\n", i, j, td[i][j]);
		}
	}
}

void pro03() {
	int input[10] = { 0 };
	printf("배열에 저장할 수를 여러개 입력, 0을 입력하면 종료.\n");

	int i = 0;
	do {
		scanf("%d", &input[i]);
	} while (input[i++] != 0);

	i = 0;
	while (input[i] != 0) {
		printf("%d", input[i++]);
	}
	puts("");
	return 0;
}

#define SIZE 6
void pro02() {
	double score[] = {1.0, 2.0, 3.5, 1.5, 2.5, 3};
	double sum = 0;

	for (int i = 0; i < SIZE; i++)	sum += score[i];

	//sum = recursionOfPro02(SIZE-1, score);

	printf("성적의 합은 %.2f이고 평균은 %.2f이다.", sum, sum/SIZE);
}

double recursionOfPro02(int n, double score[]) {
	if (n == 0) return score[0];
	else return (score[n] + recursionOfPro02(n - 1, score));
}

#define SIZE 5
void pro01() {
	int score[SIZE];
	score[0] = 1;
	score[1] = 2;
	score[2] = 3;
	score[3] = 4;
	score[4] = 5;
	//score[5] = 6; 실행오류

	int scoreSize = sizeof(score) / sizeof(score[0]);
	for (int i = 0; i < scoreSize; i++) {
		printf(" %d", score[i]);
	}
	puts("");

	for (int i = 0; i < scoreSize; i++) {
		scanf(" %d", score + i);
	}
	puts("");

	for (int i = 0; i < scoreSize; i++) {
		printf("%d", score[i]);
	}
	return 0;
}