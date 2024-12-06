package bridge.exception;

public enum ExceptionMessage {
    COMMON_ERROR("[ERROR] "),

    EMPTY_INPUT("제대로된 입력값을 입력해주세요."),
    STR_BRIDGE_SIZE("다리 길이를 숫자로 입력해주세요"),
    INVALID_BRIDGE_SIZE("다리 길이는 3이상 20이하이어야 합니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return COMMON_ERROR.message + message;
    }
}
