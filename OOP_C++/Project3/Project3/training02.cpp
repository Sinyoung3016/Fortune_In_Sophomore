#include <iostream>
#define MAXSTACKSIZE 1000 //stack의 최대크기

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
		std::cout << "(오류) 스택이 넘쳤습니다." << std::endl;
		return false;
	}
	else {
		stack[++top] = input;
		std::cout << input << "이 스택이 들어왔습니다." << std::endl;
		return true;
	}
}

int Stack::pop() {
	if (top < 0) {
		std::cout << "(오류) 스택이 비었습니다." << std::endl;
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
	std::cout << s.pop() << "을 스택에서 꺼냈습니다." << std::endl;
	std::cout << s.pop() << "을 스택에서 꺼냈습니다." << std::endl;
	std::cout << s.pop() << "을 스택에서 꺼냈습니다." << std::endl;

	system("pause");

	return 0;
}