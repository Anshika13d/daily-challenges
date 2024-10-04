class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        //1,2,3,3,4,5
        long chem = 0;
        
        Arrays.sort(skill);
        int i = 0;
        int j = n - 1;
        long sum = skill[i] + skill[j];

        while(i < j){
            int add = skill[i] + skill[j];
            if(add != sum) return -1;
            chem += skill[i] * skill[j];
            i++;
            j--;
        }

        return chem;
    }
}