package codingTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ProgrammersLv0 {
	Logger log = LoggerFactory.getLogger("ProgrammersLv0");

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
		return Arrays.stream(arr).mapToObj(a->String.valueOf(a).repeat(a)).mapToInt(Integer::valueOf).toArray();
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

	public String solution_two_num_add(String a, String b) {
		StringBuilder answer = new StringBuilder();
		if(a.length() < b.length()){
			a = "0".repeat(b.length()-a.length()) + a;
		} else if(b.length() < a.length()){
			b = "0".repeat(a.length()-b.length()) + b;
		}

		int rnd = 0;
		String[] aarr = a.split("");
		String[] barr = b.split("");
		for(int i = a.length()-1; 0<=i; i--){
			int num = Integer.parseInt(aarr[i]) + Integer.parseInt(barr[i]);
			num += rnd;
			rnd =  num /10;
			answer.insert(0, num % 10);
		}
		if(0<rnd) answer.insert(0, rnd);
		return answer.toString();
	}

	public void solution_checkMine() {
		// Question
		int[][] arr = new int[3][3];
		int[] pos = {1,1};
		for(int[] a : arr) System.out.println(Arrays.toString(a));

		for (int i=0;i<arr.length;i++){
			for (int j=0;j<arr[i].length;j++){
				if (arr[i][j] == 1) checkMine(arr,new int[]{i,j});
			}
		}
		for(int[] a : arr) System.out.println(Arrays.toString(a));

		// Answer
		int answer = Arrays.stream(arr).mapToInt(r-> Math.toIntExact(Arrays.stream(r).filter(a -> a == 0).count())).sum();
		System.out.println(answer);
	}
	public void checkMine(int[][] arr,int[] pos){
		// Check
		for(int y = -1; y <= 1; y++){
			for(int x = 1; -1 <= x; x--){
				try{
					if(arr[pos[0]+x][pos[1]+y] == 0) arr[pos[0]+x][pos[1]+y] = -1;
				} catch(Exception e){
					continue;
				}
				log.info("[x:{}, y:{}]",x,y);
			}
		}

	}

	public int[][] solution_square(int[][] arr){
		if(arr.length==arr[0].length) return arr;
		int[][] answer = new int[Math.max(arr.length,arr[0].length)][Math.max(arr.length,arr[0].length)];

		for(int i=0;i<answer.length;i++){
			for(int j=0;j<answer.length;j++){
				answer[i][j] = arr[i][j];
			}
		}
		for(int[] a : arr) System.out.println(Arrays.toString(a));
		return answer;
	}

	public String[] solution_enlargement(String[] picture, int k) {
		List<String> picList = new ArrayList<>();
		for(String pic : picture){
			String str = Arrays.stream(pic.split("")).map(r->r.repeat(k)).collect(Collectors.joining());
			for(int i=0;i<k;i++){
				picList.add(str);
			}
		}
		return picList.toArray(String[]::new);
	}

	public int solution_rank_attendance(int[] rank, boolean[]
			attendance) {
		return IntStream.range(0,rank.length).boxed()
				.filter(f->attendance[f])
				.sorted(Comparator.comparing(s->rank[s]))
				.limit(3)
				.reduce((l,r)->l*100+r)
				.orElse(0);
	}

	public int solution_spell(String[] spell, String[] dic) {
		int answer = 0;



		return answer;
	}

	/* 주사위 게임3 */
	public int solution_dice3(int a,int b,int c,int d) {
		Map<Integer,Integer> map = new HashMap<>();
		List.of(a,b,c,d).forEach(i->{
			map.put(i,map.getOrDefault(i,0)+1);
		});

		if(map.size()==1) return a*1111;
		else if(map.size()==2){
			if(map.containsValue(2)){ // (p + q) × |p - q|
				int[] result = map.keySet().stream().mapToInt(Integer::intValue).toArray();
				return (result[0] + result[1]) * Math.abs(result[0] - result[1]);
			} else{ // (10 × p + q)2
				int[] result = map.entrySet().stream().sorted(Map.Entry.comparingByValue()).mapToInt(Map.Entry::getKey).toArray();
				return (int) Math.pow(10 * result[1] + result[0],2);
			}
		}
		else if(map.size()==3) {
			int[] result = map.entrySet().stream().filter(r->r.getValue()==1).mapToInt(Map.Entry::getKey).toArray();
			return result[0]*result[1];
		}
		else return Math.min(Math.min(a,b), Math.min(c,d));
	}

	public int[] solution_pow_two(int[] arr) {
		return Arrays.copyOf(arr,(int)Math.pow(2,Math.ceil(Math.log(arr.length) / Math.log(2))));
	}

	/* 나선형 */
	public int[][] solution_spiral(int n) {
		int[][] arr = new int[n][n];

		int mode = 0, end = n*n;
		int i=0,j=0,k=1;
		while(k <= end){
			arr[i][j] = k;

 			if(((mode%4==0&&n-1<=j)
					||(mode%4==1&&n-1<=i)
					||(mode%4==2&&j<=arr.length-n)
					||(mode%4==3&&i<=arr.length-n))
					&& (++mode%4==3)){
				n--;
				continue;
			}

			if(mode%4==0) j++;
			if(mode%4==1) i++;
			if(mode%4==2) j--;
			if(mode%4==3) i--;
			k++;
		}
		return arr;
	}

	public void solution(){
		int[][] score = {{80,90},{75,60}};
		List<Integer> list = Arrays.stream(score)
				.map((r-> r[0]+r[1]))
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
		int[] answer = Arrays.stream(score).mapToInt(m->list.indexOf(m)+1).toArray();
	}

}
