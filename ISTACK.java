package Stack;

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
	//purpose: To obtain all the elements of the stack besides top
	public ISTACK<X> stackrest() throws Exception;
	//purpose: returns all elements in the stac
	public String ToString();
	}
