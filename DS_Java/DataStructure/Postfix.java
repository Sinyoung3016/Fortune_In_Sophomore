package DataStructure;

/*
infix   : 2 + 5 (괄호필요)
prefix  : + 2 5
postfix : 2 5 + (컴파일러가 사용)
 */
public class Postfix {
    /*
    스택을 사용
    [push] 연산자가 나타날 때까지, 스택에 연산값을 삽입
    연산자가 나타나면, [pop] 스택에서 연산자에 필요한 수만큼 연산값을 삭제
                    삭제한 값으로 연산 실행
                    [push] 연산결과를 스택에 삽입

    << 알고리즘 >>
    Stack <Number> stack = new Stack();
    Token token;
    Number operand1, operand2, result;
    token = postfix.nextToken();
    while(token.type() != TOKEN.EndOfExpression){
        if(token.type() == TOKEN.Operand)
            stack.push(token.value());
        else{
        operand1 = stack.pop();
        operand2 = stack.pop();
        result = evalOpertor(token.operator(), operand1, operand2);
        stack.nextToken();
        }
        token = postfix.nextToken();
    }
    Number finalResult = stack.pop();


    << From infix, To postfix >>
    1. 괄호가 있을 때
        스택 들어갈 때,
        '('를 만나면, 무조건 스택에 삽입 = 가장 높은 우선순위
        스택 안에서, 괄호 사이의 연산자들을 만나면
        '(' 위에 쌓임 = 가장 낮은 우선순위
        ')' 를 만나면, 이보다 작은 우선순위를 모두 삭제

    2. 연산자의 결함법칙
        왼쪽 우선 결합법칙에서
            두 우선순위 값이 같아야함.
        오른쪽 우선 결합법칙에서
            입력 토큰 우선순위는 스택 안 우선순위보다 높아야함.
            '^' 17            '^' 16
            ex) 2 3 2 ^ ^
            먼저 삽입된 ^과 동일한 연산자이지만, ^는 스택에 삽입되어야 하기때문에
            입력토큰으로 연산자 ^ 의 우선순위는 스택안에 있는 연산자 ^순위보다 높아야함
     */
}
