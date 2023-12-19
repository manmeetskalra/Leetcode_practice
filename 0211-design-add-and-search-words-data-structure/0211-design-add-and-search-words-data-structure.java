class WordDictionary {

    Map<Integer, List<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }
    
    public void addWord(String word) {
        List<String> list;
        if(map.containsKey(word.length())){
            list = map.get(word.length());
        }
        else{
            list = new ArrayList<>();
        }
        list.add(word);
        map.put(word.length(), list);
    }
    
    public boolean search(String word) {
        if(!map.containsKey(word.length())){
            return false;
        }
        List<String> list= map.get(word.length());
        for(int i=0;i<list.size();i++){
            if(list.get(i).length()!=word.length()){
                continue;
            }
            String s = list.get(i);
            boolean res = true;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)=='.'){
                    continue;
                }
                if(s.charAt(j)!=word.charAt(j)){
                    res = false;
                    break;
                }
            }
            if(res){
                return res;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */