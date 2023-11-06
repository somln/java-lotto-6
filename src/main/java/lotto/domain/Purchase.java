package lotto.domain;

import lotto.utill.InputValidator;

public class Purchase {

    private final int purchaseAmount;
    private final int ticketCount;

    private Purchase(int purchaseAmount, int ticketCount) {
        this.purchaseAmount = purchaseAmount;
        this.ticketCount = ticketCount;
    }

    public static Purchase create(final String input) {
        int purchaseAmount = InputValidator.validatePurchaseAmount(input);
        int ticketCount = calculateTicketCount(purchaseAmount);
        return new Purchase(purchaseAmount, ticketCount);
    }

    private static int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LottoConst.LOTTO_PRICE;
    }
}
