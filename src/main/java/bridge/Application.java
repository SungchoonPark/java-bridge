package bridge;

import bridge.controller.BridgeController;
import bridge.service.BridgeService;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BridgeController bridgeController = new BridgeController(
                new InputView(),
                new OutputView(),
                new BridgeService()
        );

        bridgeController.run();
    }
}
