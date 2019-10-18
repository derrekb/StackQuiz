
public class MTSTACK<X> implements ISTACK<X>{
	
	public MTSTACK() {};  
	public X pop() throws Exception{
		throw new Exception("Method first applied to an empty stack");}
	public MTSTACK<X> push (X v){return(new NMTSTACK<X>(v,this));}
	public X top() throws Exception{
		throw new Exception("Method first applied to an empty stack");}
	public boolean emptyStack() {return true;}
}
	
	
	
	

	
	
	
}
