package bridge.controller;

import bridge.dto.FinalResultDto;
import bridge.dto.MovingResultDto;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeService bridgeService;

    public BridgeController(InputView inputView, OutputView outputView, BridgeService bridgeService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeService = bridgeService;
    }

    public void run() {
        int bridgeSize = readBridgeSize();
        bridgeService.generateBridge(bridgeSize);

        process(bridgeSize);
    }

    private void process(int bridgeSize) {
        String movingCommand = readMoving();
        MovingResultDto moving = bridgeService.moving(movingCommand);
        printGameProgress(moving);

        processGame(moving, bridgeSize);
    }

    private int readBridgeSize() {
        while(true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private String readMoving() {
        while(true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printGameProgress(MovingResultDto movingResultDto) {
        outputView.printMap(movingResultDto.getMovingResult());
    }

    private void processGame(MovingResultDto movingResultDto, int bridgeSize) {
        if (!movingResultDto.getIsSuccess()) {
            // 실패한 경우 -> 재시작 여부 받음
            String retryInput = readRetryInput();
            if (retryInput.equals("R")) {
                // 재시작
                bridgeService.retry();
                process(bridgeSize);
                return;
            }

            FinalResultDto gameResult = bridgeService.getGameResult();
            printResult(gameResult);
            return;
        }

        // 성공한 경우
        if (bridgeSize == movingResultDto.getMovingResult().size()) {
            FinalResultDto gameResult = bridgeService.getGameResult();
            printResult(gameResult);
            return;
        }

        process(bridgeSize);
    }

    private String readRetryInput() {
        while(true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void printResult(FinalResultDto finalResultDto) {
        outputView.printResult(finalResultDto);
    }
}
