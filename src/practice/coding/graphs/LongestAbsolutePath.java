package practice.coding.graphs;

/*
Question:

Suppose we abstract our file system by a string in the following manner:

The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:

dir
    subdir1
    subdir2
        file.ext
The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a
file file.ext.

The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 represents:

dir
    subdir1
        file1.ext
        subsubdir1
    subdir2
        subsubdir2
            file2.ext
The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext
 and an empty second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory
 subsubdir2 containing a file file2.ext.

We are interested in finding the longest (number of characters) absolute path to a file within our
file system. For example, in the second example above, the longest absolute
path is "dir/subdir2/subsubdir2/file2.ext", and its length is 32 (not including the double quotes).

Given a string representing the file system in the above format, return the length of the
longest absolute path to file in the abstracted file system. If there is no file in the
system, return 0.

Note:
The name of a file contains at least a . and an extension.
The name of a directory or sub-directory will not contain a ..
Time complexity required: O(n) where n is the size of the input string.

Notice that a/aa/aaa/file1.txt is not the longest file path, if there
 is another path aaaaaaaaaaaaaaaaaaaaa/sth.png
 */

import java.util.*;

/*
Approach: Convert the given string into a graph and find longest path \t represents level of the node
and weight of each node is total characters in the file/directory name + level.
 */

//TODO: cleanup the code
public class LongestAbsolutePath {

    public int longestPath(String input){
        int maxPathLength=0, currPathLength = 0;
        int currLevel = 0, topLevel = -1;
        Stack<String> stack = new Stack<>();
        for(String curr: input.split("\\\\n")){
            currLevel = getLevel(curr);
            if(currLevel>topLevel){
                stack.push(curr);
                topLevel = currLevel;
            }else{ //currLevel is less than top level which means new absolute path is forming.
                while(currLevel<=topLevel) {
                    System.out.println("popping top::"+stack.peek());
                    String top = stack.pop();
                    topLevel = getLevel(stack.peek());
                    currPathLength-=(top.length()-topLevel);
                }
            }
            currPathLength += (curr.length()-2*currLevel)+1;
            System.out.println("curr="+curr+" and level="+currLevel+" current length until::"+currPathLength);
            if(currPathLength>maxPathLength){
                maxPathLength = currPathLength;
            }
        }

        return maxPathLength;
    }

    public int getLevel(String s){
        return (s.length() - s.replaceAll("\\\\t","").length())/2;
    }

    public void testcase2(){
        System.out.println("**** TESTCASE-2 ********");
        String input = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
        System.out.println("input length = "+input.length());
        System.out.println("Maximum absolute length of input="+(longestPath(input)-1));
    }

    public void testcase1(){
        System.out.println("**** TESTCASE-1 ********");
        String input = "123\\n\\t456\\n\\t\\t7890\\n\\t45678901234567890";
        System.out.println("input length = "+input.length());
        System.out.println("Maximum absolute length of input="+(longestPath(input)-1));
    }

    public void testbed(){
        testcase1();
        testcase2();
    }
    public static void main(String args[]){
        LongestAbsolutePath l = new LongestAbsolutePath();
        l.testbed();
    }



}
