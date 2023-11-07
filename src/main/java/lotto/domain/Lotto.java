package lotto.domain;

import lotto.exception.WinnerNumbersException;

import java.util.List;

import static lotto.domain.LottoConst.*;
import static lotto.utill.ErrorMessage.*;
import static lotto.utill.ErrorMessage.NUMBER_RANGE;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        validateNumbersCount(numbers);
        validateDuplicate(numbers);
        validateNumbersRange(numbers);
    }

    private void validateNumbersCount(List<Integer> numbers) {
        if (!isCorrectNumberCount()) {
            throw new WinnerNumbersException(String.format(NUMBER_COUNT_INVALID.getMessage(),NUMBER_COUNT));
        }
    }

    private boolean isCorrectNumberCount(){
        return numbers.size()==NUMBER_COUNT;
    }

    private void validateDuplicate(List<Integer> numbers){
        if(!hasNoduplicate(numbers)){
            throw new WinnerNumbersException(LOTTO_NUMBER_NO_DUPLICATE.getMessage());
        }
    }

    private boolean hasNoduplicate(List<Integer> numbers){
        return numbers.stream().distinct().count() == numbers.size();
    }

    private void validateNumbersRange(List<Integer> numbers){
        if(!isNumbersInRange(numbers)){
            throw new WinnerNumbersException(String.format(NUMBER_RANGE.getMessage(),MIN_NUMBER, MAX_NUMBER));
        }
    }

    private boolean isNumbersInRange(List<Integer> numbers){
        return numbers.stream().allMatch(number -> number >= MIN_NUMBER && number <= MAX_NUMBER);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}