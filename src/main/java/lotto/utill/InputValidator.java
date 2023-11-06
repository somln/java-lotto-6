package lotto.utill;

import lotto.domain.LottoConst;
import lotto.exception.PurchaseAmountException;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = TypeConverter.stringToInt(input);
        validateDivisibility(purchaseAmount);
        return purchaseAmount;
    }

    private static void validateDivisibility(int number) {
        if (!isDivisibleBy(number, LottoConst.LOTTO_PRICE)) {
            throw new PurchaseAmountException(ErrorMessage.PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

}
