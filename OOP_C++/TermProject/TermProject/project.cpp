#include <vector>
#include <fstream>
#include <iostream>
#include <sstream>
#include <cstring>
#include <string>

void printFile(int page);
void inputWord(int line, int parse, std::string input01);
void deleteWord(int line, int parse);
void changeWord(std::string input01, std::string input02);
void searchWord(std::string input01);
void parse_(std::string input, std::vector<std::string>& values, std::string& deli);

int end = 10;
int page = 1;
int main() {
    char cmd[100];
    printFile(page);

    do{
        std::cout << "" << std::endl;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        std::cout << "n : 다음 페이지, p : 이전 페이지, i : 삽입, d : 삭제, c : 변경, s : 찾기, t : 저장 후 종료" << std::endl;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        std::cin >> cmd;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;

        int line = 0, parse = 0;
        std::string input01, input02, s_line, s_parse;
        std::stringstream l, p;
        cmd[1] = ' ';

        switch (cmd[0]) {
        case 'n':
            if (page == end) {
                std::cout << "This is the Last Page" << std::endl;
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            }
            else ++page;
            printFile(page);
            break;
        case 'p':
            if (page == 1) {
                std::cout << "This is the First Page" << std::endl;
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            }
            else --page;
            printFile(page);
            break;
        case 'i':
            cmd[0] = '\n';
            s_line = strtok(cmd, ",");
            s_parse = strtok(NULL, ",");
            input01 = strtok(NULL, ")");
            l << s_line;
            l >> line;
            p << s_parse;
            p >> parse;

            inputWord(line, parse, input01);
            printFile(page);
            break;
        case 'd':
            cmd[0] = '\n';
            s_line = strtok(cmd, ",");
            s_parse = strtok(NULL, ")");
            l << s_line;
            l >> line;
            p << s_parse;
            p >> parse;

            deleteWord(line, parse);
            printFile(page);
            break;
        case 'c':
            cmd[0] = '\n';
            input01 = strtok(cmd, ",");
            input02 = strtok(NULL, ")");
            changeWord(input01, input02);
            printFile(page);
            break;
        case 's':
            input01 = strtok(cmd, ")");
            searchWord(input01);
            break;
        case 't':
            std::cout << "해당 프로그램을 종료합니다." << std::endl;
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            break;
        default :
            std::cout << "Can't find the command" << std::endl;
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        }
    } while (cmd[0] != 't');
}

void inputWord(int line, int parse, std::string input01) {

    std::ifstream in("test.txt");
    if (!in.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }
    std::string input;
    std::getline(in, input);
    in.close();

    std::ofstream out("test.txt");
    if (!out.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }

    int i = 1, count = 0, pos = 1, cursor = 1;
    std::vector<std::string> values;
    std::string deli = " ";
    parse_(input, values, deli);
   
    for(std::string s : values){
        int size = (s.length() + 1);
        if (count + size >= 75) count = 0;

        if (page == pos && line == i && parse == cursor) {
            out << input01 + " ";
        }
        
        out << s + " ";

        if ((i == 21) && (count == 0)) {
            if (pos == page) break;
            pos++;
            i = 1;
        }
      
        count += size;
        cursor++;
        if (count == 0)i++;

    }
    out.close();
}
void deleteWord(int line, int parse) {
 
    std::ifstream in("test.txt");
    if (!in.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }
    std::string input;
    std::getline(in, input);
    in.close();

    std::ofstream out("test.txt");
    if (!out.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }

    int i = 1, count = 0, pos = 1, cursor = 1;
    std::vector<std::string> values;
    std::string deli = " ";
    parse_(input, values, deli);

    for (std::string s : values) {
        int size = (s.length() + 1);
        if (count + size >= 75) count = 0;

        if (page == pos && line == i && parse == cursor) {
        }
        else {
            out << s + " ";
        }

        if ((i == 21) && (count == 0)) {
            if (pos == page) break;
            pos++;
            i = 1;
        }

        count += size;
        cursor++;
        if (count == 0)i++;

    }
    out.close();
}
void changeWord(std::string input01, std::string input02) {
    std::ifstream in("test.txt");
    if (!in.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }
    std::string input;
    std::getline(in, input);
    in.close();

    std::ofstream out("test.txt");
    if (!out.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }

    bool visited = false;
    std::vector<std::string> values;
    std::string deli = " ";
    parse_(input, values, deli);

    input01 = input01.substr(2);
    for (std::string s : values) {
        
        if (s == input01 && !visited) {
            out << input02 + " ";
            visited = true;
        }
        else out << s + " ";
    }
    out.close();
}

void printFile(int page) {
    std::ifstream in("test.txt");
    std::string s;

    if (!in.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }

    int i = 1, count = 0, pos = 1;
    do {
        in >> s;
        int size = (s.length() + 1);
        if (count + size >= 75) count = 0;

        if ((i == 21) && (count == 0)) {
            if (pos == page) break;
            pos++;
            i = 1;
        }

        if (page == pos) {
            if (count == 0) {
                if (i < 10) std::cout << "\n " << i++ << "| ";
                else std::cout << "\n" << i++ << "| ";
            }
            std::cout << s << " ";
        }
        else if (count == 0) i++;

        count += size;
    } while (!in.eof());

    if (in.eof()) end = page;
    in.close();
}
void searchWord(std::string input01) {
    std::ifstream in("test.txt");
    std::string s;
    bool print = false;
    int page = 1;
    input01 = input01.substr(2);
    int i = 1, count = 0, pos = 1;

    if (!in.is_open()) {
        std::cout << "Can't find the file" << std::endl;
    }
    do {
        in >> s;
        if (s == input01) print = true;

        if (print) {
            int size = (s.length() + 1);
            if (count + size >= 75) count = 0;

            if ((i == 21) && (count == 0)) {
                if (pos == page) break;
                pos++;
                i = 1;
            }

            if (page == pos) {
                if (count == 0) {
                    if (i < 10) std::cout << "\n " << i++ << "| ";
                    else std::cout << "\n" << i++ << "| ";
                }
                std::cout << s << " ";
            }
            else if (count == 0) i++;

            count += size;
        }
    } while (!in.eof());

    if (in.eof()) end = page;
    in.close();
}

 void parse_(std::string input, std::vector<std::string> &values, std::string& deli) {
     int pos = 0;
     std::string next;

     while ((pos = input.find(deli)) != std::string::npos) {
         next = input.substr(0, pos);
         values.push_back(next);
         input.erase(0, pos + deli.length());
     }
     values.push_back(input);
}
