package codes.designs;

import java.util.Arrays;

/**
 * 前缀树 💕 用数组[]模拟下继节点
 *
 * @author : ddv
 * @date : 2018/11/16 下午3:39
 */
class TrieNode {
    public int pass;
    public int end;
    public TrieNode[] nexts;

    public TrieNode() {
        pass = 0;
        end = 0;
        nexts = new TrieNode[26];
    }

    @Override
    public String toString() {
        return "TrieNode{"
                + "pass="
                + pass
                + ", end="
                + end
                + ", nexts="
                + Arrays.toString(nexts)
                + '}';
    }
}

public class TrieTree {
    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    @Override
    public String toString() {
        return "TrieTree{" + "root=" + root + '}';
    }

    private void add(String word) {
        if (null == word || word.length() < 1) return;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    private boolean isExist(String word) {
        if (word == null || word.length() < 1) return false;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return true;
    }

    private void remove(String word) {
        if (word == null) {
            return;
        }
        if (!isExist(word)) return;
        char[] chars = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for (int i = 0; i < chars.length; i++) {
            if (node.nexts[index].pass == 1) {
                node.nexts[index] = null;
                return;
            } else {
                node.nexts[index].pass--;
            }
            node = node.nexts[index];
        }
        node.end--;
    }

    private int prefixNumber(String word) {
        if (word == null) return 0;
        char[] chars = word.toCharArray();
        TrieNode node = root;
        int index;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            node = node.nexts[index];
            if (node == null) return 0;
        }
        return node.pass;
    }

    public static void main(String[] args) {
        TrieTree root = new TrieTree();
        root.add("abc");
        root.add("abd");
        System.out.println(root.prefixNumber("b"));
    }
}
