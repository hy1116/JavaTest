package codingTest;

import org.junit.jupiter.api.Assertions;
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

	@Test
	public void solution_test(){
		assertThat(pc.solution(7)).isEqualTo(16);
	}

	@Test
	public void solution_addElement(){
		assertThat(pc.solution_addElement(new int[]{5,1,4})).isEqualTo(new int[]{5,5,5,5,5,1,4,4,4,4});
	}

	@Test
	public void solution_dice2(){
		assertThat(pc.solution_dice2(	2, 6, 1)).isEqualTo(9);
		assertThat(pc.solution_dice2(5,3,3)).isEqualTo(	473);
		assertThat(pc.solution_dice2(3,3,3)).isEqualTo(6);
	}

	@Test
	public void solution_query(){
		assertThat(pc.solution_query(new int[]{0, 1, 2, 3, 4},new int[][]{{0, 3}, {1, 2}, {1, 4}})).isEqualTo(new int[]{3, 4, 1, 0, 2});
	}

	@Test
	public void solution_query2(){
		assertThat(pc.solution_query2(new int[]{0, 1, 2, 3, 4},new int[][]{{0, 3}, {1, 2}, {1, 4}})).isEqualTo(new int[]{3, 4, 1, 0, 2});
	}

	@Test
	public void solution_verticalRead(){
		assertThat(pc.solution_verticalRead("ihrhbakrfpndopljhygc",4, 2)).isEqualTo("happy");
	}

	@Test
	public void solution_compareDate(){
		assertThat(pc.solution_compareDate(new int[]{2021,12,28},new int[]{2021,12,29})).isEqualTo(1);
	}

	@Test
	public void solution_measure(){
		assertThat(pc.solution_measure(24)).isEqualTo(new int[]{1,2,4,6,12,24});
	}

	@Test
	public void solution_369(){
		assertThat(pc.solution_369(24)).isEqualTo(2);
	}

	@Test
	public void solution_factorial(){
		assertThat(pc.solution_factorial(3628800)).isEqualTo(10);
		assertThat(pc.solution_factorial(7)).isEqualTo(3);
	}

	@Test
	public void solution_compareArray(){
		assertThat(pc.solution_compareArray("str","rts")).isEqualTo(1);
	}

	@Test
	public void solution_permutation(){
		assertThat(pc.solution_permutation(2)).isEqualTo(new int[]{0, 50, 5, 55});
	}

	@Test
	public void solution_permutation2(){
		assertThat(pc.solution_permutation2(5,555)).isEqualTo(new int[]{5, 50, 55, 500, 505, 550, 555});
	}
	@Test
	public void solution_two_num_add(){
		assertThat(pc.solution_two_num_add("18446744073709551615","287346502836570928366")).isEqualTo("305793246910280479981");
	}
	@Test
	public void solution_dice3(){
		assertThat(pc.solution_dice3(2,2,2,2)).isEqualTo(2222);
		assertThat(pc.solution_dice3(4,4,4,4)).isEqualTo(4444);
		assertThat(pc.solution_dice3(1,2,3,4)).isEqualTo(1);
		assertThat(pc.solution_dice3(6,5,3,4)).isEqualTo(3);
		assertThat(pc.solution_dice3(6,2,3,4)).isEqualTo(2);
		assertThat(pc.solution_dice3(1,1,4,1)).isEqualTo(196);
		assertThat(pc.solution_dice3(3,6,3,6)).isEqualTo(27);
	}
	@Test
	public void solution_pow_two(){
		assertThat(pc.solution_pow_two(new int[]{1})).isEqualTo(new int[]{1});
		assertThat(pc.solution_pow_two(new int[]{1,2})).isEqualTo(new int[]{1,2});
		assertThat(pc.solution_pow_two(new int[]{1,2,3,4})).isEqualTo(new int[]{1,2,3,4});
		assertThat(pc.solution_pow_two(new int[]{1,2,3,4,5,6})).isEqualTo(new int[]{1,2,3,4,5,6,0,0});
		assertThat(pc.solution_pow_two(new int[]{1,2,3,4,5,6,7,8,9,10})).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0});
	}

	@Test
	public void solution(){
		Assertions.assertDoesNotThrow(()->pc.solution());
	}
}
