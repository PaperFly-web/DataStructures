package linkedList;

public class CircleSingleListDemo {

    public static void main(String[] args) {
        CircleSingleList circleSingleList = new CircleSingleList();
        circleSingleList.add(100);
        circleSingleList.showBoys();
        System.out.println("小孩出圈顺序======");
        circleSingleList.countBoy(10,20,100);
    }
}
class CircleSingleList{

    Boy first=null;
    //添加多少个小孩
    public void add(int nums){
        if (nums<1){
            System.out.println("小孩的数量必须大于等于1");
            return;
        }
        Boy cur=null;
        for (int i = 1; i <=nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个小孩，要单独处理
            //因为头节点，不涉及cur的向后移一位
            if (first==null){
                first=boy;
                boy.setNext(first);
                cur=boy;
            }else {
                boy.setNext(first);
                cur.setNext(boy);
                cur=boy;
            }
        }
    }

    //打印出单向循环列表
    public void showBoys(){
        //首先判断列表是否为空
        if (first==null){
            System.out.println("链表为空，不能打印======");
        }
        Boy cur=first;
        do {
            System.out.println(cur);
            cur=cur.getNext();
        }while (cur.getNext()!=first);
        //输出最后一个节点
        System.out.println(cur);

    }

    //根据用户的输入，计算出小孩出圈的顺序

    /**
     *@desc:
     *@param:[startNo:开始数数编号, startNum：数几个出圈, nums：总共有多少个节点]
     *@return:void
     *@author:paperfly
     *@time:2021/3/3 15:33
     */
    public void countBoy(int startNo,int startNum,int nums){

        if (startNo<1||startNo>nums){
            System.out.println("请检查你输入的参数======");
        }

        Boy temFirst=first;
        //让临时first指向指定编号节点
        for (int i = 1; i <startNo ; i++) {
            temFirst=temFirst.getNext();
        }
        Boy helper=temFirst;
        //让helper指向temFirst前一个节点
        while (true){
            if (helper.getNext()==temFirst){
                break;
            }
            helper=helper.getNext();
        }
        while (true){
            //判断什么时候全部出圈完毕
            if (temFirst==helper){
                break;
            }
            //数数，让helper和first向前移动
            for (int i = 0; i < startNum-1; i++) {
                temFirst=temFirst.getNext();
                helper=helper.getNext();
            }
            System.out.println("当前出圈的小孩是："+temFirst);
            helper.setNext(temFirst.getNext());
            temFirst=temFirst.getNext();
        }

        //输出最后一个出圈的小孩
        System.out.println("当前出圈的小孩是："+temFirst);
    }
}
class Boy{
    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }

    private int no;
    private Boy next;

    public Boy(int no){
        this.no=no;
    }
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}