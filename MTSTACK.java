package Stack;

public class MTSTACK<X> implements ISTACK<X> {
	public MTSTACK() {}; //initializes an emtpy stack
	public ISTACK<X> pop() throws Exception{
		throw new Exception("Method pop applied to an empty stack");} //used to throw an error if pop is used on an empty stack

	public MTSTACK() {};
	
	//Purpose: To throw an exception because you cant retrieve the the rest of a stack
	public X pop() throws Exception{
		throw new Exception("Method first applied to an empty stack");}
	public MTSTACK<X> push (X v){return(new NMTSTACK<X>(v,this));}
	public X top() throws Exception{
		throw new Exception("Method first applied to an empty stack");}
	
	public boolean emptyStack() {return true;}
}

//Purpose: //used to throw an error if top is used on an empty stack otherwise, it gets the top of the stack
	public X top() throws Exception{
		throw new Exception("Method first applied to an empty stack");} 
	
	//Purpose: method used to determine if a stack is empty
	public boolean emptyStack() {return true;}
	

	//Purpose: reverses the stack
	public ISTACK<X> reverse() {return this;} 

	//Purpose: used to get all the elements from the stack but if the stack is empty, it returns an error
	public ISTACK<X> stackrest() throws Exception {
		throw new Exception("Method first applied to an empty stack");

	}
	public String ToString() {return null;} //?


}
