package tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        binaryTree.setRoot(node1);
        System.out.println("删除前节点，前序遍历");
        binaryTree.preOrder();
        binaryTree.delNode(3);
        System.out.println("删除后，前序遍历");
        binaryTree.preOrder();
//        System.out.println("前序遍历");
//        tree.perOrder();
//        System.out.println("中序遍历");
//        tree.infixOrder();
//        System.out.println("后序遍历");
//        tree.postOrder();
    }
}

class BinaryTree{
    private HeroNode root;

    public void setRoot(HeroNode root){
        this.root=root;
    }

    //前序遍历
    public void preOrder(){
        if(this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }
    //中序遍历
    public void infixOrder(){
        if(this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }
    //后序遍历
    public void postOrder(){
        if(this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

    //删除结点
    public boolean delNode(int no){
        boolean isDel=false;
        //先判断根节点是否为null,如果不为空，再看看根节点是不是要删除的
        if(this.root!=null){
            if(this.root.getNo()==no){
                this.root=null;
                isDel=true;
            }else {
                isDel=this.root.delNode(no);
            }
        }
        return isDel;
    }
    //前序查找
    public HeroNode preOrderSearch(int no){
        if(this.root!=null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }
    //中序查找
    public HeroNode infixOrderSearch(int no){
        if(this.root!=null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }
    //前序查找
    public HeroNode postOrderSearch(int no){
        if(this.root!=null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}

//英雄节点
class HeroNode{
    private int no;
    private String name;
    HeroNode left;
    HeroNode right;
    public HeroNode(int no,String  name){
        this.no=no;
        this.name=name;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //前序遍历：根左右
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }

    //中序遍历：左根右
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }

    //后序遍历：左右根
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    //删除节点
    //规定
    // 1. 如果删除的节点是叶子节点， 则删除该节点
    // 2. 如果删除的节点是非叶子节点， 则删除该子树
    public boolean delNode(int no){
        //比对左子结点，是否是要删除的
        if(this.left!=null&&this.left.no==no){
            this.left=null;
            return true;
        }
        //如果左子结点没有找到，就找右子结点
        if(this.right!=null&&this.right.no==no){
            this.right=null;
            return true;
        }
        boolean isFind=false;
        //如果左右子结点都没有找到，就先进行左递归
        if(this.left!=null){
            isFind=this.left.delNode(no);
            //如果左递归找到了，并且删除后就直接返回
            if(isFind){
                return isFind;
            }
        }

        //进行右递归
        if(this.right!=null){
            isFind=this.right.delNode(no);
        }
        //最后无论找没找到，我就直接返回isFind
        return isFind;
    }

    //前序遍历查找
    public HeroNode preOrderSearch(int no){
        //如果和当前节点相等，就直接返回
        if(this.no==no){
            return this;
        }
        HeroNode heroNode=null;
        //如果父节点不相等，就递归遍历左子树
        if(this.left!=null){
            heroNode = this.left.preOrderSearch(no);
        }
        //如果不为空，就说明找到了，直接返回
        if(heroNode!=null){
            return heroNode;
        }
        //如果还没有找到，就递归遍历右子树
        if(this.right!=null){
            heroNode=this.right.preOrderSearch(no);
        }
        //不管你最后找没找到，我就直接返回heroNode
        return heroNode;
    }


    //中序遍历查找
    public HeroNode infixOrderSearch(int no){
        HeroNode heroNode=null;
        if(this.left!=null){
            heroNode = this.left.infixOrderSearch(no);
        }
        //如果heroNode不等于null就说明，左子树查找到了
        if(heroNode!=null){
            return heroNode;
        }
        //如果左子树没查找到，就看看当前自己等不等于
        if(this.no==no){
            return this;
        }
        //如果当前自己也不等于，就递归调用右子树
        if(this.right!=null){
            heroNode = this.right.infixOrderSearch(no);
        }
        //最后不管你找没找到，我就直接返回heroNode
        return heroNode;
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no){
        HeroNode heroNode=null;
        if(this.left!=null){
            heroNode=this.left.postOrderSearch(no);
        }
        //如果左子树找到了，就直接返回
        if(heroNode!=null){
            return heroNode;
        }

        if(this.right!=null){
            heroNode=this.right.postOrderSearch(no);
        }
        //如果右子树找到了，就直接返回
        if(heroNode!=null){
            return heroNode;
        }
        //如果左子树，右子树都没找到，就看看自己是不是
        if(this.no==no){
            return this;
        }
        //不管你找没找到，最后我就直接返回个heroNode就好了
        return heroNode;
    }
}