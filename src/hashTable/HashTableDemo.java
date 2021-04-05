package hashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);
        String key="";
        Scanner scanner = new Scanner(System.in);


        while (true){
            System.out.println("========菜单选项===========");
            System.out.println("add:添加员工");
            System.out.println("list:列出员工信息");
            System.out.println("find:查找员工信息");
            System.out.println("exit:退出");
            key = scanner.next();
            switch(key){
                case "add":
                    System.out.println("输入员工id");
                    int id=scanner.nextInt();
                    System.out.println("输入员工姓名");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查询的ID");
                    id=scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
        }


        }
    }
}
class HashTable{
    private EmpLinkedList[] empLinkedListArray;
    private int size;
    public HashTable(int size){
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        //初始化数组数据
        for (int i=0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }

    }

    //根据id求出散列值
    public int hashFun(int id){
        return id%size;
    }

    public void add(Emp emp){
        int hashFun = hashFun(emp.id);
        empLinkedListArray[hashFun].add(emp);
    }

    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }
    //根据ID查找哈希表中的员工
    public void findEmpById(int id){
        //先计算出此ID对应的散列值
        int hashFun = hashFun(id);
        Emp empById = empLinkedListArray[hashFun].findEmpById(id);
        if (empById!=null){

            System.out.println("在第"+(hashFun+1)+"链表查找到：id="+empById.id+",name="+empById.name+"");
        }else {
            System.out.println("未查找到此id:"+id+",对应的员工");
        }
    }
}
//雇员链表
class EmpLinkedList{
    private Emp head;

    //构造函数
    public EmpLinkedList(Emp emp){
        this.head=emp;
    }

    public EmpLinkedList(){

    }
    //添加节点
    public void add(Emp emp){
        //判断是否为空
        if(head==null){
            head=emp;
            return;
        }
        //如果不为空，就直接添加到链表的尾部
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                curEmp.next=emp;
                break;
            }
            curEmp=curEmp.next;
        }
    }
    //遍历链表
    public void list(int no){
        if(head==null){
            System.out.println("第"+(no+1)+"条链表为空");
            return;
        }
        Emp curEmp=head;
        System.out.print("第"+(no+1)+"链表为");
        while (true){
            //能到这里，肯定至少有一个节点了
            System.out.printf("=>id=%d name=%s\t",curEmp.id,curEmp.name);
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }

    //根据ID查找雇员
    public Emp findEmpById(int id){
        if (head==null){
            //System.out.println("当前列表为空，查找失败======");
            return null;
        }
        Emp curEmp=head;
        while (curEmp!=null){
            //找到id相同的就直接退出
            if(curEmp.id==id){
                break;
            }
            curEmp=curEmp.next;
        }
        //如果找到了，他就不是空，找不到就是null
        return curEmp;
    }
}

//雇员信息类
class Emp{
    public int id;
    public String name;
    public Emp next;
    public Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
}