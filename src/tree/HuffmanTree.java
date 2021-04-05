package tree;

import java.io.*;
import java.util.*;

public class HuffmanTree {

    public static void main(String[] args) {

        /*zipFile("D:\\1后期\\图片\\后期修图\\ps\\DSC_0002.jpg","D:\\DSC_0002.zip");
        System.out.println("压缩成功");*/

        unZipFile("D:\\DSC_0002.zip","D:\\DSC_0002.jpg");
        System.out.println("解压成功");
        /*String content="hello world";
        byte[] zip = huffmanZip(content.getBytes());
        //System.out.println(Arrays.toString(zip));
       byte[] decode = decode(zip, huffmanCode);

        for (byte b : decode) {
            System.out.printf("%c",b);
        }*/

        /*byte[] contentBytes = content.getBytes();
        List<Node> nodes = getNodeBytes(contentBytes);
        Collections.sort(nodes);
        System.out.println("获得到的字符权值：");
        for (Node node : nodes) {
            System.out.printf("%c=%s\t",node.data,node.weight);
        }
        System.out.println();

        Node node = creatHuffmanTree(nodes);
        //preOrder(node);//遍历生成的哈夫曼树
        Map<Byte, String> codes = getCodes(node);
        System.out.println("生成的哈夫曼编码：");
        for (Map.Entry<Byte,String> entry:codes.entrySet()){
            System.out.printf("%c=%s\t",entry.getKey(),entry.getValue());
        }
        System.out.println();

        //压缩数据
        byte[] zip = zip(contentBytes, huffmanCode);
        System.out.println(Arrays.toString(zip));*/
    }
    //压缩文件

    /**
     *  对文件进行压缩
     * @param srcFile   要压缩的文件
     * @param destFile  要把文件压缩到哪里
     */
    public static void zipFile(String srcFile,String destFile){
        FileInputStream is=null;
        FileOutputStream os=null;
        ObjectOutputStream oos=null;
        try {
            is=new FileInputStream(srcFile);
            //创建一个byte数组，存放读取文件的数据，is.available()是文件对应的数据大小
            byte[] b = new byte[is.available()];
            is.read(b);
            //对b  这个byte数组进行压缩
            byte[] bytes = huffmanZip(b);
            //创建输出流
            os=new FileOutputStream(destFile);
            oos=new ObjectOutputStream(os);

            //利用对象流，把压缩后的数据，和对应的哈夫曼编码的数据写入文件
            oos.writeObject(bytes);
            oos.writeObject(huffmanCode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                oos.close();
                os.close();
                is.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }


    //解压文件

    /**
     *对文件进行解压
     * @param zipFile  要解压的文件
     * @param destFile 解压到哪里
     */
    public static void unZipFile(String zipFile,String destFile){
        FileInputStream is=null;
        ObjectInputStream ois=null;
        FileOutputStream os=null;

        try {
            is=new FileInputStream(zipFile);
            ois=new ObjectInputStream(is);
            //使用对象输入流，读取之前存储的对象数据
            byte[] bytes = (byte[]) ois.readObject();
            Map<Byte,String> huffmanCodes=(Map<Byte,String>)ois.readObject();
            byte[] decode = decode(bytes, huffmanCodes);
            os=new FileOutputStream(destFile);
            os.write(decode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            try {
                os.close();
                ois.close();
                is.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

        }
    }


    //解码
    //1）需要编码后的byte数组，把这个byte数组转换成  二进制字符串
    /**
     * 把byte数据，转换成8位的二进制字符串
     * @param flag  标志是否需要补高位如果是 true ， 表示需要补高位， 如果是 false 表示不补, 如果是最后一个字节， 无需补高位
     * @param b 传入的byte
     * @return  返回b对应的二进制字符串
     */
    public static String byteToBitString(boolean flag, byte b){
        int temp=b;//把byte强转成  int数据

        //如果是正数我们还存在补高位
        if(flag) {
            //如果是正数，就补上了高位，如果是负数，那后面8位也没有影响
            temp |= 256; //按位与 256 1 0000 0000 | 0000 0001 => 1 0000 0001
        }
        //因为计算机存储的是补码，下面的这个语句是返回数据对应的补码，补码的补码，就是原码
        String str = Integer.toBinaryString(temp); //返回的是 temp 对应的二进制的补码
        if(flag) {
            //截取后面8位的数据
            return str.substring(str.length() - 8);
        } else {
            //如果是最后一个数据也是负数，就的截取一下，如果不是则直接返回原字符串
            if (str.length()>8){
                return str.substring(str.length() - 8);
            }else {
                return str;
            }
        }
    }
    //2) 把转换成二进制的字符串，翻译成对应的byte
    public static byte[] decode(byte zip[],Map<Byte,String> huffmanCodes){
        //1）把byte数组，转换成二进制字符串
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <zip.length ; i++) {
            if (i==zip.length-1){
                stringBuilder.append(byteToBitString(false,zip[i]));
            }else {
                stringBuilder.append(byteToBitString(true,zip[i]));
            }
        }
        HashMap<String, Byte> map = new HashMap<>();
        ArrayList<Byte> list = new ArrayList<>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        for (int i = 0; i <stringBuilder.length() ; ) {

            int count=1;
            Byte b=null;

            while (true){

                String substring = stringBuilder.substring(i, count + i);
                b = map.get(substring);
                if (b==null){
                    count++;
                }else {
                    break;
                }
            }
            i=count+i;
            list.add(b);

        }
        byte[] bytes = new byte[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            bytes[i]=list.get(i);
        }
        return bytes;
    }


    //封装所有方法，直接调用
    public static byte[] huffmanZip(byte[] contentBytes){
        //获取不同字符，在字符串出现的个数（也就是后面说的权值）
        List<Node> nodes = getNodeBytes(contentBytes);
        //生成哈夫曼树
        Node node = creatHuffmanTree(nodes);
        //获取哈夫曼编码表
        Map<Byte, String> huffmanCode = getCodes(node);
        //根据哈夫曼编码表，压缩数据
        byte[] zip = huffmanZip(contentBytes, huffmanCode);
        return zip;
    }


    //任务：根据bytes数组，对照huffmanCodes，压缩生成对应的数据
    /**
     *@desc:
     *@param:[contentBytes:原始数据对应的byte数据, huffmanCodes：哈夫曼编码]
     *@return:byte[]：返回的是：对照huffmanCodes编码，压缩后的数据（注意：我们是以8位压缩一次的）
     *@author:paperfly
     *@time:2021/4/4 15:44
     */
    public static byte[] huffmanZip(byte contentBytes[],Map<Byte,String> huffmanCodes){

        //1）根据哈夫曼编码表，把contentBytes转换成对应的哈夫曼二进制编码字符串
        StringBuilder stringBuilder=new StringBuilder();

        for (byte b : contentBytes) {
            stringBuilder.append(huffmanCodes.get(b));
            //System.out.printf("%c=%s\t",b,huffmanCodes.get(b));
        }

//        System.out.println(stringBuilder);
        int index=0;
        //2）获取要创建多大的数组
        //因为要1byte=8位，所以就要截取8位数据，作为一个byte存储起来
        int len=(stringBuilder.length()+7)/8;
        byte huffmanCodesBytes[]=new byte[len];

        //3）转换成的哈夫曼二进制编码字符串太长了，所以需要每8位截取一下，转换成对应的byte数据，存放在byte数组中
        for (int i = 0; i <stringBuilder.length() ; i+=8) {
            //如果到了字符串最后，可能i+8就会超出字符串的长度，所以就要判断一下
            if (i+8>stringBuilder.length()){
                //把截取到的字符串转换成byte数据
                huffmanCodesBytes[index++]=(byte)Integer.parseInt(stringBuilder.substring(i),2);
            }else {
                huffmanCodesBytes[index++]=(byte)Integer.parseInt(stringBuilder.substring(i,i+8),2);
            }
        }
        return huffmanCodesBytes;
    }

    //前序遍历哈夫曼树
    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("二叉树为空，不能遍历======");
        }
    }

    //封装，方便调用
    private static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCode;
    }
    static Map<Byte,String> huffmanCode=new HashMap<>();
    static StringBuilder stringBuilder=new StringBuilder();
    //生成哈夫曼编码表
    private static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2=new StringBuilder(stringBuilder);
        stringBuilder2.append(code);
        if (node!=null){
            if(node.data!=null){//说明是一个叶子结点
                huffmanCode.put(node.data,stringBuilder2.toString());
            }else {//非叶子结点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }
        }

    }
    //根据bytes数组，统计出数据中不同字符的数量
    public static List<Node> getNodeBytes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();
        HashMap<Byte, Integer> map = new HashMap<>();
        for (Byte b:bytes){
            Integer count = map.get(b);
            //判断当前  b   这个字符是不是已经在map中存在了
            if(count!=null){
                map.put(b,count+1);
            }else {
                map.put(b,1);
            }
        }

        for (Map.Entry<Byte,Integer> entry:map.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }

    //生成哈夫曼树
    public static Node creatHuffmanTree(List<Node> nodes){
        //生成霍夫曼树
        while (nodes.size()>1){
            //对nodes进行一次排序
            Collections.sort(nodes);
            //获取最小的2个节点
            Node leftNode = nodes.get(0);
            Node rightNode =nodes.get(1);
            //生成一个新的节点，这个只是根节点，没有data只有权值
            Node parent=new Node(leftNode.weight+rightNode.weight);
            parent.left=leftNode;
            parent.right=rightNode;
            //移除已经参加过计算的
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树， 加入到 nodes
            nodes.add(parent);
        }
        //返回根节点
        return nodes.get(0);
    }

}
//创建节点类，并实现Comparable接口，方便后面对Node排序
class Node implements Comparable<Node> {
    Integer weight;
    Byte data;
    Node left;
    Node right;

    public Node(Integer weight) {
        this.weight = weight;
        this.data=null;
    }
    public Node(Byte data,Integer weight){
        this.weight=weight;
        this.data=data;
    }
    //前序遍历
    public  void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }
    @Override
    public int compareTo(Node o) {
        return this.weight-o.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", data=" + data +
                '}';
    }
}
