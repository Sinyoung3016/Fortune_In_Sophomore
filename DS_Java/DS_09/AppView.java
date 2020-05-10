package DS_09;

import java.util.Scanner;

public class AppView {

    private static boolean debugMode = false;
    private static Scanner scanner = new Scanner(System.in);

    public AppView(){}

    //<GETTER SETTER START>
    public static boolean debugMode(){ return debugMode; }
    public static void setDebugMode(boolean newDebugMode){ debugMode = newDebugMode; }
    //<GETTER SETTER END>

    //<출력 함수 START>
    public static  void outputDebugMessage(String message){
        if(AppView.debugMode())
            System.out.print(message);
    }
    public static  void outputLineDebugMessage(String message){
        if(AppView.debugMode())
            System.out.println(message);
    }
    public static void output(String message){ System.out.print(message); }
    public static void outputLine(String message){ System.out.println(message); }
    //<출력 함수 END>

    //<입력 함수 START>
    public static String inputLine(){
        String line = AppView.scanner.nextLine().trim();
        while(line.equals(""))
            line = AppView.scanner.nextLine().trim();
        return  line;
    }
    //<입력 함수 END>

}
