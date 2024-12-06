package bridge.service;

import bridge.domain.BridgeGame;
import bridge.dto.FinalResultDto;
import bridge.dto.MovingResultDto;

public class BridgeService {
    private final BridgeGame bridgeGame;

    public BridgeService() {
        this.bridgeGame = new BridgeGame();
    }

    public void generateBridge(int bridgeSize) {
        bridgeGame.generateBridge(bridgeSize);
    }

    public MovingResultDto moving(String movingCommand) {
        return bridgeGame.move(movingCommand);
    }

    public FinalResultDto getGameResult() {
        return bridgeGame.makeGameResult();
    }

    public void retry() {
        bridgeGame.retry();
    }
}
