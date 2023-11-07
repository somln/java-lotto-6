package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import javax.swing.*;

public class InputView {

    public static String inputPurchaseAmount(){
        OutputView.printPurchaseAmountInputPrompt();
        String purchaseAmount =  Console.readLine();
        return purchaseAmount;
    }

    public static String inputWinningNumbers(){
        OutputView.printWinningNumberInputPrompt();
        String winnerNumbers = Console.readLine();
        return winnerNumbers;
    }

    public static String inputBonusNumber(){
        OutputView.printBonusNumberInputPrompt();;
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

}