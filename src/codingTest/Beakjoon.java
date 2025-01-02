package codingTest;


/* 백준 제출방법
public class Main {
    public static void main(String[] args) {
        ...
    }
}
*/
import java.util.*;
public class Beakjoon {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((double) a/b);
    }
}

/*

    public Stream<String> getParamsLines(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> lines = br.lines();
        return lines;
    }

    public void submitAnswer(String answer) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer);
        bw.flush();
    }

*/