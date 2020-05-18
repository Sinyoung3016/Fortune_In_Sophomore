package DS_10_01;

import java.util.Scanner;
public class AppView {
    static Scanner scanner = new Scanner(System.in);

    public static void output(String message){ System.out.print(message); }
    public static void outputLine(String message){ System.out.println(message); }
    public static char inputChar(){
        //문자 한개를 입력받음
        String line = AppView.scanner.nextLine().trim();
        while(line.equals("")){
            line = AppView.scanner.nextLine().trim();
        }
        return line.charAt(0);
    }
}
