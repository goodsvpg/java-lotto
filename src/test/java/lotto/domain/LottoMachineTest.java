package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMachineTest {

    @Test
    @DisplayName("주어진 로또 장수에 따라 정상적으로 Lotto 객체를 만들어 반환합니다.")
    void lotto() {
        //given
        int lottoNumberCount = 14;
        LottoMachine lottoMachine = new LottoMachine();
        //when
        Lotto lotto = lottoMachine.lotto(lottoNumberCount);
        //then
        assertThat(lotto.appropriate(lottoNumberCount)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("주어진 로또 장수에 따라 정상적으로 Lotto 객체를 만들어 반환합니다.")
    void inappropriateLotto(int lottoNumberCount) {
        LottoMachine lottoMachine = new LottoMachine();

        assertThatIllegalArgumentException().isThrownBy(
                () -> {lottoMachine.lotto(lottoNumberCount);  }
        );
    }

    @Test
    @DisplayName("6개의 숫자들로 이루어진 NumberGroup을 만드는지 확인합니다")
    void numberGroup() {
        //given
        LottoMachine lottoMachine= new LottoMachine();
        //when
        NumberGroup numberGroup = lottoMachine.numberGroup();
        //then
        assertThat(numberGroup.appropriate(LottoMachine.LOTTO_NUMBER_GROUP_LIMIT)).isTrue();
    }
}