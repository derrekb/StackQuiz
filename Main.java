package Stack;

import Stack.IList;
import Stack.IStack;
import Stack.MTList;
import Stack.MTStack;

public class Main {
	/** NOTE: ADD MORE COMMENTS THEN WHAT I HAVE
     * reverse: Reverses a given list using the given stack
     * @param aList The list that you want to reverse
     * @param stack The stack that you will use
     * @return aList that is reversed
     */
    public static IList reverse(IList aList, IStack stack) {

        // While the list is not empty recurse
        while(!aList.isEmpty()) {
            stack = stack.push(aList.car()); // push the first element of the list onto the stack
            aList = aList.cdr(); // set the list to the rest of the elements
        }

        // While the stack is not empty pop elements off
        while(!stack.isEmpty()) {
            try {
                aList = aList.addEnd(stack.top()); // Place the element at the top of the stack to the back of the list
                stack = stack.pop(); // set the stack equal to the rest of the stack

            } catch (Exception e) {
                e.printStackTrace(); // handle the error
            }
        }

        return aList; // return the reversed list
    }


    public static void main(String[] args) {
        IList list = new MTList<Integer>().cons(4).cons(5).cons(6).cons(7).cons(7);
        System.out.println(list.toString());


        IList reverseList = reverse(list, new MTStack<Integer>());
        System.out.println(reverseList.toString());

    }

}
