package DS_09;

public class PostfixCalculator {

    private static final int DEFAULT_MAX_EXPRESSION_LENGTH = 100;

    private int _maxExpressionLength;
    private Stack <Integer> _valueStack;

    //<GETTER SETTER START>
    public int maxExpressionLength() {return this._maxExpressionLength; }
    public void setMaxExpressionLength(int newMaxExpressionLength){ this._maxExpressionLength = newMaxExpressionLength; }
    private Stack<Integer> valueStack(){return this._valueStack; }
    private void setValueStack(Stack <Integer> newValueStack){ this._valueStack = newValueStack; }
    //<GETTER SETTER END>

    //<CONSTRUCTOR START>
    public PostfixCalculator(){
        this(PostfixCalculator.DEFAULT_MAX_EXPRESSION_LENGTH);
    }
    public PostfixCalculator(int givenMaxExpressionLength){
        this.setMaxExpressionLength(givenMaxExpressionLength);
        this.setValueStack(new ArrayList<Integer>(this.maxExpressionLength()));
    }
    //<CONSTRUCTOR END>

    public int evaluate(String aPostfixExpression) throws CalculatorException {
        //Stack을 이용하여 postfix 수식을 계산

        //[오류] postfix가 없어
        if ((aPostfixExpression == null) || (aPostfixExpression.length() == 0))
            throw new CalculatorException(CalculatorError.PostfixError_NoExpression);

        this.valueStack().clear();
        char token;
        for (int current = 0; current < aPostfixExpression.length(); current++) {
            token = aPostfixExpression.charAt(current);

            if (Character.isDigit(token)) {
                //token의 문자가 digit인지 확인
                int tokenValue = Character.getNumericValue(token);
                //token이 digit이면 int로 변환
                //[오류] 스택 크기보다 많은 값이 들어옴
                if (this.valueStack().isFull())
                    throw new CalculatorException(CalculatorError.PostfixError_TooLongExpression);
                else
                    this.valueStack().push(Integer.valueOf(tokenValue));
            } else {//token이 연산자
                CalculatorError error = this.executeBinaryOperator(token);
                //성공하면, 계산 후 result값을 배열의 인덱스 0번에 넣어 반환

                //[오류] 오류 반환
                if (error != CalculatorError.PostfixError_None)
                    throw new CalculatorException(error);
            }

            this.showTokenAndValueStack(token);
            //스택의 상태들 출력
        }//end of for

        if (this.valueStack().size() == 1)
            return this.valueStack().pop().intValue();//result값 반환
        else {
            //[오류] 값이 너무 많음
            throw new CalculatorException(CalculatorError.PostfixError_TooManyValues);
        }
    }
    private CalculatorError executeBinaryOperator(char anOperator){
        //Binary 연산자를 실행

        //[오류] 값이 없음 -> 계산 불가
        if(this.valueStack().size() < 2)
            return CalculatorError.PostfixError_TooFewValues;

        int operand1 = this.valueStack().pop().intValue();
        int operand2 = this.valueStack().pop().intValue();
        int calculated = 0;

        switch(anOperator) {
            case '^':
                calculated = (int) Math.pow((double) operand2, (double) operand1);
                break;
            case '*':
                calculated = operand1 * operand2;
                break;
            case '/':
                if (operand1 == 0) {
                    //[오류] 0으로 나누기
                    AppView.outputLineDebugMessage(
                            anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1
                    );
                    return CalculatorError.PostfixError_DivideByZero;
                }
                else calculated = operand2 / operand1;
                break;
            case '%':
                if (operand1 == 0) {
                    //[오류] 0으로 나누기
                    AppView.outputLineDebugMessage(
                            anOperator + " : (DivideByZero) " + operand2 + " " + anOperator + " " + operand1
                    );
                    return CalculatorError.PostfixError_DivideByZero;
                }
                else calculated = operand2 % operand1;
                break;
            case '+':
                calculated = operand2 + operand1;
                break;
            case '-':
                calculated = operand2 - operand1;
                break;
            //[오류] 지정된 연산자 아님
            default:
                return CalculatorError.PostfixError_UnknownOperator;
        } //end of swtich

        this.valueStack().push(Integer.valueOf(calculated));//계산된 값 다시 스택에 넣고 계산
        return CalculatorError.PostfixError_None;//성공
    }

    private void showTokenAndValueStack(char aToken){
        //주어진 토큰과 현재의 스택을 보여줌
        AppView.outputDebugMessage(aToken + " : ValueStack <Bottom> ");
        for(int i = 0; i < this.valueStack().size(); i++)
            AppView.outputDebugMessage(
                    ((ArrayList<Integer>) this.valueStack()).elementAt(i).intValue() + " "
            );
        AppView.outputLineDebugMessage("<Top>");
    }

}
