package cn.lxj.code;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * MDUtil2
 * description JDK有MD2和MD5的实现，使用的是MessageDigest类，而没有MD4的实现
 * 而bc这三种都有，使用的是Digest 类
 * create by lxj 2018/7/16
 **/
public class MDUtil2 {

    private static String src = "Hello MD";

    /**
     * jdk的实现
     */
    public static void jdkMD5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(src.getBytes());
            System.out.println("JDK MD5: " + Hex.encodeHexString(digest));           //使用的是cc中带的Hex需要转换为十六进制
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * jdk实现
     */
    public static void jdkMD2() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] digest = md.digest(src.getBytes());
            System.out.println("JDK MD2: " + Hex.encodeHexString(digest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * bc的实现
     */
    public static void bcMD4() {
        //方式一
//        Digest digest=new MD4Digest();
//        digest.update(src.getBytes(), 0, src.getBytes().length);
//        byte[] md4Bytes=new byte[digest.getDigestSize()];
//        digest.doFinal(md4Bytes, 0);
//        System.out.println("BC MD4: "+org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));


        //方式二(通过添加provider的方式，将sun的改为bc的provider)
        try {
            Security.addProvider(new BouncyCastleProvider());  //通过添加provider的方式
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] digest = md.digest(src.getBytes());
            System.out.println("BC MD4: " + Hex.encodeHexString(digest));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * bd的实现
     */
    public static void bcMD5() {
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md4Bytes, 0);
        System.out.println("BC MD5: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    /**
     * bd的实现
     */
    public static void bcMD2() {
        Digest digest = new MD2Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md4Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md4Bytes, 0);
        System.out.println("BC MD2: " + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
    }

    public static void main(String[] args) {
        jdkMD2();
        jdkMD5();
    }


}
