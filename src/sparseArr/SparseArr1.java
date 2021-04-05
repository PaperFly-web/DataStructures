package sparseArr;

import java.io.IOException;

public class SparseArr1 {
    public static void main(String[] args) throws IOException {
        //1.创建数组
        int chess1[][]=new int[11][11];
        chess1[1][2]=1;
        chess1[2][3]=2;
        chess1[4][5]=2;
        chess1[4][6]=2;
        System.out.println("原始数组============");
        for (int[] ints : chess1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        //创建稀疏数组
        //1.遍历获取稀疏数组大小
        int sum=0;//记录不为0值的个数
        for (int i=0;i<chess1.length;i++){
            for (int j = 0; j < chess1[i].length; j++) {
                if(chess1[i][j]!=0){
                    sum++;
                }
            }
        }
        //2.创建稀疏数组
        int sparseArr[][]=new int[sum+1][3];
        sparseArr[0][0]=chess1.length;
        sparseArr[0][1]=chess1[0].length;
        sparseArr[0][2]=sum;
        int count=0;
        for (int i=0;i<chess1.length;i++){
            for (int j = 0; j < chess1[i].length; j++) {
                if(chess1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chess1[i][j];
                }
            }
        }
        System.out.println("原始稀疏数组=========");
        for (int[] ints : sparseArr) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        //保存稀疏数组
        SaveSparseArr saveSparseArr = new SaveSparseArr(sparseArr);
        saveSparseArr.save();
        //恢复稀疏数组
        int[][] sparseArr1 = saveSparseArr.getSparseArr();
        System.out.println("恢复的稀疏数组=========");
        for (int[] ints : sparseArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
        //将稀疏数组恢复为原始数组
        int chess2[][]=new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            int i2=sparseArr[i][0];
            int j2=sparseArr[i][1];
            int val2=sparseArr[i][2];
            chess2[i2][j2]=val2;
        }
        System.out.println("恢复的原始数组======");
        for (int[] ints : chess2) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

    }
}
