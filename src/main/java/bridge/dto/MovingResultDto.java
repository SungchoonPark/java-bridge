package bridge.dto;

import java.util.List;
import java.util.Queue;

public class MovingResultDto {
    private List<MovingDto> movingResult;
    private boolean isSuccess;

    public MovingResultDto(List<MovingDto> movingResult, boolean isSuccess) {
        this.movingResult = movingResult;
        this.isSuccess = isSuccess;
    }

    public List<MovingDto> getMovingResult() {
        return movingResult;
    }

    public boolean getIsSuccess() {
        return isSuccess;
    }
}
