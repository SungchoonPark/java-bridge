package bridge.controller;

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

        String movingCommand = readMoving();
        MovingResultDto moving = bridgeService.moving(movingCommand);
        moving.print();
        //Todo: 겜 진행상황 보여주기

        // Todo: 겜 실패했는지 성공했는지 따지기
        // 실패 -> 재시작 또는 종료 물어보기
        // 성공 -> readMoving 다시 ㄱㄱ

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
}
