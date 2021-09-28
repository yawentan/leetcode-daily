package yawen;

import java.util.*;
import yawen.datastruct.*;

public class LC94M {
    List<Integer> ans = new LinkedList<Integer>();
    public void Inorder(TreeNode T){
        if(T == null)
            return;
        Inorder(T.left);
        this.ans.add(T.val);
        Inorder(T.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Inorder(root);
        return this.ans;
    }
}
