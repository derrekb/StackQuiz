package Stack;
import Stack.ISTACK;
import Stack.MTSTACK;


public class Main {
	/** NOTE: ADD MORE COMMENTS THEN WHAT I HAVE
     * reverse: Reverses a given list using the given stack
     * @param aList The list that you want to reverse
     * @param stack The stack that you will use
     * @return aList that is reversed
     */
    public static ISTACK<X> reverse(StackIList<X> A, ISTACK<X> stack) {
        // While the list is not empty recurse
        while(!A.isEmpty()) {
            // push the first element of the list onto the stack
            stack = stack.push(A.car());
            // set the list to the rest of the elements
            A = A.cdr();
        }

        // While the stack is not empty pop elements off
        while(!stack.isEmpty()) {
            try {
                // Place the element at the top of the stack to the back of the list
                A = A.addEnd(stack.top());
                // set the stack equal to the rest of the stack
                stack = stack.pop();

            } catch (Exception e) {
                e.printStackTrace(); // handle the error
            }
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
