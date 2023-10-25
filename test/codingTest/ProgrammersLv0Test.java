package codingTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgrammersLv0Test {
	ProgrammersLv0 pc = new ProgrammersLv0();

	@Test
	public void solution_emergency() {
		assertThat(pc.solution_emergency(new int[]{3,75,25})).isEqualTo(new int[]{3,1,2});
	}

	@Test
	public void solution_maxInfo() {
		assertThat(pc.solution_maxInfo(new int[]{3,1,8,4,3})).isEqualTo(new int[]{8,1});
	}

	@Test
	public void solution_dice() {
		assertThat(pc.solution_dice(new int[]{10, 8, 6}, 3)).isEqualTo(12);
	}
}
