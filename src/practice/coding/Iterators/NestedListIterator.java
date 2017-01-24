package practice.coding.Iterators;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
Given a nested list of integers, implement an iterator to flatten it.
Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
----------
Input: [[1,1],2,[1,1]]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
Output: [1,1,2,1,1]

Example 2:
----------
Input: [1,[4,[6]]]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
Output: [1,4,6]
 */
public class NestedListIterator implements Iterator<Integer>{

    Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public NestedListIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;

        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()){
                return true;
            }else{
                stack.pop();
                for(int i=top.getList().size()-1; i>=0; i--){
                    stack.push(top.getList().get(i));
                }
            }
        }

        return false;
    }

}
