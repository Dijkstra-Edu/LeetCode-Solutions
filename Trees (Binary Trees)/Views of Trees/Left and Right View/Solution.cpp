class Solution {
    public:
      vector<int> leftView(Node *root) {
          vector<int> result;
          traverse(root, 0, result);
          return result;
      }
      void traverse(Node* root, int level, vector<int>& res){
        //BRUTE FORCE APPROACH
          if(root == NULL) return;
          if(res.size() <= level){
             res.push_back({});
          }
          res[level].push_back(root->data);
          traverse(root->left, level+1, res);
          traverse(root->right, level+1, res);

          //OPTIMAL APPROACH
          if(!root) return;
          
          if(res.size() == level){
              res.push_back(root->data);
          }
          
          traverse(root->left, level+1, res);
          traverse(root->right, level+1, res);
      }
  };