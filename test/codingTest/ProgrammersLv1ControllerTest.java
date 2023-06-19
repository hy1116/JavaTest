package codingTest;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class ProgrammersLv1ControllerTest {
	ProgrammersLv1Controller pc = new ProgrammersLv1Controller();
	
	@Test
	public void solution_RepostResult_test() { // 신고 결과 받기 
		assertThat(pc.solution_RepostResult(
				new String[]{"muzi", "frodo", "apeach", "neo"},
				new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
				2)).isEqualTo(new int[]{2,1,1,0});
		assertThat(pc.solution_RepostResult(
				new String[]{"con", "ryan"},
				new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
				3)).isEqualTo(new int[]{0,0});
	}

	@Test
	public void solution_keypadPress_test() { // 키패드 누르기
		assertThat(pc.solution_keypadPress(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right")).isEqualTo("LRLLLRLLRRL");
		assertThat(pc.solution_keypadPress(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left")).isEqualTo("LRLLRRLLLRR");
		assertThat(pc.solution_keypadPress(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right")).isEqualTo("LLRLLRLLRL");
	}

	@Test
	public void solution_failureRate_test(){ // 실패율
		assertThat(pc.solution_failureRate(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3})).isEqualTo(new int[]{3, 4, 2, 1, 5});
		assertThat(pc.solution_failureRate(4,new int[]{4, 4, 4, 4, 4})).isEqualTo(new int[]{4, 1, 2, 3});
		assertThat(pc.solution_failureRate(4,new int[]{2, 2, 2, 2, 2})).isEqualTo(new int[]{2, 1, 3, 4});
	}

	@Test
	public void solution_secretMap_test() { // 비밀지도
		assertThat(pc.solution_secretMap(5,new int[]{9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28})).isEqualTo(new String[] {"#####", "# # #", "### #", "#  ##", "#####"});
		assertThat(pc.solution_secretMap(6,new int[]{46, 33, 33, 22, 31, 50},new int[]{27, 56, 19, 14, 14, 10})).isEqualTo(new String[] {"######","###  #","##  ##"," #### "," #####","### # "});

	}

	@Test
	public void solution_xn_test() { // x만큼 간격이 있는 n개의 숫자
		assertThat(pc.solution_xn(2, 5)).isEqualTo(new long[] {2, 4, 6, 8, 10});
		assertThat(pc.solution_xn(4, 3)).isEqualTo(new long[] {4, 8, 12});
		assertThat(pc.solution_xn(-4, 2)).isEqualTo(new long[] {-4, -8});

	}

	@Test
	public void solution_DartGame_test() { // 다트게임
		assertThat(pc.solution_DartGame("1D2S#10S")).isEqualTo(9);
		assertThat(pc.solution_DartGame("1D2S0T")).isEqualTo(3);
		assertThat(pc.solution_DartGame("1S*2T*3S")).isEqualTo(23);
		assertThat(pc.solution_DartGame("1D#2S*3S")).isEqualTo(5);
		assertThat(pc.solution_DartGame("1T2D3D#")).isEqualTo(-4);
		assertThat(pc.solution_DartGame("1D2S3T*")).isEqualTo(59);
		assertThat(pc.solution_DartGame("0S0S0S")).isEqualTo(0);
		assertThat(pc.solution_DartGame("0D0D10S")).isEqualTo(10);
		assertThat(pc.solution_DartGame("10D10S0D")).isEqualTo(110);
		assertThat(pc.solution_DartGame("1S2D3T*")).isEqualTo(63);
		assertThat(pc.solution_DartGame("1S2D*3T*")).isEqualTo(72);
		assertThat(pc.solution_DartGame("1S*2D*3T*")).isEqualTo(74);
	}

	@Test
	public void solution_strangeString_test() {
		assertThat(pc.solution_strangeString("hello world")).isEqualTo("HeLlO WoRlD");
	}

	@Test
	public void solution_IntDesc_test() {
		assertThat(pc.solution_IntDesc(123456)).isEqualTo(654321);
	}

	@Test
	public void solution_reverseIntArr_test() {
		assertThat(pc.solution_reverseIntArr(123456)).isEqualTo(new int[]{6,5,4,3,2,1});
		//assertThat(pc.solution_reverseIntArr(0)).isEqualTo(new int[]{0});
	}

	@Test
	public void solution_SecretCode_test() {
		assertThat(pc.solution_SecretCode("a",1)).isEqualTo("b");
		assertThat(pc.solution_SecretCode("Z",25)).isEqualTo("Y");
	}

	@Test
	public void solution_findDecimal_test() {
		assertThat(pc.solution_findDecimal(10)).isEqualTo(4);
		assertThat(pc.solution_findDecimal(5)).isEqualTo(3);
	}
	@Test
	public void solution_three_test() {
		assertThat(pc.solution_three(45)).isEqualTo(7);
	}

	@Test
	public void solution_MathTest_test() {
		assertThat(pc.solution_MathTest(new int[]{1,2,3,4,5})).isEqualTo(new int[]{1});
	}

	@Test
	public void solution_addMeasure_test() {
		assertThat(pc.solution_addMeasure(13,17)).isEqualTo(43);
	}

	@Test
	public void solution_makeDecimal_test() {
		assertThat(pc.solution_makeDecimal(new int[]{1,2,3,4})).isEqualTo(1);
		assertThat(pc.solution_makeDecimal(new int[]{1,2,7,6,4})).isEqualTo(4);
	}

	@Test
	public void solution_psyClothes_test() {
		assertThat(pc.solution_gymClothes(5,new int[]{2,4},new int[]{1,3,5})).isEqualTo(5);
		assertThat(pc.solution_gymClothes(5,new int[]{2,4},new int[]{3})).isEqualTo(4);
		assertThat(pc.solution_gymClothes(3,new int[]{3},new int[]{1})).isEqualTo(2);
		assertThat(pc.solution_gymClothes(3,new int[]{3},new int[]{3})).isEqualTo(3);
		assertThat(pc.solution_gymClothes(5,new int[]{1,2,3,4,5},new int[]{})).isEqualTo(0);
		assertThat(pc.solution_gymClothes(5,new int[]{1,2,3,4,5},new int[]{1,2,3,4,5})).isEqualTo(5);
		assertThat(pc.solution_gymClothes(5,new int[]{1,2,3,4,5},new int[]{1,2,3,4,5})).isEqualTo(5);
		assertThat(pc.solution_gymClothes(2,new int[]{1,2},new int[]{1,2})).isEqualTo(2);
		assertThat(pc.solution_gymClothes(2,new int[]{},new int[]{})).isEqualTo(2);
		assertThat(pc.solution_gymClothes(2,new int[]{},new int[]{1,2})).isEqualTo(2);
	}

	@Test
	public void solution_trio_test() {
		assertThat(pc.solution_trio(new int[]{-2, 3, 0, 2, -5})).isEqualTo(2);
	}

	@Test
	public void solution_coke_test() {
		assertThat(pc.solution_coke(2,1,20)).isEqualTo(19);
		assertThat(pc.solution_coke(4,1,20)).isEqualTo(6);
		assertThat(pc.solution_coke(4,1,20)).isEqualTo(6);
		assertThat(pc.solution_coke(20,1,20)).isEqualTo(1);
	}

	@Test
	public void solution_mbti_test() {
		assertThat(pc.solution_mbti(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5})).isEqualTo("TCMA");
		assertThat(pc.solution_mbti(new String[]{"TR", "RT", "TR"},new int[]{7, 1, 3})).isEqualTo("RCJA");
	}

	@Test
	public void solution_privacyInfo_test() {
		assertThat(pc.solution_privacyInfo("2022.05.19",new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})).isEqualTo(new int[]{1, 3});
	}

	@Test
	public void solution_number_partner_test() {
		assertThat(pc.solution_number_partner("100", "2345")).isEqualTo("-1");
		assertThat(pc.solution_number_partner("12321", "42531")).isEqualTo("321");
		assertThat(pc.solution_number_partner("111", "111")).isEqualTo("111");
		assertThat(pc.solution_number_partner("0", "1")).isEqualTo("-1");
		assertThat(pc.solution_number_partner("21474836471", "21474836471")).isEqualTo("87764443211");
		assertThat(pc.solution_number_partner("52", "5522")).isEqualTo("52");
		assertThat(pc.solution_number_partner("000000000", "000000000")).isEqualTo("0");
	}

	@Test
	public void solution1_test() {
		assertThat(pc.solution1(new String[]{"2", "3", "+", "D", "0", "3", "R"})).isEqualTo(20);
	}

	@Test
	public void solution2_test() {
		assertThat(pc.solution2(new int[] {1, 3, 4, 6} , new int[] {2, 3, 4, 5})).isEqualTo(3);
	}

	@Test
	public void solution3_test () {
		assertThat(pc.solution3("bucketplace")).isEqualTo("cceeabklptu");
	}

	@Test
	public void solution4_test() {
		assertThat(pc.solution4_v2("3*2-5*1")).isEqualTo(new int[]{-9, -9, -9, 1, 1});
		assertThat(pc.solution4_v2("7*2-3")).isEqualTo(new int[]{-7,11});
		//assertThat(pc.solution4_v2("1*1*1*1*1")).isEqualTo(new int[]{1});
	}

	@Test
	public void solution5_test() {
		assertThat(pc.solution5_v2(new int[] { 9, 10, 6, 0, 4, 6, 10})).isEqualTo(3);
		assertThat(pc.solution5_v2(new int[] { 5, 3, 1, 3, 6, 4})).isEqualTo(0);
		assertThat(pc.solution5_v2(new int[] { 10, 10, 3, 9, 4, 10, 3, 9, 3, 10, 9})).isEqualTo(11);
		assertThat(pc.solution5_v2(new int[] { 6, 10, 3, 9, 4, 10, 3, 9, 3, 10, 6})).isEqualTo(9);
		assertThat(pc.solution5_v2(new int[] { 7,7,7,9,9,9})).isEqualTo(5);
		assertThat(pc.solution5_v2(new int[] { 7,7,7,7,7,9,9,9})).isEqualTo(5);
		assertThat(pc.solution5_v2(new int[] { 7,7,12,12,7,1,1,1})).isEqualTo(3);
	}

	@Test
	public void solution_making_hamburger_test() {
		assertThat(pc.solution_making_hamburger_stack(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1})).isEqualTo(2);
		assertThat(pc.solution_making_hamburger_stack(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2})).isEqualTo(0);
		assertThat(pc.solution_making_hamburger_stack(new int[]{1,1,2,3,1,2,3,1,2,3,1,1})).isEqualTo(2);
		assertThat(pc.solution_making_hamburger_stack(new int[]{1,2,3,1,2,3,1,1})).isEqualTo(1);
		assertThat(pc.solution_making_hamburger_stack(new int[]{1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1,2,3,1})).isEqualTo(3);
	}

	@Test
	public void solution_near_string_test() {
		assertThat(pc.solution_near_string("banana")).isEqualTo(new int[]{-1, -1, -1, 2, 2, 2});
	}

	@Test
	public void solution_food_fight_test() {
		assertThat(pc.solution_food_fight(new int[]{1,3,4,6})).isEqualTo("1223330333221");
	}

	@Test
	public void solution_hall_of_fame_test() {
		assertThat(pc.solution_hall_of_fame(3,new int[]{10, 100, 20, 150, 1, 100, 200})).isEqualTo(new int[]{10, 10, 10, 20, 20, 100, 100});
	}

	@Test
	public void solution_fruit_seller_test() {
		assertThat(pc.solution_fruit_seller(4,3,new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2})).isEqualTo(33);
		assertThat(pc.solution_fruit_seller(3,4,new int[]{1, 2, 3, 1, 2, 3, 1})).isEqualTo(8);
	}

	@Test
	public void solution_trump_bundle_test() {
		assertThat(pc.solution_trump_bundle(
				new String[]{"i", "drink", "water"}
				,new String[]{"want", "to"}
				,new String[]{"i", "want", "to", "drink", "water"}
		)).isEqualTo("Yes");
	}

	@Test
	public void solution_split_string_test() {
		assertThat(pc.solution_split_string(
				"banana"
		)).isEqualTo(3);
	}

	@Test
	public void solution_babbling_test() {
		assertThat(pc.solution_babbling(
				new String[]{"aya", "yee", "u", "maa"}
		)).isEqualTo(1);
		assertThat(pc.solution_babbling(
				new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}
		)).isEqualTo(2);
		assertThat(pc.solution_babbling(
				new String[]{"ayaaya", "yewoomaaya","aya", "ye", "woo", "maya"}
		)).isEqualTo(4);
	}

	@Test
	public void solution_painting_test() {
		assertThat(pc.solution_painting(
				8,4,new int[]{2,3,6} //3.6666666...
		)).isEqualTo(2);
	}

	@Test
	public void solution_memory_score_test() {
		assertThat(pc.solution_memory_score(
				new String[]{"may", "kein", "kain", "radi"}
				,new int[]{5, 10, 1, 3}
				,new String[][]{{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"},{"kon", "kain", "may", "coni"}}
		)).isEqualTo(new int[]{19, 15, 6});
	}

	@Test
	public void solution_orders_weapon_test() {
		assertThat(pc.solution_orders_weapon(5,3,2)).isEqualTo(10);
	}

	@Test
	public void solution_secret_code_test() {
		assertThat(pc.solution_secret_code("aukks","wbqd",5)).isEqualTo("happy");
		assertThat(pc.solution_secret_code("aaaaaaa","wbqd",5)).isEqualTo("hhhhhhh");
		assertThat(pc.solution_secret_code("wxyz","abcd",8)).isEqualTo("ijkl");
	}

	@Test
	public void solution_roughly_made_keyboard_test() {
		assertThat(pc.solution_roughly_made_keyboard(new String[]{"ABACD", "BCEFD"},new String[]{"ABCD","AABB"})).isEqualTo(new int[]{9,4});
	}

	@Test
	public void solution_running_race_test() {
		assertThat(pc.solution_running_race(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "kai"})).isEqualTo(new String[]{"kai","mumu", "soe", "poe",  "mine"});
		assertThat(pc.solution_running_race(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine"})).isEqualTo(new String[]{"mumu", "kai", "mine", "soe", "poe"});
		assertThat(pc.solution_running_race(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine", "mine"})).isEqualTo(new String[]{"mumu","mine", "kai", "soe", "poe"});
		assertThat(pc.solution_running_race(new String[]{"mumu", "soe", "poe", "kai", "mine"},new String[]{"kai", "kai", "mine", "mine", "soe"})).isEqualTo(new String[]{"mumu", "kai", "soe", "mine", "poe"});
	}

	@Test
	public void solution_cleaning_background_test() {
		assertThat(pc.solution_cleaning_background(new String[]{".#...", "..#..", "...#."})).isEqualTo(new int[]{0, 1, 3, 4});
	}

	@Test
	public void solution_walking_park_test() {
		assertThat(pc.solution_walking_park(new String[]{"SOO","OOO","OOO"},new String[]{"E 2","S 2","W 1"})).isEqualTo(new int[]{2,1});
		assertThat(pc.solution_walking_park(new String[]{"SOO", "OXX", "OOO"},new String[]{"E 2", "S 2", "W 1"})).isEqualTo(new int[]{0,1});
		assertThat(pc.solution_walking_park(new String[]{"OSO", "OOO", "OXO", "OOO"},new String[]{"E 2", "S 3", "W 1"})).isEqualTo(new int[]{0,0});
		assertThat(pc.solution_walking_park(new String[]{"OSO", "OOO", "OXO", "OOO"},new String[]{"E 2", "S 3", "W 1"})).isEqualTo(new int[]{0,0});

	}
}
