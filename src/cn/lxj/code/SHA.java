package cn.lxj.code;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA
 * description 单向加密，SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，
 * 被广泛地应用于电子商务等信息安全领域。虽然，SHA与MD通过碰撞法都被破解了，但是SHA仍然是公认的安全加密算法，较之MD更为安全
 * create by lxj 2018/7/16
 **/
public class SHA {
    public static final String KEY_SHA = "SHA";

    public static String getResult(String inputStr) throws NoSuchAlgorithmException {
        BigInteger sha = null;
        System.out.println("========加密前的数据：" + inputStr);
        byte[] bytes = inputStr.getBytes();

        MessageDigest instance = MessageDigest.getInstance(SHA.KEY_SHA);
        instance.update(bytes);
        sha = new BigInteger(instance.digest());
        System.out.println("==========SHA加密后：" + sha.toString());
        return sha.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String inputStr = "简答加密";
        getResult(inputStr);
    }
}
