package cn.lxj.code;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHAUtil
 * description 安全散列算法
 * SHA-1、SHA-2（SHA-224、SHA-256、SHA-384、SHA-512），只有SHA-224是bc实现，其他是jdk实现
 * create by lxj 2018/7/16
 **/
public class SHAUtil {
    private static String src = "Hello SHA";

    /**
     * JDK实现
     */
    public static void jdkSHA1() {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA");
            digest.update(src.getBytes());
            System.out.println("JDK SHA1: " + Hex.encodeHexString(digest.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * JDK实现
     */
    public static void mcSHA1() {
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha1Byte1 = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Byte1, 0);
        System.out.println("MC SHA1:" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Byte1));
    }

    public static void ccsha(){
        System.out.println("CC sha1:"+ DigestUtils.shaHex(src));
    }
}
