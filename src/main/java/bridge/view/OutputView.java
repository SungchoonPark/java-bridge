package bridge.view;

import bridge.dto.FinalResultDto;
import bridge.dto.MovingDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String FINAL_MESSAGE = "\n최종 게임 결과";
    private static final String SUCCESS_MESSAGE = "\n게임 성공 여부: ";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %d";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<MovingDto> movingDtos) {
        StringBuilder upSide = new StringBuilder();
        StringBuilder downSide = new StringBuilder();

        upSide.append("[ ");
        downSide.append("[ ");
        for (int i = 0; i < movingDtos.size(); i++) {
            MovingDto curMovingDto = movingDtos.get(i);

            if (i != movingDtos.size() - 1) {
                if (curMovingDto.getCommand().equals("U") && curMovingDto.isSuccess()) {
                    upSide.append("O ").append("| ");
                    downSide.append("  ").append("| ");
                }

                if (curMovingDto.getCommand().equals("U") && !curMovingDto.isSuccess()) {
                    upSide.append("X ").append("| ");
                    downSide.append("  ").append("| ");
                }

                if (curMovingDto.getCommand().equals("D") && curMovingDto.isSuccess()) {
                    upSide.append("  ").append("| ");
                    downSide.append("O ").append("| ");
                }

                if (curMovingDto.getCommand().equals("D") && !curMovingDto.isSuccess()) {
                    upSide.append("  ").append("| ");
                    downSide.append("X ").append("| ");
                }
            } else {
                if (curMovingDto.getCommand().equals("U") && curMovingDto.isSuccess()) {
                    upSide.append("O ");
                    downSide.append("  ");
                }

                if (curMovingDto.getCommand().equals("U") && !curMovingDto.isSuccess()) {
                    upSide.append("X ");
                    downSide.append("  ");
                }

                if (curMovingDto.getCommand().equals("D") && curMovingDto.isSuccess()) {
                    upSide.append("  ");
                    downSide.append("O ");
                }

                if (curMovingDto.getCommand().equals("D") && !curMovingDto.isSuccess()) {
                    upSide.append("  ");
                    downSide.append("X ");
                }
            }

        }
        upSide.append("]");
        downSide.append("]");
        System.out.println(upSide);
        System.out.println(downSide);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(FinalResultDto finalResultDto) {
        System.out.println(FINAL_MESSAGE);
        printMap(finalResultDto.getMovingResult());

        if (finalResultDto.isGameSuccess()) {
            System.out.println(String.format(SUCCESS_MESSAGE + "성공"));
            System.out.println(String.format(TRY_COUNT_MESSAGE, finalResultDto.getTotalTryCount()));
            return;
        }
        System.out.println(String.format(SUCCESS_MESSAGE + "실패"));
        System.out.println(String.format(TRY_COUNT_MESSAGE, finalResultDto.getTotalTryCount()));
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

}
