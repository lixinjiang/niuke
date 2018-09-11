package cn.lxj.treenote;

/**
 * TestBean
 * description 测试Bean
 * create class by lxj 2018/9/10
 **/
public class TestBean extends BaseData{
    public String message;

    @Override
    public int compareTo(BaseData data) {
        if (number == data.number) // 相等，0
            return 0;
        else if (number < data.number) // 小于，-1
            return -1;
        return 1;   // 大于，+1
    }

    public TestBean() {}

    public TestBean(int number, String msg) {
        this.number = number;
        this.message = msg;
    }

    public TestBean(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "number:" + number + ",message:" + message;
    }
}