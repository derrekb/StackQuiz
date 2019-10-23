package Stack;
import Stack.ISTACK;
import Stack.MTSTACK;


public class Main {
	/** 
     * reverse: Reverses a given list using the given stack
     * @param aList The list that you want to reverse
     * @param stack The stack that you will use
     * @return aList that is reversed
     */
    public static ISTACK<X> reverse(StackIList<X> A, ISTACK<X> stack) {
        // While the list is not empty recurse
        while(!A.isEmpty()) {

            //Invariant: [0.. n-1) in the stack A is in reverse order (n-1) is the unprocessed part of list
            

            //Invariant: [0...n) is reversed in stack
            stack = stack.push(A.car());
             // push the first element of the list onto the stack
            
            //Invariant: [n....i) is unprocessed
            A = A.cdr();
            // set the list to the rest of the elements

            //Termination Argument: The loop will terminate because the stack will eventually become empty because
            // the first eleement of the list is pushed every loop. Since the top car of the stack is pushed after every loop
            // the stack will become empty making the while false terminating the loop.
        }

        // While the stack is not empty pop elements off
        while(!stack.isEmpty()) {
            try {
                //Invariant:[0.. n-1) in the stack is in reverse order (n-1 is the unprocessed part of list

                // Place the element at the top of the stack to the back of the list
                //Invariant: [0...n) is reversed in stack
                // Place the element at the top of the stack to the back of the list
                A = A.addEnd(stack.top());
                // set the stack equal to the rest of the stack
                stack = stack.pop();

            } catch (Exception e) {
                e.printStackTrace(); // handle the error
            }
            //Termination Argument: The loop will terminate because the stack will eventually become empty because
            // the first eleement of the list is pushed every loop. Since the top car of the stack is pushed after every loop
            // the stack will become empty making the while false terminating the loop.
        }
        // return the reversed list
        return A;
    }


    public static void main(String[] args) {
        ISTACK<X> B = new MTSTACK<Integer>().push(4).push(5).push(6).push(7).push(7);
        System.out.println(B.toString());


        ISTACK<X> reversestack = reverse(B, new MTStack<Integer>());
        System.out.println(reversestack.toString());

    }

}
