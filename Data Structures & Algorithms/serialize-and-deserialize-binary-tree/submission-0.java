public class Codec {
    public String serialize(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();

        StringBuilder s = new StringBuilder();

        if(root == null)return s.toString();

        q.add(root);

        while(!q.isEmpty()){
            TreeNode t = q.pollFirst();
            if(t == null){
                s.append("null,");
            }else{
                s.append(t.val);
                s.append(",");
            }

            if(t == null){
                continue;
            }

            q.addLast(t.left);
            q.addLast(t.right);
        }

        s.deleteCharAt(s.length()-1);

        return s.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0)return null;
        String[] s = data.split(",");

        Deque<TreeNode> q = new ArrayDeque<>();// can't contain null , also we don't need

        int n = s.length;

        if(s[0].equals("null")){
            return null;
        }

        
        int index = 1;

        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);

        while(!q.isEmpty()){
            TreeNode t = q.pollFirst();
            if(s[index].equals("null")){
                index++;
            }else{
                t.left = new TreeNode(Integer.parseInt(s[index++]));
                q.addLast(t.left);
            }

            if(s[index].equals("null")){
                index++;
            }else{
                t.right = new TreeNode(Integer.parseInt(s[index++]));
                q.addLast(t.right);
            }
            
        }

        return root;
    }
}