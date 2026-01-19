class Solution {
    public:
        ListNode* rotateRight(ListNode* head, int k){
            if(head == NULL) return NULL;
            int  n = 1;
            ListNode* temp = head;
            while(temp->next != NULL){
                temp = temp -> next;
                n++;
            }
            ListNode* start = head;
            for(int i=0; i<n-(k%n); i++){
                temp->next = start;
                temp = temp->next;
                start = start->next;
            }
            temp->next = NULL;
            return start;
        }
    };