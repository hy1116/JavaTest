package util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CryptoUtilTest {

    @Test
    @DisplayName("aes256 암호화 테스트")
    public void test_encrypt_aes256_base64() {
        String str = "0";

        String encStr = CryptoUtil.encrypt_aes256_base64(str);

        assertEquals(encStr,"OXpjithoHTWLJEyQjBq/HQ==");
    }

    @Test
    @DisplayName("aes256 복호화 테스트")
    public void test_decrypt_aes256_base64() {
        String str = "PV/EdE8bfV7WvxBqpX2TmA==";

        String encStr = CryptoUtil.decrypt_aes256_base64(str);

        assertEquals(encStr,"701012650784");
    }

    @Test
    @DisplayName("seed128 암호화 테스트")
    public void test_encrypt_seed128_base64() {
        String str = "0";

        String encStr = CryptoUtil.encrypt_seed128_base64(str);

        assertEquals(encStr,"lMrXpdLIZ8pJxq7+BTptDg==");
    }
}