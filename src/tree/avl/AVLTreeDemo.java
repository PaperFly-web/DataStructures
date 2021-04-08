package tree.avl;



public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        ALVTree avlTree = new ALVTree();
        //循环的添加结点到二叉排序树
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
//        System.out.println(avlTree.getRoot().leftHeight());
//        avlTree.infixOrder();
//        System.out.println(avlTree.getRoot().right.left);
    }

}

class ALVTree{
    private Node root;

    public Node getRoot(){
        return root;
    }
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }

    //查找目标target
    public Node search(int value) {
        if (root != null) {
            return root.search(value);
        } else {
            return null;
        }
    }

    //查找目标节点的父节点
    public Node searchParent(int value) {
        if (root != null) {
            return root.searchParent(value);
        } else {
            return null;
        }
    }

    //删除节点
    public void delNode(int value) {
        if (root == null) {//如果root为空，就不用删除了
            return;
        }

        //单独处理，如果要删除的是根节点,并且删除的树是  光杆或者只有一个子树
        //如果要删除的是根节点，但是这个树有2个子树，那么可以满足 =》 删除的节点，有2个子树，后面程序会处理
        if (root.value == value&&root.left==null&&root.right==null) {
            root = null;
            return;
        }else if (root.value==value&&root.left!=null&&root.right==null){
            this.root=this.root.left;
            return;
        }else if(root.value==value&&root.left==null&&root.right!=null){
            this.root=this.root.right;
            return;
        }
        //找到要删除的目标节点和它的父结点
        Node target = root.search(value);
        Node parent = root.searchParent(value);

        //1）如果要删除的是叶子节点
        if (target.left == null && target.right == null) {
            //就直接把目标节点置为空，就完事
            if (parent.right == target) {
                parent.right = null;
            } else {
                parent.left = null;
            }
            return;
        }
        //2)如果要删除的节点是有一个子树的
        if (target.left != null && target.right == null) {

            //还要判断，目标节点是父节点的左子树还是右子树
            if (parent.left.value == value) {
                parent.left = target.left;
            } else {
                parent.right = target.left;
            }
            return;
        } else if (target.right != null && target.left == null) {
            //还要判断，目标节点是父节点的左子树还是右子树
            if (parent.left.value == value) {
                parent.left = target.right;
            } else {
                parent.right = target.right;
            }
            return;
        }

        //到这里了，就一定是2个子树的了
        //3) 如果要删除的节点，有2个子树

        //右子树最小节点的父节点
        Node minNodeParent = target.searchRigthMinParent();
        //右子树最小节点
        Node minNode = target.searchRigthMin();
        //targetNode.value = temp
        target.value = minNode.value;

        //删除右子树中最小的节点
        if (minNodeParent.left == minNode) {
            minNodeParent.left = null;
        } else {
            minNodeParent.right = null;
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }
}


class Node {
    int value;
    Node left;
    Node right;


    public Node(int value) {
        this.value = value;
    }

    /**
     * RR类型
     */
    public void rrRoate(){
        //1),创建一个新的节点，值为当前节点的值
        Node newNode = new Node(this.value);
        //2)让新节点的右指针，指向当前节点  右子结点的左节点
        newNode.right=this.right.left;
        //3）新节点的左指针，指向当前节点的左子树
        newNode.left=this.left;
        //4）让当前节点的值，等于右子结点的值
        this.value=this.right.value;
        //5)让当前节点的右指针，指向当前节点的右子树的右子树
        this.right=this.right.right;
        //6)让当前结点的左指针，指向新创建的节点
        this.left=newNode;
    }

    /**
     * LL类型
     */
    public void llRoate(){
        //1)创建一个新的结点，值为当前节点的值
        Node newNode = new Node(this.value);
        //2)让新节点的左指针，指向当前节点  左子结点的右节点
        newNode.left=this.left.right;
        //3）新节点的右指针，指向当前节点的右子树
        newNode.right=this.right;
        //4)让当前节点的值，等于左子结点的值
        this.value=this.left.value;
        //5)让当前节点的左指针，指向当前节点的左子树的左子树
        this.left=this.left.left;
        //6)让当前结点的右指针，指向新创建的节点
        this.right=newNode;
    }

    /**
     * LR型
     */
    public void lrRoate(){
        //1)把当前节点的左子树，进行一次RR
        this.left.rrRoate();
        //2)在对当前节点进行一次ll
        this.llRoate();
    }

    /**
     * RL型
     */
    public void rlRoate(){
        //1)把当前节点的右子树，进行一次LL
        this.right.llRoate();
        //2)在对当前节点进行一次ll
        this.rrRoate();
    }
    /**
     * 查找以当前节点为根节点，左子树的高度
     * @return
     */
    public int leftHeight(){
        if(left==null){
            return 0;
        }
        return left.height();
    }

    /**
     * 查找以当前节点为根节点，右子树的高度
     * @return
     */
    public int rightHeight(){
        if(right==null){
            return 0;
        }
        return right.height();
    }
    /**
     * 查找以当前节点为根节点，树的高度
     * @return
     */
    public int height(){

        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    /**
     * 搜索结点,查找到就返回结点，找不到就返回null
     *
     * @param value 要查找的值
     * @return
     */
    public Node search(int value) {
        if (this.value == value) {
            return this;
        } else {
            if (value < this.value) {//如果小于当前节点，就像左子树遍历
                if (this.left != null) {//左子树不为空，才能向左子树遍历
                    return this.left.search(value);
                } else {//如果左子树为空，就遍历结束，返回null
                    return null;
                }
            } else {//如果大于当前节点，就向右子树遍历
                if (this.right != null) {//右子树不为空，才能向右子树遍历
                    return this.right.search(value);
                } else {
                    return null;
                }
            }
        }
    }

    /**
     * 查询当前目标节点的父节点
     *
     * @param value 要查找的值
     * @return
     */
    public Node searchParent(int value) {
        //左子树或者右子树不为空，并且和value相等，就返回
        if ((this.left != null && this.left.value == value)
                || (this.right != null && this.right.value == value)) {
            return this;
        }

        if (value < this.value) {//如果小于当前节点，就像左子树遍历
            if (this.left != null) {//左子树不为空，才能向左子树遍历
                return this.left.searchParent(value);
            } else {//如果左子树为空，就遍历结束，返回null
                return null;
            }
        } else {//如果大于当前节点，就向右子树遍历
            if (this.right != null) {//右子树不为空，才能向右子树遍历
                return this.right.searchParent(value);
            } else {
                return null;
            }
        }
    }

    //添加结点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        //如果小于当前结点值，就挂到左子树
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {//如果大于等于，就挂到右子树
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }

        //在添加节点的时候，进行平衡二叉树
        //1)左子树，大于右子树的情况
        if ((this.leftHeight()-this.rightHeight())>1){
            //先判断是LL型，还是LR型
            //1.2）判断是不是LL型
            //如果左指针的左子树高度，大于左指针的右子树高度，说明就是LL型
            if(this.left.leftHeight()>this.left.rightHeight()){
                this.llRoate();
            }else {//否则就是LR型
                this.lrRoate();
            }
            return;
        }

        //2)右子树大于左子树的情况
        if ((this.rightHeight()-this.leftHeight())>1){
            //先判断是RR型，还是RL型
            //1.2）判断是不是RR型
            //如果左指针的左子树高度，大于左指针的右子树高度，说明就是LL型
            if(this.right.rightHeight()>this.right.leftHeight()){
                this.rrRoate();
            }else {//否则就是RL型
                this.rlRoate();
            }
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    private Node searchRigthMin(Node node) {
        if (node.left != null) {
            return searchRigthMin(node.left);
        } else {
            return node;
        }
    }

    /**
     * 查找右子树最小的节点
     * 调用这个函数，首先你要确保，这个节点一定右子树不为空
     *
     * @return 查找到右子树最小的节点
     */
    public Node searchRigthMin() {
        return searchRigthMin(this.right);
    }

    private Node searchRigthMinParent(Node node) {
        if (node.left.left != null) {
            return searchRigthMin(node.left);
        } else {
            return node;
        }
    }

    /**
     * 查找右子树最小的节点的父节点
     * 调用这个函数，首先你要确保，这个节点一定右子树不为空
     *
     * @return 查找到右子树最小的节点
     */
    public Node searchRigthMinParent() {
        //如果右子树最小的节点，就是当前节点的  右节点，就直接返回当前节点
        if (this.right.left == null) {
            return this;
        }
        return searchRigthMinParent(this.right);
    }
}