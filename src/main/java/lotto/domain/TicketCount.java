package lotto.domain;

public class TicketCount {

    private final int count;

    public TicketCount(int purchaseAmount){
        this.count = calculateLottoTicket(purchaseAmount);
    }

    private int calculateLottoTicket(int purchaseAmount){
        return purchaseAmount / LottoConst.LOTTO_PRICE;
    }

}
