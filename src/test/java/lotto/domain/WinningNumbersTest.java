package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningNumbersTest {

    @Test
    @DisplayName("입력된 당첨 숫자들로 NumberGroup이 생성되고 재 호출시에도 동일한 객체가 호출되는지 확인합니다.")
    void numberGroup() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        //when
        NumberGroup numberGroup = new WinningNumbers(winningNumbers).numberGroup();
        NumberGroup recallNumberGroup = new WinningNumbers(winningNumbers).numberGroup();
        //then
        assertThat(numberGroup.equals(recallNumberGroup)).isTrue();
    }

    @Test
    @DisplayName("입력된 당첨 숫자들로 String[]이 생성되는지 확인합니다.")
    void numbers() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6";
        //when
        String[] numberGroup = new WinningNumbers(winningNumbers).numbers();
        //then
        assertThat(numberGroup.length).isEqualTo(WinningNumbers.LIMIT);
    }

    @Test
    @DisplayName("입력된 당첨 숫자들로 String[]이 생성되는지 확인합니다.")
    void illegalNumbers() {
        //given
        String winningNumbers = "1, 2, 3, 4, 5, 6, 7";
        //when
        assertThatIllegalArgumentException().isThrownBy(
                () -> {
                    new WinningNumbers(winningNumbers).numbers();
                }
        );
    }
}