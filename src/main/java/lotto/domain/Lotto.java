package lotto.domain;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this.numbers = LottoGenerator.generateLotto();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
