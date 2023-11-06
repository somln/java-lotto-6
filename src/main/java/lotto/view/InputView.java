package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPurchaseAmount(){
        OutputView.printPurchaseAmountInputPrompt();
        String purchaseAmount =  Console.readLine();
        return purchaseAmount;
    }

    public static String inputWinnerNumbers(){
        OutputView.printWinnerNumberInputPrompt();
        String winnerNumbers = Console.readLine();
        return winnerNumbers;
    }

}
