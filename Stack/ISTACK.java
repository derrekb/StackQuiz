package Stack;

import Stack.ISTACK;

/**
 *Purpose: Interface for the Stack: Does not use List
 *
 * @param <X>
 */
public interface ISTACK<X> {
	//purpose: adds top to stack
	public ISTACK<X> push(X v);
	//purpose: gets top of Stack
	public X top() throws Exception;
	//purpose: removes the top from the stack
	public ISTACK<X> pop() throws Exception;
	//Purpose: to check if stack is empty
	public boolean emptyStack();
	//purpose: To reverse the stack
	public ISTACK<X> reverse();
	//purpose: To return all elements in the stack as strings
	public String ToString();
	}
