#include <iostream>

void increment(int* x) {
	++*x;
}

int main() {
	using namespace std;

	int x = 10;
	cout << "증가 이전 값 :" << x << endl;
	increment(&x);
	cout << "증가 이후 값 :" << x << endl;

	system("pause");
	return 0;
}