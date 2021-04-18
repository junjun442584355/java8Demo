package com.wumj.demo.interview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wumj
 * @date 2020-07-26 10:38
 */
class TreeNode {
    int data;
    TreeNode leftNode;
    TreeNode rightNode;

    public TreeNode() {
    }

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}

public class TreeInterview {
    ArrayList<Integer> result = new ArrayList<>();
    public TreeNode initTree() {
        TreeNode J = new TreeNode(8, null, null);
        TreeNode H = new TreeNode(4, null, null);
        TreeNode G = new TreeNode(2, null, null);
        TreeNode F = new TreeNode(7, null, J);
        TreeNode E = new TreeNode(5, H, null);
        TreeNode D = new TreeNode(1, null, G);
        TreeNode C = new TreeNode(9, F, null);
        TreeNode B = new TreeNode(3, D, E);
        TreeNode A = new TreeNode(6, B, C);
        return A;
    }

    public void printNode(TreeNode node) {
        System.out.println(node.getData());

    }

    /**
     * 先序
     *
     * @param root
     */
    public void theFirstTraversal(TreeNode root) {
        printNode(root);
        if (root.getLeftNode() != null) {
            theFirstTraversal(root.getLeftNode());

        }
        if (root.getRightNode() != null) {
            theFirstTraversal(root.getRightNode());

        }


    }

    /**
     * 中序
     *
     * @param root
     */

    public void theInOrderTraversal(TreeNode root) {
        if (root.getLeftNode() != null) {
            theInOrderTraversal(root.getLeftNode());
        }
        result.add(root.data);
        printNode(root);
        if (root.getRightNode() != null) {
            theInOrderTraversal(root.getRightNode());
        }
    }

    /**
     * 后序
     */
    public void thePostOrderTraversal(TreeNode root) {
        if (root.getLeftNode() != null) {
            thePostOrderTraversal(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            thePostOrderTraversal(root.getRightNode());
        }
        printNode(root);
        result.add(root.data);
    }

    /**
     * 递归
     */
    @Test
    public void test1() {
        TreeNode root = initTree();
//        theFirstTraversal(root);
//        theInOrderTraversal(root);
        thePostOrderTraversal(root);
        System.out.println("------------");
        result.stream().forEach(System.out::println);;

    }


    /**
     * 非递归方式
     * 前序
     * 用栈堆
     */

    public void theFirstTraversal_Stack(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || treeNodeStack.size()>0){  //控制整个循环
            if (node!=null){//判定当前节点
                printNode(node);
                treeNodeStack.push(node);
                node=node.getLeftNode();
            }else{
                node=treeNodeStack.pop();
                node=node.getRightNode();
            }
        }

    }
    /*
    * 中序
    * */
    public void theInOrderTraversal_Stack(TreeNode root){
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || treeNodeStack.size()>0){  //控制整个循环
            if (node!=null) {//判定当前节点
                treeNodeStack.push(node);
                node=node.getLeftNode();
            }else{
                node=treeNodeStack.pop();
               printNode(node);
               node=node.getRightNode();

            }
        }

    }

    /**
     * 后续最复杂
     */
    public void thePostOrderTraversal_Stack(TreeNode root){
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode currentNode=root;//当前访问的节点
        TreeNode lastvisitNode=null;//上次访问的节点
        //把currentNode移到左子树的最下边
        while (currentNode!=null){
            treeNodeStack.push(currentNode);
            currentNode=currentNode.getLeftNode();

        }
        while (!treeNodeStack.empty()){
            currentNode = treeNodeStack.pop();
            //一个节点被访问的前提，无右子树或者左子树被访问过
            if (currentNode.getRightNode()!=null&& currentNode.getRightNode()!=lastvisitNode){
                treeNodeStack.push(currentNode);//再次入栈
                currentNode=currentNode.getRightNode();//进入右子树且确定右子树不为空
                while (currentNode!=null){
                    //再走到右子树的最左边
                    treeNodeStack.push(currentNode);
                    currentNode=currentNode.getLeftNode();
                }
            }else{
                printNode(currentNode);
                lastvisitNode=currentNode;
            }
        }

    }

    @Test
    public void test03(){
        TreeNode treeNode = initTree();
//        theFirstTraversal_Stack(treeNode);
//        theInOrderTraversal_Stack(treeNode);
        thePostOrderTraversal_Stack(treeNode);

    }

    /**
     * 获取size
     *
     */
    public int getSize(TreeNode root){
        int size=1;
        if(root.getLeftNode()!=null){
            size+=getSize(root.getLeftNode());
        }
        if(root.getRightNode()!=null)
        {
            size+=getSize(root.getRightNode());

        }
        return size;

    }

    /**
     * 获取高度
     * @param node
     * @return
     */
    public  int getHeightByRecursion(TreeNode node){
        if (node == null) return 0;
        int left = getHeightByRecursion(node.getLeftNode());
        int right = getHeightByRecursion(node.getRightNode());
        if (left > right){
            return left + 1;
        }else {
            return right + 1;
        }
    }
    /**
     * 层次遍历
     */
    public void LaywerTraversal(TreeNode root){
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        TreeNode currentNode;
        while (!list.isEmpty()) {
            currentNode = list.poll();
            printNode(currentNode);
            if (currentNode.getLeftNode() != null) {
                list.add(currentNode.getLeftNode());
            }
            if (currentNode.getRightNode() != null) {
                list.add(currentNode.getRightNode());
            }
        }

    }
    @Test
    public void test2(){
        TreeNode treeNode = initTree();
        int size = getSize(treeNode);
        System.out.println("size = " + size);
        int heightByRecursion = getHeightByRecursion(treeNode);
        System.out.println("heightByRecursion = " + heightByRecursion);
        LaywerTraversal(treeNode);


    }
}
