package DS_08;

public class AppController {
    private static final int STACK_CAPACITY = 5;

    private ArrayList<Character> _stack;

    private int _inputChars;
    private int _pushedChars;
    private int _ignoredChars;

    //<GETTER SETTER START>
    private ArrayList<Character> stack(){ return this._stack;}
    private void setStack( ArrayList<Character> newStack) { this._stack = newStack; }
    private int inputChars(){ return this._inputChars; }
    private void setInputChars( int newInputChar) { this._inputChars = newInputChar; }
    private int pushedChars(){ return this._pushedChars; }
    private void setPushedChars( int newPushedChar) { this._pushedChars = newPushedChar; }
    private int ignoredChars(){ return this._ignoredChars; }
    private void setIgnoredChars( int newIngnoredChar) { this._ignoredChars = newIngnoredChar; }
    //<GETTER SETTER END>

    //<CONSTRUCTOR START>
    public AppController(){
        this.setStack(new ArrayList<Character>(AppController.STACK_CAPACITY));
        this.setInputChars(0);
        this.setPushedChars(0);
        this.setIgnoredChars(0);
    }
    //<CONSTRUCTOR END>

    public void run(){
        AppView.outputLine("<< 스택 기능 확인 프로그램을 시작합니다 >>");
        AppView.outputLine("");

        char input = this.inputChar();
        while(input != '!'){
            this.countInputChar();
            if(Character.isAlphabetic(input)){//알파벳 검사
                this.pushToStack(input);
                this.countPushedChar();
            }
            else if(Character.isDigit(input)){//숫자 문자 검사
                this.popN(Character.getNumericValue(input));
                //숫자 문자를 정수 값으로 변환
            }
            else if(input == '-')
                this.popOne();
            else if(input == '#')
                this.showStackSize();
            else if(input == '/')
                this.showAllFromBottom();
            else if(input == '\\')
                this.showAllFromTop();
            else if(input == '^')
                this.showTopElement();
            else{
                AppView.outputLine("[Ignore] 의미 없는 문자라 입력되었습니다.");
                this.countIgnoredChar();
            }
            input = this.inputChar();
        }
        this.quitStackProcessing();

        this.showStatistics();;
        AppView.outputLine("");
        AppView.outputLine("<< 스택 확인 프로그램을 종료합니다 >>");
    }


    //<횟수 계산 START>
    private void countInputChar(){
        this.setInputChars(this.inputChars() + 1);
    }
    private void countIgnoredChar(){
        this.setIgnoredChars(this.ignoredChars() + 1);
    }
    private void countPushedChar(){
        this.setPushedChars(this.pushedChars() + 1);
    }
    //<횟수 계산 END>

    //<스택 수행 관련 START>
    private void pushToStack(char aCharForPush){
        //스택에 추가
        if(this.stack().isFull())
            AppView.outputLine("(오류) 스택이 꽉 차서, 더 이상 넣을 수 없습니다.");
        else{
            Character charObjectForAdd = Character.valueOf(aCharForPush);
            //char형을 Character객체로 변환 WrapperClass
            if(this.stack().push(charObjectForAdd))
                AppView.outputLine("[Push] 삽입된 원소는 '" + aCharForPush + "' 입니다.");
            else
                AppView.outputLine("(오류) 스택에 넣는 동안에 오류가 발생하였습니다.");
        }
    }
    private void popOne(){
        //스택의 맨위에서 하나 삭제
        if(this.stack().isEmpty())
            AppView.outputLine("[Pop.Empty] 스택에 삭제할 원소가 없습니다.");
        else{
            Character poppedChar = this.stack().pop();
            if(poppedChar == null)
                AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생하였습니다.");
            else
                AppView.outputLine("[Pop] 삭제된 원소는 '" + poppedChar + "' 입니다.");
        }
    }
    private void popN(int numberOfCharsToBePopped){
        //스택에서 n개의 원소 삭제
        if(numberOfCharsToBePopped == 0)
            AppView.outputLine("[Pops] 삭제할 원소의 개수가 0개 입니다.");
        else{
            int count = 0;
            while( (count < numberOfCharsToBePopped) && (!this.stack().isEmpty())){
                // count가 n보다 작음 && 스택이 비어있지 않음
                Character poppedChar = this.stack().pop();
                if(poppedChar == null)
                    AppView.outputLine("(오류) 스택에서 삭제하는 동안에 오류가 발생했습니다.");
                else
                    AppView.outputLine("[Pops] 삭제된 원소는 '" + poppedChar + "' 입니다.");

                count++;
            }
            if(count < numberOfCharsToBePopped)
                AppView.outputLine("[Pops.Empty] 스택에 더이상 삭제할 원소가 없습니다.");
        }
    }
    private void quitStackProcessing(){
        //스택을 비우고 프로그램 종료시
        AppView.outputLine("");
        AppView.outputLine("<스택을 비우고 사용을 종료합니다>");
        this.showAllFromBottom();
        this.popN(this.stack().size());
    }
    //<스택 수행 관련 START>

    //<출력 관련 START>
    private void showAllFromBottom(){
        //스택의 모든 원소를 Bottom부터 Top까지 출력함.
        AppView.output("[Stack] <Bottom> ");
        for(int order = 0; order < this.stack().size(); order++){
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
        AppView.outputLine(" <Top> ");
    }
    private void showAllFromTop(){
        //스택의 모든 원소를 Bottom부터 Top까지 출력함.
        AppView.output("[Stack] <Top> ");
        for(int order = this.stack().size()-1; order >= 0; order--){
            AppView.output(this.stack().elementAt(order).toString() + " ");
        }
        AppView.outputLine(" <Bottom> ");
    }
    private void showTopElement(){
        //스택의 Top 원소를 출력
        if(this.stack().isEmpty())
            AppView.outputLine("[Top.Empty] 스택이 비어서 Top 원소가 존재하지 않습니다.");
        else
            AppView.outputLine("[Top] 스택의 Top 원소는 '" + this.stack().peek() + "' 입니다.");
    }
    private void showStackSize(){
        //스택의 원소 개수를 출력
        AppView.outputLine("스택에는 현재 " + this.stack().size() + " 개의 원소가 있습니다.");

    }
    private void showStatistics(){
        //스택의 통계를 출력
        AppView.outputLine("");
        AppView.outputLine("<스택 사용 통계>");
        AppView.outputLine("- 입력된 문자는 " + this.inputChars() +" 개 입니다.");
        AppView.outputLine(
                "- 정상 처리된 문자는 " +(this.inputChars() - this.ignoredChars()) + " 개 입니다."
        );
        AppView.outputLine("- 무시된 문자는 " + this.ignoredChars() + " 개 입니다.");
        AppView.outputLine("- 삽입된 문자는 " + this.pushedChars() + " 개 입니다.");
    }
    //<출력 관련 END>


    //<입력 관련 START>
    private char inputChar(){
        AppView.output("? 문자를 입력하시오 : ");
        return AppView.inputChar();
    }
    //<입력 관련 END>

}
