package codingTest;

import static org.assertj.core.api.Assertions.assertThat;

import codingTest.Beakjoon;
import org.junit.jupiter.api.Test;

import java.io.*;

public class BeakjoonTest {
    @Test
    public void testSolution1() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("4");
        bw.write("1");
        bw.write("1010");
        bw.write("10");
        bw.write("10101");
        bw.flush();

        Beakjoon bc = new Beakjoon();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        if(br.read() > -1){
            answer = br.readLine();
        }

        assertThat(answer).isEqualTo("5");
    }

}

