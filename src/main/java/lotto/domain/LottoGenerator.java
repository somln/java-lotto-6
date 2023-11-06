package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.domain.LottoConst.*;

public class LottoGenerator {

    public static List<Integer> generateLotto() {
        Set<Integer> numbers = generateUniqueNumbers(NUMBER_COUNT, MIN_NUMBER, MAX_NUMBER);
        return new ArrayList<>(numbers);
    }

    private static Set<Integer> generateUniqueNumbers(int count, int minNumber, int maxNumber) {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < count) {
            int number = generateRandomNumber(minNumber, maxNumber);
            numbers.add(number);
        }
        return numbers;
    }

    private static int generateRandomNumber(int minNumber, int maxNumber) {
        return Randoms.pickNumberInRange(minNumber, maxNumber);
    }

}
