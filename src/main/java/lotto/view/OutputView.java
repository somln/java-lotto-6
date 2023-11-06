package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Purchase;

public class OutputView {
    private static final String PROMPT_ENTER_PURCHASE_AMOUNT="구입금액을 입력해 주세요.";
    private static final String PROMPT_LOTTO_TICKET_COUNT= "%d개를 구매했습니다.";
    private static final String PROMPT_ENTER_WINNING_NUMBER= "당첨 번호를 입력해 주세요.";
    private static final String PROMPT_ENTER_BONUS_NUMBER= "보너스 번호를 입력해 주세요";


    public static void printPurchaseAmountInputPrompt(){
        System.out.println(PROMPT_ENTER_PURCHASE_AMOUNT);
    }

    public static void printTicketCount(Purchase purchase){
        System.out.printf(PROMPT_LOTTO_TICKET_COUNT+ "%n", purchase.getTicketCount());
    }

    public static void printWinningNumberInputPrompt(){
        System.out.println(PROMPT_ENTER_WINNING_NUMBER);
    }

    public static void printBonusNumberInputPrompt(){
        System.out.println(PROMPT_ENTER_BONUS_NUMBER);
    }

    public static void printLottos(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
        System.out.println();
    }

}
