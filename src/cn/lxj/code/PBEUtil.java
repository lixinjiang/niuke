package cn.lxj.code;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * PBEUtil
 * description 基于口令的<p>对称加密算法</p>
 * 它其实是对之前的算法的包装，比如说MD5和DES，我这里就是的是对MD5和DES包装的PBE算法，还有其他类型的PBE
 * 口令就是我们俗话说的密码，PBE中有一个salt（盐）的概念，盐就是干扰码
 * create by lxj 2018/7/16
 **/
public class PBEUtil {
    private static String src = "Hello PBE";

    /**
     * JDK实现
     */
    public static void jdkPBE() {
        try {
            //初始化盐
            SecureRandom random = new SecureRandom();
            byte[] salt = random.generateSeed(8);   //指定为8位的盐 （盐就是干扰码，通过添加干扰码增加安全）

            //口令和密钥
            String password = "lynu";              //口令
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key = factory.generateSecret(pbeKeySpec);  //密钥

            //加密
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);   //参数规范，第一个参数是盐，第二个是迭代次数（经过散列函数多次迭代）
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE, key, pbeParameterSpec);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk PBE加密: " + Base64.encodeBase64String(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key, pbeParameterSpec);
            result = cipher.doFinal(result);
            System.out.println("jdk PBE解密: " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
