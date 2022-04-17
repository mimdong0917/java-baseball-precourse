package baseball.domain;

import baseball.view.InputView;

import java.util.*;

public class UserVal {

    private final List<Integer> userValList;
    private final int VALID_LENGTH = 3;

    public UserVal() {
        String userValString = new InputView().getUserVal();
        checkValidateUserVal(userValString);
        this.userValList = userValIntegerList(userValString);
    }

    public List<Integer> getUserValList(){
        return userValList;
    }

    private List<String> userValString2List(String userValString){
        return Arrays.asList(userValString.split(""));
    }

    private List<Integer> userValIntegerList(String userValString) {

        List<Integer> userValIntegerList = new ArrayList<>();
        String[] splitString = userValString.split("");

        for (int i=0; i<userValString.length(); i++) {
            userValIntegerList.add(Integer.parseInt(splitString[i]));
        }

        return userValIntegerList;
    }

    private void checkValidateUserVal(String userValString){

        if(userValString.length() != VALID_LENGTH) {
            throw new IllegalArgumentException("3개 이상의 값을 입력했습니다.");
        }

        if(!isUnique(userValString)) {
            throw new IllegalArgumentException("모두 서로 다른 값이 아닙니다.");
        }

        if(!isValidDigit(userValString)){
            throw new IllegalArgumentException("숫자가 아닌 값을 입력했습니다.");
        }

    }

    private boolean isValidDigit(String userValString){

        boolean isValid = true;

        for (int i=0; i<userValString.length(); i++) {
            if(!Character.isDigit(userValString.charAt(i))){
                isValid = false;
            }
        }

        return isValid;
    }

    private boolean isUnique(String userValString){

        List<String> userValStringList = userValString2List(userValString);

        Set<String> userValSet = new HashSet<>();

        userValStringList.forEach(userVal -> userValSet.add(userVal));

        return userValSet.size() == VALID_LENGTH;
    }


}
