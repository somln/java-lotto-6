package lotto.utill;

import lotto.exception.BonusNumberException;
import lotto.exception.PurchaseAmountException;
import lotto.exception.WinnerNumbersException;

import java.util.List;

import static lotto.domain.LottoConst.*;
import static lotto.utill.ErrorMessage.*;

public class InputValidator {

    public static int validatePurchaseAmount(String input) {
        int purchaseAmount = TypeConverter.stringToInt(input);
        validateDivisibility(purchaseAmount);
        return purchaseAmount;
    }

    public static List<Integer> validateWinnerNumbers(String input){
        List<Integer> numbers = TypeConverter.StringToIntegerList(input);
        validateDuplicate(numbers);
        validateNumbersCount(numbers);
        validateNumbersRange(numbers);
        return numbers;
    }

    public static int validateBonusNumber(List<Integer> winningNumbers, String input) {
        int bonusNumber = TypeConverter.stringToInt(input);
        validateBonusOverlap(winningNumbers,bonusNumber);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateDivisibility(int number) {
        if (!isDivisibleBy(number, LOTTO_PRICE)) {
            throw new PurchaseAmountException(PURCHASE_AMOUNT.getMessage());
        }
    }

    private static boolean isDivisibleBy(int number, int divisor) {
        return number % divisor == 0;
    }

    private static void validateDuplicate(List<Integer> numbers){
        if(!hasNoduplicate(numbers)){
            throw new WinnerNumbersException(LOTTO_NUMBER_NO_DUPLICATE.getMessage());
        }
    }

    private static boolean hasNoduplicate(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }

    private static void validateNumbersCount(List<Integer> numbers){
        if(!isNumberCountRight(numbers)){
            throw new WinnerNumbersException(String.format(NUMBER_COUNT_INVALID.getMessage(),NUMBER_COUNT));
        }
    }

    private static boolean isNumberCountRight(List<Integer> numbers){
        return numbers.size()==NUMBER_COUNT;
    }

    private static void validateNumbersRange(List<Integer> numbers){
        if(!isNumbersInRange(numbers)){
            throw new WinnerNumbersException(String.format(NUMBER_RANGE.getMessage(),MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isNumbersInRange(List<Integer> numbers){
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    private static void validateBonusOverlap(List<Integer> winningNumbers, int bonusNumber) {
        if(isAlreadyInWinningNumbers(winningNumbers, bonusNumber)){
            throw new BonusNumberException(BONUS_NUMBER_OVERLAP.getMessage());
        }
    }

    private static boolean isAlreadyInWinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        return winningNumbers.contains(bonusNumber);
    }

    private static void validateNumberRange(int bonusNumber) {
        if(!isNumberInRange(bonusNumber)) {
            throw new BonusNumberException(String.format(NUMBER_RANGE.getMessage(), MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isNumberInRange(int bonusNumber) {
        return (bonusNumber >= MIN_NUMBER && bonusNumber <= MAX_NUMBER);
    }

}
