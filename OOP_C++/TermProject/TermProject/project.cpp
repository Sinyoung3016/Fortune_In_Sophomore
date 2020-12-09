#include <vector>
#include <fstream>
#include <iostream>
#include <sstream>
#include <cstring>
#include <string>

class Editor {
private:
    static Editor* edit;
    const char* text;
    int text_end = 1, page = 1;
    int line = 0, parse = 0;

    void initEnd() {
        std::ifstream in(text);
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
                pos++;
                i = 1;
            }
            else if (count == 0) i++;

            count += size;
        } while (!in.eof());

        if (in.eof()) text_end = pos;
        in.close();
    }
    void inputWord(int line, int parse, std::string input01) {

        try {
            std::ifstream in(text);
            if (!in.is_open()) {
                std::cout << "Can't find the file" << std::endl;
            }
            std::string input;
            in.clear();
            std::getline(in, input);
            in.close();

            std::ofstream out(text);
            if (!out.is_open()) {
                std::cout << "Can't find the file" << std::endl;
            }

            int i = 1, count = 0, pos = 1, cursor = 1;
            bool find = false;
            std::vector<std::string> values;
            std::string deli = " ";
            parse_(input, values, deli);

            for (std::string s : values) {
                int size = (s.length() + 1);
                if (count + size >= 75) {//nextline
                    count = 0;
                    i++;
                }
                if (page == pos && line == i) {
                    if (parse == cursor) {
                        find = true;
                        out << input01 + " ";
                    }
                    cursor++;
                }

                out << s + " ";
                if ((i == 21) && (count == 0)) { //nextpage
                    if (pos == page) break;
                    pos++;
                    i = 1;
                }

                count += size;
            }
            if (!find) throw std::exception("! 해당하는 parse값이 너무 큽니다.");
            out.close();
        }
        catch (std::exception& a) {
            throw;
        }

    }
    void deleteWord(int line, int parse) {
        try{
        std::ifstream in(text);
        if (!in.is_open()) {
            std::cout << "Can't find the file" << std::endl;
        }
        std::string input;
        in.clear();
        std::getline(in, input);
        in.close();

        std::ofstream out(text);
        if (!out.is_open()) {
            std::cout << "Can't find the file" << std::endl;
        }

        int i = 1, count = 0, pos = 1, cursor = 1;
        bool find = false;
        std::vector<std::string> values;
        std::string deli = " ";
        parse_(input, values, deli);

        for (std::string s : values) {
            int size = (s.length() + 1);
            if (count + size >= 75) {//nextline
                count = 0;
                i++;
            }
            if (page == pos && line == i) {
                if (parse == cursor) {
                    find = true;
                }
                else {
                    out << s + " ";
                }
                cursor++;
            }
            else {
                out << s + " ";
            }
            if ((i == 21) && (count == 0)) { //nextpage
                if (pos == page) break;
                pos++;
                i = 1;
            }

            count += size;
        }
        if (!find) throw std::exception("! 해당하는 parse값이 너무 큽니다.");

        out.close();
        }
        catch (std::exception& a) {
            std::cout << a.what() << std::endl; 
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        }
    }
    void changeWord(std::string input01, std::string input02) {
        std::ifstream in(text);
        if (!in.is_open()) {
            std::cout << "Can't find the file" << std::endl;
        }
        std::string input;
        in.clear();
        std::getline(in, input);
        in.close();

        std::ofstream out(text);
        if (!out.is_open()) {
            std::cout << "Can't find the file" << std::endl;
        }

        bool find = false;
        std::vector<std::string> values;
        std::string deli = " ";
        parse_(input, values, deli);

        input01 = input01.substr(2);
        for (std::string s : values) {

            if (s == input01 && !find) {
                out << input02 + " ";
                find = true;
            }
            else out << s + " ";
        }
        if (!find) throw std::exception("! 해당 input은 텍스트 내에 존재하지 않습니다.");

        out.close();        
    }
    void searchWord(std::string input01) {
        std::ifstream in(text);
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

        if (!print) throw std::exception("! 해당 input은 텍스트 내에 존재하지 않습니다.");
        in.close();
    }
    void parse_(std::string input, std::vector<std::string>& values, std::string& deli) {
        int pos = 0;
        std::string next;

        while ((pos = input.find(deli)) != std::string::npos) {
            next = input.substr(0, pos);
            values.push_back(next);
            input.erase(0, pos + deli.length());
        }
        values.push_back(input);
    }

public:
    Editor(const char* text) : text(text) {
        initEnd();
    }
    static Editor* getInstance(const char* text) {
        if (!edit)
            edit = new Editor(text);
        return edit;
    }

    int text_end_f() {
        return text_end;
    }

    void printFile() {
        std::ifstream in(text);
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

        if (in.eof()) text_end = pos;
        in.close();
    }
    bool next() {
        if (page == text_end) {
            std::cout << "This is the Last Page" << std::endl;
            return true;
        }
        else ++page;
        return false;
    }
    bool prev() {
        if (page == 1) {
            std::cout << "This is the First Page" << std::endl;
            return true;
        }
        else --page;
        return false;
    }
    bool deleteFunc(char *cmd) {
        try {
            cmd[0] = '\n';
            std::string s_line = strtok(cmd, ",");
            std::string s_parse = strtok(NULL, ",");

            if (strtok(NULL, ",") != NULL)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : i(int line, int parse, string input)");

            std::stringstream l, p;
            l << s_line;
            l >> line;
            p << s_parse;
            p >> parse;

            std::cout << line << ":" << parse << std::endl;

            if (!line || !parse)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : i(int line, int parse, string input)");
            if (1 > line || line > 20)
                throw std::exception("! 범위 밖 입력입니다.(line은 1~20의 정수)");
           }
        catch (std::exception& a) {
            throw;
        }

        deleteWord(line, parse);
        printFile();
        return true;
    }
    bool inputFunc(char* cmd) {
        std::string s_line, s_parse, input01;
        std::stringstream l, p;

        try {
            cmd[0] = '\n';

            s_line = strtok(cmd, ",");
            s_parse = strtok(NULL, ",");
            input01 = strtok(NULL, ",");

            if (strtok(NULL, ",") != NULL)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : i(int line, int parse, string input)");

            l << s_line;
            l >> line;
            p << s_parse;
            p >> parse;

            if (!line || !parse)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : i(int line, int parse, string input)");
            if (1 > line || line > 20)
                throw std::exception("! 범위 밖 입력입니다.(line은 1~20의 정수)");
            if (input01.size() >= 75)
                throw std::exception("! string은 75자 미만 출력이 가능합니다.");
        }
        catch (std::exception& a) {
            throw;
        }

        inputWord(line, parse, input01);
        printFile();
        return true;
    }
    bool changeFunc(char* cmd) {
        std::string input01, input02;
        try {
            cmd[0] = '\n';
            input01 = strtok(cmd, ",");
            input02 = strtok(NULL, ",");

            if (strtok(NULL, ",") != NULL)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : c(string input, string input)");

            if (input01.size() >= 75 || input02.size() >= 75)
                throw std::exception("! string은 75자 미만 출력이 가능합니다.");
        }
        catch (std::exception& a) {
            throw;
        }

        changeWord(input01, input02);
        printFile();
        return true;
    }
    bool searchFunc(char* cmd) {
        std::string input01;

        try {
            input01 = strtok(cmd, ",");

            if (strtok(NULL, ",") != NULL)
                throw std::exception("! 입력 포멧이 잘못되었습니다 : s(string input)");
        }
        catch (std::exception& a) {
            throw;
        }

        searchWord(input01);
        return true;
    }
};

Editor* Editor::edit = NULL;
Editor* e = Editor::getInstance("test.txt");

char cmd[100];
bool checkCmd();
bool pass;
int main() {
    e->printFile();

    do {
        
        std::cout << "" << std::endl;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        std::cout << "n : 다음 페이지, p : 이전 페이지, i : 삽입, d : 삭제, c : 변경, s : 찾기, t : 저장 후 종료" << std::endl;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        std::cin >> cmd;
        std::cout << "-----------------------------------------------------------------------------------------" << std::endl;

        try {

            pass = checkCmd();

        if (!pass) {
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            e->printFile();
            continue;
        }
         
        switch (cmd[0]) {
        case 'n':
            if (e->next())
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            e->printFile();
            break;
        case 'p':
            if (e->prev())
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            e->printFile();
            break;
        case 'i':
            if (!e->inputFunc(cmd)) {
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
                e->printFile();
            }
            break;
        case 'd':
            if (!e->deleteFunc(cmd)) {
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
                e->printFile();
            }
            break;
        case 'c':
            if (!e->changeFunc(cmd)) {
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
                e->printFile();
            }
            break;
        case 's':
            if(!e->searchFunc(cmd)){
                std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
                e->printFile();
            }
            break;
        case 't':
            std::cout << "해당 프로그램을 종료합니다." << std::endl;
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            break;
        default :
            std::cout << "Can't find the command" << std::endl;
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
        }

        }
        catch (std::exception& a) {
            std::cout << a.what() << std::endl;
            std::cout << "-----------------------------------------------------------------------------------------" << std::endl;
            e->printFile();
        }

    } while (cmd[0] != 't');
}

bool checkCmd() {
    int len = strlen(cmd);
    if (cmd[0] == 'n' || cmd[0] == 'p' || cmd[0] == 't') {
        if (len != 1) {
            throw std::exception("Can't find the command");
        }
    }
    else if (cmd[0] == 'i' || cmd[0] == 's' || cmd[0] == 'd' || cmd[0] == 'c') {
        int count = 0;
        bool pass = false;
        if (cmd[1] == '(' && cmd[len - 1] == ')') {
            for (int i = 2; i < len - 1; i++) {
                if (cmd[i] == ',') count++;
            }

            if (cmd[0] == 'i' && count == 2 && len >= 8) pass = true;
            if (cmd[0] == 's' && count == 0 && len >= 4) pass = true;
            if (cmd[0] == 'd' && count == 1 && len >= 6) pass = true;
            if (cmd[0] == 'c' && count == 1 && len >= 6) pass = true;

            if (pass) {
                cmd[1] = ' ';
                cmd[strlen(cmd) - 1] = ',';
            }
            else {
                throw std::exception("! 입력 포멧이 잘못되었습니다(ex : i(1,2,apple) )");
            }
        }
        else {
            throw std::exception("! 입력 포멧이 잘못되었습니다(ex : i(1,2,apple) )");
        }
    }
    else {
        throw std::exception("Can't find the command");
    }
    return true;
}

