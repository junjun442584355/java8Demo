package com.wumj.demo.interview;

import org.junit.Test;

import java.util.*;

/**
 * @author wumj
 * @date 2020-08-18 10:37
 */
public class Interview02 {
    /**
     * 生成随机的四位数，并且每位数字不重复
     */
    public void generateNum() {
        Random random = new Random();
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        StringBuilder result = new StringBuilder();
        while (result.length() < 4) {
            int temp = random.nextInt(10);
            if (result.length() == 0 && temp == 0)
                continue;
            if (arr[temp] == 0) {
                result.append(temp);
                arr[temp] = 1;
            }
        }
        System.out.println(result);
    }

    public void generateNum2() {
        Random random = new Random();
        HashSet<Integer> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        while (result.length() < 4) {
            int temp = random.nextInt(10);
            if (result.length() == 0 && temp == 0)
                continue;
            if (!set.contains(temp)) {
                result.append(temp);
                set.add(temp);
            }
        }
        System.out.println(result);
    }

    @Test
    public void test01() {
//        generateNum();
        generateNum2();
    }

    /**
     * 回文数
     *
     * @param num
     * @return
     */
    public boolean huiwenshu(int num) {
        if (num < 0)
            return false;
        String target = String.valueOf(num);
        StringBuilder result = new StringBuilder(target).reverse();
        return target.equals(result);
    }

    /**
     * 统计一行字符串，分别统计其英文字母，空格，数字，和其他字符的个数
     */
    public void tongjiNum(String s) {
        System.out.println("英文字母个数：" + (s.length() - s.replaceAll("[a-zA-Z]", "").length()));
        System.out.println("空格个数：" + (s.length() - s.replaceAll(" ", "").length()));
        System.out.println("数字个数：" + (s.length() - s.replaceAll("\\d", "").length()));
        System.out.println("其他字符个数：" + (s.length() - s.replaceAll("[^a-zA-Z\\d ]", "").length()));
    }

    @Test
    public void test02() {
        tongjiNum("gwe 84388r 3f34r 34r3r34r tfef g[ 5]");
        System.out.println("gwe 84388r 3f34r 34r3r34r tfef g[ 5]".trim());
    }

    /**
     * 14 输入某年某月某日，判断这一天是这一年的第几天？
     */
    public int dayOfYearByDateFormat(int year, int month, int day) {
        //暂不实现
        return 0;
    }

    /**
     * 24 给一个不多于5位的正整数，要求：
     * 一、求它是几位数，二、逆序打印出各位数字。
     */
    public void d(int num) {
        String s = String.valueOf(num);
        System.out.println(s.length());
        StringBuilder result = new StringBuilder(s).reverse();
        System.out.println("result = " + result);
    }

    @Test
    public void test04() {
        d(4567);
    }

    /**
     * 31 将一个数组逆序输出。
     */
    public <T> void resversedArray(T[] arr) {
        List<T> list = Arrays.asList(arr);
        Collections.reverse(list);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void test05() {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        resversedArray(a);
    }

    /**
     * 取一个整数a从右端开始的4～7位。
     * int 最大10位够用了
     */
    public void intSub(int num, int start, int end) {
        //思路一：转换为char数组
        char[] chars = String.valueOf(num).toCharArray();
        if (chars.length < end)
            return;
        for (int i = start - 1; i < start + end; i++) {
            System.out.println("i = " + i);
        }

        //思路二：s.substring截取
    }

    @Test
    public void test06() {
        intSub(123456789, 3, 6);
    }

    /**
     * 杨辉三角
     */
    public void yanghuisanjiao(int n) {
        if (n <= 0)
            return;
        int[][] y = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    y[i][j] = 1;
                } else {
                    y[i][j] = y[i - 1][j - 1] + y[i - 1][j];
                }
                System.out.print(y[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public void yanghuisanjiao2(int n) {
        if (n <= 0)
            return;
        int[][] y = new int[n][];
        for (int i = 0; i < y.length; i++) {
            y[i] = new int[i + 1];
            for (int j = 0; j < y[i].length; j++) {
                if (j == 0 || i == j)
                    y[i][j] = 1;
                else
                    y[i][j] = y[i - 1][j - 1] + y[i - 1][j];
                System.out.print(y[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------");

        for (int i = 0; i < y.length; i++) {
            Arrays.stream(y[i]).forEach((t) -> System.out.print(t + "\t"));
            System.out.println();
        }

    }

    public void yanghuisanjiao3(int n) {
        if (n <= 0)
            return;
        for (int i = 0; i < n; i++) {
            int number = 1;
            //打印空格字符串
            System.out.format("%" + (n - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", number);
                number = number * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    @Test
    public void test07() {
//        yanghuisanjiao(10);
        yanghuisanjiao3(10);
    }

    public String trans1(int num, int radix) {
        if (radix == 2)
            return Integer.toBinaryString(num);
        if (radix == 8)
            return Integer.toOctalString(num);
        if (radix == 16)
            return Integer.toHexString(num);
        return null;

    }

    //十进制转换成2，8，16
    public String trans12(int num, int radix) {
        StringBuilder result = new StringBuilder();
        while (num != 0) {
            result.append(num % radix);
            num = num / radix;
        }
        return result.reverse().toString();
    }

    //2，8，16转换成10进制
    //64位2进制转换为10进制
    public Long binary2To10(String binary) {
        //先补足64位进行计算
        StringBuffer sb = new StringBuffer(binary);
        for (int i = 0; i < (64 - binary.length()); i++) {
            sb.insert(0, "0");
        }
        char[] in = sb.toString().toCharArray();
        char[] usea = new char[in.length];
        //首位等于1则为负数,需要取反
        if (in[0] == '1') {
            for (int i = 0; i < in.length; i++) {
                if (in[i] == '1') {
                    usea[i] = '0';
                } else {
                    usea[i] = '1';
                }
            }
        } else {
            usea = in;
        }
        long count = 0;
        for (int i = 0; i < usea.length; i++) {
            count += (long) ((int) ((int) usea[i] - (int) ('0')) * Math.pow(2, (usea.length - 1) - i));
        }
        //首位等于1则为负数, 需要加1再取负数
        if (in[0] == '1') {
            count = -(count + 1);
        }
        return count;
    }

    /**
     * 二进制转10进制，包含小数，
     * 还应该判定是否是负数！！但此处尚未实现，比较复杂
     *
     * @param binary
     * @return
     */
    public double binary2To10_2(String binary) {
        //查找该二进制是否存在小数点
        int index = binary.indexOf('.');
        //转化成的十进制
        double ten = 0;
        //整数部分
        double integer = 0;
        //小数部分
        double decimal = 0;
        //index等于-1，说明没有小数部分
        if (index == -1) {
            for (int i = 0; i < binary.length(); i++) {
                //48为字符'0'对应的ASCII值；
                //ten += (binary.charAt(i) - 48) * Math.pow(2, -(i-(binary.length() - 1)));
                //或者可以将字符转化为字符串，再由字符串转化为数字
                ten += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i - (binary.length() - 1)));
            }
        } else {
            //计算整数部分
            for (int i = 0; i < index; i++) {
                integer += Integer.parseInt(String.valueOf(binary.charAt(i))) * Math.pow(2, -(i - (index - 1)));
            }
            //计算小数部分
            for (int j = index + 1; j < binary.length(); j++) {
                decimal += Integer.parseInt(String.valueOf(binary.charAt(j))) * Math.pow(2, (index - j));
            }
            ten = integer + decimal;
        }
        return ten;
    }

    /**
     * 十进制的负数转换为二进制
     * 思路：
     * -3如何转换成二进制？
     * <p>
     * 首先我们将+3转换成二进制，假设是为int类型(32位)的，那么二进制表示为：
     * <p>
     * 0000 0000 0000 0000 0000 0000 0000 0011
     * －－这称之为原码：一个整数的绝对值的二进制表示称之为原码。
     * <p>
     * 负数转换成二进制分为3步：
     * <p>
     * 1、首先将负数转换为对应的原码
     * <p>
     * -3的原码为(也就是+3转换成二进制后的字符串)：
     * <p>
     * 0000 0000 0000 0000 0000 0000 0000 0011
     * <p>
     * 2、再将原码的每一位做取反操作得到反码。   取反操作：0变为1     1变为0；  取反后的结果即为：
     * <p>
     * 1111 1111 1111 1111 1111 1111 1111 1100
     * <p>
     * 3、将反码+1得到补码
     * <p>
     * 1111 1111 1111 1111 1111 1111 1111 1101
     *
     * @param num
     * @return
     */
    public double _10To2(int num) {
        if (num < 0) {

        } else {

        }
        return 0.0;
    }

    @Test
    public void test08() {
        System.out.println(trans1(100, 8));
        System.out.println(trans12(100, 8));
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 1)
            return 0;
        int start = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                max = Math.max(max, i - start + 1);
            } else {
                start = i;
            }
        }

        return max;
    }

    @Test
    public void test09() {
        int[] a = {1, 2, 3, 2, 3, 4, 5, 7, 8, 0, 1, 2, 3};
        System.out.println(findLengthOfLCIS(a));
    }

    /**
     * 给定一个字符串，找出串中最长连续数字串
     * 例如：
     * str="frfrf3rr4dffdf56r78122334567gg789";
     * 返回34567，和长度5
     *
     * @param str
     * @return
     */
    public Map<String, String> getIncNumber(String str) {
        HashMap<String, String> map = new HashMap<>();
        if (str == null || "".equals(str))
            return null;
        if (str.length() == 1) {
            map.put("result", str);
            map.put("length", String.valueOf(str.length()));
            return map;
        }
        int pos = 0;//记录最终开始位置
        int localPos=0;//记录当前开始位置
        int max = 0;//记录最终长度
        int localMax = 0;//记录当前长度
        if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            max = localMax = 1;
        }else{
            pos=localPos=1;
        }
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {//当前是 数字
                if (localMax != 0 && str.charAt(i) > str.charAt(i - 1)) {//i-1是数字，并且当前连续递增
                    localMax++;
                }else{//i-1是数字，但不是连续递增,i-1不是数字
                    localMax=1;
                    localPos=i;
                }
              //  max = Math.max(max, localMax);
                if (max<localMax){
                    max=localMax;
                    pos=localPos;
                }

            }
        }
        map.put("result",str.substring(pos,pos+max));
        map.put("length",String.valueOf(max));
        return map;
    }

    @Test
    public void test10(){
        Map<String, String> map = getIncNumber("frfrf3rr4dffdf56r78122334567gg789");
        if (map!=null && !map.isEmpty()){
            System.out.println("reslult:"+map.get("result"));
            System.out.println("length = " + map.get("length"));
        }

    }

    /**
     *
     * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
     *
     * 示例:
     *
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     *
     * 方法一：
     * 暴力解决：依次遍历
     * 方法二：
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return 0;
    }
    @Test
    public void test11(){

    }

}

