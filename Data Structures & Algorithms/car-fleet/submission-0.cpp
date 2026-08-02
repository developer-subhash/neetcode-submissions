#define pii pair<int,int>


class Solution {
public:
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        vector<pii> order; 
        for(int i=0;i<position.size();i++){
            order.push_back({position[i], speed[i]});
        }

        sort(order.begin(), order.end());

        int ans = 0;

        for(int i=order.size()-1;i>=0;){
            int j = i-1;
            for(;j>=0;){
                int d = target - order[j].first;
                // if front car takes more or equal time than current time then it will be part of fleet
                if(1LL*(target-order[i].first)*order[j].second >= 1LL*d*order[i].second){
                    j--;
                }else{
                    break;
                }
            }
            i = j;
            ans++;
        }

        return ans;
    }
};
