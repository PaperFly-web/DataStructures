package tree.threadedBinaryTree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        HeroNode root = new HeroNode(1, "1");
        HeroNode node1 = new HeroNode(3, "3");
        HeroNode node2 = new HeroNode(6, "6");
        HeroNode node3 = new HeroNode(8, "8");
        HeroNode node4 = new HeroNode(10, "10");
        HeroNode node5 = new HeroNode(14, "14");
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setLeft(node5);
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.postThreadedNodes();
        HeroNode right = node4.getRight();
        System.out.println(right);
    }
}


class ThreadedBinaryTree {
    private HeroNode root;
    //为了实现线索化， 需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时， pre 总是保留前一个结点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //重载一下
    public void infixThreadedNodes() {
        this.infixThreadedNodes(root);
    }

    public void preThreadedNodes(){
        this.preThreadedNodes(root);
    }

    public void postThreadedNodes(){
        this.postThreadedNodes(root);
    }
    /**
     * @desc: 线索化节点, 以中序线索化为例
     * @param:[node：就是需要线索化的节点]
     * @return:void
     * @author:paperfly
     * @time:2021/3/28 17:04
     */
    public void infixThreadedNodes(HeroNode node) {
        //先判断需要线索化的节点是不是为null
        if (node == null) {
            return;
        }
        //1）先进行左子树
        infixThreadedNodes(node.getLeft());
        //2）进行线索化
        //处理前驱节点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        //为什么要用pre来判断？
        //因为用node话，就还不能确定下一个节点是谁，所以先找到下一个节点，然后用pre处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //设置前驱节点的右指针类型为   后继节点
            pre.setRightType(1);
        }
        //注意！！！每次处理完一个节点后，都要让pre指向当前节点，然后node在向后走一步
        pre = node;
        //3）进行右子树
        infixThreadedNodes(node.getRight());
    }

    //前序线索化
    public void preThreadedNodes(HeroNode node){
        //先判断需要线索化的节点是不是为null
        if (node == null) {
            return;
        }

        //处理前驱节点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        //为什么要用pre来判断？
        //因为用node话，就还不能确定下一个节点是谁，所以先找到下一个节点，然后用pre处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //设置前驱节点的右指针类型为   后继节点
            pre.setRightType(1);
        }
        //注意！！！每次处理完一个节点后，都要让pre指向当前节点，然后node在向后走一步
        pre = node;
        preThreadedNodes(node.getLeft());
        preThreadedNodes(node.getRight());

    }

    //后序线索化
    public void postThreadedNodes(HeroNode node){
        //先判断需要线索化的节点是不是为null
        if (node == null) {
            return;
        }
        postThreadedNodes(node.getLeft());
        postThreadedNodes(node.getRight());


        //处理前驱节点
        if (node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        //为什么要用pre来判断？
        //因为用node话，就还不能确定下一个节点是谁，所以先找到下一个节点，然后用pre处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱结点的右指针指向当前结点
            pre.setRight(node);
            //设置前驱节点的右指针类型为   后继节点
            pre.setRightType(1);
        }
        //注意！！！每次处理完一个节点后，都要让pre指向当前节点，然后node在向后走一步
        pre = node;
    }
    //中序遍历
    public void infixOrder() {
        HeroNode node = this.root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }

    }


}

//英雄节点
class HeroNode {
    private int no;
    private String name;
    HeroNode left;
    HeroNode right;
    //1. 如果 leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果 rightType == 0 表示指向是右子树, 如果 1 表示指向后继结点
    private int leftType;
    private int rightType;


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
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


}