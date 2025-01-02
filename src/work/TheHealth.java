package work;

import kr.lifesemantics.common.security.SecuUtility;
import org.slf4j.LoggerFactory;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TheHealth {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(TheHealth.class);

    public String encryptParam(String str) throws Exception {
        if(str.length() != 10) {
            throw new Exception("아이디 길이가 유효하지않습니다. (10자리 고정)");
        }
        str += this.makeAuthCode();
        String encStr = SecuUtility.EncryptAria(str);
        log.info("parameter [{}] encrypted [{}]",str,encStr);
        return encStr;
    }

    private String makeAuthCode(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
        return LocalTime.now().format(dtf);
    }
}
