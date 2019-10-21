package Stack;

public interface ISTACK<X> {
	public ISTACK<X> push(X v);
	//adds top to stack
	public X top() throws Exception;
	//gets top of Stack
	public ISTACK<X> pop() throws Exception;
	//removes the top from the stack
	public boolean emptyStack();
	//Purpose: to check if stack is empty
	public ISTACK<X> reverse();
	//To reverse the stack
	public ISTACK<X> stackrest() throws Exception;
	//To obtain all the elements of the stack besides top
	public String ToString();
	//returns all elements in the stack

}
