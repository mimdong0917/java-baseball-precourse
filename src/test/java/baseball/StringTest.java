package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    @Test
    void String_스플릿_테스트() {
        String input = "864";
        String[] split = input.split("");
        assertThat(split)
                .contains("8")
                .contains("6")
                .contains("4");

    }

    @Test
    void String_숫자_테스트() {

        String input = "알랄2";
        boolean isValid = true;

        for (int i=0; i<input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                isValid = false;
            }
        }

        assertThat(isValid).isEqualTo(false);
    }

    @Test
    void 숫자_Unique_테스트() {
        List<String> userValStringList = new ArrayList<String>();
        userValStringList.add("1");
        userValStringList.add("8");
        userValStringList.add("9");

        Set<String> userValSet = new HashSet<>();

        userValStringList.forEach(userVal -> userValSet.add(userVal));

        assertEquals(userValSet.size(), 3);
    }

}
