package bridge.view;

import bridge.exception.ExceptionMessage;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printStartMessage();
        String bridgeSize = Console.readLine();
        checkInputIsEmpty(bridgeSize);
        checkBridgeSizeIsNum(bridgeSize);
        checkValidBridgeSize(Integer.parseInt(bridgeSize));

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    private void checkInputIsEmpty(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void checkBridgeSizeIsNum(String bridgeSize) {
        try {
            Integer.parseInt(bridgeSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.STR_BRIDGE_SIZE.getMessage());
        }
    }

    private void checkValidBridgeSize(int bridgeSize) {
        if(bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BRIDGE_SIZE.getMessage());

        }
    }
}
