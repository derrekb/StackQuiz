package Stack;

import Stack.ISTACK;
import Stack.MTSTACK;


public class Main {
	/** 
     * reverse: Reverses a given list using the given stack
     * @param A The list that you want to reverse
     * @param stack The stack that you will use
     * @return aList that is reversed
     */
    public static StackIList reverse(StackIList A, ISTACK stack) {
        // While the list is not empty recurse
        while(!A.isEmpty()) {

            //Invariant: [0.. n-1) in the stack A is in reverse order (n-1) is the unprocessed part of list

            try {

                //Invariant: [0...n) is reversed in stack
                stack = stack.push(A.first());
                // push the first element of the list onto the stack

                //Invariant: [n....i) is unprocessed
                A = A.rest();
                // set the list to the rest of the elements
                //Termination Argument: The loop will terminate because the stack will eventually become empty because
                // the first element of the list is pushed every loop. Since the top car of the stack is pushed after every loop
                // the stack will become empty making the while false terminating the loop.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // While the stack is not empty pop elements off
        while(!stack.emptyStack()) {
            try {
                //Invariant:[0.. n-1) in the stack is in reverse order (n-1 is the unprocessed part of list

                // Place the element at the top of the stack to the back of the list
                //Invariant: [0...n) is reversed in stack
                // Place the element at the top of the stack to the back of the list
                A = A.appendVal(stack.top());
                // set the stack equal to the rest of the stack
                stack = stack.pop();
                //Termination Argument: The loop will terminate because the stack will eventually become empty because
                // the first element of the list is pushed every loop. Since the top car of the stack is pushed after every loop
                // the stack will become empty making the while false terminating the loop.

            } catch (Exception e) {
                e.printStackTrace(); // handle the error
            }

        }
        // return the reversed list
        return A;
    }


    public static void main(String[] args) {
        StackIList<Integer> list1 = new StackNMTLIST<Integer>(1, new StackMTLIST<>());
        list1 = list1.cons(2).cons(3).cons(4);

        StackIList<Integer> list1reversed = new StackNMTLIST<>(4, new StackMTLIST<>());
        list1reversed = list1reversed.cons(3).cons(2).cons(1);


        StackIList<Integer> postReversel1 = reverse(list1, new MTSTACK<Integer>() );
        System.out.println(postReversel1.equals(list1reversed));
    }
}
