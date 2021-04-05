package linkedList;

import java.util.Stack;

public class SingleListDemo {

    public static void main(String[] args) {
        SingleList singleList = new SingleList();
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        singleList.add(hero1);
        singleList.add(hero4);
        SingleList singleList2 = new SingleList();
        singleList2.add(hero2);
        singleList2.add(hero3);
        singleList.join(singleList2.getHead());
        singleList.list();

    }


}


class SingleList{
    //创建头结点
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead(){
        return head;
    }
    //判断当前节点是否已经存在
    public boolean isExit(HeroNode heroNode){
        //由于不能改变头结点，所以用临时变量保存
        HeroNode temNode=head;
        while (true){

            if(temNode.next==null){
                break;
            }
            if (heroNode==temNode.next){
                return true;
            }
            temNode=temNode.next;
        }
        return false;
    }
    //添加节点到链表,只能添加到链表的尾部
    public void add(HeroNode heroNode){
        boolean exit = isExit(heroNode);
        if (exit){
            System.out.println("对不起，传入的"+heroNode.no+"编号的节点已经存在======");
            return;
        }
        //由于不能改变头结点，所以用临时变量保存
        HeroNode temNode=head;
        while (true){

            if(temNode.next==null){
                break;
            }
            temNode=temNode.next;
        }
        temNode.next=heroNode;
    }
    //添加节点到链表,根据编号排序添加
    public void addByOrder(HeroNode heroNode){
        boolean exit = isExit(heroNode);
        if (exit){
            System.out.println("对不起，传入的"+heroNode.no+"编号的节点已经存在======");
            return;
        }
        //判断是否当前节点排名已经存在，默认不存在
        boolean flag=false;
        //由于不能改变头结点，所以用临时变量保存
        HeroNode temNode=head;
        while (true){

            //如果节点为空，或者节点到尾部了
            if(temNode.next==null){
                break;
            }

            if (temNode.next.no>heroNode.no){
               break;
            }else if(temNode.next.no==heroNode.no){
                //有节点排名和当前节点相等
                flag=true;
                break;
            }
            temNode=temNode.next;
        }
        if (flag){
            System.out.println("已经有这个排名了："+heroNode.no+"");
        }else {
            heroNode.next=temNode.next;
            temNode.next=heroNode;
        }

    }
    //修改节点
    public void update(HeroNode heroNode){
        if(head.next==null){
            System.out.println("链表为空，不能修改======");
            return;
        }
        HeroNode temHero=head.next;
        boolean flag=false;
        while (true){
            if(temHero.no==heroNode.no){
                flag=true;
                break;
            }
            //到节点末尾了，就直接退出
            if(temHero.next==null){
                break;
            }
            temHero=temHero.next;
        }
        if(flag){
            temHero.name=heroNode.name;
            temHero.nickName=heroNode.nickName;
        }else {
            System.out.println("没有找到"+heroNode.no+"编号的节点======");
        }
    }
    //删除节点
    public void remove(int no){
        if (head.next==null){
            System.out.println("节点为空=====");
            return;
        }
        //由于不能改变头结点，所以用临时变量保存
        HeroNode temNode=head;
        boolean flag=false;
        while (true){
            //遍历到最后了，也还没找到就直接退出
            if(temNode.next==null){
                break;
            }
            //找到这个节点了，设置flag为true
            if (temNode.next.no==no){
                flag=true;
                break;
            }
            temNode=temNode.next;
        }
        if (flag){
            temNode.next=temNode.next.next;
        }else {
            System.out.println("没有找到这个"+no+"节点======");
        }

    }



    //打印链表所有信息
    public void list(){
        //由于不能改变头结点，所以用临时变量保存
        HeroNode temNode=head.next;
        while (true){
            System.out.println(temNode);
            if(temNode.next==null){
                break;
            }

            temNode=temNode.next;
        }
    }
    //获取链表有效节点个数
    public int size(){
        int num=0;
        HeroNode temNode=head;
        while (true){
            if (temNode.next==null){
                break;
            }
            num++;
            temNode=temNode.next;
        }
        return num;
    }

    //查找倒数第几个节点
    public HeroNode findLastNumNode(int lastNum){
        //1.首先遍历出游几个节点
        int size = size();
        HeroNode tem=head.next;
        //判断是否有这个节点
        if(lastNum<=0||lastNum>size){
            return null;
        }
        for (int i=1;i<=size-lastNum;i++){
            tem=tem.next;
        }
        return tem;
    }

    //单链表反转

    /**
     * 思想
     *  每遍历一个节点，就取出一个，插到新的头结点执行的节点最前面，然后在把新头结点置为最前
     *  1，定义一个临时空头
     *  2，在定义2个变量，用于遍历原先列表
     */
    public void reverse(){
        HeroNode reverseHead=new HeroNode(0,"","");
        HeroNode cur;
        HeroNode next;
        //当前节点为空，或者只有一个节点，就不需要进行反转
        if (head.next==null||head.next.next==null){
            return;
        }
        //定义2个变量，用于遍历原先的链表
        cur=head.next;
        next=cur.next;
        while (cur.next!=null){
            //取出节点，插到新的头节点执像的节点
            cur.next=reverseHead.next;
            //新头节点，在置于最前
            reverseHead.next=cur;
            //变量后移遍历下一个原始链表中的节点
            cur=next;
            next=next.next;

        }
        //处理最后一个节点
        cur.next=reverseHead.next;
        reverseHead.next=cur;
        //把原始节点的头，指向最新的节点
        head=reverseHead;
    }

    /**
     * reversePrint,逆序打印链表
     * 思想：
     *  利用栈的性质
     *  遍历列表，取出数据放入栈中
     *  然后依次打印栈中的数据
     */
    public void reversePrint(){
        if (head.next==null){
            return;
        }
        HeroNode tem=head.next;
        Stack<HeroNode> stack=new Stack<>();
        //遍历列表，取出节点，存入栈中
        while (tem!=null){
            stack.push(tem);
            tem=tem.next;
        }
        //取出栈中的数据，逆序打印链表的数据
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并链表
     * @param otherHead
     */
    public void join(HeroNode otherHead){
        //判断链表是否为空
        if(otherHead.next==null){
            return;
        }
        HeroNode tem=otherHead.next;
        HeroNode flag;
        while (tem!=null){
            flag=tem;
            tem=tem.next;
            //把取出的节点的next指针置为null。不然加入节点的时候容易出错
            flag.next=null;
            addByOrder(flag);

        }
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;
    public HeroNode(int no,String name,String nickName){
        this.no=no;
        this.name=name;
        this.nickName=nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}