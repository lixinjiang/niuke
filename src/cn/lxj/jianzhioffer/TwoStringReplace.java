package cn.lxj.jianzhioffer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class TwoStringReplace {
    public String replaceSpace(StringBuffer sbf) {
        boolean flag = true;
        while (flag) {
            int num = 0;
            int temp = sbf.indexOf(" ", num);
            if (temp == -1) {
                return sbf.toString();
            } else {
                sbf.replace(temp, temp + 1, "%20");
                num = temp;
            }
        }
        return sbf.toString();
    }
}
