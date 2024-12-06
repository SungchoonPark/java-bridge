package bridge.domain;

import bridge.dto.MovingDto;
import bridge.dto.MovingResultDto;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean canMoving(String movingCommand, int moveCount) {
        if (bridge.get(moveCount).equals(movingCommand)) return true;
        return false;
    }

    public MovingResultDto move(List<String> movings) {
        List<MovingDto> movingResult = new ArrayList<>();
        for (int i = 0; i < movings.size(); i++) {
            movingResult.add(new MovingDto(bridge.get(i), canMoving(movings.get(i), i)));
        }
        return new MovingResultDto(movingResult);
    }
}