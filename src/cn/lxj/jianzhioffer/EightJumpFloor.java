package cn.lxj.jianzhioffer;

import org.junit.Test;

/**
 * @ClassName EightJumpFloor
 * @Description 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @Author lxj
 * @Date 2018/4/17
 **/
public class EightJumpFloor {
    public int JumpFloor(int target) {
        // 也是用递归 f(n) = f(n-1) + f(n-2)
        if(target <= 0){
            return -1;
        }else if(target == 1 || target == 2){
            return target;
        }else {
            return JumpFloor(target-1) + JumpFloor(target-2);
        }
    }
    @Test
    public void test(){
        System.out.println(JumpFloor(10));
    }
}
