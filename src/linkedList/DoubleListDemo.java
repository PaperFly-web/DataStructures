package linkedList;

public class DoubleListDemo {
    public static void main(String[] args) {
        DoubleList doubleList = new DoubleList();
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        doubleList.addByOrder(hero1);
        doubleList.addByOrder(hero4);
        doubleList.addByOrder(hero2);
        doubleList.addByOrder(hero3);
        doubleList.update(new HeroNode2(4, "林冲---", "豹子头"));
        doubleList.list();
        doubleList.remove(3);
        System.out.println("删除后的数据======");
        doubleList.list();
    }
}
class DoubleList{
    //创建头结点
    private HeroNode2 head=new HeroNode2(0,"","");

    public HeroNode2 getHead(){
        return head;
    }
    //判断当前节点是否已经存在
    public boolean isExit(HeroNode2 heroNode){
        //由于不能改变头结点，所以用临时变量保存
        HeroNode2 temNode=head;
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
    public void add(HeroNode2 heroNode){
        boolean exit = isExit(heroNode);
        if (exit){
            System.out.println("对不起，传入的"+heroNode.no+"编号的节点已经存在======");
            return;
        }
        //由于不能改变头结点，所以用临时变量保存
        HeroNode2 temNode=head;
        while (true){

            if(temNode.next==null){
                break;
            }
            temNode=temNode.next;
        }
        temNode.next=heroNode;
        heroNode.pre=temNode;
    }
    //添加节点到链表,根据编号排序添加
    public void addByOrder(HeroNode2 heroNode){
        //如果链表为null
        if (head.next==null){
            head.next=heroNode;
            heroNode.pre=head;
            return;
        }
        boolean exit = isExit(heroNode);
        if (exit){
            System.out.println("对不起，传入的"+heroNode.no+"编号的节点已经存在======");
            return;
        }
        //判断是否当前节点排名已经存在，默认不存在
        boolean flag=false;
        //由于不能改变头结点，所以用临时变量保存
        HeroNode2 temNode=head.next;
        HeroNode2 end=null;
        //能到这里说明，至少有一个节点了
        while (true){
            //如果节点到尾部了
            if(temNode==null){
                break;
            }
            if (temNode.no>heroNode.no){//如果这一步成功，说明前面的都比他小
                break;
            }else if(temNode.no==heroNode.no){
                //有节点排名和当前节点相等
                flag=true;
                break;
            }
            //如果到遍历完了，还没有找到，就保存为部节点的信息
            if (temNode.next==null){
                end=temNode;
            }
            temNode=temNode.next;

        }
        if (flag){
            System.out.println("已经有这个排名了："+heroNode.no+"");
        }else {
            if (end!=null){
                end.next=heroNode;
                heroNode.pre=end;
            }else {
                temNode.pre.next=heroNode;
                heroNode.pre=temNode.pre;
                temNode.pre=heroNode;
                heroNode.next=temNode;
            }

        }

    }
    //修改节点
    public void update(HeroNode2 heroNode){
        if(head.next==null){
            System.out.println("链表为空，不能修改======");
            return;
        }
        HeroNode2 temHero=head.next;
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
        HeroNode2 temNode=head.next;
        boolean flag=false;
        while (true){
            //遍历到最后了，也还没找到就直接退出
            if(temNode==null){
                break;
            }
            //找到这个节点了，设置flag为true
            if (temNode.no==no){
                flag=true;
                break;
            }
            temNode=temNode.next;
        }
        if (flag){
            temNode.pre.next=temNode.next;
            //如果删除的是最后一个节点，temNode.next就是null。如果不进行处理的话，就会报空指针异常
            if(temNode.next!=null){
                temNode.next.pre=temNode.pre;
            }else {
                temNode.pre=null;
            }
        }else {
            System.out.println("没有找到这个"+no+"节点======");
        }

    }
    //打印链表所有信息
    public void list(){
        //由于不能改变头结点，所以用临时变量保存
        HeroNode2 temNode=head.next;
        while (true){
            System.out.println(temNode);
            if(temNode.next==null){
                break;
            }

            temNode=temNode.next;
        }
    }

}
class HeroNode2{
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int no,String name,String nickName){
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