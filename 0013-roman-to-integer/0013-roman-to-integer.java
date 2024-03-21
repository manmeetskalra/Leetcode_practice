class Solution {
    public int romanToInt(String s) {
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("I",1);
        hash.put("V",5);
        hash.put("X",10);
        hash.put("L",50);
        hash.put("C",100);
        hash.put("D",500);
        hash.put("M",1000);
        hash.put("IV",4);
        // hash.put("VI",6);
        hash.put("IX",9);
        // hash.put("XI",11);
        hash.put("XL",40);
        // hash.put("LX",60);
        hash.put("XC",90);
        // hash.put("CX",110);
        hash.put("CD",400);
        // hash.put("DC",600);
        hash.put("CM",900);
        // hash.put("MC",1100);
        
        int i=0;
        int sum=0;
        while(i<s.length()){
            String s1;
            String s2 = s.substring(i,i+1);
            if(i<s.length()-1){
                s1 = s.substring(i,i+2);
            }else{
                s1="";
            }
            if(s1!=null && s1.length()!=0 && hash.containsKey(s1)){
                // System.out.println(s1);
                sum+=hash.get(s1);
                i=i+2;
            }else{
                // System.out.println(s2);
                sum+=hash.get(s2);
                i=i+1;
            }
        }
        return sum;
    }
}