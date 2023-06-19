package util;

import lib.KISA_SEED_CBC;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CryptoUtil {
    // AES-256/SEED128
    private static String key = "1234567890ABCDEFGHIJKLMNOPQRSTUV";
    private static String IV  = "1234567890ABCDEF";

    public static String encrypt_aes256_base64(String str) {
        String result = "";
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParamSpec);

            byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
            result = Base64.getEncoder().encodeToString(encrypted);
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String decrypt_aes256_base64(String str) {
        String result = "";
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
            IvParameterSpec ivParamSpec = new IvParameterSpec(IV.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParamSpec);

            byte[] decodedBytes = Base64.getDecoder().decode(str);
            byte[] decrypted = cipher.doFinal(decodedBytes);
            result = new String(decrypted, "UTF-8");
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String encrypt_seed128_base64(String str) {
        String result = "";
        try{
            byte[] strBytes = str.getBytes("UTF-8");
            byte[] encrypted = KISA_SEED_CBC.SEED_CBC_Encrypt(key.getBytes(),IV.getBytes(),strBytes,0,strBytes.length);
            result = new String(Base64.getEncoder().encode(encrypted), "UTF-8");
        } catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public static String decrypt(String str) throws Exception {
        byte[] strBytes = Base64.getDecoder().decode(str.getBytes());
        byte[] enc = KISA_SEED_CBC.SEED_CBC_Decrypt(key.getBytes(), IV.getBytes(), strBytes, 0, strBytes.length);
        return new String(enc, "UTF-8");
    }
}
