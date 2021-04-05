package tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
    }
}
//顺序存储的二叉树
class ArrBinaryTree{
    //用来存放二叉树的数据
    int []arr;
    public ArrBinaryTree(int arr[]){
        this.arr=arr;
    }
    //重载方法，方便调用
    public void preOrder(){
        this.preOrder(0);
    }
    public void infixOrder(){
        this.infixOrder(0);
    }
    public void postOrder(){
        this.postOrder(0);
    }
    //前序遍历
    public void preOrder(int index){
        //先判断这个二叉树是不是空的
        if(arr==null||arr.length==0){
            System.out.println("存储二叉树的数组为空，不能进行前序遍历");
            return;
        }
        //如果不为空，则进行遍历
        //先输出当前
        System.out.println(arr[index]);
        //递归左遍历
        //先判断，左子树是否为空（即，有没有超过数据界限）
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }

        //递归遍历右子树
        //先判断，右子树是否为空（即，有没有超过数据界限）
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    //中序遍历
    public void infixOrder(int index){
        //先判断这个二叉树是不是空的
        if(arr==null||arr.length==0){
            System.out.println("存储二叉树的数组为空，不能进行前序遍历");
            return;
        }
        //递归调用，遍历左子树
        //先判断，左子树是否为空（即，有没有超过数据界限）
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }
        System.out.println(arr[index]);
        //递归遍历右子树
        //先判断，右子树是否为空（即，有没有超过数据界限）
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
    }

    //后序遍历
    public void postOrder(int index){
        //先判断这个二叉树是不是空的
        if(arr==null||arr.length==0){
            System.out.println("存储二叉树的数组为空，不能进行前序遍历");
            return;
        }
        //递归调用，遍历左子树
        //先判断，左子树是否为空（即，有没有超过数据界限）
        if((index*2+1)<arr.length){
            preOrder(index*2+1);
        }

        //递归遍历右子树
        //先判断，右子树是否为空（即，有没有超过数据界限）
        if((index*2+2)<arr.length){
            preOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}