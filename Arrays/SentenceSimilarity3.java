class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        String[] a1 = s1.split(" ");
        String[] a2 = s2.split(" ");

        int n = a1.length;
        int m = a2.length;

        int i = 0;
        int j = 0;

        // Check for matching prefix
        while (i < n && i < m && a1[i].equals(a2[i])) {
            i++;
        }

        // Check for matching suffix
        while (j < n - i && j < m - i && a1[n - 1 - j].equals(a2[m - 1 - j])) {
            j++;
        }

        // If the remaining part between prefix and suffix doesn't match, return false
        return i + j == Math.min(n, m);
    }
}
