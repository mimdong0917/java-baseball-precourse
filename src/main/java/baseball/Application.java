package baseball;

import baseball.domain.BaseballRandomValGenerator;
import baseball.domain.UserVal;
import baseball.service.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        do {
            List<Integer> baseballRandomValList = new BaseballRandomValGenerator().getBaseballRandomValList();
            newUserVal(baseballRandomValList);
        } while(isNewGame());

    }

    private static void newUserVal(List<Integer> baseballRandomValList) {
        List<Integer> userValList = new UserVal().getUserValList();

        BaseballGame baseballGame = new BaseballGame(baseballRandomValList, userValList);

        if(!baseballGame.isWinning()) {
            printResult(baseballGame);
            newUserVal(baseballRandomValList);
            return;
        }

        OutputView.printWinningMessage();

    }

    private static boolean isNewGame() {
        int NEW_GAME = 1;
        int QUIT = 2;

        int userValNeworQuit = InputView.getNewGameOrEndVal();

        if(userValNeworQuit != NEW_GAME && userValNeworQuit != QUIT) {
            throw new IllegalArgumentException("입력 오류");
        }

        return userValNeworQuit == NEW_GAME;
    }

    private static void printResult(BaseballGame baseballGame) {
        if(baseballGame.isNothing()) {
            OutputView.printNothingMessage();
            return;
        }
        OutputView.printStrikeAndBallMessage(baseballGame.getStrikeNumber(), baseballGame.getBallNumber());
    }

}
