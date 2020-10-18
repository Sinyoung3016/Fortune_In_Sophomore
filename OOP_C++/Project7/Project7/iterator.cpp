#include <vector>
#include <iostream>

int main() {
	std::vector<int> vec;
	vec.push_back(11);
	vec.push_back(22);
	vec.push_back(33);
	vec.push_back(44);

	for (std::vector<int>::iterator itr = vec.begin(); itr != vec.end(); ++itr) {
		if (*itr == 22) {
			itr = vec.erase(itr);
			//중간에 iterator을 수정하면 안되므로, 재할당해줌.
			//또는 itr = vec.begin()으로 다시 선언.
		}
	}
	for (std::vector<int>::iterator itr = vec.begin(); itr != vec.end(); ++itr) {
		std::cout << "Vector element: " << *itr << std::endl;
	}
}