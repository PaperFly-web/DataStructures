package leetcode;

import java.util.*;

public class Solution332 {
    public static void main(String[] args) {
        Solution332 s = new Solution332();
        List<List<String>> tickets = new ArrayList<>();
        String[][] a = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL", "SFO"}};
        for (int i = 0; i < 5; i++) {
            List<String> list1 = new ArrayList<>();
            list1.add(a[i][0]);
            list1.add(a[i][1]);
            tickets.add(list1);
        }
        System.out.println(s.findItinerary(tickets));
    }


    private Deque<String> res = new LinkedList<>();
    private Map<String, Map<String, Integer>> map = new HashMap<String, Map<String, Integer>>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            Map<String,Integer> tem;
            if(map.containsKey(ticket.get(0))){
                tem = map.get(ticket.get(0));
                tem.put(ticket.get(1),tem.getOrDefault(ticket.get(1),0)+1);
            }else {
                tem = new TreeMap<>();
                tem.put(ticket.get(1),1);
            }
            map.put(ticket.get(0),tem);
        }
        res.add("JFK");
        this.backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    public boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            return true;
        }

        String last = res.getLast();
        if(map.containsKey(last)){
            for (Map.Entry<String, Integer> entry : map.get(last).entrySet()) {
                Integer count = entry.getValue();
                if(count>0){
                    res.add(entry.getKey());
                    entry.setValue(count-1);
                    if(this.backTracking(ticketNum)){
                        return true;
                    }
                    entry.setValue(count);
                    res.removeLast();
                }
            }
        }



























        /*String last = res.getLast();
        if(map.containsKey(last)){
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                Integer count = target.getValue();
                if(count>0){
                    res.add(target.getKey());
                    target.setValue(count-1);
                    if(this.backTracking(ticketNum)){
                        return true;
                    }
                    res.removeLast();
                    target.setValue(count);
                }
            }
        }*/
        return false;
    }

}
