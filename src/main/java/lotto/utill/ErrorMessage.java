package lotto.utill;

public enum ErrorMessage {

    PURCHASE_AMOUNT("[ERROR] 로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
