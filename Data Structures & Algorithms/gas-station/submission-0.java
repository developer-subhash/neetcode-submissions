class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for(int i=0;i<n;i++){
            gas[i] -= cost[i];
            cost[i] = 0;
        }

        int start = 0;
        int fuel = 0;
        int i=0;

        while(i<n){
            fuel += gas[i];
            if(fuel < 0){
                fuel = 0;
                start = i+1;
            }
            i++;
        }

        if(fuel < 0)return -1;

        if(start == 0)return 0;

        i = 0;
        while(i<start){
            fuel += gas[i];
            if(fuel < 0)return -1;
            i++;
        }

        return start;


    }
}