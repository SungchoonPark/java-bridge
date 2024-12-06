package bridge.domain;

import bridge.dto.MovingResultDto;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final BridgeMaker bridgeMaker;
    private Bridge bridge;
    private int totalTryCount;
    private List<String> clientCommands;

    public BridgeGame() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        clientCommands = new ArrayList<>();
        this.totalTryCount = 0;
    }

    public void generateBridge(int size) {
        bridge = new Bridge(bridgeMaker.makeBridge(size));
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MovingResultDto move(String movingCommand) {
        clientCommands.add(movingCommand);
        return bridge.move(clientCommands);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
