package codingTest;
// 백준 알고리즘
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int idx = sc.nextInt()-1;

        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=num;i++){
            if(num%i==0) list.add(i);
            if(idx < list.size()) break;
        }
        System.out.println(list.get(idx));
    }
}


