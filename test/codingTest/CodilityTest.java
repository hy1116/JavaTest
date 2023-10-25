package codingTest;

import codingTest.Codility;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CodilityTest {
	@Test
	public void solution_binary_gap(){
		assertThat(Codility.solution_binary_gap(1)).isEqualTo(0);
		assertThat(Codility.solution_binary_gap(9)).isEqualTo(3);
	}
}
