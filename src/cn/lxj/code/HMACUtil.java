package cn.lxj.code;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * HMACUtil 对称加密算法
 * description 含有秘钥的摘要算法，也简称mac，秘钥不同摘要也不同
 * create by lxj 2018/7/16
 **/
public class HMACUtil {
    private static String src = "Hello HMAC";

    /**
     * JDK实现
     */
    public static void jdkHmacMD5() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");  //初始化KeyGenerator
            SecretKey secretKey = keyGenerator.generateKey(); //产生密钥
            //byte[] key=secretKey.getEncoded();     //获得密钥(默认生成)

            byte[] key = Hex.decodeHex(new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});  //手动生成密钥(十位)

            SecretKey secretKey2 = new SecretKeySpec(key, "HmacMD5"); //还原密钥
            Mac mac = Mac.getInstance(secretKey2.getAlgorithm());  //实例化mac
            //初始化mac
            mac.init(secretKey2);
            byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
            System.out.println("jdk hmacMD5: " + Hex.encodeHexString(hmacMD5Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * bc实现
     */
    public static void bcHmacMd5() {
        HMac hMac = new HMac(new MD5Digest());
        hMac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));  //需要十位密钥
        hMac.update(src.getBytes(), 0, src.getBytes().length);

        byte[] hmacMD5 = new byte[hMac.getMacSize()];
        hMac.doFinal(hmacMD5, 0);
        System.out.println("bc hmacMD5: " + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5));
    }

    public static void main(String[] args) {
        jdkHmacMD5();
        bcHmacMd5();
    }
}