#include <iostream>
#include <memory>

class Animal {
	public:
		char* name;
		int age;
		Animal(int age_, const char* name_) {
			age = age_;
			name = new char[strlen(name_)+1];
			strcpy(name, name_);
		}
		Animal(Animal& a) {
			age = a.age;
			name = new char[strlen(a.name) + 1];
			strcpy(name, a.name);
		}
		void changeName(const char* newName) {
			strcpy(name, newName);
		}
		void printAnimal() {
			std::cout << "Name: " << name << "\n Age: " << age << std::endl;
		}
};

int main() {
	Animal a(10, "Jenny");
	Animal b = a;
	a.age = 22;
	a.changeName("Brown");
	a.printAnimal();
	b.printAnimal();
	getchar();
	return 0;
}