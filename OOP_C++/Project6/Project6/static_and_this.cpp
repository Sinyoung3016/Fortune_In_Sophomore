#include <iostream>

class My_Cat {
	static int number_of_cats;
	int age;
	char* name;
	int weight;

public:
	My_Cat();
	My_Cat(int x, const char* name);
	My_Cat(const My_Cat& cat);
	~My_Cat();

	void show_status() const;
	void printName();
	My_Cat& compare_age(My_Cat& comp_cat);
};
int My_Cat::number_of_cats = 0;

My_Cat::My_Cat() : age(20), name(NULL), weight(10) {
	number_of_cats++;
}
My_Cat::My_Cat(int x, const char* cat_name) : weight(10) {
	age = x;
	number_of_cats++;
	name = new char[strlen(cat_name) + 1];
	strcpy(name, cat_name);
}
My_Cat::My_Cat(const My_Cat& cat) : weight(10) {
	std::cout << "Copy constructor invocation" << std::endl;
	age = cat.age;
	number_of_cats++;
	name = new char[strlen(cat.name) + 1];
	strcpy(name, cat.name);
}
My_Cat::~My_Cat() {
	if (name) delete[] name;
}
void My_Cat::show_status() const {
	using namespace std;
	cout << "My Cat Name : " << name << endl;
	cout << "My Cat Age : " << age << endl;
	cout << "My Cat Weight : " << weight<< endl;
	cout << "Current Number of Class : " << number_of_cats << endl;
}
void My_Cat::printName() {
	std::cout << name << std::endl;
}
My_Cat& My_Cat::compare_age(My_Cat& comp_cat) {
	if (comp_cat.age > this->age)
		return comp_cat;
	else return *this;
}
int main() {
	My_Cat cat1(3, "A");
	cat1.show_status();

	My_Cat cat2 = cat1;
	cat2.show_status();

	My_Cat cat3(5, "C");
	cat3.show_status();

	cat1.compare_age(cat3).printName();
	return 0;
}

