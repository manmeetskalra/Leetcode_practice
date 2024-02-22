class Solution {
    public boolean winnerOfGame(String colors) {
        int alice = colors.length()-colors.replaceAll("A{3,}","AA").length();
        int bob = colors.length()-colors.replaceAll("B{3,}","BB").length();
        if(alice<=bob){
            return false;
        } return true;
    }
}