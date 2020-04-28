package DS_05;

import java.util.Scanner;

public class AppView {
    private static Scanner input = new Scanner(System.in);

    private AppView(){}

    public static void outputDebugMessage(String message){
        System.out.println(message);
    }

    public static void outputLine(String message){
        System.out.println(message);
    }

    public static void output(String message){ System.out.print(message); }

    public static int inputInteger()throws NumberFormatException { return Integer.parseInt(AppView.input.next()); }

}
