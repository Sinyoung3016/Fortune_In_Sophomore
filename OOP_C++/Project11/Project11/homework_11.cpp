#include <iostream>
#include <string>


class Animal {
public:
	Animal() {}
	int size = 0;
	virtual void sound() = 0;
	virtual void isBiggerthan(const Animal& a) = 0;
};

class Dog : public Animal {
public:
	Dog() {}
	int speed = 0;
	virtual int getSpeed() = 0;
	virtual void fast(const Dog& b) = 0;
};

class Bird : public Animal {
public:
	Bird() {}
	int altitude = 0;
	virtual int getAltitude() = 0;
	virtual void isHigherthan (const Bird& b) = 0;
};

class Shepherd : public Dog {
public:
	Shepherd(int speed_, int size_) {
		speed = speed_;
		size = size_;
	}
	int getSpeed() override {
		return speed;
	}
	void fast(const Dog& b) override {
		if (this->speed > b.speed) {
			std::cout << "true" << std::endl;
		}
		else{
			std::cout << "false" << std::endl;
		}
	}
	void sound() override{}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else 
			std::cout << "false" << std::endl;
	}
};
class Bulldog : public Dog {
public:
	int getSpeed() override {
		return speed;
	}
	Bulldog(int speed_, int size_){
		speed = speed_;
		size = size_;
	}
	std::string big(const Dog& b){}
	void fast(const Dog& b) override {
		if (this->speed > b.speed) {
			std::cout << "true" << std::endl;
		}
		else {
			std::cout << "false" << std::endl;
		}
	}
	void sound() override{}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else 
			std::cout << "false" << std::endl;
	}
};
class Beagle : public Dog {
public:
	int getSpeed() override {
		return speed;
	}
	Beagle(int speed_, int size_){
		speed = speed_;
		size = size_;
	}
	std::string big(const Dog& b){}
	void fast(const Dog& b) override {
			if (this->speed > b.speed) {
			std::cout << "true" << std::endl;
		}
		else {
			std::cout << "false" << std::endl;
		}
	}
	void sound() override{}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else 
			std::cout << "false" << std::endl;
	}
};

class Swallow : public Bird {
public:
	Swallow() {}
	Swallow(int altitude_, int size_) {
		altitude = altitude_;
		size = size_;
	}
	void sound() override {
		std::cout << "Swallow_Cry" << std::endl;
	}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else 
			std::cout << "false" << std::endl;
	}
	int getAltitude() override {
		return altitude;
	}
	void isHigherthan(const Bird& b) override {
		if (this->altitude > b.altitude)
			std::cout << "true" << std::endl;
		else
			std::cout << "false" << std::endl;
	}
};

class Eagle : public Bird {
public:
	Eagle() {}
	Eagle(int altitude_, int size_) {
		altitude = altitude_;
		size = size_;
	}
	void sound() override {
		std::cout << "Eagle_Cry" << std::endl;
	}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else
			std::cout << "false" << std::endl;
	}
	int getAltitude() override {
		return altitude;
	}
	void isHigherthan(const Bird& b) override {
		if (this->altitude <= b.altitude)
			std::cout << "true" << std::endl;
		else
			std::cout << "false" << std::endl;
	}
};

class Chicken : public Bird {
public:
	Chicken() {}
	Chicken(int altitude_, int size_) {
		altitude = altitude_;
		size = size_;
	}
	void sound() override {
		std::cout << "Chicken_Cry" << std::endl;
	}
	void isBiggerthan(const Animal& a) override {
		if (this->size > a.size)
			std::cout << "true" << std::endl;
		else
			std::cout << "false" << std::endl;
	}
	int getAltitude() override {
		return altitude;
	}
	void isHigherthan(const Bird& b) override {
		if (this->altitude > b.altitude)
			std::cout << "true" << std::endl;
		else
			std::cout << "false" << std::endl;
	}
};


int main() {
	Swallow s (10,20);
	Swallow news(30,40);
	Shepherd h(1, 1);
	Bulldog bul(20, 30);
	h.fast(bul);
}












