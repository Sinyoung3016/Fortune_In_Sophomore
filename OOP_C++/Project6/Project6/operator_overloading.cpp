#include <iostream>
#include <string>

class test {
private:
	int value;
public :
	test() {};
	test(int value_) : value(value_) {};

	void showValue() {
		std::cout << value << std::endl;
	}
	test& operator+(const test& a) {
		value -= a.value;
		return *this;
	}
};

int main() {
	test value1(5);
	value1.showValue();
	test value2(10);
	value2.showValue();

	test addValue = value1 + value2;
	addValue.showValue();
	return 0;
}