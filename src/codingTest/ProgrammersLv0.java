package codingTest;

import com.google.common.primitives.Chars;
import com.google.common.primitives.Ints;

import java.time.LocalDate;
import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgrammersLv0 {
	public int[] solution_emergency(int[] emergency) {
		List<Integer> list = Arrays.stream(emergency).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		return Arrays.stream(emergency).map(a->list.indexOf(a)+1).toArray();
	}

	public int[] solution_maxInfo(int[] array) {
		int max = Arrays.stream(array).max().orElse(0);
		int idx = Arrays.stream(array).boxed().collect(Collectors.toList()).indexOf(max);
		return new int[]{max,idx};
	}

	public int solution_dice(int[] box, int n) {
		int answer = 0;

		return answer;
	}

	public int solution(int n) {
		IntStream test = IntStream.rangeClosed(0,n)
				.filter(r -> r%2==n%2)
				.map(a -> (n%2==0)? a : (int)Math.pow(a,2));
		test.forEach(System.out::println);
		int[] arr = {};
		Arrays.stream(arr).map(r->{
			if(50 < r && r%2 == 0) return r/2;
			else if(r < 50 && r%2 ==1) return r*2;
			else return r;
		}).toArray();

		return IntStream.rangeClosed(0,n)
				.filter(r -> r%2==n%2)
				.map(a -> (n%2!=0)? a : (int)Math.pow(a,2))
				.sum();
		/*
		return IntStream.rangeClosed(10,3).boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(Integer::intValue).toArray();
		*/
	}
	// 배열의 원소만큼 추가하기
	public int[] solution_addElement(int[] arr) {
		Arrays.stream(arr).mapToObj(a->String.valueOf(a).repeat(a)).collect(Collectors.joining()).split("");
		System.out.println(Arrays.stream(arr).mapToObj(a->String.valueOf(a).repeat(a)).collect(Collectors.joining()));

		return new int[]{};
	}

	public int solution_dice2(int a,int b,int c) {
		Set<Integer> set = new HashSet<>(List.of(a, b, c));
		return IntStream.rangeClosed(1, 4-set.size())
				.map(r -> (int) (Math.pow(a,r) + Math.pow(b,r) + Math.pow(c,r)))
				.reduce(1,(id,op)->id*op);
	}

	public int[] solution_query(int[] arr, int[][] queries) {
		for(int[] qu : queries){
			int temp = arr[qu[0]];
			arr[qu[0]] = arr[qu[1]];
			arr[qu[1]] = temp;
		}
		return arr;
	}

	public int[] solution_query2(int[] arr, int[][] queries) {
		List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
		return Arrays.stream(queries)
				.mapToInt(q -> {
					OptionalInt result = arrList.stream().skip(q[0]).limit(q[1])
							.filter(r->q[2]<r)
							.mapToInt(Integer::intValue)
							.min();
					arrList.remove(result.getAsInt());
					return result.orElse(-1);
				})
				.toArray();
	}

	public String solution_verticalRead(String my_string, int m, int c) {
		return IntStream.range(0,my_string.length()/m)
				.mapToObj(r -> String.valueOf(my_string.charAt(r*m+c-1)))
				.collect(Collectors.joining());
	}

	public int solution_compareDate(int[] data1, int[] date2) {
		return LocalDate.of(data1[0],data1[1],data1[2]).isBefore(LocalDate.of(date2[0],date2[1],date2[2]))?1:0;
	}

	public int[] solution_measure(int n) {
		return IntStream.rangeClosed(1,n).filter(r->n%r==0).toArray();
	}

	public int solution_369(int n) {
		List<String> arr = List.of("3","6","9");
		return (int)Arrays.stream(String.valueOf(n).split("")).filter(arr::contains).count();
	}

	public String solution_duplicate(String s) {
		return Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
	}

	public int solution_factorial(int n) {
		int idx = 0;
		while(factorial(++idx) <= n);
		return idx-1;
	}
	public int factorial(int n){
		if(n==1) return 1;
		return n*factorial(n-1);
	}

	public int solution_compareArray(String s1,String s2){
		return Arrays.stream(s1.split("")).sorted().collect(Collectors.joining())
				.equals(Arrays.stream(s2.split("")).sorted().collect(Collectors.joining()))?1:0;
	}

	public int[] solution_permutation(int n){
		Set<Integer> set = new HashSet<>();
		int[] arr = {0,5};

		permutation(set,arr, new int[n],0,n);
		return set.stream().mapToInt(Integer::intValue).toArray();
	}
	public void permutation(Set<Integer> set, int[] arr, int[] out, int depth, int n){
		if(depth ==  n) {
			String s = Arrays.stream(out).mapToObj(String::valueOf).collect(Collectors.joining());
			set.add(Integer.parseInt(s));
			return;
		}
		for(int i : arr){
			out[depth] = i;
			permutation(set,arr,out,depth+1,n);
		}
	}

	public int[] solution_permutation2(int l,int r){
		Set<Integer> set = new HashSet<>();
		IntStream.rangeClosed(String.valueOf(l).length(),String.valueOf(r).length())
				.forEach(a->permutation(set,new int[]{0,5}, new int[a],0,a));

		int[] answer = set.stream().mapToInt(Integer::intValue).filter(a->l<=a&&a<=r).sorted().toArray();
		return answer.length==0?new int[]{-1}:answer;
	}

	public void solution() {
		int n =4;

		int[][] answer = new int[n][n];
		for (int[] arr: answer){
			System.out.println(Arrays.toString(arr));
		}

		int mode = -1, i=0, j=0, idx = 0;
		while(answer[i][j]==0){
			if(n < ++mode) mode = 0;
			if(mode == 2) n--;
			while((0 <= i & i < n) | (0 <= j & j < n)){
				System.out.println("i :"+i+" j :"+j);
				if(mode==0) i++;
				else if(mode==1) j++;
				else if(mode==2) i--;
				else j--;

				answer[i][j] = ++idx;
			}
		}

		for (int[] arr: answer){
			System.out.println(Arrays.toString(arr));
		}
	}


}
