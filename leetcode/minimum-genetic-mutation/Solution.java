class Solution {
    private int minMutation = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
    
        mutate(start, end, Arrays.asList(bank), 0);
        return minMutation == Integer.MAX_VALUE ? -1 : minMutation;
    }

    public void mutate(String start, String end, List<String> bank, int depth) {
        if (start.equals(end)) {
            minMutation = Math.min(minMutation, depth);
            return;
        }

        ArrayList<String> copyBank = new ArrayList<>(bank);
        for (int i = 0; i < bank.size(); i++) {
            if (canMutate(start.toCharArray(), bank.get(i).toCharArray())) {
                copyBank.remove(bank.get(i));
                mutate(bank.get(i), end, copyBank, depth + 1);
            }
        }
    }

    public boolean canMutate(char[] from, char[] to) {
        int diff = 0;
        for (int i = 0; i < from.length; i++) {
            if (from[i] != to[i]) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }
        
        return true;
    }
}

