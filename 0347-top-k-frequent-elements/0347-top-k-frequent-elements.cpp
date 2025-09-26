class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        vector<int>ans;
        unordered_map<int,int>mp;
        for(int i=0;i<nums.size();i++){
            mp[nums[i]]++;
        }
       priority_queue<pair<int,int>>pq;
       for(auto it:mp){
        int x=it.first;
        int y=it.second;
        pq.push({y,x});
       }
        while(k>0 && !pq.empty()){
            int m=pq.top().first;
            int n=pq.top().second;
            ans.push_back(n);
            pq.pop();
            k--;
        }
        return ans;
    }
};