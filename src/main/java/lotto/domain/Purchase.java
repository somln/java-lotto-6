package lotto.domain;

import lotto.exception.PurchaseAmountException;

import static lotto.domain.LottoConst.LOTTO_PRICE;
import static lotto.utill.ErrorMessage.PURCHASE_AMOUNT;

public class Purchase {

    private final int purchaseAmount;
    private final int ticketCount;

    public Purchase(int purchaseAmount) {
        validateDivisibility(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        this.ticketCount = calculateTicketCount(purchaseAmount);
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LottoConst.LOTTO_PRICE;
    }

    private static void validateDivisibility(int number) {
        if (!isDivisibleBy(number, LOTTO_PRICE)) {
            throw new PurchaseAmountException(PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }
}
