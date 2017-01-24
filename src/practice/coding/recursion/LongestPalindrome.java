package practice.coding.recursion;

public class LongestPalindrome{



	//recursive approach2: cleaner than getLongestPalindrome and more readable time: O(n^3)
	public String getLongestPalindrome2(String inputStr){
		//char[] inputArray = inputStr.toCharArray();
		int inputArrayLen = inputStr.length();
		String maxPalindrome="";
		//loop through each character
		for(int i=0; i<inputArrayLen; i++){
			for(int j=inputArrayLen-1; j>=i; j-- ){
				String currString = inputStr.substring(i, j);
				if (isPalindrome(currString) && currString.length()>maxPalindrome.length()){
					maxPalindrome = currString;
				}
			}
		}
		return maxPalindrome;
	}

	private boolean isPalindrome(String s){
		int n = s.length();
		for(int i=0; i<n/2; i++){
			if(s.charAt(i) != s.charAt(n-i-1)){
				return false;
			}
		}
		return true;
	}
	

	//recursive approach1: Very unclean and not readable time: O(n^3)
	public StringBuilder getLongestPalindrome(String inputStr){
		
		StringBuilder inputString = new StringBuilder(inputStr);
		StringBuilder batchString = new StringBuilder(inputStr);;
		StringBuilder iterationString = new StringBuilder(inputStr);;
		StringBuilder currentPalindrome=new StringBuilder();
		StringBuilder currentLeftPalindrome=new StringBuilder();
		StringBuilder currentRightPalindrome=new StringBuilder();
		StringBuilder maxPalindrome=new StringBuilder();

		//Loop through batches
		for(int batch=0; batch < inputString.length(); batch++){
			//decide search window
			batchString = new StringBuilder(inputString.substring(batch));
                    	
			//For each batch string: check all possible combinations
			for(int i=0; i<batchString.length();i++){
				
				//form new substring to navigate
				iterationString = new StringBuilder(batchString.substring(0,batchString.length()-i));
                                
				 //reset variables
				 currentLeftPalindrome=new StringBuilder("");
				 currentRightPalindrome=new StringBuilder("");
				 currentPalindrome = new StringBuilder("");
                                
				//take each iterationString and look for palindrome
				for(int j=0; j<iterationString.length()/2; j++){
					if(iterationString.charAt(j)==iterationString.charAt(iterationString.length()-(j+1))){
						currentLeftPalindrome.append(iterationString.charAt(j));
						String str = iterationString.charAt(j)+currentRightPalindrome.toString();
						currentRightPalindrome = new StringBuilder(str);
					}else{
						currentLeftPalindrome=new StringBuilder("");
						currentRightPalindrome=new StringBuilder("");
						currentPalindrome = new StringBuilder("");
					}
				} 
				//insert middle character if needed
				if(iterationString.length()%2==1){
					currentPalindrome.append(currentLeftPalindrome);
					currentPalindrome.append(iterationString.charAt(iterationString.length()/2));
					currentPalindrome.append(currentRightPalindrome);
				}else{
					currentPalindrome.append(currentLeftPalindrome);
					currentPalindrome.append(currentRightPalindrome);
				}
                                
                                //check currPalindrome against max palindrome
				if(currentPalindrome.length()>maxPalindrome.length()){
					maxPalindrome = currentPalindrome;
				}
			
			}

		}

		return maxPalindrome;


	}


	public static void main(String[] args){
             	LongestPalindrome lp = new LongestPalindrome();
		System.out.println("longest palindrome1="+lp.getLongestPalindrome("ccdababadd"));
		System.out.println("longest palindrome2="+lp.getLongestPalindrome2("ccdababadd"));
	}
}
