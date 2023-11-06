package lotto.utill;

public enum ErrorMessage {

    PURCHASE_AMOUNT("[ERROR] 로또 구입 금액은 1,000원 단위로 나누어 떨어져야 합니다."),
    LOTTO_NUMBER_NO_DUPLICATE ("[ERROR] 로또 당첨 번호는 될 수 없습니다."),
    NUMBER_COUNT_INVALID("[ERROR] %d개의 숫자를 입력해야 합니다"),
    NUMBER_RANGE("[ERROR] 숫자의 범위는 %d에서 %d까지여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
