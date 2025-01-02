package work;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MallflexTest {
    @Test
    public void replaceMasking(){
        //2
        String str2 = "123456789";
        int startIdx2 = 3, endIdx2 = 6;

        String regex2 = String.format("(?<=.{%d}).(?=.{%d})",startIdx2,str2.length() - endIdx2);
        System.out.println(regex2);

        String replacedString2 = str2.replaceAll(regex2,"*");
        System.out.println(replacedString2);

        assertThat(replacedString2.substring(startIdx2,endIdx2)).isEqualTo("*".repeat(endIdx2 - startIdx2));

        // 1
        String str = "최현영";
        int startIdx = 1, endIdx = 2;

        String regex = String.format("(?<=.{%d}).(?=.{%d})",startIdx,str.length() -endIdx);
        System.out.println(regex);

        String replacedString = str.replaceAll(regex,"*");
        System.out.println(replacedString);

        assertThat(replacedString.substring(startIdx,endIdx)).isEqualTo("*".repeat(endIdx - startIdx));

    }
}
