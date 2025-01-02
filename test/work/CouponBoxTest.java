package work;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouponBoxTest {
    @Test
    public void loginSamsungLifeInsuranceTest() throws Exception {
        String p3 = "a64fdca215827399df343ad5d0549dac";
        CouponBox couponBox = new CouponBox();
        couponBox.loginSamsungLifeInsurance(p3);

        Assertions.assertDoesNotThrow(()->couponBox.loginSamsungLifeInsurance(p3));
    }
}
