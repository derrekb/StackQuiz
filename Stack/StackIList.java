package Stack;

public interface StackIList<X> {
	public StackIList<X> cons(X val);
	//Purpose: add the given value to this stack
	public int lenght();
	//Purpose: return the length of this stack
	public boolean isEmpty();
	//Purpose: Determine if this stack is empty
	public boolean equals(StackIList<X>l);
	//Purpose: To determine if the given stack is equal to this stack
	public X first() throws Exception;
	//Purpose: To return the first element of this stack
	public StackIList<X> rest() throws Exception;
	//Purpose: To return the rest of this stack
	public X stackref(int i) throws Exception;
	//Purpose: To return the ith element of this stack
	public StackIList<X> append(StackIList<X>L);
	//Purpose: To append the given stack to this stack
	public StackIList<X> reverse();
	//Purpose: To reverse this stack
	public <R> StackIList<R>map(StackIFun<X,R>f);
	//Purpose: To map the given function to the elements of this stack
	public StackIList<X> filter(StackIPred<X> p);
	//Purpose: Return a stack w/ elements of this stack satisfying the predicate
	public<R> R foldl(StackIFun2<X,R>f, R res);
	//Purpose: To apply the given function to all the elements of the given
	//stack from left to right and return the accumulated result
	public<R> R foldr(StackIFun2<X,R> f, R res);
	//Purpose: To apply the given function to all the elements of the given
	//stack from right to left and return the accumulated result
	public boolean ormap(StackIPred<X> p);
	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public boolean andmap(StackIPred<X> p);
	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public X second() throws Exception;
	//Purpose: To return the second element of this stack
	public X third() throws Exception;
	//Purpose: To return the second element of this stack
	public boolean member(StackIPred<X> p);
	//To determine if there exists elements in the given stack for which the predicate holds
	public StackIList<X> remove(X v);
	//To remove all instances of v from the given stack
	public StackIList<X> pop() throws Exception;
	//removes top from stack
	public StackIList<X> push(X v);
	//adds an element to the stack
	public X top() throws Exception;
	// returns top of stack

	// Adds an element to the end of the list
	public StackIList<X> appendVal(X val) throws Exception;

	// Prints the list as a string
	public String toString();
}
