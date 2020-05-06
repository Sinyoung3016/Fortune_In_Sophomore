package DS_07;
import java.util.Scanner;
public class AppView {
    static  Scanner input = new Scanner(System.in);

    public AppView(){}

    //<INPUT 함수 START>
    public static int inputInt() throws NumberFormatException{
        return Integer.parseInt(AppView.input.nextLine());
    }
    public static int inputScore(){
        while(true){
            try{
               AppView.output("- 점수를 입력하시오 (0~100) : ");
               int score = AppView.inputInt();
               return score;
            }catch(NumberFormatException e){
                AppView.outputLine("[오류] 정수가 입력되지 않았습니다.");
            }
        }
    }
    public static boolean doesContinueToInputStudent(){
        AppView.output("성적을 입력하려면 'Y' 또는 'y'를, 종료하려면 다른 아무 키나 누르시오. : ");
        String line = null;
        do{
            line = AppView.input.nextLine();
            //빈 줄이 아닐 때까지 입력 받음
        }while(line.equals(""));
        char answer = line.charAt(0);
        return ((answer == 'Y')||(answer == 'y'));
    }
    //<INPUT 함수 END>


    //<OUTPUT 함수 START>
    public static void outputLine(String message){
        System.out.println(message);
    }
    public static void output(String message){
        System.out.print(message);
    }
    public static void outputNumberOfStudents(int aNumberOfStudent){
        AppView.outputLine("학급 학생 수: " + aNumberOfStudent);
    }
    public static void outputHighestScore(int aScore){
        AppView.outputLine("학급 최고 점수: " + aScore);
    }
    public static void outputLowestScore(int aScore){
        AppView.outputLine("학급 최저 점수: " + aScore);
    }
    public static void outputAverageScore(double anAverageScore){
        System.out.format("학급 평균: %.1f\n",anAverageScore);
    }
    public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudent){
        AppView.outputLine("평균 이상인 학생 수: " + aNumberOfStudent);
    }
    public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudent){
        AppView.outputLine(aGrade + "학점의 학생 수는 " + aNumberOfStudent + "입니다.");
    }
    public static void outputScore(int aScore){
        AppView.outputLine("점수 : "+ aScore);
    }
    //<OUTPUT 함수 END>


}
