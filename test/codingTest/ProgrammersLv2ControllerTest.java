package codingTest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProgrammersLv2ControllerTest {
	private ProgrammersLv2Controller pc = new ProgrammersLv2Controller();

	@Test
	public void solution_TextCompression_test() { // 문자열 압축
		assertThat(pc.solution_TextCompression("aabbaccc")).isEqualTo(7);
		assertThat(pc.solution_TextCompression("ababcdcdababcdcd")).isEqualTo(9);
		assertThat(pc.solution_TextCompression("abcabcdede")).isEqualTo(8);
		assertThat(pc.solution_TextCompression("abcabcabcabcdededededede")).isEqualTo(14);
		assertThat(pc.solution_TextCompression("xababcdcdababcdcd")).isEqualTo(17);
	}

	@Test
	public void solution_moreSpicy_test() { // 비밀지도
		assertThat(pc.solution_moreSpicy(new int[] {12, 1, 2, 3, 9, 10},7)).isEqualTo(2);
		assertThat(pc.solution_moreSpicy(new int[] {1, 2, 9, 12, 10, 13},10)).isEqualTo(2);
		assertThat(pc.solution_moreSpicy(new int[] {1, 2, 9, 12, 10, 13},160)).isEqualTo(-1);
		assertThat(pc.solution_moreSpicy(new int[] {1, 2, 3, 4, 5, 6, 7},5)).isEqualTo(2);
	}
	
	@Test
	public void solution_openKaKao_test() { // 오픈채팅방
		assertThat(pc.solution_openKaKao(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"}))
		.isEqualTo(new String[] {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."});
	}

	@Test
	public void solution_normalSquare_test() { // 다트게임임
		assertThat(pc.solution_normalSquare(8, 12)).isEqualTo(80); // 8X12-(4X6)   1/3
		assertThat(pc.solution_normalSquare(6, 12)).isEqualTo(60); // 6X12-(6X2)   1/2
		assertThat(pc.solution_normalSquare(8, 8)).isEqualTo(56); // 8X8-(8X1)     1/1
		assertThat(pc.solution_normalSquare(4, 12)).isEqualTo(36); // 4x12-(4X3)   1/3
		assertThat(pc.solution_normalSquare(6, 8)).isEqualTo(36); // 6X8-(2X6)     1/4
	}

	@Test
	public void solution_124Country_test() {
		assertThat(pc.solution_124Country(1)).isEqualTo("1");
		assertThat(pc.solution_124Country(2)).isEqualTo("2");
		assertThat(pc.solution_124Country(3)).isEqualTo("4");
		assertThat(pc.solution_124Country(4)).isEqualTo("11");
		assertThat(pc.solution_124Country(5)).isEqualTo("12");
	}

	@Test
	public void solution_keepDistance_test() {
		assertThat(pc.solution_keepDistance(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})).isEqualTo(new int[]{1, 0, 1, 1, 1});
	}

	@Test
	public void solution_lcm_test() {
		assertThat(pc.solution_lcm(new int[]{2,4,3,6})).isEqualTo(12);
		assertThat(pc.solution_lcm(new int[]{4})).isEqualTo(4);
		assertThat(pc.solution_lcm(new int[]{12,12,5})).isEqualTo(60);
	}

	@Test
	public void solution_jadenCase_test() {
		assertThat(pc.solution_jadenCase("3people unFollowed me ")).isEqualTo("3people Unfollowed Me ");
	}

	@Test
	public void solution_max_int_test(){
		assertThat(pc.solution_max_int(new int[]{344, 34})).isEqualTo("34434");
		assertThat(pc.solution_max_int(new int[]{3, 30, 34, 5, 9,300})).isEqualTo("9534330300");
		assertThat(pc.solution_max_int(new int[]{343, 344, 34})).isEqualTo("34434343");
		assertThat(pc.solution_max_int(new int[]{1, 10, 100, 1000})).isEqualTo("1101001000");
	}

	@Test
	public void solution_matrix_rotation_test(){
		assertThat(pc.solution_matrix_rotation(6,6,new int[][]{{2, 2, 5, 4},{3, 3, 6, 6}, {5, 1, 6, 3}})).isEqualTo(new int[]{8,10,25});
		assertThat(pc.solution_matrix_rotation(3,5,new int[][]{{1,1,2,2},{2,3,3,4}, {1,2,3,4},{1,1,3,4},{2,2,3,5}})).isEqualTo(new int[]{1,8,1,1,3});
		assertThat(pc.solution_matrix_rotation(3,4,new int[][]{{1,1,2,2},{1,2,2,3}, {1,3,2,4},{2,2,3,4}})).isEqualTo(new int[]{1,1,1,4});
		assertThat(pc.solution_matrix_rotation(5,3,new int[][]{{2,1,3,3}})).isEqualTo(new int[]{4});
		assertThat(pc.solution_matrix_rotation(4,3,new int[][]{{1,2,3,3},{3,1,4,3}})).isEqualTo(new int[]{2,6});
		//assertThat(pc.solution_matrix_rotation(100,97,new int[][]{{1,1,2,2},{1,1,2,2},{1,1,100,97}})).isEqualTo(new int[]{1,1,2});
	}

	@Test
	public void solution_expression_number_test(){
		assertThat(pc.solution_expression_number(15)).isEqualTo(4);
	}

	@Test
	public void solution_fibonacci_test(){
		assertThat(pc.solution_fibonacci(3)).isEqualTo(2);
	}

	@Test
	public void solution_next_max_int_test(){
		assertThat(pc.solution_next_max_int(78)).isEqualTo(83);
		assertThat(pc.solution_next_max_int(15)).isEqualTo(23);
	}

	@Test
	public void solution_english_word_chain_game_test(){
		assertThat(pc.solution_english_word_chain_game(3,new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})).isEqualTo(new int[]{3, 3});
	}

	@Test
	public void solution_target_number_test(){
		assertThat(pc.solution_target_number(new int[]{1,1,1,1,1},3)).isEqualTo(5);
		assertThat(pc.solution_target_number(new int[]{4,1,2,1},4)).isEqualTo(2);
	}

	@Test
	public void solution_correct_bracket_test(){
		assertThat(pc.solution_correct_bracket("()")).isEqualTo(true);
	}

	@Test
	public void solution_matrix_multiple_test(){
		assertThat(pc.solution_matrix_multiple(new int[][]{{0,0,0},{0,0,0}},new int[][]{{0,0},{0,0},{0,0}})).isEqualTo(new int[][]{{0,0},{0,0}});
		assertThat(pc.solution_matrix_multiple(new int[][]{{1, 4}, {3, 2}, {4, 1}},new int[][]{{3, 3}, {3, 3}})).isEqualTo(new int[][]{{15, 15}, {15, 15}, {15, 15}});
	}

	@Test
	public void solution_repeat_binary_test(){
		assertThat(pc.solution_repeat_binary("110010101001")).isEqualTo(new int[]{3,8});
		assertThat(pc.solution_repeat_binary("1111111")).isEqualTo(new int[]{4,1});
	}

	@Test
	public void solution_expect_tournament_test(){
		assertThat(pc.solution_expect_tournament(4, 1, 4)).isEqualTo(2);
		assertThat(pc.solution_expect_tournament(8, 4, 7)).isEqualTo(3);
		assertThat(pc.solution_expect_tournament(8, 1, 2)).isEqualTo(1);
		assertThat(pc.solution_expect_tournament(8, 2, 3)).isEqualTo(2);
		assertThat(pc.solution_expect_tournament(16, 1, 16)).isEqualTo(4);
		assertThat(pc.solution_expect_tournament(16, 8, 9)).isEqualTo(4);
		assertThat(pc.solution_expect_tournament(16, 9, 12)).isEqualTo(2);
	}

	@Test
	public void solution_stock_price_test(){
		assertThat(pc.solution_stock_price(new int[]{1, 2, 3, 2, 3})).isEqualTo(new int[]{4, 3, 1, 1, 0});
	}

	@Test
	public void solution_slice_array_test(){
		assertThat(pc.solution_slice_array(3,2,5)).isEqualTo(new int[]{3,2,2,3});
	}

	@Test
	public void solution_vowel_dictionary_test(){
		assertThat(pc.solution_vowel_dictionary("A")).isEqualTo(1);
		assertThat(pc.solution_vowel_dictionary("AAAEA")).isEqualTo(11);
		assertThat(pc.solution_vowel_dictionary("AAAAE")).isEqualTo(6);
		assertThat(pc.solution_vowel_dictionary("AAAIA")).isEqualTo(17);
		assertThat(pc.solution_vowel_dictionary("AAAI")).isEqualTo(16);
		assertThat(pc.solution_vowel_dictionary("AAEI")).isEqualTo(47);
		assertThat(pc.solution_vowel_dictionary("I")).isEqualTo(1563);
		assertThat(pc.solution_vowel_dictionary("IA")).isEqualTo(1564);
		assertThat(pc.solution_vowel_dictionary("IAA")).isEqualTo(1565);
		assertThat(pc.solution_vowel_dictionary("EIO")).isEqualTo(1189);
		assertThat(pc.solution_vowel_dictionary("AAAE")).isEqualTo(10);
	}

	@Test
	public void solution_h_index_test(){
		assertThat(pc.solution_h_index(new int[]{3, 0, 6, 1, 5})).isEqualTo(3);
	}

	@Test
		public void solution_phonebook(){
		assertThat(pc.solution_phonebook(new String[]{"119", "97674223", "1195524421"})).isEqualTo(false);
		assertThat(pc.solution_phonebook(new String[]{"123","456","789"})).isEqualTo(true);
	}

	@Test
	public void solution_pair_remove(){
		assertThat(pc.solution_pair_remove("baabaa")).isEqualTo(1);
		assertThat(pc.solution_pair_remove("cdcd")).isEqualTo(0);
	}

	@Test
	public void solution_truck(){
		assertThat(pc.solution_truck(2,10,new int[]{7,4,5,6})).isEqualTo(8);
		assertThat(pc.solution_truck(100,100,new int[]{10,10,10,10,10,10,10,10,10,10})).isEqualTo(110);
	}

	@Test
	public void solution_camouflage(){
		assertThat(pc.solution_camouflage(new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}})).isEqualTo(5);
	}

	@Test
	public void solution_carpet(){
		assertThat(pc.solution_carpet(10,2)).isEqualTo(new int[]{4,3});
	}

	@Test
	public void solution_skillTree(){
		assertThat(pc.solution_skillTree("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA","AC","CA"})).isEqualTo(4);
	}

	@Test
	public void solution_develop_skill_test(){
		assertThat(pc.solution_develop_skill(new int[]{0,0,0},new int[] {1, 1, 1})).isEqualTo(new int[]{3});
		assertThat(pc.solution_develop_skill(new int[]{0,0,0},new int[] {1, 1, 1})).isEqualTo(new int[]{3});
		assertThat(pc.solution_develop_skill(new int[]{95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1})).isEqualTo(new int[]{1, 3, 2});
		assertThat(pc.solution_develop_skill(new int[]{93, 30, 55},new int[] {1, 30, 5})).isEqualTo(new int[]{2, 1});

	}

	@Test
	public void solution_under_two_bit(){
		assertThat(pc.solution_under_two_bit(new long[]{2,7})).isEqualTo(new long[]{3,11});
		assertThat(pc.solution_under_two_bit(new long[]{3})).isEqualTo(new long[]{5});
		assertThat(pc.solution_under_two_bit(new long[]{0})).isEqualTo(new long[]{1});
	}

	@Test
	public void solution_minerals_test(){
		assertThat(pc.solution_mineral(new int[]{1, 3, 2},new String[]{"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"})).isEqualTo(12);
		assertThat(pc.solution_mineral(new int[]{0, 1, 1},new String[]{"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"})).isEqualTo(50);
	}

	//======================================================================================

	@Test
	public void solution_max_square_test(){
		assertThat(pc.solution_max_square(new int[][]{{0,1,1,1},{0,1,1,1},{1,1,1,1},{0,0,1,0}})).isEqualTo(9);
		assertThat(pc.solution_max_square(new int[][]{{0,0,1,1}, {1,1,1,1}})).isEqualTo(4);
	}

	@Test
	public void solution_coloringbook_test(){
		assertThat(pc.solution_coloringbook(6,4,new int[][]{{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}})).isEqualTo(new int[]{2, 6});
	}


	@Test
	public void solution_eat_the_ground_test(){
		assertThat(pc.solution_eat_the_ground(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 18}, {4, 3, 2, 1}})).isEqualTo(25);
	}

	@Test
	public void solution_course(){
		assertThat(pc.solution_course(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},new int[]{2,3,4})).isEqualTo(new String[]{"AC", "ACDE", "BCFG", "CDE"});
	}

	@Test
	public void solution_rescue_boat(){
		assertThat(pc.solution_rescue_boat(new int[]{70, 50, 80, 50},100)).isEqualTo(3);
		assertThat(pc.solution_rescue_boat(new int[]{70, 80, 50},100)).isEqualTo(3);
		assertThat(pc.solution_rescue_boat(new int[]{50, 50, 50, 50, 50},50)).isEqualTo(5);
		assertThat(pc.solution_rescue_boat(new int[]{60, 60, 60, 60},240)).isEqualTo(1);
		assertThat(pc.solution_rescue_boat(new int[]{90, 80, 70, 60, 50, 40},130)).isEqualTo(3);
		assertThat(pc.solution_rescue_boat(new int[]{100},100)).isEqualTo(1);
		assertThat(pc.solution_rescue_boat(new int[]{50,10,50,10,50,10},60)).isEqualTo(3);
	}

	@Test
	public void solution_fatigue(){
		assertThat(pc.solution_fatigue(80,new int[][]{{80,20},{50,30},{30,10}})).isEqualTo(3);
	}

	@Test
	public void solution_joystick(){
		assertThat(pc.solution_joystick("AAAAA")).isEqualTo(0);
		assertThat(pc.solution_joystick("JAZ")).isEqualTo(11);
		assertThat(pc.solution_joystick("JAN")).isEqualTo(23);
		assertThat(pc.solution_joystick("JEROEN")).isEqualTo(56);
		assertThat(pc.solution_joystick("BAAAAAAABB")).isEqualTo(5);
		assertThat(pc.solution_joystick("AAAABBBAAA")).isEqualTo(9);
	}

	@Test
	public void solution_n_queen_test(){
		assertThat(pc.solution_n_queen(4)).isEqualTo(2);
	}

	@Test
	public void solution_choice_tangerine_test(){
		assertThat(pc.solution_choice_tangerine(2,new int[]{2,2,4,4,6,6})).isEqualTo(1);
		assertThat(pc.solution_choice_tangerine(6,new int[]{1, 3, 2, 5, 4, 5, 2, 3})).isEqualTo(3);
	}

	@Test
	public void solution_drawing_comma_test(){
		assertThat(pc.solution_drawing_comma(1,5)).isEqualTo(26);
		assertThat(pc.solution_drawing_comma(2,4)).isEqualTo(6);
		assertThat(pc.solution_drawing_comma(3,6)).isEqualTo(6);
		assertThat(pc.solution_drawing_comma(3,5)).isEqualTo(4);
		assertThat(pc.solution_drawing_comma(500,1000)).isEqualTo(6);
	}

	@Test
	public void solution_magical_elevator_test(){
		assertThat(pc.solution_magical_elevator(16)).isEqualTo(6);
		assertThat(pc.solution_magical_elevator(2554)).isEqualTo(16);
		assertThat(pc.solution_magical_elevator(666)).isEqualTo(10);
		assertThat(pc.solution_magical_elevator(100000000)).isEqualTo(1);
		assertThat(pc.solution_magical_elevator(100000001)).isEqualTo(2);
		assertThat(pc.solution_magical_elevator(155)).isEqualTo(11);
		assertThat(pc.solution_magical_elevator(154)).isEqualTo(10);
		assertThat(pc.solution_magical_elevator(5)).isEqualTo(5);
	}


	@Test
	public void skill3_test(){
		assertThat(pc.skill3(new int[]{14, 6, 5, 11, 3, 9, 2, 10})).isEqualTo(36);
	}


	@Test
	public void solution_mini_subString_test() {
		assertThat(pc.solution_mini_subString("3141592","271")).isEqualTo(2);
		assertThat(pc.solution_mini_subString("33333333333333333","3141592")).isEqualTo(0);
		assertThat(pc.solution_mini_subString("333333333333333333","333333333333333333")).isEqualTo(0);
	}

}
