package lotto.domain;

import lotto.utill.InputValidator;

public class Purchase {

    private final int purchaseAmount;
    private final int ticketCount;

    public Purchase(String input) {
        this.purchaseAmount = InputValidator.validatePurchaseAmount(input);
        this.ticketCount = calculateTicketCount(purchaseAmount);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LottoConst.LOTTO_PRICE;
    }
}
