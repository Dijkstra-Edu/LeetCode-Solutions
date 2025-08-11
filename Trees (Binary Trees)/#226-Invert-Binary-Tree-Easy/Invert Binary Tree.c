
struct TreeNode* invertTree(struct TreeNode* root) {

    if (root == NULL)
    return NULL;

    //A simple swap of the left and right nodes of the given tree
    struct TreeNode *temp;

    temp = root->right;
    root->right = root->left;
    root->left = temp;  

    //recursive swapping at each node
    invertTree(root->right);
    invertTree(root->left);

    return root;
    
}

//A simple, intuitive, recursive approach
//Time Complexity: O(n)
//Space Complexity:: O(n)