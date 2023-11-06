package lotto.utill.validator;

import lotto.exception.PurchaseAmountException;
import lotto.utill.TypeConverter;

import static lotto.domain.LottoConst.LOTTO_PRICE;
import static lotto.utill.ErrorMessage.PURCHASE_AMOUNT;

public class PurchaseAmountValidator {

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = TypeConverter.stringToInt(input);
        validateDivisibility(purchaseAmount);
        return purchaseAmount;
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
