package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int ticketCount) {
        this.lottos = createLottos(ticketCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> createLottos(int ticketCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.generateLotto());
            lottos.add(lotto);
        }
        return lottos;
    }




}
