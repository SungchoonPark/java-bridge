package bridge.dto;

import java.util.List;

public class FinalResultDto {
    private final List<MovingDto> movingResult;
    private final int totalTryCount;
    private final boolean gameSuccess;

    public FinalResultDto(List<MovingDto> movingResult, int totalTryCount, boolean gameSuccess) {
        this.movingResult = movingResult;
        this.totalTryCount = totalTryCount;
        this.gameSuccess = gameSuccess;
    }

    public List<MovingDto> getMovingResult() {
        return movingResult;
    }

    public int getTotalTryCount() {
        return totalTryCount;
    }

    public boolean isGameSuccess() {
        return gameSuccess;
    }
}
