package cn.lxj.jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution34
 * description
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 * create class by lxj 2018/9/12
 **/
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        List<Character> characters = new ArrayList<>();
        Set<Character> removedChars = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!characters.contains(c) && !removedChars.contains(c)){
                characters.add(Character.valueOf(c));
            } else{
                characters.remove(Character.valueOf(c));
                removedChars.add(c);
            }
        }
        if (characters.size() == 0) return -1;
        return str.indexOf(characters.get(0));
    }
}