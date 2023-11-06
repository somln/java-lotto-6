package lotto.utill;

import lotto.domain.LottoConst;
import lotto.exception.PurchaseAmountException;
import lotto.exception.WinnerNumbersException;

import java.util.List;

import static lotto.domain.LottoConst.*;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = TypeConverter.stringToInt(input);
        validateDivisibility(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinnerNumbers(String input){
        List<Integer> numbers = TypeConverter.StringToIntegerList(input);
        validateDuplicate(numbers);
        validateNumberCount(numbers);
        validateNumberRange(numbers);
        return numbers;
    }

    private static void validateDivisibility(int number) {
        if (!isDivisibleBy(number, LOTTO_PRICE)) {
            throw new PurchaseAmountException(ErrorMessage.PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    private static void validateDuplicate(List<Integer> numbers){
        if(!hasNoduplicate(numbers)){
            throw new WinnerNumbersException(ErrorMessage.LOTTO_NUMBER_NO_DUPLICATE.getMessage());
        }
    }

    private static boolean hasNoduplicate(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }

    private static void validateNumberCount(List<Integer> numbers){
        if(!isNumberCountRight(numbers)){
            throw new WinnerNumbersException(String.format(ErrorMessage.NUMBER_COUNT_INVALID.getMessage(),NUMBER_COUNT));
        }
    }

    private static boolean isNumberCountRight(List<Integer> numbers){
        return numbers.size()==NUMBER_COUNT;
    }

    private static void validateNumberRange(List<Integer> numbers){
        if(!isNumberInRange(numbers)){
            throw new WinnerNumbersException(String.format(ErrorMessage.NUMBER_RANGE.getMessage(),MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isNumberInRange(List<Integer> numbers){
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }
}
