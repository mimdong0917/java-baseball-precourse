package baseball.service;

import java.util.List;

public class BaseballGame {

    private static final int VAL_LENGTH = 3;

    private final List<Integer> baseballRandomValList;
    private final List<Integer> userValList;
    private Integer strikeNumber;
    private Integer ballNumber;
    private boolean isWinning;
    private boolean isNothing;

    public BaseballGame(List<Integer> baseballRandomValList, List<Integer> userValList) {
        this.baseballRandomValList = baseballRandomValList;
        this.userValList = userValList;
        startGame();
    }

    private void startGame() {
        initGame();
        checkStrikeAndBall();
        checkNothing();
        checkWinning();
    }


    private void initGame() {
        strikeNumber = 0;
        ballNumber = 0;
        isWinning = false;
        isNothing = false;
    }

    private void checkStrikeAndBall() {
        for (int i = 0; i < VAL_LENGTH; i++) {
            if(isStrike(i)) {
                strikeNumber++;
                continue;
            }
            if(isBall(i)) {
                ballNumber++;
            }
        }
    }

    private void checkNothing() {
        if(strikeNumber == 0 && ballNumber ==0) {
            isNothing = true;
        }
    }

    private void checkWinning() {
        if(strikeNumber == VAL_LENGTH) {
            isWinning = true;
        }
    }

    private boolean isStrike(int index) {
        return baseballRandomValList.get(index).equals(userValList.get(index));
    }

    private boolean isBall(int index) {
        return baseballRandomValList.contains(userValList.get(index));
    }

    public boolean isWinning() {
        return isWinning;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public Integer getStrikeNumber() {
        return strikeNumber;
    }

    public Integer getBallNumber() {
        return ballNumber;
    }
}
