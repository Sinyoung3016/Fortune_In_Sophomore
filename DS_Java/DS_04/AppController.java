package DS_04;

public class AppController {
    private static final int MENU_ADD = 1;
    private static final int MENU_REMOVE = 2;
    private static final int MENU_SEARCH = 3;
    private static final int MENU_FREQUENCY = 4;
    private static final int MENU_END_OF_RUN = 9;
    private LinkedBag<Coin> _coinBag;

    //<getter setter start>
    private LinkedBag<Coin> coinBag (){
        return this._coinBag;
    }
    private void setCoinBag(LinkedBag<Coin> newCoinBag){
        this._coinBag = newCoinBag;
    }
    //<getter setter end>

    public AppController() {}

    public void run() {
        AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다 >>>");
        AppView.outputLine("");

        //ArrayList와 달리, LinkedList는 초기화시 사이즈_size를 필요로 하지 않기 때문에 필요없음
        this.setCoinBag (new LinkedBag<Coin>());

        int menuNumber = AppView.inputMenuNumber();
        while (menuNumber != MENU_END_OF_RUN) {
            switch (menuNumber) {
                case MENU_ADD:
                    this.addCoin();
                    break;
                case MENU_REMOVE:
                    this.removeCoin();
                    break;
                case MENU_SEARCH:
                    this.searchForCoin();
                    break;
                case MENU_FREQUENCY:
                    this.frequencyOfCoin();
                    break;
                default:
                    this.undefinedMenuNumber(menuNumber);
            }
            menuNumber = AppView.inputMenuNumber();
        }
        this.showStatistics();
        AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다 >>>");
    }

    //MENU_ADD
    private void addCoin(){
            int coinValue = AppView.inputCoinValue();
            if(this.coinBag().add( new Coin(coinValue)))
                AppView.outputLine("_주어진 값을 갖는 동전을 가방에 넣는데 성공했습니다.");
            else
                AppView.outputLine("_주어진 값을 갖는 동전을 가방에 넣는데 실패했습니다.");
        }

    //MENU_REMOVE
    private void removeCoin(){
            int coinValue = AppView.inputCoinValue();
            if(this.coinBag().remove( new Coin(coinValue)) != null)
                AppView.outputLine("_주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.");
            else
                AppView.outputLine("_주어진 값을 갖는 동전은 가방에 존재하지 않습니다.");
    }
    //MENU_SEARCH
    private void searchForCoin(){
        int coinValue = AppView.inputCoinValue();
        if(this.coinBag().doesContain( new Coin(coinValue)))
            AppView.outputLine("_주어진 값을 갖는 동전은 가방에 존재합니다.");
        else
            AppView.outputLine("_주어진 값을 갖는 동전은 가방에 존재하지 않습니다.");
    }
    //MENU_FREQUENCY
    private void frequencyOfCoin(){
        int coinValue = AppView.inputCoinValue();
        int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
        AppView.outputLine("_주어진 값을 갖는 동전의 개수는 " + frequency + "개 입니다.");
    }
    //DEFAULT
    private void undefinedMenuNumber( int menuNumber ){
        AppView.outputLine("_선택된 매뉴 번호 " + menuNumber + "는 잘못된 번호입니다.");
    }

    //MENU_END_OF_RUN <start>
    private void showStatistics(){
        AppView.outputLine("가방에 들어 있는 동전의 개수 : " + this.coinBag().size());
        AppView.outputLine("동전 중 가장 큰 값 : " + this.maxCoinValue());
        AppView.outputLine("모든 동전 값의 합 : " + this.sumOfCoinValues());
    }
    private int sumOfCoinValues(){
        int sum = 0;
        for(int i =0; i < this.coinBag().size(); i++) {
            sum += this.coinBag().elementAt(i).value();
        }
        return sum;
    }
    private int maxCoinValue(){
        int maxValue = 0;
        for(int i =0; i < this.coinBag().size(); i++) {
            if (this.coinBag().elementAt(i).value() > maxValue)
                maxValue = this.coinBag().elementAt(i).value();
        }
        return maxValue;
    }
    //MENU_END_OF_RUN <end>
}
