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
	return i; //return���� i = 3�� ��ȯ�ϰ�, �Ҹ��ڿ��� i = 10�� ����. 
}
*/
int &foo() {
	i = 3;
	A object;
	return i; //���۷����� ��ȯ�Ͽ�, ��ȯ ���� 10�� ���Ҵ� �Ѱ��� �ݿ��Ǿ� ���
}

int main() {
	cout << foo() << endl;
	return 0;
}
