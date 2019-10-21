package Stack;
public class MTSTACK<X> implements ISTACK<X> {
	//Purpose: initializes an emtpy stack
	public MTSTACK() {}; 
	//Purpose: To pop a stack (returns rest of a stack)
	public ISTACK<X> pop() throws Exception{
		throw new Exception("Method pop applied to an empty stack");} //used to throw an error if pop is used on an empty stack

	
	//Purpose: To push an element on a stack. Pushing places an element on top of a stack-> outputs a new stack
	//X: is the empty stack
	//v: is a local variable which represents the element being pushed to the top of the empty stack
	public MTSTACK<X> push (X v){return(new NMTSTACK<X>(v,this));}
	
	
	//Purpose: A check to determine if an empty stack is empty -> returns true
	public boolean emptyStack() {return true;}

//Purpose: used to throw an error if top is used on an empty stack otherwise, it gets the top of the stack
	public X top() throws Exception{
		throw new Exception("Method first applied to an empty stack");}
	
	//Purpose: method used to determine if a stack is empty
	public boolean emptyStack() {return true;}
	

	//Purpose: reverses the stack-> Returns the stack
	public ISTACK<X> reverse() {return this;} 

	//Purpose: used to get all the elements from the stack but if the stack is empty, it returns an error
	public ISTACK<X> stackrest() throws Exception {
		throw new Exception("Method first applied to an empty stack");

	}
	//Purpose: Outputs the contents of a stack into a string
	public String ToString() {return null;} 


}
