package lotto.domain.winning;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import static lotto.domain.lotto.LottoConst.MIN_MATCH_COUNT;

public class WinningResult {
    private Map<WinningPrize, Integer> winnersCount;

    public WinningResult() {
        winnersCount = new HashMap<>();
        initializeWinnersCount();
    }

    private void initializeWinnersCount() {
        for (WinningPrize prize : WinningPrize.values()) {
            winnersCount.put(prize, 0);
        }
    }

    public Map<WinningPrize, Integer> getWinnersCount() {
        return winnersCount;
    }

    public void calculateWinnersCount(Lottos lottos, WinningTicket winningTicket) {
        for (Lotto lotto : lottos.getLottos()) {
            calculateSingleWinner(lotto, winningTicket);
        }
    }

    private void calculateSingleWinner(Lotto lotto, WinningTicket winningTicket) {
        int matchCount = winningTicket.matchWinningLotto(lotto);
        boolean bonus = winningTicket.matchBonusNumber(lotto);

        updateWinnersCount(matchCount, bonus);
    }

    private void updateWinnersCount(int matchCount, boolean bonus) {
        if (MIN_MATCH_COUNT < matchCount) {
            WinningPrize prize = WinningPrize.getPrize(matchCount, bonus);
            if (prize != null) {
                winnersCount.put(prize, winnersCount.get(prize) + 1);
            }
        }
    }

}