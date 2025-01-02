package work;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StardreamTest {
    Stardream test = new Stardream();
    @Test
    public void giftDetailTest() throws Exception {
        String[] origin = ("5epNHZpm9EeueZt5CdX9Rw%3D%3D"+","+"wOyo8IyfDiiy+DOE6vLRHg==").split(",");;
        String[] updated = test.getKbIds();

        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(updated));

        assertThat(origin).isEqualTo(updated);
    }
}
