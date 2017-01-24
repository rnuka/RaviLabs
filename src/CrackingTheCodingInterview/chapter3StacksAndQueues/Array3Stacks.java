package CrackingTheCodingInterview.chapter3StacksAndQueues;

/**
 * Created by rnuka on 10/15/15.
 */
/*
Question 3.1 Describe how you could use a single array to implement three stacks.
 */
public class Array3Stacks {
    int stackSize = 9;
    int[] buffer = new int[stackSize*3];
    int[] stackNum = {-1,-1,-1}; //-1 indicate empty stacks

    int availablePosition(int stkNum){
        return stkNum * stackSize + stackNum[stkNum];
    }

    //push the stack num and data
    void push(int stkNum, int data) throws Exception{

        if(stkNum > 2 || stkNum < 0){
            throw new Exception("Invalid stack");
        }


        if(stackNum[stkNum]+1 >= stackSize){
            throw new Exception("Stack size full");
        }


        stackNum[stkNum]++;
        int availPosition = availablePosition(stkNum);
        buffer[availPosition] = data;
    }

    //pop stackNum specific element
    int pop(int stkNum) throws Exception{

        if(stackNum[stkNum] == -1){
            throw new Exception("trying to pop empty stack");
        }

        int availPosition = availablePosition(stkNum);
        int top = buffer[availPosition];
        buffer[availPosition] = 0; //reset buffer
        stackNum[stkNum]--;
        return top;
    }

    //peek stackNum specific element
    int peek(int stkNum) throws Exception{
        if(stackNum[stkNum] == -1){
            throw new Exception("trying to peek empty stack");
        }
        int availPosition = availablePosition(stkNum);
        System.out.println("available position="+availPosition);
        return buffer[availPosition];
    }

    public static void main(String[] args){
        Array3Stacks as = new Array3Stacks();
        try {
            as.push(0, 2);
            as.push(0,1);
            //as.pop(0);
            as.push(1,3);
            as.pop(1);
            //as.pop(1);
            as.push(2,1);
            System.out.println("s0 peek="+as.peek(0));

        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
