import java.util.ArrayList;
import java.util.List;

/**
 *
 */

/**
 * @author Shaurya
 */
public class TreeTest {

  private static TreeNode root;

  /**
   * @param args
   */
  static {
    List<Integer> dataList = new ArrayList<Integer>();
    dataList.add(2);
    dataList.add(1);
    dataList.add(0);
    dataList.add(5);
    dataList.add(8);
    dataList.add(3);
    dataList.add(9);
    dataList.add(7);
    root = populateTree(dataList, new TreeNode());
  }

  public static void main(String[] args) {
    TreeTest test = new TreeTest();
    List<Integer> inorder = new ArrayList<Integer>();
    List<Integer> preorder = new ArrayList<Integer>();
    List<Integer> postorder = new ArrayList<Integer>();
    List<Integer> tracePath = new ArrayList<>();
    test.inorderTraversal(root, inorder);
    test.preorderTraversal(root, preorder);
    test.postorderTraversal(root, postorder);
    test.findPath(root, 0, tracePath);
    for (Integer in : tracePath) {
      System.out.println(in);
    }
  }

  //Preorder traversal
  //NLR
  public boolean findPath(TreeNode root, Integer data, List<Integer> path) {
    if (root != null) {
      path.add(root.getData());
      if (root.getData() == data.intValue()) {
        return true;
      } else {
        if (this.findPath(root.getLeft(), data, path) ||
            this.findPath(root.getRight(), data, path)) {
          return true;
        } else {
          path.remove(path.size() - 1);
          return false;
        }
      }
    }else{
      return false;
    }
  }

  //LRN
  public void postorderTraversal(TreeNode root, List<Integer> list) {
    if (root.getLeft() == null) {
      list.add(root.getData());
      return;
    } else {
      if (root.getLeft() != null) {
        this.postorderTraversal(root.getLeft(), list);
      }
      if (root.getRight() != null) {
        this.postorderTraversal(root.getRight(), list);
      }
      list.add(root.getData());
    }
  }

  //NLR
  public void preorderTraversal(TreeNode root, List<Integer> list) {
    if (root != null) {
      list.add(root.getData());
      this.preorderTraversal(root.getLeft(), list);
      this.preorderTraversal(root.getRight(), list);
    } else {
      return;
    }
  }

  //LNR
  public void inorderTraversal(TreeNode root, List<Integer> list) {
    if (root.getLeft() == null) {
      list.add(root.getData());
      return;
    } else {
      if (root.getLeft() != null) {
        this.inorderTraversal(root.getLeft(), list);
      }
      list.add(root.getData());
      if (root.getRight() != null) {
        this.inorderTraversal(root.getRight(), list);
      }
    }
  }

  public static TreeNode populateTree(List<Integer> dataList, TreeNode root) {
    root.setData(dataList.get(0));
    for (int i = 1; i < dataList.size(); i++) {
      insert(dataList.get(i), root);
    }
    return root;
  }

  public static void insert(int data, TreeNode root) {
    TreeNode temp = new TreeNode();
    temp.setData(data);
    if (root.getData() >= data) {
      if (root.getLeft() == null) {
        root.setLeft(temp);
      } else {
        insert(data, root.getLeft());
      }
    } else {
      if (root.getRight() == null) {
        root.setRight(temp);
      } else {
        insert(data, root.getRight());
      }
    }
  }

}
