package cn.edu.tongji.ranger.encryption;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by wangdechang on 2016/4/26.
 */
public class Keys {
    public static final String key = "uiuga7af1";

    private static byte[] Encrypt(byte[] text, byte[] key) throws Exception {
        SecretKeySpec aesKey = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        return cipher.doFinal(text);
    }

    private static byte[] Decrypt(byte[] text, byte[] key) throws Exception {
        SecretKeySpec aesKey = new SecretKeySpec(key, "AES");

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        return cipher.doFinal(text);
    }

    public static String EncodeAES(String password, String key) throws Exception {
        byte[] keybBytes = MD5STo16Byte.encrypt2MD5toByte16(key);
        byte[] passwdBytes = password.getBytes();

        byte[] aesBytyes = Encrypt(passwdBytes, keybBytes);
        return new String(Base64.encode(aesBytyes));
    }

    public static String DeCodeAES(String password, String key) throws Exception {
        byte[] debase64Bytes = Base64.decode(password);
//	System.out.println("debase64Bytes=" + debase64Bytes.length + " === " + new String(debase64Bytes));

        byte[] keybBytes = MD5STo16Byte.encrypt2MD5toByte16(key);
//	System.out.println("keybBytes=" + new String(keybBytes));

//	 ByteArrayOutputStream baos = new ByteArrayOutputStream();
//	 DataOutputStream outputstream = new DataOutputStream(baos);
//	 outputstream.writeChars( new String(keybBytes));
//	 byte[] contents = baos.toByteArray();

        return new String(Decrypt(debase64Bytes, keybBytes));
    }
}
