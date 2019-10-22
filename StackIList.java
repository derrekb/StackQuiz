package Stack;

public interface StackIList<X> {
	public StackIList<X> cons(X val);
	//Purpose: add the given value to this list
	public int lenght();
	//Purpose: return the length of this list
	public boolean isEmpty();
	//Purpose: Determine if this list is empty
	public boolean equals(StackIList<X>l);
	//Purpose: To determine if the given list is equal to this list
	public X first() throws Exception;
	//Purpose: To return the first element of this list
	public StackIList<X> rest() throws Exception;
	//Purpose: To return the rest of this list
	public X listref(int i) throws Exception;
	//Purpose: To return the ith element of this list
	public StackIList<X> append(StackIList<X>L);
	//Purpose: To append the given list to this list
	public StackIList<X> reverse();
	//Purpose: To reverse this list
	public <R> StackIList<R>map(StackIFun<X,R>f);
	//Purpose: To map the given function to the elements of this list
	public StackIList<X> filter(StackIPred<X> p);
	//Purpose: Return a list w/ elements of this list satisfying the predicate
	public<R> R foldl(StackIFun2<X,R>f, R res);
	//Purpose: To apply the given function to all the elements of the given
	//list from left to right and return the accumulated result
	public<R> R foldr(StackIFun2<X,R> f, R res);
	//Purpose: To apply the given function to all the elements of the given
		//list from right to left and return the accumulated result
	public boolean ormap(StackIPred<X> p);
	//Purpose: To determine if there exist elements in a given list for which a predicate holds
	public boolean andmap(StackIPred<X> p);
	//Purpose: To determine if there exist elements in a given list for which a predicate holds
	public X second() throws Exception;
	//Purpose: To return the second element of this list
	public X third() throws Exception;
	//Purpose: To return the second element of this list
	public boolean member(StackIPred<X> p);
	//To determine if there exists elements in the given list for which the predicate holds
	public StackIList<X> remove(X v);
	//To remove all instances of v from the given list
}
