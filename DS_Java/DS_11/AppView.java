package DS_11;

import java.util.Scanner;

public class AppView {

    static Scanner scanner = new Scanner(System.in);

    //<출력 메소드 START>
    public static void output(String message){ System.out.print(message); }
    public static void outputLine(String message){ System.out.println(message); }
    //<출력 메소드 END>

    //<입력 메소드 START>
    public static char inputChar(){
        //문자 한개를 입력받음
        String line = scanner.nextLine().trim();
        while(line.equals("")){
            line = scanner.nextLine().trim();
        }
        return line.charAt(0);
    }
    //<입력 메소드 END>
}
