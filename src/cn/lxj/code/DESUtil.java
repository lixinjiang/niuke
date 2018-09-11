package cn.lxj.code;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Security;

/**
 * DESUtil  对称加密算法
 * description  对称加密算法主要分为:DES , 3DES(3重DES) , AES(想要替代DES)  , PBE(基于口令的对称算法)
 * create by lxj 2018/7/16
 **/
public class DESUtil {
    private static String src = "Hello DES";

    /**
     * jdk实现
     */
    public static void jdkDES() {
        try {
            //生成key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");//des加密算法
            keyGenerator.init(56);      //指定key长度，同时也是密钥长度(56位)
            SecretKey secretKey = keyGenerator.generateKey(); //生成key的材料
            byte[] key = secretKey.getEncoded();  //生成key
            System.out.println(new String(key, "ISO8859-1"));

            //key转换成密钥
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);      //转换后的密钥

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  // 算法类型/工作方式/填充方式
            cipher.init(Cipher.ENCRYPT_MODE, key2);   //指定为加密模式
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdkDES加密: " + Hex.encodeHexString(result));  //转换为十六进制

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key2);  //相同密钥，指定为解密模式
            result = cipher.doFinal(result);   //根据加密内容解密
            System.out.println("jdkDES解密: " + new String(result));  //转换字符串

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * bc实现方式
     */
    public static void bcDES() {
        try {
            //通过改变provider的方式
            Security.addProvider(new BouncyCastleProvider());

            //生成key,使用bc需要在后面指定"BC"
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");

            keyGenerator.getProvider();

            keyGenerator.init(56);      //指定key长度，同时也是密钥长度
            SecretKey secretKey = keyGenerator.generateKey(); //生成key的材料
            byte[] key = secretKey.getEncoded();  //生成key

            //key转换成密钥
            DESKeySpec desKeySpec = new DESKeySpec(key);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            SecretKey key2 = factory.generateSecret(desKeySpec);      //转换后的密钥

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");  //算法类型/工作方式/填充方式
            cipher.init(Cipher.ENCRYPT_MODE, key2);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("bcDES加密: " + Hex.encodeHexString(result));  //转换为十六进制

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key2);  //相同密钥
            result = cipher.doFinal(result);   //根据加密内容解密
            System.out.println("bcDES解密: " + new String(result));  //转换字符串

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        jdkDES();
        bcDES();
    }
}
