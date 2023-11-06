package lotto.domain;

import lotto.utill.InputValidator;

public class Purchase {

    private final int purchaseAmount;
    private final int ticketCount;

    private Purchase(String input) {
        int purchaseAmount = InputValidator.validatePurchaseAmount(input);
        this.purchaseAmount = purchaseAmount;
        this.ticketCount = calculateTicketCount(purchaseAmount);
    }

    public static Purchase create(final String input) {
        return new Purchase(input);
    }

    public int calculateTicketCount(int purchaseAmount){
        return purchaseAmount / LottoConst.LOTTO_PRICE;
    }
}
