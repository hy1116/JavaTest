package work;

import kr.lifesemantics.common.security.SecuUtility;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CouponBox {

    public boolean loginSamsungLifeInsurance(String p3) throws Exception {
        try{
            String decryptedUserId = "";
            try {
                p3 = p3.replaceAll("(\r|\n|\r\n|\n\r)", "");

                decryptedUserId = SecuUtility.DecryptAria(p3);
            } catch (Exception e) {
                throw new Exception("복호화 오류");
            }

            // 인가코드 검증
            String id = decryptedUserId.substring(0, 10);
            String time = decryptedUserId.substring(10);
            if (!checkTime(time)) {
                throw new Exception("인가코드(시간) 검증오류");
            }
        } catch(Exception e){
            System.out.println(e.getMessage() + " : USERID [ " + p3 + " ]");
            System.out.println("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해 주십시오");
        }

        return false;
    }

    public boolean checkTime(String time) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmmss");
            LocalTime target = LocalTime.parse(time, dtf);
            LocalTime now = LocalTime.now();

            // 현재 시간 기준으로 앞뒤로 1분 검증
            if(!(target.isBefore(now.plusMinutes(1)) && target.isAfter(now.minusMinutes(1)))) {
                System.out.println("인증 가능 시간 초과 [" + target + "]");
                return false;
            }
        } catch (Exception e) {
            System.out.println("인증 시간 변환오류 [" + time + "]");
            return false;
        }
        return true;
    }
}
