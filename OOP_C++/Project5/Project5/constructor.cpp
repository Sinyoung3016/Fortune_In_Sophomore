class Animal {
	int numberOfLeg = 0;
public:
	Animal() {};
	Animal(int numberOfLeg) {
		this->numberOfLeg = numberOfLeg;
	}
};

int main() {
	Animal a;
	return 0;
}