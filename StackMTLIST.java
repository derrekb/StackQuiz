package Stack;

/**
 * Purpose: Class for empty Stack : with list
 *
 * @param <X>
 */

public class StackMTLIST<X> implements StackIList<X>{
	
	//Purpose: initializes an emtpy stack
	public StackMTLIST() {}
	
	//Purpose: To add an element to a stack
	public StackIList<X> cons(X v){
		//returns stack with v at the top of stack
		return(new StackNMTLIST<X>(v,this));}
	
	//Purpose: to determine the length of the stack
	public int lenght() {
		//stack is empty
		return 0;}
	
	//Purpose: to determine if stack is empty
	public boolean isEmpty() {
		return true;}
	
	//Purpose: To determine if this stack is equal to stack l
	public boolean equals(StackIList<X> l) {
		//returns true if l is empty because that is only when it will equal this stack
		return l.isEmpty();}
	
	//Purpose: To determine the item at the top of the stack
	public X first() throws Exception{
		//Exception: throws exception because this stack is empty
		throw new Exception("Method first applied to an empty stack");}
	
	//Purpose: To return the rest of the stack after the top item has been removed
	public StackIList<X> rest() throws Exception{
		//Exception: because this stack is empty
		throw new Exception("Method rest applied to an empty stack");}
	
	//Purpose: To return the ith element of the stack
	public X stackref(int i) throws Exception{
		//Exception: because this stack is empty
		throw new Exception("Method listref applied to an empty stack");	}
	
	//Purpose: To append this stack with a stack L
	public StackIList<X> append(StackIList<X>L){
		return L;}
		//returns L since this stack is empty
	
	//Purpose: To reverse this stack
	public StackIList<X> reverse() {
		return this;}
		//returns this stack since it is empty
	
	//Purpose: To map the given function to the elements of this stack
	public <R> StackIList<R> map(StackIFun<X,R>f){
		return new StackMTLIST<R>();}
		//returns stack with function StackIFun implemented on this stack
	
	//Purpose: to filter this stack by predicate p
	public StackIList<X> filter(StackIPred<X>p){
		return this;}
		//returns this stack since it is empty
	
	//Purpose: To apply the given function to all the elements of the given
	//stack from left to right and return the accumulated result
	public <R> R foldl(StackIFun2<X,R>f, R res) {
		return res;}
	
	//Purpose: To apply the given function to all the elements of the given
	//stack from right to left and return the accumulated result
	public <R> R foldr(StackIFun2<X,R>f, R res) {
		return res;}

	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public boolean ormap(StackIPred<X> p){
		return false;}
		//since this stack is empty
	
	//Purpose: To determine if there exist elements in a given stack for which a predicate holds
	public boolean andmap(StackIPred<X> p){
		return false;}
		//since this stack is empty
	
	//Purpose: To return the second element in the stack
	public X second() throws Exception{
		throw new Exception("Method second applied to an empty stack");}
		//Exception: empty stack does not have a second element
	
	//Purpose: To return the third element of the stack
	public X third() throws Exception{
		throw new Exception("Method third applied to an empty stack");}
		//Exception: empty stack does not have a third element
	
	//Purpose:To determine if there exists elements in the given stack for which the predicate holds
	public boolean member(StackIPred<X> p) {
		return false;}
		//since stack is empty
	
	//Purpose: To remove an element from the stack
	public StackIList<X> remove(X v) {
		return this;}
		//since stack is empty

	//Purpose: To obtain the rest of the stack
	public StackIList<X> pop() throws Exception {
		throw new Exception("Method pop applied to an empty list");}
		//Exception: this stack is empty
	
	//Purpose: To push an item onto the top of the stack
	public StackIList<X> push(X v) {
		StackIList<X> A = new StackMTLIST(); 
		return A.cons(v);}
		//returns new Non Empty stack with item v
	
	//Purpose: To obtain top of stack
	public X top() throws Exception {
		throw new Exception("Method top applied to an empty list");}
		//Exception: this stack is empty, does not have an element

	//Purpose: To return all elements in the stack as strings 
	public String ToString() {
		return "";
		}//stack is empty

}
