package cn.lxj.code;


import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * DESUtil  对称加密算法
 * Base64可以使用JDk中自带的类实现，还可以使用Bouncy Castle（简称bc）或Commons Codec（简称cc）实现
 * description jdk和bc的实现方式
 * create by lxj 2018/7/16
 **/
public class BaseUtilT {
    private static String src = "Hello DES";

    /**
     * jdk的实现方式
     *
     * @throws IOException
     */
    public static void jdkBase64() throws IOException {
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println("encode:" + encode);

        BASE64Decoder decoder = new BASE64Decoder();
        String decode = new String(decoder.decodeBuffer(encode));
        System.out.println("decode:" + decode);
    }


    /**
     * bc的实现方式
     */
    public static void bouncybastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode: " + new String(encode));

        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("decode: " + new String(decode));
    }

    /**
     * org.apache.commons.codec.binary.Base64的实现方式
     */
    public static void commonscodecBase64() {
        byte[] encode = Base64.encodeBase64(src.getBytes());
        System.out.println("encode: " + new String(encode));  //需要转化为String

        byte[] decode = Base64.decodeBase64(encode);
        System.out.println("decode: " + new String(decode));
    }

    public static void main(String[] args) throws IOException {
        System.out.println("jdk实现方式");
        jdkBase64();
        System.out.println("bc实现方式");
        bouncybastleBase64();
        System.out.println("cc实现方式");

    }
}
