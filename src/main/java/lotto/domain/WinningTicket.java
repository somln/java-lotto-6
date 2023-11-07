package lotto.domain;

import lotto.exception.BonusNumberException;

import java.util.List;

import static lotto.domain.LottoConst.MAX_NUMBER;
import static lotto.domain.LottoConst.MIN_NUMBER;
import static lotto.utill.ErrorMessage.BONUS_NUMBER_OVERLAP;
import static lotto.utill.ErrorMessage.NUMBER_RANGE;

public class WinningTicket {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningTicket(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validateBonusNumber(Lotto lotto, int bonusNumber){
        validateNumberRange(bonusNumber);
        validateBonusOverlap(lotto, bonusNumber);
    }

    private static void validateNumberRange(int bonusNumber) {
        if(!isNumberInRange(bonusNumber)) {
            throw new BonusNumberException(String.format(NUMBER_RANGE.getMessage(), MIN_NUMBER, MAX_NUMBER));
        }
    }

    private static boolean isNumberInRange(int bonusNumber) {
        return (bonusNumber >= MIN_NUMBER && bonusNumber <= MAX_NUMBER);
    }

    private static void validateBonusOverlap(Lotto lotto, int bonusNumber) {
        if(isAlreadyInWinningNumbers(lotto, bonusNumber)){
            throw new BonusNumberException(BONUS_NUMBER_OVERLAP.getMessage());
        }
    }

    private static boolean isAlreadyInWinningNumbers(Lotto lotto, int bonusNumber){
        List<Integer> winningNumbers = lotto.getNumbers();
        return winningNumbers.contains(bonusNumber);
    }
}
