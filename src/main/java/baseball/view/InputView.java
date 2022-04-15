package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NEW_GAME_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getUserVal(){
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getNewGameOrEndVal(){
        System.out.println(NEW_GAME_OR_END_MESSAGE);
        return Console.readLine();
    }

}
