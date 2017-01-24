package practice.coding.strings;

public class PatternSearch {
    public PatternSearch() {
    }
    
    String origText = "fulteftlingsuccessfulypatlterns";
    String pattern = "ful";
    public void patternSearch(){
        for(int i=0;i<(origText.length()+1-pattern.length());i++){
            for(int j=0;j<pattern.length();j++){
                if(pattern.charAt(j)!=origText.charAt(i+j)){
                    break;
                }
                if(j==pattern.length()-1){
                    System.out.println("Substring found at"+(i+1)+":"+(i+1+j));
                }
            }
        }
    }
    
    public static void main(String args[]){
        PatternSearch ps=new PatternSearch();
        ps.patternSearch();
    }
}
