package DS_01;
import java.util.*;
public class AppView {

    private static Scanner scanner = new Scanner(System.in);

    public AppView() {
    }

        //입력관련 함수들
    public static int inputOrder() {//과제
        System.out.print("마방진 차수를 입력하세요. (음수를 입력하면 종료합니다) : ");
        int inputOrder = scanner.nextInt();
        return inputOrder;
    }

        //출력관련 함수들
    public static void output(String message) {
        System.out.print(message);
    }

    public static void outputLine(String message) {
        System.out.println(message);
    }

    public static void outputTitleWithOrder(int order){ //과제
        System.out.println("Magic Square Board : Order " + order);
    }

    public static void outputRowNumber(int number) {
        System.out.printf("[%3d]", number);
    }

    public static void outputCellValue(int value) {
        System.out.printf("[%3d]", value);
    }

}
