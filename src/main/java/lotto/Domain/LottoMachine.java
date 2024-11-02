package lotto.Domain;

import lotto.Messages.ErrorMessage;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_STOCK = 10000;
    private PurchaseAmount purchaseAmount;

    private LottoMachine(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoMachine from(PurchaseAmount purchaseAmount) {
        validateAmount(purchaseAmount);

        return new LottoMachine(purchaseAmount);
    }

    private static void validateAmount(PurchaseAmount purchaseAmount) {
        int amount = purchaseAmount.getValue();
        checkMinimum(amount);
        checkDivisible(amount);
        checkLimit(amount);
    }

    private static void checkMinimum(int amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.INSUFFICIENT_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkDivisible(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_PURCHASE_AMOUNT.getMessage());
        }
    }

    private static void checkLimit(int amount) {
        if (amount / LOTTO_PRICE > MAX_STOCK) {
            throw new IllegalArgumentException(ErrorMessage.MAX_OUT_PURCHASE_AMOUNT.getMessage());
        }
    }

}
