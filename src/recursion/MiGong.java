package recursion;

public class MiGong {
    public static void main(String[] args) {

        //创建迷宫
        int[][] map = new int[8][7];

        //为迷宫上墙
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        map[6][4]=1;
        System.out.println("地图的初始化情况======");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        setWay(map,1,1);
        System.out.println("寻找迷宫的路后======");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    //传递一个地图，然后传递一个坐标，开始找路
    //约定：下--右--上--左，如果走不通在回溯
    //当 map[i][j] 为 0 表示该点没有走过 当为 1 表示墙 ； 2 表示通路可以走 ； 3 表示该点已经
    //走过， 但是走不通
    public static boolean setWay(int[][] map, int i, int j) {
        //如果走到了最后一个就返回true
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果传入的点，是可以走的，就按照约定探测
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i-1, j )) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }

    }
}
