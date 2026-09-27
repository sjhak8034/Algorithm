#include <iostream>
#include <bits/stdc++.h>
using namespace std;

int n, m;
int from[100000], to[100000], weight[100000];
int A, B;



void dijkstra(int root,
              const vector<vector<pair<int,int>>>& edge_map,
              vector<int>& dist) {
    dist[root] = 0;
    priority_queue<pair<int,int>> pq;
    pq.push(make_pair(0,root));
    while(!pq.empty()){
        int v,node;
        tie(v,node) = pq.top();
        v= -v;
    
        vector<pair<int,int>>edges = edge_map[node];
        
        pq.pop();

        if(v > dist[node]){
            continue;
        }

        for(pair<int,int> edge : edges){
            int weight, next_node;
            tie(weight, next_node) = edge;
         
            if(weight + v >= dist[next_node]){
                continue;
            }
            pq.push(make_pair(-weight - v, next_node));
            dist[next_node] = weight + v;
        }
    }

}

int main() {
    cin >> n >> m;

    vector<vector<pair<int,int>>> edge_map(n + 1);
    vector<int> dist(n + 1, INT_MAX);

    for (int i = 0; i < m; i++) {
        cin >> from[i] >> to[i] >> weight[i];
        edge_map[from[i]].push_back(make_pair(weight[i],to[i]));
        edge_map[to[i]].push_back(make_pair(weight[i],from[i]));
    }
    
    cin >> A >> B;
    
    dijkstra(A,edge_map,dist);
    cout << dist[B];
    return 0;
}
