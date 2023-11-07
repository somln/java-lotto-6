package lotto.domain.winning;

public enum WinningPrize {
    First(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    Second(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    Third(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    Fourth(4, 50_000, "4개 일치 (50,000원) - "),
    Fifth(3, 5_000, "3개 일치 (5,000원) - ");

    private int matchCount;
    private int reward;
    private String message;

    WinningPrize(int matchCount, int reward, String message) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public String getMessage() {
        return message;
    }

    public static WinningPrize getPrize(int matchCount, boolean bonus){
        if(matchCount==First.matchCount) return First;
        if(matchCount== Second.matchCount) return Second;
        for (WinningPrize winningPrize : values()) {
            if (matchCount == winningPrize.matchCount && winningPrize != Second) {
                return winningPrize;
            }
        }
        return null;
    }
}
