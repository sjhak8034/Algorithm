#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int A, B, N;
int bus_fare[1000];
int stop_count[1000];
int bus_stops[1000][100];
pair<long,int> dist[1001][1001]; // 버스 * 지점 bill, time
priority_queue<tuple<long,int,int,int>, vector<tuple<long,int,int,int>>, greater<>> pq; // 값, 시간, 지점, 버스 순

void dijkstra(int root, vector<vector<int>>& stop_map){
    dist[1000][root] = make_pair(0,0); 
    pq.push(make_tuple(0,0,root,1000));

    while(!pq.empty()){

        long bill;
        int time,stop,bus;
        tie(bill,time,stop,bus) = pq.top();
        pq.pop();
        if (bus != 1000 && make_pair(bill,time) > dist[bus][stop]) continue;   

        for(auto& n_bus : stop_map[stop]){
            long n_bill = bill;
            if(n_bus != bus){
                n_bill += bus_fare[n_bus];
            }
            if( make_pair(n_bill,time) >= dist[n_bus][stop]){
                continue;
            }

            dist[n_bus][stop] = make_pair(n_bill,time);

            
            int idx = 0;
            for(int i = 0; i < stop_count[n_bus]; i++){
                int n_stop = bus_stops[n_bus][i];
                if(n_stop == stop){
                    idx = i;
                }    
            }

            for(int i = idx + 1; i < stop_count[n_bus]; i++){
                int n_stop = bus_stops[n_bus][i];
                if(make_pair(n_bill,time + i - idx) >= dist[n_bus][n_stop]){
                    continue;
                }
                dist[n_bus][n_stop] = make_pair(n_bill,time + i - idx);
                pq.push(make_tuple(n_bill,time + i - idx,n_stop,n_bus));
            }

        }

        
    }

}

int main() {
    cin >> A >> B >> N;

    vector<vector<int>> stop_map(1001);

    for (int i = 0; i < N; i++) {
        cin >> bus_fare[i] >> stop_count[i];
        for (int j = 0; j < stop_count[i]; j++) {
            cin >> bus_stops[i][j];
            stop_map[bus_stops[i][j]].push_back(i);
        }
    }

    for(int i = 0; i <= 1000; i++){
        for(int j = 0; j <= 1000; j++){
            dist[i][j] = make_pair(LONG_MAX, LONG_MAX);
        }
       
    }

    dist[1000][A] = make_pair(0,0);

    

    dijkstra(A,stop_map);

    pair<long,int> ans = make_pair(LONG_MAX,LONG_MAX);

    for(int i = 0; i < N; i++){
        ans = min(dist[i][B], ans);
    }
    ans = min(dist[1000][B], ans);
    if( ans.first == LONG_MAX){
        cout << -1 << " "<< -1;
        return 0;
    }
    cout << ans.first<< " " << ans.second;

    

    return 0;
}
