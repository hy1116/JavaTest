package work;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StardreamTest {
    Stardream test = new Stardream();
    @Test
    public void giftDetailTest() throws Exception {
        String[] origin = new String[]{"cyflElDMOlAixB2PH05QJg==", "wOyo8IyfDiiy+DOE6vLRHg=="};
        String[] updated = test.getKbIds();

        System.out.println(Arrays.toString(updated));

        assertThat(origin).isEqualTo(updated);
    }
}
