package graph;

import java.util.*;

public class Graph {

    int numOfEdges;//图中边的个数
    int edges[][];//邻接矩阵：图中，边和变的关系
    List<String> vertextList;//顶点的集合
    boolean isVisited[];//访问遍历时，保存节点是否被访问过
    LinkedList<Integer> queue = new LinkedList<>();//广度优先遍历时候需要用到的
    public static void main(String[] args) {

        Graph graph = new Graph(5);
        String vertexs[]={"A","B","C","D","E"};
        for (String vertex : vertexs) {
            graph.insertVertext(vertex);
        }

        //A-B A-D B-D B-C D-E
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,3,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(3,4,1);
//        graph.showGraph();
        System.out.println("深度优先遍历------");
        graph.dfs();
        System.out.println();
        System.out.println("广度优先遍历------");
        graph.bfs();
    }
    /**
     *
     * @param n  这个图一共有几个顶点
     */
    public Graph(int n){
        //初始化邻接矩阵
        edges=new int[n][n];
        //初始化顶点结合
        vertextList=new ArrayList<>(n);

    }
    /**
     * 重载bfs，方便调用
     */
    public void bfs(){
        //初始化，记录结点访问记录的数组
        isVisited=new boolean[this.getVertextNum()];
        this.bfs(isVisited,0);
    }
    /**
     * 广度优先遍历
     * @param isVisited 保存每个节点是否被访问过
     * @param i 要被访问的节点索引，这个传过来的索引，一定是被确定没有被访问过了
     */
    private void bfs(boolean[] isVisited,int i){

        //1）判断当前节点是不是被访问过，如果没访问过则输出当前节点，并设置为访问过
        if (!isVisited[i]){
            //1-1）输出当前节点
            System.out.print(getValueByIndex(i)+"-->");
            //1-2)把当前访问的节点设置为访问过
            isVisited[i]=true;
            //1-3)把访问过的节点加入  队列
            queue.addLast(i);
        }

        //2）循环递归
        while (!queue.isEmpty()){
            //2-1)循环遍历，与这个节点相邻的节点有没有被访问过的
            for (int j=0;j<this.getVertextNum();j++){
                //2-1-1)如果j和  i有直接相邻，并且j还没有被访问
                if(edges[i][j]==1&&!isVisited[j]){
                    //访问j
                    System.out.print(getValueByIndex(j)+"-->");
                    //设置j已经被访问过
                    isVisited[j]=true;
                    //把访问过得加入队列
                    queue.addLast(j);
                }
            }
            //取出队列的值
            Integer u = queue.removeFirst();
            //递归进行下一次
            bfs(isVisited,u);
        }

    }
    /**
     * 重载dfs，方便调用
     */
    public void dfs(){
        //初始化，记录结点访问记录的数组
        isVisited=new boolean[this.getVertextNum()];
        dfs(isVisited,0);
    }
    /**
     * 深度优先遍历
     * @param isVisited 保存每个节点是否被访问过
     * @param i 要被访问的节点索引，这个传过来的索引，一定是被确定没有被访问过了
     */
    private void dfs(boolean []isVisited,int i){
        //1）先输出这次要访问的节点
        System.out.print(this.getValueByIndex(i)+"-->");
        //2) 把这个节点设置为被访问过
        isVisited[i]=true;
        //3)循环遍历递归，与这个节点相邻的节点有没有被访问过的
        for (int j=0;j<this.getVertextNum();j++){
            //3-1)如果j和  i有直接相邻，并且j还没有被访问，那就递归去访问j
            if(edges[i][j]==1&&!isVisited[j]){
                dfs(isVisited,j);
            }
        }
    }


    /**
     * 获取图中边的数量
     * @return
     */
    public int getNumOfEdges(){
        return numOfEdges;
    }

    /**
     * 获取图中顶点的个数
     * @return
     */
    public int getVertextNum(){
        return vertextList.size();
    }

    /**
     * 获取边的权重值
     * @param v1 第一个顶点对应在顶点集合中的索引
     * @param v2 第二个顶点对应在顶点集合中的索引
     * @return
     */
    public int getWeightByIndex(int v1,int v2){
        return edges[v1][v2];
    }

    /**
     * 获取对应索引对应的值
     * @param i 顶点对应在集合中的索引
     * @return
     */
    public String getValueByIndex(int i){
        return vertextList.get(i);
    }

    /**
     * 输出图
     */
    public void showGraph(){
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
    /**
     * 添加顶点到集合
     * @param vertext  对应顶点的数据
     */
    public void insertVertext(String vertext){
        vertextList.add(vertext);
    }

    /**
     * 添加顶点之间边的关系
     * @param v1 第一个顶点对应在顶点集合中的索引
     * @param v2 第二个顶点对应在顶点集合中的索引
     * @param weight 这俩个顶点之间的权重
     */
    public void insertEdge(int v1,int v2,int weight){
        //因为这是一个无向图，所以要双向添加顶点之间的关系
        edges[v1][v2]=weight;
        edges[v2][v1]=weight;
        //每添加一个边的关系后，就把边的数量+1
        numOfEdges++;
    }
}
