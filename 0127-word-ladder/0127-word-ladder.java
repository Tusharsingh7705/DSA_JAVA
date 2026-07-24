class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String>st=new HashSet<>(wordList);
        if(!st.contains(endWord)) return 0;
        Queue<String>q=new LinkedList<>();
        q.offer(beginWord);
        int count=1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                String word=q.poll();
                if(word.equals(endWord)) return count;
            
                char[] arr=word.toCharArray();
                for(int j=0;j<arr.length;j++){
                    char or=arr[j];
                    for(char ch='a';ch<='z';ch++){
                        arr[j]=ch;
                        String nw=new String(arr);
                        if(st.contains(nw)){
                            q.offer(nw);
                            st.remove(nw);
                        }
                    }
                    arr[j]=or;
                }
            }
            count++;
        }
        return 0;
    }
}