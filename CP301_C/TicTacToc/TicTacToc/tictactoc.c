#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int win(char board[3][3], char a);

int main() {
	char board[3][3];
	int x, y, k, i;
	int who; //상태

	//보드를 초기화
	for (x = 0; x < 3; x++) {
		for (y = 0; y < 3; y++)
			board[x][y] = ' ';
	}

	printf("<<< Tic Tac Toc >>>\n");
	puts("");
	printf("> 게임을 시작합니다.\n");
	puts("");
	printf(">> 1번 : 2인 대결\n");
	printf(">> 2번 : 컴퓨터와 1인 대결\n");
	printf(">> 3번 : 종료\n");
	puts("");
	printf("> 번호를 입력하세요 : ");
	scanf("%d", &who);

	while (who != 3) { //종료

		if (who == 1) {//2인 대결
			for (k = 0; k < 9; k++) {

				do {//좌표 입력
					puts("");
					printf("(x,y) 좌표 : ");
					scanf(" %d %d", &x, &y);
					if ((0 > x || x > 2) || (0 > y || y > 2)) {
						printf("> 범위 밖 좌표입니다.\n");
						continue;
					}
					if (board[x][y] != ' ') printf("> 이미 입력된 자리입니다.\n");
				}while (board[x][y] != ' ');

				board[x][y] = (k % 2 == 0) ? 'X' : 'O'; //플레이어 1번은 x, 플레이어 2번은 o

				for (i = 0; i < 3; i++) { 
					printf("---:---:---\n");
					printf(" %c : %c : %c \n", board[i][0], board[i][1], board[i][2]);
				}
				printf("---:---:---\n");

				if (win(board, board[x][y]) == 1) { //승리 여부
					int num = (k % 2 == 0) ? 1 : 2;
					puts("");
					printf(">> win : 플레이어 %d <<\n", num);
					who = 3;
					break;
				}

				if (k == 8) { //마지막까지 무승부
					puts("");
					printf(">> 무승부 <<\n");
					who = 3;
					break;
				}
			}

		}//end of who == 1

		else if (who == 2) { //컴퓨터와 대결

			for (k = 0; k < 9; k++) {

				do{//좌표 입력
					if (k % 2 == 0) { //플레이어
						puts("");
						printf("(x,y)좌표 : ");
						scanf(" %d %d", &x, &y);
						if ((0 > x || x > 2) || (0 > y || y > 2)) {
							printf("> 범위 밖 좌표입니다.\n");
							continue;
						}
						if (board[x][y] != ' ') printf("> 이미 입력된 자리입니다.\n");
					}
					else {//컴퓨터
						puts("");
						printf("(x,y)좌표 : (컴퓨터)\n");
						srand(time(NULL));
						do {
							x = rand() % 3 + 1;
							y = rand() % 3 + 1;
						} while (board[x][y] != ' ');
					}
				}while(board[x][y] != ' ');

				board[x][y] = (k % 2 == 0) ? 'X' : 'O'; //플레이어 1번은 x

				for (i = 0; i < 3; i++) {
					printf("---:---:---\n");
					printf(" %c : %c : %c \n", board[i][0], board[i][1], board[i][2]);
				}
				printf("---:---:---\n");

				if (win(board, board[x][y]) == 1) {
					puts("");
					if(k % 2 == 0) {
						printf(">> win : 플레이어 <<\n");
						who = 3;
						break;
					}
					if (k % 2 != 0) {
						printf(">> win : 컴퓨터 <<\n");
						who = 3;
						break;
					}
				}

				if (k == 8) {
					puts("");
					printf(">> 무승부 <<\n");
					who = 3;
					break;
				}

			}//end of for k

		}//end of who == 1

		else {//선택사항 밖
			puts("");
			printf("> 잘못된 입력입니다. 다시 입력하세요.\n");
			printf("> 번호를 입력하세요 : ");
			scanf("%d", &who);
		}

	}//end of while

	printf("> 프로그램을 종료합니다.");

	return 0;
}

int win(char board [3][3], char a) {//승자여부를 확인
		int x = 0;
		int y = 0;
		int count = 0;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++){
				if (board[i][j] == a) count++;
			}
			if (count == 3) return 1;
			else count = 0;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 2; j >= 0 ; j--) {
				if (board[j][i] == a) count++;
			}
			if (count == 3) return 1;
			else count = 0;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[j][i] == a) count++;
			}
			if (count == 3) return 1;
			else count = 0;
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 2; j >= 0; j--) {
				if (board[i][j] == a) count++;
			}
			if (count == 3) return 1;
			else count = 0;
		}
		for (int i = 0; i < 3; i++)
			if (board[i][0] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		for (int i = 0; i < 3; i++)
			if (board[i][1] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		for (int i = 0; i < 3; i++)
			if (board[i][2] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		for (int i = 0; i < 3; i++)
			if (board[0][i] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		for (int i = 0; i < 3; i++)
			if (board[1][i] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		for (int i = 0; i < 3; i++)
			if (board[2][i] == a) count++;

		if (count == 3) return 1;
		else count = 0;
		return 0;
}