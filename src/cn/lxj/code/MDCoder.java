package cn.lxj.code;

import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * MD
 * description 单向加密
 * MD(Message Digest algorithm ，信息摘要算法)通常我们不直接使用上述MD加密。通常将MD产生的字节数组交给BASE再加密一把，得到相应的字符串
 * create by lxj 2018/7/16
 **/
public class MDCoder {
    public static final String KEY_MD5 = "MD5";
    public static final String KEY_MD2 = "MD2";
    public static final String KEY_MD4 = "MD4";

    public static String getResult(String inputStr, String keyMd) throws NoSuchAlgorithmException {
        System.out.println("=======加密前的数据:" + inputStr);
        BigInteger bigInteger = null;
        MessageDigest md = MessageDigest.getInstance(keyMd);
        byte[] inputData = inputStr.getBytes();
        md.update(inputData);
        bigInteger = new BigInteger(md.digest());
        System.out.println(keyMd + "=============加密后：" + bigInteger.toString());
        return bigInteger.toString();
    }

    /**
     * MD2加密
     *
     * @param data
     * @return
     */
    public static String encodeMd2(byte[] data) throws NoSuchAlgorithmException {
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance(MDCoder.KEY_MD2);
        // 执行摘要信息
        byte[] digest = md.digest(data);
        // 将摘要信息转换为32位的十六进制字符串
        return new String(new HexBinaryAdapter().marshal(digest));
    }

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static String encodeMd5(byte[] data) throws Exception {
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance(MDCoder.KEY_MD5);
        // 执行摘要信息
        byte[] digest = md.digest(data);
        // 将摘要信息转换为32位的十六进制字符串
        return new String(new HexBinaryAdapter().marshal(digest));
    }

    /**
     * md4加密  BouncyCastle补充的MD4算法的应用
     *
     * @param data
     * @return
     */
    public static String encodeMd4(byte[] data) throws NoSuchAlgorithmException {
        //加入BouncyCastle的支持
        Security.addProvider(new BouncyCastleProvider());
        // 初始化MessageDigest
        MessageDigest md = MessageDigest.getInstance(MDCoder.KEY_MD4);
        //执行摘要信息
        byte[] digest = md.digest(data);
        //将摘要信息转换为32位的十六进制字符串
        return new String(Hex.encode(digest));
    }

    /**
     * Commons Codec提供的实现,Commons Codec提供了消息摘要的工具类-----DigestUtils类。DigestUtils类是对Sun提供的MessageDigest类的一次封装，提供了MD5
     * 和SHA系列消息摘要算法的实现。
     *
     * @param data
     * @return
     * @throws Exception
     */
    // MD5加密 返回十六进制的字符串
    public static String encodeMd5Hex(byte[] data) throws Exception {
        return DigestUtils.md5Hex(data);
    }

    /**
     * MD5加密,返回十进制的字节数组
     *
     * @param data
     * @return
     */
    public static byte[] encodeMd52(byte[] data) {
        return DigestUtils.md5(data);
    }

    public static void main(String[] args) throws Exception {
        String inputString = "简单加密欧拉欧拉";
        getResult(inputString, MDCoder.KEY_MD2);
        getResult(inputString, MDCoder.KEY_MD5);
        System.out.println("-------------------------------------------");
        System.out.println(MDCoder.encodeMd2(inputString.getBytes()));
        System.out.println(MDCoder.encodeMd5(inputString.getBytes()));
        System.out.println(MDCoder.encodeMd4(inputString.getBytes()));
        //十六进制字符串
        System.out.println(MDCoder.encodeMd5Hex(inputString.getBytes()));
        //字符数组
        System.out.println(new String(org.apache.commons.codec.binary.Hex.encodeHex(MDCoder.encodeMd52(inputString
                .getBytes()))));

    }
}