package cn.lxj.treenote;

/**
 * BaseData
 * description
 * create class by lxj 2018/9/10
 **/
public abstract class BaseData {
    public int number;
    /**
     * 与另一数据对比大小
     * @param data  待对比数据
     * @return  整型值：0   相等； > 0 大于参数； < 0 小于参数
     */
    public abstract int compareTo(BaseData data);
}
