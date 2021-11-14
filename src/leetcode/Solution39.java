package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        int[] candidates = {1,2};
        System.out.println(s.combinationSum(candidates, 4));
    }
    private  List<Integer> path = new ArrayList<>();
    private Map<String,List<Integer>> res = new HashMap<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.backTracking(candidates,target);
        List list = res.entrySet().stream().map(x -> {
            return x.getValue();
        }).collect(Collectors.toList());
        return list;
    }

    private void backTracking(int[] candidates,int target){

        if(getSum(path)>target){
            return;
        }
        if(getSum(path)==target){
            this.addRes(path);
            return;
        }
        for (int i=0;i<candidates.length;i++){
            path.add(candidates[i]);
            this.backTracking(candidates,target);
            path.remove(path.size()-1);
        }

    }

    public void addRes(List<Integer> path){
        List<Integer> temPath = new ArrayList<>(path);
        temPath.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        temPath.forEach(x->{
            stringBuilder.append(x);
        });
        if(!res.containsKey(stringBuilder.toString())){
            res.put(stringBuilder.toString(),new ArrayList<>(path));
        }
    }

    public Integer getSum(List<Integer> path){
        return path.stream().reduce(0,(sum,y)->sum+y);
    }
}
