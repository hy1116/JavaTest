package work;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class TheHealthTest {
    TheHealth theHealth = new TheHealth();

    @Test
    public void encryptParamTest(){
        String id = "H123456789";
        assertThatCode(()->theHealth.encryptParam(id)).doesNotThrowAnyException();
    }
}
