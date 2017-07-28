public class ShortestUniquePrefix {
    class Trie {
        char val;
        Trie [] children;
        int count;

        public Trie(char val) {
            this.val = val;
            children = new Trie[26];
            count = 1;
        }
    }

    private void insertIntoTrie(Trie root, String s) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if (root.children[val] == null) {
                root.children[val] = new Trie(s.charAt(i));
            } else {
                root.children[val].count += 1;
            }
            root = root.children[val];
        }
    }

    private String findPrefix(Trie root, String s) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            if (root.children[val] == null) {
                return sb.toString();
            } else if(root.children[val].count == 1) {
                sb.append(root.children[val].val);
                return sb.toString();
            } else {
                sb.append(root.children[val].val);
                root = root.children[val];
            }

        }

        return sb.toString();

    }

    public ArrayList<String> prefix(ArrayList<String> a) {
        if (a == null || a.size() == 0) {
            return a;
        }

        Trie root = new Trie('/');

        for (String s : a) {
            Trie current = root;
            insertIntoTrie(current, s);
        }

        ArrayList<String> result = new ArrayList<>();
        for (String s : a) {
            Trie current = root;
            result.add(findPrefix(current, s));

        }

        return result;

    }
}
