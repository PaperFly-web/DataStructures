package algorithm;

/**
 * 递归太难了！！！！！！！！！！学不会了
 */
public class HanoiTower {

    private static double nums=0;
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
        //1073741823
        //2147483647
        System.out.println("总共走了"+nums+"次");
    }


    public static void hanoiTower(int num,char a,char b,char c){
        nums++;
        //如果只有一个盘，就直接冲  A移动   C（相对）
        if (num==1){
            System.out.println("第 1 个盘从 " + a + "->" + c);
        }else {
            //如果我们有 n >= 2 情况， 我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoiTower(num-1,a,c,b);
            //2. 把最下边的盘 A->C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //3. 把 B 塔的所有盘 从 B->C , 移动过程使用到 a 塔
            hanoiTower(num-1,b,a,c);
        }
    }
}
