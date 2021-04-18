package com.wumj.demo.interview;

import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.junit.Test;
import sun.print.SunMinMaxPage;

import javax.print.attribute.standard.RequestingUserName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author wumj
 * @date 2021-01-08 15:04
 */

/**
 * 回溯公式
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class Interview03 {
    /**
     * 任何两个皇后都不能处于同一条横行、纵行或斜线上。
     * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
     * 输入：n = 1
     * 输出：[["Q"]]
     *
     * 思路：回溯
     * @param n
     * @return
     */
    List<List<String>> result = new ArrayList<>();//存放n皇后结果
    public List<List<String>> solveNQueens(int n) {
        if (n <1){
            System.out.println("参数有误");
            return null;
        }
        char[][] arr = initArr(n);//初始化
        nQueens(arr,0);
        return result;
    }

    private void nQueens(char[][] arr,int rows){
        if (rows==arr.length){//成功，重点
            List<String> list = getList(arr);
            result.add(list);
       //     list.stream().forEach(System.out::println);
            return;
        }
        for (int j = 0; j < arr[rows].length; j++) {
            if (isExist(arr,rows,j)){
                arr[rows][j]='Q';
                nQueens(arr,rows+1);//下一行,此处是重点
                arr[rows][j]='.';//回溯
            }
        }
    }

    /**
     * n皇后判定该位置能否放
     * @param arr
     * @param x 横坐标轴
     * @param y 纵坐标轴
     * @return
     */
    private boolean isExist(char [][] arr, int x, int y){
       /* for (int i = 0; i < arr[x].length; i++) {//该点的横线上判定
            if ('Q' == arr[x][i])
                return false;
        }*/
        for (int j= 0; j < arr.length; j++) {//该点的竖线上进行判定
            if ('Q' == arr[j][y])
                return false;
        }
        //判定对角线（主对角线）
        for (int i = x,j = y ; i < arr.length && j < arr[x].length ; i++,j++) {
            if ('Q' == arr[i][j])
                return false;
        }
        for (int i = x,j = y ; i >= 0 && j >= 0 ; i--,j--){
            if ('Q' == arr[i][j])
                return false;
        }
        //副对角线
        for (int i = x,j = y ; i < arr.length && j >= 0 ; i++,j--) {
            if ('Q' == arr[i][j])
                return false;
        }
        for (int i = x,j = y ; i >= 0 && j < arr[x].length ; i--,j++) {
            if ('Q' == arr[i][j])
                return false;
        }
        return true;
    }

    //初始化数组
    private char[][] initArr(Integer n){
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        return arr;
    }

    /**
     * 将数组转换为需要的输出格式
     * @param arr
     * @return
     */
    private  List<String> getList(char [][] arr){
       /* for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }*/
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new String(arr[i]));
        }
        return list;
    }

    /**
     * n皇后
     */
    @Test
    public void test01(){
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            list.stream().forEach(System.out::println);
        }
    }


    /**
     * 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 输入: [-2,1,-3,4,-1,2,1,-5,4]
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     *
     * 思路1：普通计算
     * 思路2：分治法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int result=nums[0];
        int temp=0;
        for (int num : nums) {
            if (temp >0){
                temp+=num;
            }else{
                temp=num;
            }
            result=Math.max(temp,result);
        }
        return result;
    }
    public int maxSubArray2(int[] nums) {
        return 0;
    }
    /**
     * 最大子序和
     */
    @Test
    public void test02(){
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray1(nums);
        System.out.println("i = " + i);
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n==0)
            return 1;
        if (n >0 )
            ;
        return 1;
    }
    @Test
    public void test03(){

    }

    /**
     * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] flagArr = getFlag(matrix.length, matrix[0].length);
        return null;
    }
    private int[][] getFlag(int m,int n){
        char[][] flagArr = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flagArr[i][j]='F';
            }
        }
        return null;
    }

    @Test
    public void test04(){

    }

    /**
     * 无重复字符的最长子串
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * 方法一：滑窗法
     * @param s
     * @return
     *
     */
    public int lengthOfLongestSubstring01(String s) {//此方法时间复杂度过高
        int length = s.length();
        int result=0;
        for (int i = 1; i <= length; i++) {//滑窗
            for (int j = 0; j <= length - i; j++) {
                if(lengthOfLongestSubstring01Arr(s,j,j+i)){
                    result=i;
                    break;
                }
            }
        }
        return result;
    }
    private boolean lengthOfLongestSubstring01Arr(String s, int start,int end){

        HashSet<Character> chars = new HashSet<>();
        for (int i = start; i < end; i++) {
            chars.add(s.charAt(i));
        }
        if (chars.size()==end-start)
            return true;
        else
            return false;
    }

    public int lengthOfLongestSubstring02(String s) {

        return 0;
    }
    @Test
    public void test05(){
        String s = "pwwkew";
        int i = lengthOfLongestSubstring01(s);
        System.out.println("i = " + i);
        /* int j = 0;
        for (int i = 0; i < 100; i++) {
            j = j++;
        }
        System.out.println(j);*/
    }

    /**
     * Z 字形变换
     * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
     *
     * P   A   H   N
     * A P L S I` I G
     * Y   I   R
     * 输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        return null;
    }


    /**
     * 全排列
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列
     * 输入: [1,2,3]
     * 输出:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * 思路：回溯
     * * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(result,list,nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums){
        if (list.size()==nums.length){
            result.add(new ArrayList<Integer>(list));
            //此处不能写result.add(list）,不然会是空的
            return;
        }
        for (int num : nums) {
            if (!list.contains(num)){
                list.add(num);
                backtrack(result,list,nums);
                list.remove(list.size()-1);
            }
        }
    }


    @Test
    public void test06(){
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        for (List<Integer> list : permute) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }
    }

    /**
     *  全排列 II
     *  给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     *  输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     *  [1,2,1],
     *  [2,1,1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    @Test
    public void test07(){
    }

}
