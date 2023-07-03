package codingTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProgrammersLv2Controller {
	static Logger log = LoggerFactory.getLogger("ProgrammersLv2Controller");

	// LV2. 문자열 압축
	public static int solution_TextCompression(String s) {
		int answer = s.length();
		for (int i = 1; i <= Math.floor(s.length() / 2); i++) {  // 문자 단위
			int cnt = 0, eqcnt = 0; // 반복 횟수, 같은문자 카운트
			int min = s.length(); // 압축 문자 길이
			String prevword = s.substring(0, i); // 이전 문자
			while (cnt++ < s.length() / i) { // 최대 문자열 반까지 자름
				// 현재 문자열 (마지막에 i개로 안잘릴수있으므로 마지막 카운트엔 length를 넣음)
				String str = s.substring(i * cnt, Math.min(i * (cnt + 1), s.length()));
				if (prevword.equals(str)) eqcnt++; // 이전 문자와 같을 시 카운트 증가
				else if (eqcnt > 0) { // 같은문자 카운트 끝났으면 줄어든 문자 수 계산
					// 줄어든 문자 수 계산 : (잘린 단위 X 반복된횟수-1 ) + 반복횟수 자릿 수(10일경우 2이므로)
					min = min - ((eqcnt) * i) + ((int) Math.log10(eqcnt + 1) + 1);
					eqcnt = 0; // 같은문자 카운트 초기화
				}
				prevword = str; // 이전 문자에 현재문자 저장
			}
			if (min < answer) answer = min; // i개로 잘랐을때의 갯수가 최솟값보다 작으면 갱신
		}
		return answer;
	}

	// LV2. 더 맵게
	public static int solution_moreSpicy(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> heap = Arrays.stream(scoville).boxed()
				.collect(Collectors.toCollection(PriorityQueue::new));
		while (heap.peek() != null && heap.peek() < K) {
			if (heap.size() == 1) return -1;
			heap.add(heap.poll() + (heap.poll() * 2));
			answer++;
		}

		return answer > 0 ? answer : -1;
	}

	// LV2. 오픈채팅방
	public static String[] solution_openKaKao(String[] record) {
		Map<String, String> usermap = new HashMap<>();
		List<String> answer = new ArrayList<>();
		for (String str : record) {
			String[] temparr = str.split(" ");
			if ("Enter".equals(temparr[0])) {
				usermap.put(temparr[1], temparr[2]);
				answer.add(temparr[1] + "/님이 들어왔습니다.");
			} else if ("Leave".equals(temparr[0])) {
				answer.add(temparr[1] + "/님이 나갔습니다.");
			} else if ("Change".equals(temparr[0])) {
				usermap.put(temparr[1], temparr[2]);
			}
		}

		return answer.stream().map(a -> usermap.get(a.split("/")[0]) + a.split("/")[1]).toArray(String[]::new);
	}

	// LV2. 멀쩡한 사각형
	public static long solution_normalSquare(long w, long h) {
		long answer = w * h; // 첫 사각형 크기

		long gcd = 1, idx = w;
		while (1 < idx) { // 공약수 구하기
			if (w % idx == 0 && h % idx == 0) {
				gcd *= idx;
				w /= idx;
				h /= idx;
				idx = w;
			} else idx--;
		}
		long gcd2 = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
		return answer - gcd * (w + h - 1);
	}

	// LV2. 124 나라의 숫자
	public static String solution_124Country(int n) {
		StringBuffer sb = new StringBuffer();
		while(n > 0){
			int su = n%3==0?3:n%3;
			sb.append((int)Math.pow(2,su-1));
			n /= 3;
			if(su==3) n -= 1;
		}
		return sb.reverse().toString();
	}

	// LV2. 거리두기 확인하기
	public static int[] solution_keepDistance(String[][] places) {
		int[] answer = new int[]{1,1,1,1,1};
		for(int i=0;i<places.length;i++){ // 각 대기실
			// 참가자 리스트 확인
			List<int[]> plist = new ArrayList<>();
			for(int j=0;j<places[0].length;j++){ // 각 열
				String[] temparr = places[i][j].split("");
				for(int k=0;k<temparr.length;k++){ // 각 행
					if("P".equals(temparr[k])) plist.add(new int[]{j,k});
				}
			}

			// 거리 검색
			for (int j=0;j<plist.size()-1;j++){
				for (int k=j+1;k<plist.size();k++){
					int xdistance = Math.abs(plist.get(j)[0]-plist.get(k)[0]);
					int ydistance = Math.abs(plist.get(j)[1]-plist.get(k)[1]);
					int xpos = plist.get(j)[0]>plist.get(k)[0]?plist.get(k)[0]:plist.get(j)[0];
					int ypos = plist.get(j)[1]>plist.get(k)[1]?plist.get(k)[1]:plist.get(j)[1];

					if(xdistance+ydistance<=1){
						answer[i]=0;
						break;
					}else if(xdistance+ydistance==2){
						if(xdistance==ydistance){
							if ("0".equals(places[i][xpos].split("")[ypos])
							||"0".equals(places[i][xpos+1].split("")[ypos])
							||"0".equals(places[i][xpos].split("")[ypos+1])
							||"0".equals(places[i][xpos+1].split("")[ypos+1])){
								answer[i]=0;
								break;
							}
						} else if(xdistance==0 && !"X".equals(places[i][xpos].split("")[ypos+1])){
							answer[i]=0;
							break;
						} else if(ydistance==0 && !"X".equals(places[i][xpos+1].split("")[ypos])){
							answer[i]=0;
							break;
						}
					}
				}
				if(answer[i]==0) break;
			}
		}
		return answer;
	}

	// LV2. n개의 최소공배수
	public static int solution_lcm(int[] arr) {
		int answer = 1;

		for (int i=0;i<arr.length-1;i++){
			BigInteger gcd = BigInteger.valueOf(1);
			for(int k=i+1;k<arr.length;k++) {
				gcd = BigInteger.valueOf(arr[i]).gcd(BigInteger.valueOf(arr[k]));
				if (1 < gcd.intValue()) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] % gcd.intValue() == 0) {
							arr[j] /= gcd.intValue();
						}
					}
					answer *= gcd.intValue();
				}
			}
		}
		for(int a: arr) answer *= a;

		return answer;
	}

	// LV2. JadenCase 문자열 만들기
	public static String solution_jadenCase(String s) {
		String answer =  Arrays.stream(s.split(" "))
				.map(a -> a.length()!=0 ? a.split("")[0].toUpperCase()+a.substring(1).toLowerCase():"")
				.collect(Collectors.joining(" "));
		answer = " ".equals(s.substring(s.length()-1))?answer+" ":answer;
		return answer;
	}

	// LV2. 행렬테두리 회전하기
	public static int[] solution_matrix_rotation(int rows,int columns,int[][] queries){
		int[][] matrix = new int[rows][columns];
		IntStream.range(0,rows).forEach(i->IntStream.range(0,columns).forEach(j-> matrix[i][j] = i*columns+j+1));

        return IntStream.range(0, queries.length).map(i -> rotate_matrix(rows,columns,matrix,queries[i])).toArray();
	}

	public static int rotate_matrix(int rows,int columns,int[][] matrix,int[] query){
		int min = 10000;

		int[][] copy_matrix = new int[rows][columns];
		IntStream.range(0,copy_matrix.length).forEach(a -> System.arraycopy(matrix[a],0,copy_matrix[a],0,matrix[a].length));

		int x_pos = query[1]-1, y_pos = query[0]-1;
		do{
			if(copy_matrix[y_pos][x_pos] < min) min = copy_matrix[y_pos][x_pos];
			if 		(x_pos <  query[3]-1 && y_pos == query[0]-1) matrix[y_pos][x_pos+1] = copy_matrix[y_pos][x_pos++];
			else if (x_pos == query[3]-1 && y_pos <  query[2]-1) matrix[y_pos+1][x_pos] = copy_matrix[y_pos++][x_pos];
			else if (x_pos >  query[1]-1 && y_pos == query[2]-1) matrix[y_pos][x_pos-1] = copy_matrix[y_pos][x_pos--];
			else if (x_pos == query[1]-1 && y_pos >= query[0]-1) matrix[y_pos-1][x_pos] = copy_matrix[y_pos--][x_pos];
		}while((query[1]-1 < x_pos && x_pos <= query[3]-1) || (query[0]-1 < y_pos && y_pos <= query[2]-1));

		return min;
	}

	// LV2. 가장큰수
	public static String solution_max_int(int[] numbers) {
		String answer = Arrays.stream(numbers).boxed()
				.sorted(Comparator.comparing(String::valueOf,(a,b) -> (b+a).compareTo(a+b)))
				.map(String::valueOf)
				.collect(Collectors.joining());
		return answer.charAt(0)=='0'?"0":answer;
	}

	// LV2. 최솟값만들기
	public int solution_make_min_value(int []A, int []B){
		Arrays.sort(A);
		Arrays.sort(B);
		return IntStream.range(0,A.length).map(i->A[i]*B[B.length-i-1]).sum();
	}

	// LV2.최솟값과 최대값
	public String solution_min_max_value(String s) {
		int[] arr = Arrays.stream(s.split(" ")).map(Integer::valueOf).sorted().mapToInt(a->a).toArray();
		return arr[0]+" "+arr[arr.length];
	}

	// LV2. 숫자의 표현
	public static int solution_expression_number(int n) {
		int answer = 1;

		int s = 1,e = 2;
		while(s < e){
			int sum = 0;//IntStream.rangeClosed(s,e).sum();
			for(int i=s;i<=e;i++) sum += i;
			if(sum > n) s++;
			else if(sum == n){
				answer++;
				s++;
				e++;
			}
			else e++;
		}

		return answer;
	}

	// LV2. 피보나치 수
	public static int solution_fibonacci(int n) {
		List<Integer> fibo = new ArrayList<>();
		fibo.add(0);
		fibo.add(1);
		while(fibo.size() <= n){
			fibo.add(fibo.get(fibo.size()-2)%1234567+fibo.get(fibo.size()-1)%1234567);
		}
		return fibo.get(fibo.size()-1)%1234567;
	}

	// LV2. 다음 큰 숫자
	public static int solution_next_max_int(int n) {
		int answer = 0;
		int cnt = Integer.toBinaryString(n).replace("0","").length();
		while(0 < n++){
			int cnt2 = Integer.toBinaryString(n).replace("0","").length();
			if(cnt==cnt2) break;
		}
		return n;
	}

	// LV2. 가장 큰 사각형 찾기
	public static int solution_max_square(int [][]board) {
		int answer = 1234;
		List<int[]> zeroList = new ArrayList<>();
		for(int i=0;i<board.length;i++){
			for (int j=0;j<board[0].length;j++){
				if(board[i][j] < 1){
					zeroList.add(new int[]{i,j});
				}
			}
		}
		return 0;
	}

	// LV2. 컬러링북
	public static int[] solution_coloringbook(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		Map<Integer,List<int[]>> colormap = new HashMap<>();
		for (int i=0;i<picture.length;i++) {
			List<int[]> list = new ArrayList<>();
			for (int j=0;j<picture[0].length;j++){
				if(0 < picture[i][j]){
					if(colormap.get(picture[i][j]) != null && !colormap.get(picture[i][j]).isEmpty()){
						list = colormap.get(picture[i][j]);
					}
					list.add(new int[]{i,j});
					colormap.put(picture[i][j],list);
				}
			}
		}

		for(Integer i : colormap.keySet()){
			Map<String,List<int[]>> newlist = new HashMap<>();
			List<int[]> area = new ArrayList<>();
			for(int k=0;k<colormap.get(i).size();k++){
				int[] pos = colormap.get(i).get(k);
				if(newlist.size()==0){
					area.add(new int[]{pos[0],pos[1]});
					colormap.get(i).remove(colormap.get(i).indexOf(new int[]{pos[0]+1,pos[1]}));
				}
			}
		}

		return answer;
	}

	// LV2. 행렬의 곱셈
	public static int[][] solution_matrix_multiple(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];
		for(int i=0;i<arr1.length;i++){
			for(int j=0;j<arr2[0].length;j++){
				answer[i][j] = 0;
				for(int k=0;k<arr2.length;k++){
					answer[i][j] += (arr1[i][k]*arr2[k][j]);
				}
			}
		}
		return answer;
	}

	// LV2. 영어로 끝말잇기
	public static int[] solution_english_word_chain_game(int n, String[] words) {
		int cnt = 0;
		String prev_word = words[0];
		while(++cnt < words.length){
			if(prev_word.charAt(prev_word.length()-1)!=words[cnt].charAt(0)) break;
			if(0 <= Arrays.asList(words).indexOf(words[cnt]) && Arrays.asList(words).indexOf(words[cnt]) < cnt) break;
			prev_word = words[cnt];
		}
		if(words.length <= cnt) return new int[]{0,0};
		return new int[]{cnt%n+1,cnt/n+1};
	}

	// LV2. 타켓넘버
	public static int solution_target_number(int[] numbers, int target) {
		int answer = 0;
		int cnt = -1;
		while(++cnt < Math.pow(2,numbers.length)){
			String bi = Integer.toBinaryString(cnt);
			int result_number = 0;
			for(int i=0;i<numbers.length;i++){
				if(i < numbers.length-bi.length()) result_number += numbers[i];
				else if(bi.charAt(i-(numbers.length-bi.length()))=='1') result_number -= numbers[i];
				else result_number += numbers[i];
			}
			if(result_number==target) answer++;
		}
		return answer;
	}

	// LV2. 올바른 괄호 : 효율성 통과 못함 ㅅㅂ
	public static boolean solution_correct_bracket(String s) {
		int i=0;
		Stack<Character> stack = new Stack<>();
		while(i<s.length()){
			char c = s.charAt(i++);
			if(stack.empty()){
				if('('==c) stack.push(c);
				else return false;
			}
			else if('('==c) stack.push(c);
			else if(')'==c){
				if('('==stack.peek()) stack.pop();
				else return false;
			}
			else return false;
		}
		return stack.empty()?true:false;
	}

	// LV2.이진변환 반복하기
	public static int[] solution_repeat_binary(String s) {
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;
		while (s.length() > 1){
			answer[0]++;
			answer[1] += Arrays.stream(s.split("")).filter(a->"0".equals(a)).count();
			s = Integer.toBinaryString(s.replace("0","").length());
		}
		return answer;
	}

	// LV2. 예상 대진표
	public static int solution_expect_tournament(int n, int a, int b) {
		int answer = (int)Math.floor(Math.log(n)/Math.log(2));
		while(Math.min(a,b) > n/2 || Math.max(a,b) <= n/2){
			n /= 2;
			answer--;
			if(Math.max(a,b) > n && Math.min(a,b) > n){
				a -= n;
				b -= n;
			}
		}
		return answer;
	}

	// LV2. 주식가격
	public static int[] solution_stock_price(int[] prices) {
		int[] answer = new int[prices.length];
		for(int i=0;i<prices.length;i++){
			int cnt = 0;
			for(int j=i+1;j<prices.length;j++){
				cnt++;
				if(prices[j] < prices[i]) break;
			}
			answer[i] = cnt;
		}
		return answer;
	}

	// LV2. n^2배열 자르기
	public static int[] solution_slice_array(int n, long left, long right) {
		int[] answer = new int[(int)(right-left+1)];
		int idx = 0;
		for(long i = (long)Math.floor(left/n);i<=Math.floor(right/n);i++){
			for(long j = 0;j<n;j++){
				if(left <= i*n+j && i*n+j <= right){
					answer[idx++] = (int)Math.max(i,j)+1;
				}
			}
		}
		return answer;
	}

	// LV2. 모음사전
	enum vowel{A,E,I,O,U};
	public static int solution_vowel_dictionary(String word) {
		int answer = 0;
		int[] jump = new int[5];
		for(int i=0;i<5;i++){
			jump[i] = (int)Math.pow(5,i) + (i-1<0?0:jump[i-1]);
		}
		String[] strarr = word.split("");
		for (int i=0;i<strarr.length;i++) {
			answer += vowel.valueOf(strarr[i]).ordinal()*jump[4-i] + 1;
		}
		return answer;
	}

	// LV2. 전화번호부
	public static boolean solution_phonebook(String[] phone_book) {
		boolean answer = true;
		PriorityQueue<String> queue = Arrays.stream(phone_book).collect(Collectors.toCollection(PriorityQueue::new));
		while(1 < queue.size()){
			String str = queue.poll();
			if(str.startsWith(queue.peek())||queue.peek().startsWith(str)){
				answer = false;
				break;
			}
		}
		return answer;
	}

	// LV2. 짝지어 제거하기
	public static int solution_pair_remove(String s){
		//int answer = -1;
		String[] stringarr = s.split("");
		Stack<String> st = new Stack<>();
		for(String str :stringarr ){
			if(st.size()!=0&&str.equals(st.peek())){
				st.pop();
			}else if(st.size()>stringarr.length/2){
				return 0;
			}else{
				st.push(str);
			}
		}
		return st.size()==0?1:0;
	}

	// LV2. 프린터
	public static int solution_printer(int[] priorities, int location) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i : priorities) list.add(new Integer(i));

		Integer idx = list.get(location);
		int cnt = 1;
		while(0 < list.size()){
			boolean flag = false;
			Integer i = list.pollFirst();
			for(Integer i2 : list){
				if(i2.compareTo(i) > 0){
					flag = true;
					break;
				}
			}
			if(flag) list.addLast(i);
			else{
				if(i == idx) break;
				cnt++;
			}
		}
		return cnt;
	}

	// LV2. 다리를 지나가는 트럭
	public static int solution_truck(int bridge_length, int weight, int[] truck_weights) {
		int answer = 1;

		Queue<Integer> bridgeQ = new LinkedList<>();
		int idx = 1;
		for(int i=0;i<bridge_length-1;i++) bridgeQ.add(0);

		int bridgeW = truck_weights[0];
		bridgeQ.add(truck_weights[0]);
		while(0 < bridgeW){
			bridgeW -= bridgeQ.poll();

			if(idx < truck_weights.length && bridgeW + truck_weights[idx] <= weight){
				bridgeW += truck_weights[idx];
				bridgeQ.add(truck_weights[idx]);
				idx++;
			} else{
				bridgeQ.add(0);
			}
			answer++;
		}
		return answer;
	}

	// LV2. 위장
	public static int solution_camouflage(String[][] clothes) {
		int answer = 1;

		Map<String,Integer> list = new HashMap<>();
		for (String[] s1 : clothes){
			if(list.containsKey(s1[1])) list.put(s1[1],list.get(s1[1])+1);
			else list.put(s1[1],1);
		}
		for(String s : list.keySet()){
			answer *= list.get(s)+1;
		}
		return answer-1;
	}
	// LV2. 카펫
	public static int[] solution_carpet(int brown, int yellow) {
		int idx = IntStream.rangeClosed(1,(int)Math.sqrt(yellow))
				.filter(i -> yellow % i == 0)
				.findFirst().getAsInt();
		return new int[]{yellow/idx+2,idx+2};
	}
	// LV2. 스킬트리
	public static int solution_skillTree(String skill, String[] skill_trees) {
		return (int)Arrays.stream(skill_trees)
				.filter(s->skill.startsWith(s.replaceAll("[^"+skill+"]","")))
				.count();
	}

	// 20220726 완료
	// LV2. 기능개발 [https://school.programmers.co.kr/learn/courses/30/lessons/42586]
	public static int[] solution_develop_skill(int[] progresses, int[] speeds) {
		List<Integer> answerList = new ArrayList<Integer>();
		boolean flag = false;
		int idx=0,date=0,cnt=1;
		while(idx < progresses.length) {
			if (progresses[idx] + (date * speeds[idx]) < 100) {
				if(flag){
					answerList.add(cnt);
					cnt = 1;
				}
				date++;
				flag = false;
			} else if (flag){
				idx++;cnt++;
			} else {
				idx ++;
				flag = true;
			}
			if(idx == progresses.length) answerList.add(cnt);
		}
		return answerList.stream().mapToInt(Integer::intValue).toArray();
	}

	//LV2. 2개이하로 다른 비트 2022.07.26 완료
	public static long[] solution_under_two_bit(long[] numbers) {
		long[] answer = new long[numbers.length];
		for(int i = 0; i < numbers.length;i++){
			String target = Long.toBinaryString(numbers[i]);
			int idx = target.lastIndexOf("0");

			if(idx == target.length()-1){ // 마지막숫자가 0일경우
				answer[i] = numbers[i]+1;
			}else if(idx == -1){ // 첫자리가 0일 경우
				answer[i] = Long.parseUnsignedLong("10"+target.substring(idx+2),2);;
			}else{
				answer[i] = Long.parseUnsignedLong(target.substring(0,idx)+"10"+target.substring(idx+2),2);
			}
		}
		return answer;
	}

	// LV.2 귤고르기
	public static int solution_choice_tangerine(int k, int[] tangerine) {
		int answer = 0;

		Long[] arr = Arrays.stream(tangerine).boxed()
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
				.values().toArray(Long[]::new);

		Arrays.sort(arr,Comparator.reverseOrder());

		int sum = 0;
		for(Long i : arr){
			sum += i;
			answer++;
			if(k <= sum) break;
		}

		return answer;
	}

	// LV2. 광물캐기
	enum mineral{diamond,iron,stone};
	public static int solution_mineral(int[] picks, String[] minerals) {
		int answer = 0;

		// int List 변환
		List<Integer> mineList = Arrays.stream(minerals).mapToInt(a-> mineral.valueOf(a).ordinal()).boxed().collect(Collectors.toList());

		// 5개씩 나누기
		int unit = 5;
		List<List<Integer>> mineSubList = new ArrayList<>();
		for(int i=0;i<Arrays.stream(picks).sum();i++){
			if (minerals.length < unit*(i+1)){
				mineSubList.add(mineList.subList(unit*i,minerals.length));
				break;
			} else{
				mineSubList.add(mineList.subList(unit*i,unit*(i+1)));
			}
		}

		// sum 오름차순 정렬
		mineSubList = mineSubList.stream().sorted(
						Comparator.comparing((List<Integer> a)->a.stream().filter(b->b==0).count())
								.thenComparing((List<Integer> c)->c.stream().filter(b->b==1).count())
								.thenComparing((List<Integer> e)->e.stream().filter(f->f==2).count())
								.reversed())
				.collect(Collectors.toList());

		// 곡괭이 선택 및 피로도 계산
		int pick = 0;
		for(List<Integer> list : mineSubList){
			while(picks[pick] == 0){
				pick++;
				if(pick >= picks.length) return answer;
			}
			picks[pick]--;

			for(Integer i :list) answer += Math.ceil(Math.pow(5,pick-i));
		}
		return answer;
	}

	// LV2. 광물캐기 ver2 23.03.29
	public static int solution_mineral2(int[] picks, String[] minerals) {
		return IntStream.iterate(0,i->i+5).limit(Arrays.stream(picks).sum())
				.mapToObj(r -> Arrays.stream(minerals)
						.skip(r).limit(5)
						.mapToInt(a-> mineral.valueOf(a).ordinal()).boxed()
						.collect(Collectors.toList()))
				.sorted(Comparator.comparing((List<Integer> a)->a.stream().filter(b->b==0).count())
						.thenComparing((List<Integer> c)->c.stream().filter(b->b==1).count())
						.thenComparing((List<Integer> e)->e.stream().filter(f->f==2).count())
						.reversed())
				.mapToInt(s->{
					int pick = 0;
					while(picks[pick] == 0) pick++;
					picks[pick++]--;
					int finalPick = pick;
					return s.stream().mapToInt(i -> (int)Math.ceil(Math.pow(5, finalPick -i))).sum();
				}).sum();
	}

	//LV2. 구명보트 23.07.03 드디어 ㅠ
	public static int solution_rescue_boat(int[] people, int limit) {
		Arrays.sort(people);

		int answer = 0, minIdx = 0;
		for(int i=people.length-1; 0 <= i; i--){
			if(i < minIdx) break;
			answer++;
			int weight = people[i];
			if(weight <= limit/2){
				answer += Math.ceil((i - minIdx)/2);
				break;
			} else if(people[minIdx] + weight <= limit){
				minIdx++;
			}
		}

		return answer;
	}

	//LV2. H-index 23.07.03
	public static int solution_h_index(int[] citations) {
		AtomicInteger ai = new AtomicInteger(citations.length);
		while(0 < ai.getAndDecrement()){
			long upperCnt = Arrays.stream(citations).filter(a-> ai.get() < a).count();
			if(ai.get() < upperCnt) break;
		}
		return ai.incrementAndGet();
	}

	//============================================================================\

	//LV2. 피로도 23.07.03 [89.5 %]
	public static int solution_fatigue(int k, int[][] dungeons) {
		int answer = 0;

		List<int[]> list = Arrays.stream(dungeons)
				.sorted(Comparator
						.comparing((int[] a)-> a[0]-a[1])
						.thenComparing(a->a[0])
						.thenComparing(a->a[1])
						.reversed()
				).collect(Collectors.toList());

		for(int[] d : list){
			if(k < d[0]) continue;
			k -= d[1];
			answer++;
		}
		/*
		Map<Integer,Integer> map = new HashMap<>();
		for(int[] dungeon: dungeons) map.put(dungeon[0],dungeon[1]);

		List<Map.Entry<Integer,Integer>> listmap = map.entrySet().stream()
				.sorted(Comparator.comparing((Map.Entry<Integer,Integer> a)-> a.getValue()-a.getKey()).thenComparing(Map.Entry::getKey))
				.collect(Collectors.toList());

		for(Map.Entry e : listmap){
			log.info("[{},{}]",e.getKey(),e.getValue());
			if(k < (int)e.getKey()) break;
			k -= (int) e.getValue();
			answer++;
		}
		*/
		return answer;
	}

	//LV2. 땅따먹기
	public static int solution_eat_the_ground(int[][] land) {
		int answer = 0;
		Map<Integer,Integer> map = new LinkedHashMap<>();
		for(int i=0;i<land.length;i++){
			map.put(i,Arrays.stream(land[i]).max().getAsInt());
		}
		map.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey));
		for(int k : map.keySet()){
			for(int i=0;i<=land.length;i++){
				if(map.get(k)==land[k][i]){
					if(0 <= k-1) land[k-1][i] = 0;
					if(k+1 < land.length) land[k+1][i] = 0;
				}
			}
		}

		for(int i=0;i<land.length;i++){
			answer += Arrays.stream(land[i]).max().getAsInt();
		}

		return answer;
	}

	//LV2. 코스요리
	public static String[] solution_course(String[] orders, int[] course) {
		String[] answer = {};
		for(int i :course){
			for (String str : orders){
				str.split("");
			}
		}
		return answer;
	}

	//LV2. 조이스틱 - 20220805 48.1
	public static int solution_joystick(String name) {
		/*int answer = 0;

		//System.out.println(">> name : "+name);
		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < name.length(); i++) {
			int num = Math.min(Math.abs(name.charAt(i) - 'A'),Math.abs(name.charAt(i) - 'Z')+1);
			if(num!=0) numList.add(i);
			answer += num;
		}

		boolean reverse = false;
		int idx = 0,move =0;
		while(0 < numList.size()-1){
			move++;
			//System.out.println(">> idx : "+idx);
			int min = name.length();
			for(int i=0;i<numList.size();i++){
				if(numList.get(i) == idx){
					numList.remove(i);
					continue;
				}
				if(numList.get(i)-idx < min){ //
					min = numList.get(i)-idx;
					reverse = false;
				}
				if(name.length()-numList.get(i) < min){
					min = name.length() - numList.get(i);
					reverse = true;
				} else if(numList.get(i)-idx < min && name.length()-numList.get(i) < min){
					min = numList.get(i)-idx;
				}
			}

			if(reverse){
				if(--idx < 0) idx = name.length()-1;
			}else{
				if(name.length()-1 < ++idx) idx = 0;
			}
			if(name.length()-1 == move) break;
		}

		return answer+move;*/
		int answer = 0;

		List<Integer> numList = new ArrayList<>();
		for(int i = 0; i < name.length(); i++) {
			int num = Math.min(Math.abs(name.charAt(i) - 'A'),Math.abs(name.charAt(i) - 'Z')+1);
			if(num!=0) numList.add(i);
			answer += num;
		}

		boolean reverse = false;
		int idx = 0,move =0;
		while(0 < numList.size()-1){
			if(name.length()-1 == ++move) break;
			int min = name.length();
			for(int i=0;i<numList.size();i++){
				if(numList.get(i) == idx){
					numList.remove(i);
					continue;
				}
				if(numList.get(i)-idx == name.length()-numList.get(i) && numList.get(i)-idx < min){
					min = numList.get(i)-idx;
					continue;
				}
				if(name.length()-numList.get(i) < min){
					min = name.length() - numList.get(i);
					reverse = true;
				}
				if(numList.get(i)-idx < min){ //
					min = numList.get(i)-idx;
					reverse = false;
				}
			}

			if(reverse && idx-1 < 0) idx = name.length()-1;
			else if(!reverse && name.length()-1 < idx+1) idx = 0;
		}

		return answer+move;
	}

	// LV2. N-Queen
	public static int solution_n_queen(int n) {
		return factorial(n);
	}
	public static int factorial(int n){
		if(n==1) return 1;
		else return n * factorial(n-1);
	}


	// LV2. 점찍기
	public static long solution_drawing_comma(int k, int d) {
		/*
		//20221209
		long answer = (int)Math.pow(d/k+1,2);
		System.out.println("*----- d : "+d+" / k :"+k);
		double unit = d/k,idx = 0;
		while(idx <= d-k){
			System.out.println("unit : "+ unit);
			idx += k;
			answer -= (int)unit;
			unit = Math.sqrt(unit);
		}
		return answer;
		*/
		/*
		// 20221208
		int answer = 0;
		int yd = d;
		for(int x=0;x<=d;x+=k){
			for(int y=0;y<=Math.sqrt(x*y);y+=k){
				if(Math.pow(x,2)+Math.pow(y,2) <= Math.pow(d,2)){
					System.out.println("["+x+","+y+"]");
					answer++;
				}
			}
		}
		return answer;
		*/
		// 20221209

		//double mi = ((double)d/(double)k)*Math.PI;
		/*
		double mi = (k+1)*d;
		System.out.println(mi);
		System.out.println((Math.pow((d/k)+1,2)));
		int answer = (int)(Math.pow((d/k)+1,2) - mi);


		 */
		/*
		double answer = Math.pow((d/k)+1,2);
		for(int i = 0; i < d; i+=k){
			for(int j = 0; j < d;j+=k){
				d = (int)Math.sqrt(d);
				System.out.println("i :"+i+" / j : "+j);
				answer--;
			}
		}
		*/
		//20221212
		double answer = Math.pow((d/k)+1,2)*(Math.PI/4);

		return (int)answer;
	}

	//
	public static int solution_magical_elevator(int storey) {
		int answer = 0;

		String[] strarr = String.valueOf(storey).split("");
		for (int i=strarr.length-1;0 <= i;i--){
			int a = Integer.parseInt(strarr[i]);
			int b = Math.abs(10 - a);
			if(b < 0 || a <= b){
				answer += a;
			}else{
				answer += b;
				if(i!=0) strarr[i-1] = String.valueOf(Integer.valueOf(strarr[i-1])+1);
			}
		}

		/*
		String[] strarr = String.valueOf(storey).split("");
		for (int i=0;i<strarr.length;i++){
			int a = Integer.parseInt(strarr[i]);
			int b = Math.abs(10 - a);
			System.out.println("a : "+ a + "/ b : "+b);
			if(a <= b){
				answer += a;
			}else{
				answer += b;
				if(i < strarr.length-1 &&Integer.valueOf(strarr[i+1]) <= 5) answer++;
				else  answer--;
			}
			System.out.println("answer : "+ answer);
		}
		*/

		return answer;
	}


	public static int skill3(int sticker[]){
		int answer = 0;
		Queue<Integer> queue = Arrays.stream(sticker).boxed().collect(Collectors.toCollection(PriorityQueue::new));
		List<Integer> list = Arrays.stream(sticker).boxed().collect(Collectors.toList());
		while(!queue.isEmpty()){
			int max = queue.poll();
			if(0 < list.indexOf(max)){
				answer += max;

				int idx = list.indexOf(max);
				list.remove(list.get(idx));
				if(idx < list.size()-1){
					list.remove(idx+1);
				}else{
					list.remove(list.size()-1);
				}
				if(1 < idx){
					list.remove(idx-1);
				}else{
					list.remove(0);
				}
			}
		}
		return answer;
	}

	// LV2. 가장 작은 문자열
	public static int solution_mini_subString(String t, String p) {
		return (int) IntStream.rangeClosed(0,t.length()-p.length())
				.mapToLong(a->Long.valueOf(t.substring(a,a+p.length())))
				.filter(r->r<=Long.valueOf(p))
				.count();
	}
}
