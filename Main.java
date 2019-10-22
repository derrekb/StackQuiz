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
            stack = stack.push(A.car()); // push the first element of the list onto the stack
            A = A.cdr(); // set the list to the rest of the elements
        }

        // While the stack is not empty pop elements off
        while(!stack.isEmpty()) {
            try {
                A = A.addEnd(stack.top()); // Place the element at the top of the stack to the back of the list
                stack = stack.pop(); // set the stack equal to the rest of the stack

            } catch (Exception e) {
                e.printStackTrace(); // handle the error
            }
        }

        return A; // return the reversed list
    }


    public static void main(String[] args) {
        ISTACK<X> B = new MTSTACK<Integer>().push(4).push(5).push(6).push(7).push(7);
        System.out.println(B.toString());


        ISTACK<X> reversestack = reverse(B, new MTStack<Integer>());
        System.out.println(reversestack.toString());

    }

}
