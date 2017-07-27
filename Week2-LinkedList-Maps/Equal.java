public class Equal {
    class Pair {
        int start_index;
        int end_index;

        public Pair(int start_index, int end_index) {
            this.start_index = start_index;
            this.end_index = end_index;
        }
    }

    private boolean checkIfSmaller(ArrayList<Integer> result, ArrayList<Integer> newResult) {
        for (int i=0; i< result.size(); i++) {
            // System.out.println(result.get(i)+ " " + newResult.get(i));
            if (result.get(i) < newResult.get(i)) {
                // System.out.println("returning false");
                return false;
            } else if (result.get(i) > newResult.get(i)) {
                // System.out.println("returning true");
                return true;
            }
        }
        return false;
    }

    private void isEqual(Pair p, int i, int j, ArrayList<Integer> result) {

        // System.out.println(p.start_index+ " "+ p.end_index+ " " + i+ " "+ j);
        if ((p.start_index < i) && (p.end_index != j) && (p.end_index != i)) {
            ArrayList<Integer> newResult = new ArrayList<>();
            newResult.add(p.start_index);
            newResult.add(p.end_index);
            newResult.add(i);
            newResult.add(j);
            // System.out.println("result sizw-->>" + result.size());
            if (result.size() == 0 || checkIfSmaller(result, newResult)) {
                // System.out.println("replacing");
                result.clear();
                for (int r : newResult) {
                    // System.out.println(r);
                    result.add(r);
                }
                // System.out.println("================");
            }
        }

    }

    public ArrayList<Integer> equal(ArrayList<Integer> a) {
        if (a == null || a.size() == 0) {
            return a;
        }

        int size = a.size();
        Map<Integer, Pair> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0; i<size; i++) {
            for (int j=i+1; j<size; j++) {
                int sum = a.get(i) + a.get(j);
                if (map.containsKey(sum)) {
                    isEqual(map.get(sum), i, j, result);
                    //   map.get(sum).add(new Pair(i, j));

                } else {

                    map.put(sum, new Pair(i, j));
                }
            }
        }

        return result;
    }
}
