package leetcode.lcp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : ddv
 * @since : 2020/9/11 12:11 PM
 */
public class L14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        if (str.length() == 0) {
            return "";
        }

        CharTree rootTree = CharTree.valueOf(null);
        for (String string : strs) {
            rootTree.generateNode(string);
        }
        return rootTree.getSameString();
    }

    static class CharTree {
        private Character character;
        private Map<Character, CharTree> charTreeMap = new HashMap<>();

        public void generateNode(String str) {
            char[] chars = str.toCharArray();
            CharTree nextTree = null;
            for (char aChar : chars) {
                if (nextTree == null) {
                    nextTree = charTreeMap.get(aChar);
                }

                if (nextTree == null) {
                    nextTree = CharTree.valueOf(aChar);
                    charTreeMap.put(aChar, nextTree);
                }
            }
        }

        public CharTree getNext(Character character) {
            return charTreeMap.get(character);
        }

        public String getSameString() {
            return "";
        }

        public static CharTree valueOf(Character character) {
            CharTree charTree = new CharTree();
            charTree.character = character;
            return charTree;
        }
    }

    public static void main(String[] args) {
        L14 l14 = new L14();
        System.out.println(l14.longestCommonPrefix(new String[] {"c", "c"}));
    }
}
