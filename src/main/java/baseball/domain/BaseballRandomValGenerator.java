package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballRandomValGenerator {

    private static final int BASEBALL_MIN_NUM = 1;
    private static final int BASEBALL_MAX_NUM = 9;
    private static final int BASEBALL_NUM_SIZE = 3;

    private final List<Integer> baseballRandomValList;

    public BaseballRandomValGenerator() {
        baseballRandomValList = createBaseballRandomVal();
    }

    public List<Integer> getBaseballRandomValList(){
        return baseballRandomValList;
    }

    private List<Integer> createBaseballRandomVal() {
        List<Integer> baseballRandomVal = new ArrayList<>();

        while(baseballRandomVal.size() <BASEBALL_NUM_SIZE) {
            int randomVal = Randoms.pickNumberInRange(BASEBALL_MIN_NUM, BASEBALL_MAX_NUM);

            if(baseballRandomVal.contains(randomVal)){
                continue;
            }

            baseballRandomVal.add(randomVal);
        }

        return baseballRandomVal;
    }

}
