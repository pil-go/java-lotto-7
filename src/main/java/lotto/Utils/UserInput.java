package lotto.Utils;

import lotto.Messages.OutputMessage;
import lotto.View.InputView;
import lotto.View.OutputView;

public class UserInput {
    public String purchaseAmount() {
        OutputView.printMessage(OutputMessage.REQUEST_PURCHASE_AMOUNT.getMessage());
        return InputView.readLine();
    }

}