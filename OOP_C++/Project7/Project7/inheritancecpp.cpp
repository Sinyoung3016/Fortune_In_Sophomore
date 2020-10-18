#include <iostream>

//다중상속으로 발생하는 오류 해결
//1. 클래스 생성시 virtual처리로, Cat과 Dog의 Base Class를 동기화
//2. 모든 맴버나 함수를 부를때 명시적으로 처리.

class Animal {
public:
	
protected:
	int age;
};

//class Cat : public virtual Animal {};
//class Dog : public virtual Animal {};
//

class Cat : public Animal {};
class Dog : public Animal {};

class DogCat : public Cat, public Dog {
public:
	void setAge() {
		//age = 10;
		Cat::age = 10;
	}
};

int main() {
	DogCat* dat = new DogCat();
	Animal* animal;
	//animal = dat;
	animal = static_cast<Cat*>(dat);
	animal = (Cat*)dat;
}