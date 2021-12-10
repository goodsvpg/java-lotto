package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ValidationValueFactoryTest {
    @ParameterizedTest
    @ValueSource(strings = {"-1", "19^8", "-10000"})
    @DisplayName("숫자 이외의 값을 파라미터로 create를 생성하면 illegalArgumentException을 발생시키는지 확인합니다")
    void illegalArgument(String argument) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {new ValidationValueFactory().create(argument);}
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "198", "10000"})
    @DisplayName("숫자 형식의 string 값을 파라미터로 create를 생성하면 StringToIntegerValue 객체 생성이 되는지 확인합니다")
    void legalArgument(String argument) {
        assertThat(new ValidationValueFactory().create(argument).equals(new StringToIntegerValue(argument))).isTrue();
    }
}