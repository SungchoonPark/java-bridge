package bridge.controller;

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

        readMoving();
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
