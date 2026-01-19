class Solution {
    public:
        Node* copyRandomList(Node* head) {
            // brute forced using two vectors and two hashmaps.
            vector<Node*> v;
            Node* temp = head;
            unordered_map<int, int> umap;
            unordered_map<Node*, int> vmap;
            int k = 0;
            while(temp != NULL){
                v.push_back(temp);
                vmap[temp] = k;
                k++;
                temp = temp->next;
            }
            for(int i=0; i<v.size(); i++){
                umap[i] = (v[i]->random != NULL)?vmap[v[i]->random]:-1;
            }
            Node* new_head = new Node(0);
            Node* new_tail = new_head;
            vector<Node*> new_v;
            for(int i=0; i<v.size(); i++){
                Node* x = new Node(v[i]->val);
                new_tail -> next = x;
                new_tail = new_tail -> next;
                new_v.push_back(x);
            }
            Node* tail = new_head -> next;
            for(int i=0; i<v.size(); i++){
                tail->random = (umap[i] != -1)?new_v[umap[i]]: NULL;
                tail = tail->next;
            }
            return new_head->next;
    
            // optimized using single hashmap
            Node* temp = head;
            unordered_map<Node*, Node*> umap;
            while(temp != NULL){
                Node* x = new Node(temp->val);
                umap[temp] = x;
                temp = temp->next;
            }
            Node* temp2 = head;
            while(temp2 != NULL){
                umap[temp2]->next = (temp2->next)?umap[temp2->next]:NULL;
                umap[temp2]->random = (temp2->random)?umap[temp2->random]:NULL;
                temp2 = temp2->next;
            }
            return umap[head];
    
        }
    };