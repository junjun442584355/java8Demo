package com.wumj.demo.interview;

import com.sun.deploy.util.ArrayUtil;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;
import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wumj
 * @date 2020-07-27 16:13
 */
public class Interview01 {
    @Test
    public void test01() {
        int[] ints = {3, 2, 4};
        int[] ints1 = twoSum(ints, 6);
        Arrays.stream(ints1).forEach(System.out::println);
    }


    /**
     * 两数之和
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 本思路：把数组放入map中，
     * 一层循环，查找target-nums[i]的差值是否存在map中
     * 来源：力扣（LeetCode）
     * <p>
     * 其他思路：
     * 暴力解决，两层循环
     *
     * @param nums
     * @param target
     * @return
     */

    public int[] twoSum(int[] nums, int target) {
        HashMap map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int p = target - nums[i];
            if (map.containsKey(p) && i != (int) map.get(p)) {
                return new int[]{i, (int) map.get(p)};
            }
        }
        return new int[]{-1, -1};
    }

    /*
     * 2. 两数相加
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 本思路：
     * 获取各自对应节点的值：
     * 然后对和值进行对10取模，因为两个数相加可能进位
     * 用flag进行判定是否进位！（i=0,没有进位，i=1，进位）
     *例如
     * （2+5）%10=7，i=0;
     * (4+6)%10=0;i=1;
     * （3+4+1)%10=8；
     * 因为上面进位了，所以这里要+1；
     * 重点：最后要看i为什么，如果为11，则表明最后进位了需要创建一个节点存放1，如：是三位数加上三位数为四位数
     *
     * */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(-1), pre = listNode;
        int i = 0;//表明两个位数相加没有超过9；
        while (l1 != null || l2 != null) {
            int result1 = 0;
            if (l1 != null) {
                result1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                result1 += l2.val;
                l2 = l2.next;
            }
            if (i == 1) {
                result1 += 1;
                i = 0;//归原
            }
            if (result1 > 9) {
                result1 = result1 % 10;
                i = 1;//表明两个位数相加超过9；
            }
            pre.next = new ListNode(result1);
            pre = pre.next;
        }
        if (i == 1) {//说明最好进位了，比如三位数加三位数成四位数，这里很重要
            pre.next = new ListNode(1);
        }
        return listNode.next;
    }

    @Test
    public void test02() {
        ListNode listNode11 = new ListNode(0);
        /*ListNode listNode12=new ListNode(4);
        ListNode listNode13=new ListNode(6);
        listNode11.next=listNode12;
        listNode12.next=listNode13;*/

        ListNode listNode21 = new ListNode(7);
//        ListNode listNode22=new ListNode(3);
//        ListNode listNode23=new ListNode(3);
//        listNode21.next=listNode22;
//        listNode22.next=listNode23;
        ListNode resultNode = addTwoNumbers(listNode11, listNode21);
        while (resultNode != null) {
            System.out.println(resultNode.val + "---->");
            resultNode = resultNode.next;
        }
    }

    /**
     * 寻找两个正序数组的中位数
     * nums1 = [1, 3]
     * nums2 = [2]
     * 则中位数是 2.0
     * <p>
     * 其他思路：
     * 使用System.arraycopy将讲个数组都复制到新数组上，然后使用Arrays.sort（），对新数组进行排序，再取中位数
     * <p>
     * 其他思路：
     * 这个题目可以归结到寻找第k小(大)元素问题，思路可以总结如下：取两个数组中的第k/2个元素进行比较，
     * 如果数组1的元素小于数组2的元素，则说明数组1中的前k/2个元素不可能成为第k个元素的候选，
     * 所以将数组1中的前k/2个元素去掉，组成新数组和数组2求第k-k/2小的元素，因为我们把前k/2个元素去掉了，
     * 所以相应的k值也应该减小。另外就是注意处理一些边界条件问题，比如某一个数组可能为空或者k为1的情况。
     *
     * @param nums1
     * @param nums2
     * @return
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Integer[] result = new Integer[nums1.length + nums2.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= nums1.length) {
                result[index] = nums2[j++];
            } else if (j >= nums2.length) {
                result[index] = nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                result[index] = nums2[j++];
            } else {
                result[index] = nums1[i++];
            }
        }
        if (result.length % 2 == 0) {
            return ((double) (result[result.length / 2 - 1] + result[result.length / 2])) / 2;
        }
        return result[result.length / 2];
    }

    @Test
    public void test03() {
        int[] ints = {1, 2, 3, 4, 5};
        int[] ints1 = {2, 10, 11};
        System.out.println(findMedianSortedArrays(ints, ints1));

    }

    /**
     * 整数反转
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * <p>
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * <p>
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 重点:int数据反转溢出！！！1534236469反转溢出，输出为0；
     *
     * @param x
     * @return
     */

    public int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    @Test
    public void test04() {
        System.out.println(reverse(1534236469));
    }


    /**
     * 这个还没写完，有问题！！！
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int index = 0;
        while (index < str.length() && chars[index] == ' ') {//去掉前面的空格
            index++;
        }
        boolean flag = true;//正
        if (chars[index] == '-') {
            flag = false;
            index++;
        } else if (chars[index] == '+') {
            index++;
        } else if (!Character.isDigit(chars[index])) {
            // 其他符号
            return 0;
        }
        while (index < chars.length && Character.isDigit(chars[index])) {

        }
        return 0;
    }

    @Test
    public void test05() {
        System.out.println(myAtoi("+777 7rrr"));
    }


    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * <p>
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * <p>
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * <p>
     * 思路：将int x转换为char[] 类型，然后再对字符数组进行判定
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 10 && x >= 0)
            return true;
        if (x < 0)
            return false;
        char[] target = String.valueOf(x).toCharArray();
        for (int i = 0; i < target.length / 2; i++) {
            if (target[i] != target[target.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test06() {
        System.out.println(isPalindrome(10));

    }


    /**
     * 有序数组去重
     * 例如：
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 3 并且原数组的前五个元素被修改为 1, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 例如：
     * 给定 nums = [0,0,1,1,1,1,2,3,3]，
     * 函数应返回新长度 length = 4, 并且原数组的前五个元素被修改为 0, 1, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param arr
     * @return
     */

    public int removeDuplicates(int[] arr) {
        if (arr == null)
            return 0;
        if (arr.length == 1)
            return 1;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int i = 0;
        for (Integer in : set) {
            arr[i++] = in;
        }
        return set.size();
    }

    @Test
    public void test07() {
        int[] target = {0, 0, 1, 1, 2, 2, 3, 4, 4, 5, 5, 5, 5, 6};
        int result = removeDuplicates(target);
        System.out.println();
        for (int i = 0; i < result; i++) {
            System.out.println(target[i]);

        }
    }


    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [1,1,1,2,2,3],
     * <p>
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,1,2,3,3],
     * <p>
     * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates2(int[] nums) {
        if (nums == null)
            return 0;
        if (nums.length < 3)
            System.out.println(2);
        int index = 1;//前面0，1不用判定，所以开始index在1 的位置，index表明此标记及之前的都是符合规律的
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {//每次nums[i]都和index的前面一位进行判定（因为可以允许两位相同）
                nums[++index] = nums[i];
            }
        }
        return index + 1;//因为index是从0开始的
    }

    @Test
    public void test08() {
        int[] target = {0, 0, 4, 4, 4, 4, 5, 5, 7, 9, 10, 10};
        int result = removeDuplicates2(target);
        System.out.println("result = " + result);
        for (int i = 0; i < result; i++) {
            System.out.println("i = " + target[i]);
        }

    }

    /**
     * 二叉树的中序遍历
     * 递归
     * 输入: [1,null,2,3]
     * 1
     * \
     * 2
     * /
     * 3
     * <p>
     * 输出: [1,3,2]
     *
     * @param root
     * @return
     */
//递归
    public List<Integer> inorderTraversal(TreeNode2 root) {
        List<Integer> result = new ArrayList();
        if (root == null)
            return result;
        if (root.left != null) {
            List<Integer> result_left = inorderTraversal(root.left);
            result.addAll(result_left);
        }
        result.add(root.val);
        if (root.right != null) {
            List<Integer> result_right = inorderTraversal(root.right);
            result.addAll(result_right);
        }
        return result;
    }

    //非递归,中序
    public List<Integer> inorderTraversal02(TreeNode2 root) {
        List<Integer> result = new ArrayList();
        if (root == null)
            return result;
        Stack<TreeNode2> stack = new Stack<>();
        TreeNode2 node = root;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                result.add(node.val);
                node = node.right;
            }
        }
        return result;
    }

    @Test
    public void test09() {
        TreeNode2 J = new TreeNode2(8, null, null);
        TreeNode2 H = new TreeNode2(4, null, null);
        TreeNode2 G = new TreeNode2(2, null, null);
        TreeNode2 F = new TreeNode2(7, null, J);
        TreeNode2 E = new TreeNode2(5, H, null);
        TreeNode2 D = new TreeNode2(1, null, G);
        TreeNode2 C = new TreeNode2(9, F, null);
        TreeNode2 B = new TreeNode2(3, D, E);
        TreeNode2 A = new TreeNode2(6, B, C);
        List<Integer> result = inorderTraversal02(A);
        System.out.println("result = " + result.size());
        for (Integer in : result) {
            System.out.println("integer = " + in);
        }

    }

    /**
     * 最长回文自串
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     *
     * @param s
     * @return
     */
//暴力解决  时间复杂度O(n^2)
    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.length() == 0)
            return result;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {//索引位置
            for (int j = i + 1; j <= s.length(); j++) {//循环max数：从1到s.length()
                String temp = s.substring(i, j);
                if (isPalindromic(temp) && max < temp.length()) {
                    max = temp.length();
                    result = temp;
                }
            }
        }
        return result;
    }

    //判定是否是回文字符穿
    private boolean isPalindromic(String s) {
        //也可以,使用反转
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        String str = new String(sb);
        return s.equals(str);
       /* char[] chars = s.toCharArray();
        for (int i = 0; i <s.length()/2; i++) {
            if (chars[i]!=chars[s.length()-i-1])
                return false;
        }
        return true;*/
    }

    //中心扩展法
    public String longestPalindrome02(String s) {
        String result = "";
        if (s == null || s.length() == 0)
            return result;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            len1 = Math.max(len1, len2);
            if (len1 > end - start +1) {
                start = i - (len1 - 1) / 2;//因为都是从0开始的
                end = i + len1 / 2;

            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return (right - 1) - (left + 1) + 1;
    }

    @Test
    public void test10() {
        String result = longestPalindrome02("babaab");
//        String result = longestPalindrome("tttty");
        System.out.println("result = " + result);
    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);//排序
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return result;
        for (int i = 0; i < nums.length - 2; i++) {   //第一个数的位置
            if (nums[i] > 0)//因为nums数组是经过排序的，所以第一个数倘若>0，则后面的数都>0，不可能相加为0
                break;
            if (i > 0 && nums[i] == nums[i - 1])//去重，减少操作,此处i>0很重要，第一个数
                continue;
            int second = i + 1;//第二个数的位置
            int third = nums.length - 1; //第三个数的位置
            while (second < third) {
                if (nums[second] + nums[third] < -nums[i]) {
                    second++;
                    /*while (second < third && nums[second] == nums[second - 1]) {  //可加可不加
                        second++; //重复元素，去重
                    }*/
                } else if (nums[second] + nums[third] > -nums[i]) {
                    third--;
                   /* while (second < third && nums[third] == nums[third + 1]) { //可加可不加
                        third--; //重复元素，去重
                    }*/
                } else {
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[second]);
                    item.add(nums[third]);
                    result.add(item);
                    second++;
                    third--;
                    while (second < third && nums[second] == nums[second - 1]) {
                        second++; //重复元素，去重
                    }
                    while (second < third && nums[third] == nums[third + 1]) {
                        third--; //重复元素，去重
                    }
                }
            }
        }
        return result;
    }

    @Test
    public void test11() {
        int[] nums = new int[]{-1, 0, 1};
        List<List<Integer>> result = threeSum(nums);
        System.out.println("result = " + result.size());
        result.stream().forEach(System.out::println);
    }

    /**
     *
     * 无重复的字符的最长字串
     * @param s
     * @return
     */
    int lengthOfLongestSubstring(String s) {  //之前的代码,复杂度O(n^2)
        char[] chars = s.toCharArray();
        int  size,i=0,j,k,max=0;//i是索引，j是判定到哪个位置，就是讲j对应的值跟前面的字符串进行比较，看是否有重复字段
        size = s.length();
        for(j = 0;j<size;j++){
            for(k = i;k<j;k++)
                if(chars[k]==chars[j]){
                    i = k+1;
                    break;
                }
            if(j-i+1 > max)
                max = j-i+1;
        }
        return max;
    }

    @Test
    public void test12() {
        System.out.println(lengthOfLongestSubstring("abcbrfybb"));
//        System.out.println(longestSubstring("abcbbb"));
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode2 {
    int val;
    TreeNode2 left;
    TreeNode2 right;

    TreeNode2(int x) {
        val = x;
    }

    public TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
