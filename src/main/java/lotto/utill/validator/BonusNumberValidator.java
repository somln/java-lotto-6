package lotto.utill.validator;

import lotto.exception.BonusNumberException;
import lotto.exception.PurchaseAmountException;
import lotto.exception.WinnerNumbersException;
import lotto.utill.TypeConverter;

import java.util.List;

import static lotto.domain.LottoConst.*;
import static lotto.domain.LottoConst.MAX_NUMBER;
import static lotto.utill.ErrorMessage.*;
import static lotto.utill.ErrorMessage.NUMBER_RANGE;

public class BonusNumberValidator {

    public static int validateBonusNumber(List<Integer> winningNumbers, String input) {
        int bonusNumber = TypeConverter.stringToInt(input);
        validateBonusOverlap(winningNumbers,bonusNumber);
        validateNumberRange(bonusNumber);
        return bonusNumber;
    }

    private static void validateNumberRange(int bonusNumber) {
        if(!isNumberInRange(bonusNumber)) {
            throw new BonusNumberException(String.format(NUMBER_RANGE.getMessage(), MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isNumberInRange(int bonusNumber) {
        return (bonusNumber >= MIN_NUMBER && bonusNumber <= MAX_NUMBER);
    }

    private static void validateBonusOverlap(List<Integer> winningNumbers, int bonusNumber) {
        if(isAlreadyInWinningNumbers(winningNumbers, bonusNumber)){
            throw new BonusNumberException(BONUS_NUMBER_OVERLAP.getMessage());
        }
    }

    private static boolean isAlreadyInWinningNumbers(List<Integer> winningNumbers, int bonusNumber){
        return winningNumbers.contains(bonusNumber);
    }
}
