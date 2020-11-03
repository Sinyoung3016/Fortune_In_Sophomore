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

    public static int inputCost(){
        int cost;
        String scannedToken;
        while(true){
            AppView.output("? cost 를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                cost = Integer.parseInt(scannedToken);
                return cost;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) cost 수 입력에 오류가 있습니다: "+scannedToken);
            }
        }
    }
    public static int inputSourceVertex(){
        int sourceVertex;
        String scannedToken;
        while(true){
            AppView.output("? 출발 vertex를 입력하시오: ");
            scannedToken = AppView.scanner.next();
            try {
                sourceVertex = Integer.parseInt(scannedToken);
                return sourceVertex;
            }
            catch (NumberFormatException e){
                AppView.outputLine("[오류] 출발 vertex 입력에 오류가 있습니다: "+scannedToken);
            }
        }
    }
    public static int inputNumberOfVertices(){
        int numberOfVertices;
        String scannedToken;
        while(true){
            AppView.output("? vertex 수를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                numberOfVertices = Integer.parseInt(scannedToken);
                return numberOfVertices;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) Vertex 수 입력에 오류가 있습니다: ");
            }
        }
    }
    public static int inputNumberOfEdges(){
        int numberOfEdges;
        String scannedToken;
        while(true){
            AppView.output("? edge 수를 입력하시오 : ");
            scannedToken = AppView.scanner.next();
            try{
                numberOfEdges = Integer.parseInt(scannedToken);
                return numberOfEdges;
            }
            catch (NumberFormatException e){
                AppView.outputLine("(오류) edge 수 입력에 오류가 있습니다 : ");
            }
        }
    }
    public  static  int inputTailVertex(){
        int tailVertex;
        String scannerToken;
        while(true){
            AppView.output("? tail vertex 를 입력하시오 : ");
            scannerToken = AppView.scanner.next();
            try{
                tailVertex = Integer.parseInt(scannerToken);
                return tailVertex;
            }
            catch(NumberFormatException e){
                AppView.outputLine("(오류) tail vertex 입력에 오류가 있습니다 : ");
            }
        }
    }
    public  static  int inputHeadVertex(){
        int headVertex;
        String scannerToken;
        while(true){
            AppView.output("? head vertex 를 입력하시오 : ");
            scannerToken = AppView.scanner.next();
            try{
                headVertex = Integer.parseInt(scannerToken);
                return headVertex;
            }
            catch(NumberFormatException e){
                AppView.outputLine("(오류) head vertex 입력에 오류가 있습니다 : ");
            }
        }
    }
}
