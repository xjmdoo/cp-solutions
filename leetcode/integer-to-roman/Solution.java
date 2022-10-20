class Solution {
    public String intToRoman(int num) {
        Map<Integer, String> m = new TreeMap<>(Comparator.reverseOrder());
        m.put(1, "I");
        m.put(4, "IV");
        m.put(5, "V");
        m.put(9, "IX");
        m.put(10, "X");
        m.put(40, "XL");
        m.put(50, "L");
        m.put(90, "XC");
        m.put(100, "C");
        m.put(400, "CD");
        m.put(500, "D");
        m.put(900, "CM");
        m.put(1000, "M");

        StringBuilder res = new StringBuilder("");
        while (num > 0) {
            for (Integer i : m.keySet()) {
                if (num - i >= 0) {
                    num -= i;
                    res.append(m.get(i));
                    break;
                }
            }
        }

        return res.toString();
    }
}

