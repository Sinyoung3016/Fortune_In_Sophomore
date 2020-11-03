package app;
import java.util.Scanner;

public final class AppView {
private static Scanner scanner = new Scanner(System.in);
    private static final boolean DEBUG_MODE = true;
    public static void outputDebugMessage(String aString){
        if(DEBUG_MODE){
            System.out.print(aString);
        }
    }
    private AppView () {
    }

    public static void outputLine (String aString) {
        System.out.println (aString) ;
    }
    public static void output (String aString) {
        System.out.print (aString) ;
    }

    public static int inputNumberOfVertices(){
        int numberOfVertices;
        String scannedToken;
        while(true){
            AppView.output("? 원소의 개수를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                numberOfVertices = Integer.parseInt(scannedToken);
                return numberOfVertices;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) 원소의 개수 입력에 오류가 있습니다: ");
            }
        }
    }
    public static int inputNumberOfEdges(){
        int numberOfEdges;
        String scannedToken;
        while(true){
            AppView.output("? 관계 쌍의 수를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                numberOfEdges = Integer.parseInt(scannedToken);
                return numberOfEdges;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) 관계 쌍의 수 입력에 오류가 있습니다 : ");
            }
        }
    }
    public  static  int inputTailVertex(){
        int tailVertex;
        String scannerToken;
        while(true){
            AppView.output("? 관계 쌍의 첫 번째 원소를 입력하시오 : ");
            scannerToken = AppView.scanner.next();
            try{
                tailVertex = Integer.parseInt(scannerToken);
                return tailVertex;
            }
            catch(NumberFormatException e){
                AppView.outputLine("(오류) 관계 쌍의 첫 번째 원소 입력에 오류가 있습니다 : ");
            }
        }
    }
    public  static  int inputHeadVertex(){
        int headVertex;
        String scannerToken;
        while(true){
            AppView.output("? 관계 쌍의 두 번째 원소를 입력하시오 : ");
            scannerToken = AppView.scanner.next();
            try{
                headVertex = Integer.parseInt(scannerToken);
                return headVertex;
            }
            catch(NumberFormatException e){
                AppView.outputLine("(오류) 관계 쌍의 두 번째 원소 입력에 오류가 있습니다 : ");
            }
        }
    }
}
