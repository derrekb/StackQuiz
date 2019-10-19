package Stack;

public class MTSTACK<X> implements ISTACK<X> {
	public MTSTACK() {}; //initializes an emtpy stack 
	public ISTACK<X> pop() throws Exception{
		throw new Exception("Method pop applied to an empty stack");} //used to throw an error if pop is used on an empty stack
	
	public ISTACK<X> push (X v){return new NMTSTACK<X>(v, this);}
	//method that adds to the top of the stack making it a not empty stack
	
	public X top() throws Exception{
		throw new Exception("Method first applied to an empty stack");} //used to throw an error if top is used on an empty stack
	//otherwise, it gets the top of the stack
	
	public boolean emptyStack() {return true;}
	//method used to determine if a stack is empty
	
	public ISTACK<X> reverse() {return this;} //reverses the stack
	
	//used to get all the elements from the stack but if the stack is empty, it returns an error
	public ISTACK<X> stackrest() throws Exception {
		throw new Exception("Method first applied to an empty stack");
		
	}
	public String ToString() {return null;} //?
	

}
