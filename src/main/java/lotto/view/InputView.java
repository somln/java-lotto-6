package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputPurchaseAmount(){
        OutputView.printPurchaseAmountInputPrompt();
        String purchaseAmount =  Console.readLine();
        return purchaseAmount;
    }

}
