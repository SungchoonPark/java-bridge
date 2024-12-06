package bridge.dto;

import java.util.List;
import java.util.Queue;

public class MovingResultDto {
    private List<MovingDto> movingResult;

    public MovingResultDto(List<MovingDto> movingResult) {
        this.movingResult = movingResult;
    }

    public void print() {
        for (MovingDto movingDto : movingResult) {
            System.out.println(movingDto);
        }
    }
}
