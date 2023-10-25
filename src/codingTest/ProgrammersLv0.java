package codingTest;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgrammersLv0 {
	public int[] solution_emergency(int[] emergency) {
		List<Integer> list = Arrays.stream(emergency).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return Arrays.stream(emergency).map(a->list.indexOf(a)+1).toArray();
	}

	public int[] solution_maxInfo(int[] array) {
		int max = Arrays.stream(array).max().getAsInt();
		int idx = Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(max);
		return new int[]{max,idx};
	}

	public int solution_dice(int[] box, int n) {
		int answer = 0;
		return answer;
	}
}
