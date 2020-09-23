import java.util.Scanner;

public class AppView {
    private static Scanner scanner = new Scanner(System.in);

    public static void outputLine(String aMessage) {
        System.out.println(aMessage);
    }

    public static void output(String aMessage) {
        System.out.print(aMessage);
    }

    public static int inputInt() throws NumberFormatException {
        return Integer.parseInt(AppView.scanner.next());
    }

    public static int inputTailVertex() {
        int tailVertex;
        String scannedToken;
        while (true) {
            AppView.output(">> tail vertex를 입력하세요. : ");
            scannedToken = AppView.scanner.next();
            try {
                tailVertex = Integer.parseInt(scannedToken);
                return tailVertex;
            } catch (NumberFormatException e) {
                AppView.outputLine("(오류) tail vertex 입력에 오류가 있습니다. : " + scannedToken);
            }
        }
    }

    public static int inputHeadVertex() {
        int headVertex;
        String scannedToken;
        while (true) {
            AppView.output(">> head vertex를 입력하세요. : ");
            scannedToken = AppView.scanner.next();
            try {
                headVertex = Integer.parseInt(scannedToken);
                return headVertex;
            } catch (NumberFormatException e) {
                AppView.outputLine("(오류) head vertex 입력에 오류가 있습니다. : " + scannedToken);
            }
        }
    }
}
