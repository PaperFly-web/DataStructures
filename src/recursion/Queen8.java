package recursion;

/**
 * 使用递归，解决8皇后问题
 */
public class Queen8 {
    //定义一共有多少个皇后
    static int max=8;
    //定义数组，保存皇后的位置
    static int[] map =new int[max];
    //记录打印了多少次
    static int count=0;
    //记录判断了多少次
    static int judgeCount=0;
    public static void main(String[] args) {
        check(0);
        System.out.println("一共多少种："+count);
        System.out.println("一共判断了多少次："+judgeCount);
    }

    public static void check2(int n){
        if (n==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            map[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }




    /**
     * 放置第n个皇后，这个才是真正的放置皇后位置
     * @return
     */
    public static void check(int n){
        if (n==max){
            //如果n==max，就说明都满足了，下到最后一颗棋子了（因为n是从0开始的）
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先把皇后放到第i列
            map[n]=i;
            //然后判断，这个放置的位置对不对
            if (judge(n)) {
                //如果对了，就放置下一个皇后
                //如果下一个下不了，就回溯回来
                check(n+1);
            }
        }
    }

    /**
     *@desc: 判断当前这一步是否能满足8皇后的规则。注意：这是检查放置皇后的位置是否可行
     *@param:[n:第几个棋子]
     *@return:boolean
     *@author:paperfly
     *@time:2021/3/6 15:10
     */
    public static boolean judge(int n){
        judgeCount++;
        //判断当前棋子，对已经下好的所有棋子是否满足
        for (int i = 0; i < n; i++) {
            //map[i]==map[n]：如果在同一列上，则不满足
            //Math.abs(n-i)==Math.abs(map[i]=map[n]):如果在同一斜线上（这里利用了斜率或者等腰直接三角形），则不满足
            //不可能会在同一行上，因为每一次下棋子，都会向下一行下
            if (map[i]==map[n]||Math.abs(n-i)==Math.abs(map[i]-map[n])){
                return false;
            }
        }
        return true;
    }

    //打印出皇后的位置
    public static void print(){
        count++;
        for (int i = 0; i < max; i++) {
            System.out.print(map[i]);
        }
        System.out.println();
    }
}
