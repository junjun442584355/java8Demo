package com.wumj.demo.interview;

import org.junit.Test;

import java.util.*;

/**
 * @author wumj
 * @date 2020-06-17 18:31
 */
public class SortInterview {
    /*
     * 排序：冒泡，选择，快排，归并排序，堆排序，插入排序
     * */

    /*
     * 若题目只让排序，可以使用容器
     * */
    /*
    * array转换为arraylist:
    *
1:ArrayList<Element> arrayList = new ArrayList<Element>(Arrays.asList(array));
2:List<Element> list = Arrays.asList(array);
    *
    * */
    public <T> void sort(T[] array) {
        ArrayList arrayList1 = new ArrayList(Arrays.asList(array));
        Collections.sort(arrayList1);
        arrayList1.forEach(System.out::println);

        System.out.println("-------------");
        arrayList1.stream()
                .sorted()
                .forEach(System.out::println);


        /*List<T> list1 = Arrays.asList(array);
        list1.forEach(System.out::println);*/


       /* int array_list = array.length;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < array_list; i++) {
            arrayList.add(array[i]);
        }
        arrayList.forEach(System.out::println);*/
    }

    @Test
    public void test() {
        Integer[] a = new Integer[]{4, 7, 12, 4, 45, 23, 9, 7};
        Integer[] a3 = new Integer[]{1, 6, 7, 3, 5, 9, 4, 2};
        sort(a);
    }


    /*
     * 冒牌排序，大的往后
     * */
    public <T extends Comparable> void bubbleSort(T[] list) {
        int list_length = list.length;
        T temp = null;
        for (int i = 0; i < list_length - 1; i++) {
            for (int j = 0; j < list_length - 1 - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        Arrays.stream(list).forEach(System.out::println);
    }

    /*
     * 冒牌排序：大的往后
     * */
    public <T> void bubbleSort2(T[] list, Comparator<T> com) {
        int list_length = list.length;
        T temp = null;
        for (int i = 0; i < list_length - 1; i++) {
            for (int j = 0; j < list_length - 1 - i; j++) {
                if (com.compare(list[j], list[j + 1]) > 0) {
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        Arrays.stream(list).forEach(System.out::println);
    }


    /*
     * 冒泡排序
     * */
    @Test
    public void test1() {
        Integer[] a = new Integer[]{4, 7, 12, 4, 45, 23, 9, 7};
        Integer[] a3 = new Integer[]{1, 6, 7, 3, 5, 9, 4, 2};
        bubbleSortReverse(a);
       /* bubbleSort2(a3, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });*/

        /*bubbleSort2(a3, (x, y) -> x.compareTo(y));
        System.out.println("-------------------------");

        String[] a1 = new String[]{"xxx", "xxv", "ttt", "vvvv", "rrrr"};
        bubbleSort(a1);*/

    }

    /*
     * 选择排序
     * */
    public <T extends Comparable> void selectionSort(T[] list) {
        if (list == null)
            System.out.println("传入数据为空");
        else {
            int list_length = list.length;
            int index = 0;
            for (int i = 0; i < list_length - 1; i++) {
                // 第一处重点index=i;
                index = i;
                for (int j = i + 1; j < list_length; j++) {
                    //  第二处   list[index]
                    if (list[index].compareTo(list[j]) > 0) {
                        index = j;
                    }
                }
                T temp = list[i];
                list[i] = list[index];
                list[index] = temp;
            }

            Arrays.stream(list).forEach(System.out::println);

        }

    }


    /*
     * 选择排序
     * */
    @Test
    public void test2() {
        Integer[] a = new Integer[]{4, 7, 12, 4, 45, 23, 9, 7};
        Integer[] a3 = new Integer[]{1, 6, 7, 3, 5, 9, 4, 2};
        selectionSort(a3);
        System.out.println("------------------------");

        String[] a1 = new String[]{"xxx", "xxv", "ttt", "vvvv", "rrrr"};
        selectionSort(a1);
    }


    /*
     * 快排
     * */
    public <T extends Comparable> void quickSort(T[] list) {
        if (list == null && list.length == 0) {
            System.out.println("输入数据为空");
            return;
        }
        quickSortAction(list, 0, list.length - 1);
        Arrays.stream(list).forEach(System.out::println);
    }

    public <T extends Comparable> void quickSortAction(T[] list, int begin, int end) {
        if(begin > end)
            return;
        T tmp = list[begin];
        int i = begin;
        int j = end;
        while(i != j){
            while(list[j].compareTo(tmp) >=0  && j > i)
                j--;
            while(list[i].compareTo(tmp) <=0 && j > i)
                i++;
            if(j > i){
                T t = list[i];
                list[i] = list[j];
                list[j] = t;
            }
        }
        list[begin] = list[i];
        list[i] = tmp;
        quickSortAction(list, begin, i-1);
        quickSortAction(list, i+1, end);


    }


/*
* 快排
* */
    @Test
    public void test3(){
        Integer[] a = new Integer[]{4, 7, 12, 4, 45, 23, 9, 7};
        Integer[] a3 = new Integer[]{1, 6, 7, 3, 5, 9, 4, 2};
        quickSort(a);

    }


    /*
    * 冒泡排序：逆序，小的冒泡
    * */
    public <T extends Comparable> void bubbleSortReverse(T[] list){
        int list_length=list.length;
        for (int i = 0; i < list_length-1; i++) {
            for (int j = list_length-1; j > i; j--) {
                if(list[j].compareTo(list[j-1])<0){
                    T temp=list[j];
                    list[j]=list[j-1];
                    list[j-1]=temp;

                }            }
        }
        Arrays.stream(list).forEach(System.out::println);
    }

    @Test
    public void test5() {
        Integer[] a = new Integer[]{4, 7, 12, 4, 45, 23, 9, 7};
        Integer[] a3 = new Integer[]{1, 6, 7, 3, 5, 9, 4, 2};
        bubbleSortReverse(a3);
    }


//    归并排序
    public Integer[] MergeSort(Integer[] array){
        if (array.length < 2)
            return array;
        int mid=array.length/2;
        Integer[] left=Arrays.copyOfRange(array,0,mid);
        Integer[] right=Arrays.copyOfRange(array, mid,array.length);
        return Merge(MergeSort(left),MergeSort(right));

    }
    public Integer[] Merge(Integer[] left,Integer[] right){
//        Class<? extends Comparable[]> aClass = leftNode.getClass();
//        T[] result = (T[])Array.newInstance(leftNode.getClass(),leftNode.length + rightNode.length);
//        T[] result = (T[]) new Comparable[leftNode.length + rightNode.length];
        Integer[] result=new Integer[left.length + right.length];
//        index是result的索引，i是left[],j是right[]的
         for (int index=0,i=0,j=0;index<result.length;index++){
             if(i>=left.length){
                result[index]=right[j++];
             }  else if (j>=right.length){
                 result[index]=left[i++];
             } else if (left[i].compareTo(right[j])>0){
                 result[index]=right[j++];
             }else{
                 result[index]=left[i++];
             }
         }
         return result;

    }
    @Test
    public void test06(){
        Integer[] a3 = new Integer[]{1, 2, 4,6,9,5,23,11};
        Integer[] result=MergeSort(a3);
        Arrays.stream(result)
                .forEach(System.out::println);
    }

//    查找
//    1、顺序查找
//    2、二分查找
//    非递归
    public <T extends Comparable>int binarySearch(T[] array,T target){
        int start=0;
        int end=array.length-1;

        while(start<=end){
//            mid=low+(key-a[low])/(a[high]-a[low])*(high-low)  对于表长较大，而关键字分布又比较均匀的查找表来说，
//            插值查找算法的平均性能比折半查找要好的多。
//            反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。
            int mid=(start+end)/2;
            if(array[mid].compareTo(target)==0){
                return mid;
            }else if(array[mid].compareTo(target)<0){
                start=mid+1;
            }else {
                end = mid - 1;
            }
        }
        return  -1;
    }
//递归
    public <T extends Comparable>int binarySearch1(T[] array,T target,int start,int end){
        /*target不存在*/
        if (start==end && array[end].compareTo(target)!=0){
            return -1;
        }
        int mid=start+(end-start)/2;
        if (array[mid].compareTo(target)==0)
            return mid;
        if(array[mid].compareTo(target)>0)
            return binarySearch1(array,target,start,mid-1);
        else
            return binarySearch1(array,target,mid+1,end);
    }

    @Test
    public void test07(){
        Integer[] a=new Integer[]{0,1,2,3,4,5,6,7,9};
        System.out.println(binarySearch1(a,-9,0,a.length-1));
    }

}
