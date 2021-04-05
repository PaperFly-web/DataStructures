package sparseArr;



import java.io.*;

public class SaveSparseArr {
    private int sparseArr[][];
    public SaveSparseArr(int sparseArr[][]){
        this.sparseArr=sparseArr;
    }

    //保存稀疏数组到文件中
    public void save() throws IOException {
        File file = new File("D:/sparseArr.txt");
        if (file.exists()){
            file.delete();
        }

        OutputStream outputStream = new FileOutputStream("D:/sparseArr.txt",true);
        for (int i = 0; i < sparseArr.length; i++) {

            outputStream.write((sparseArr[i][0]+" ").getBytes());
            outputStream.write((sparseArr[i][1]+" ").getBytes());
            outputStream.write((sparseArr[i][2]+" ").getBytes());

        }
        outputStream.flush();
        outputStream.close();

    }

    //从文件中恢复稀疏数组
    public int[][]  getSparseArr() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:/sparseArr.txt");
        int count=0;
        int read ;
        int temSparseArr[]=new int[3];
        String sum="";
        //创建稀疏数组
        while ((read=fileInputStream.read())!=-1) {

            if (read!=32){
                read=read-48;
                sum=sum+read;
            }else {
                //把稀疏数组第一行的数据保存到零时数组中
                temSparseArr[count]= Integer.parseInt(sum);
                if(count==2){
                    break;
                }
                sum="";
                count++;
            }
        }
        //创建稀疏数组大小
        this.sparseArr=new int[temSparseArr[2]+1][3];
        this.sparseArr[0]=temSparseArr;

        int i=1;
        int j=0;
        count=0;
        sum="";
        //把后续文件中的值保存到数组中
        while ((read=fileInputStream.read())!=-1) {

            if (read!=32){
                read=read-48;
                sum=sum+read;

            }else {
                if(count%3==0&&count!=0){
                    i++;
                    j=0;
                }
                this.sparseArr[i][j]= Integer.parseInt(sum);

                sum="";
                j++;
                count++;
            }
        }
        fileInputStream.close();
        return this.sparseArr;
    }
}
