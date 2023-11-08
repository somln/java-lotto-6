package lotto.controller;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.Purchase;
import lotto.domain.winning.WinningResult;
import lotto.domain.winning.WinningTicket;
import lotto.utill.TypeConverter;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    public void playGame() {
        String inputPurchaseAmount = InputView.inputPurchaseAmount();
        int purchaseAmount =  TypeConverter.stringToInt(inputPurchaseAmount);
        Purchase purchase = new Purchase(purchaseAmount);
        int ticketCount = purchase.getTicketCount();

        Lottos lottos = new Lottos(ticketCount);
        OutputView.printLottos(lottos);

        String inputWinningNumbers = InputView.inputWinningNumbers();
        List<Integer> winningNumbers = TypeConverter.StringToIntegerList(inputWinningNumbers);
        Lotto winningLotto = new Lotto(winningNumbers);

        String inputBonusNumber = InputView.inputBonusNumber();
        int bonusNumber = TypeConverter.stringToInt(inputBonusNumber);
        WinningTicket winningTicket = new WinningTicket(winningLotto, bonusNumber);

        WinningResult winningResult = new WinningResult();
        winningResult.calculateWinnersCount(lottos, winningTicket);

        OutputView.printWinningResult(winningResult);

    }
}
