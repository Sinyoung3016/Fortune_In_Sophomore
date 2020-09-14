#include <iostream>
#define MAXSTACKSIZE 1000 //stack�� �ִ�ũ��

class Stack {
	int top;
public:
	int stack[MAXSTACKSIZE]; //stack

	Stack() { top = -1; };

	bool push(int input);
	int pop();
};

bool Stack::push(int input) {
	if (top >= MAXSTACKSIZE - 1) {
		std::cout << "(����) ������ ���ƽ��ϴ�." << std::endl;
		return false;
	}
	else {
		stack[++top] = input;
		std::cout << input << "�� ������ ���Խ��ϴ�." << std::endl;
		return true;
	}
}

int Stack::pop() {
	if (top < 0) {
		std::cout << "(����) ������ ������ϴ�." << std::endl;
		return -1;
	}
	else {
		int returnValue = -1;
		returnValue = stack[top--];
		return returnValue;
	}
}

int main() {
	class Stack s;
	s.push(7);
	s.push(88);
	s.push(999);
	std::cout << s.pop() << "�� ���ÿ��� ���½��ϴ�." << std::endl;
	std::cout << s.pop() << "�� ���ÿ��� ���½��ϴ�." << std::endl;
	std::cout << s.pop() << "�� ���ÿ��� ���½��ϴ�." << std::endl;

	system("pause");

	return 0;
}