#include <iostream>

using namespace std;
int i;

class A {
public: 
	~A() {
	i = 10;
	}
};
/*
int foo() {
	i = 3;
	A object;
	return i; //return으로 i = 3을 반환하고, 소멸자에서 i = 10을 진행. 
}
*/
int &foo() {
	i = 3;
	A object;
	return i; //레퍼런스를 반환하여, 반환 이후 10을 재할당 한것이 반영되어 출력
}

int main() {
	cout << foo() << endl;
	return 0;
}
