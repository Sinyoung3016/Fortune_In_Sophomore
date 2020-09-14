#include <iostream>
class SetValue {
	int x, y;
public:
	void setX(int givenX) {
		x = givenX;
	}
	void setY(int givenY) {
		y = givenY;
	}
	int getX() {
		return x;
	}
	int getY() {
		return y;
	}
};

int main() {
	SetValue obj;
	obj.setX(33);
	obj.setY(44);

	std::cout << "X = " << obj.getX() << ", Y = " << obj.getY() << std::endl;
	return 0;
}