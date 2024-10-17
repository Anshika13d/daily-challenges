class Pair{
    char ch;
    int val;

    Pair(char ch, int val){
        this.ch = ch;
        this.val = val;
    }
}
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.val, x.val));

        if(a > 0) pq.offer(new Pair('a', a));
        if(b > 0) pq.offer(new Pair('b', b));
        if(c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair pair = pq.poll();
            char ch = pair.ch;
            int freq = pair.val;

            if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) != ch){
                sb.append(ch);
                freq--;
            }
            else if(sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2) && sb.charAt(sb.length() - 1) == ch){
                if(!pq.isEmpty()){
                    Pair pair2 = pq.poll();
                    char ch2 = pair2.ch;
                    int freq2 = pair2.val;

                    sb.append(ch2);
                    freq2--;

                    if(freq2 != 0) pq.offer(new Pair(ch2, freq2));
                }
                else break;
            }
            else{
                sb.append(ch);
                freq--;
            }

            if(freq != 0) pq.offer(new Pair(ch, freq));
        }

        return sb.toString();
    }
}
