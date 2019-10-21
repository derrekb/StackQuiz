package Stack;

public class NMTSTACK<X> implements ISTACK<X> {
	private X car;
	private ISTACK<X> cdr;
	
	public NMTSTACK(X f, ISTACK<X> r) {
		car = f;
		cdr = r;	}
	
	public ISTACK<X> push(X v){
		return new NMTSTACK<X>(v,this);	}
	
	public ISTACK<X> pop() throws Exception {
		return this.cdr;
	}	
	public X top() throws Exception{return car;}
	
	public ISTACK<X> stackrest() throws Exception{return cdr;}
	
	public boolean emptyStack() {return false;}
	
		private ISTACK<X> revhelper(ISTACK<X> l, ISTACK<X>res)
	//ACCUM INV: reverse(this) == append(reverse(l), res)
	{try {if(l.emptyStack()) {return res;}
	else{return (revhelper(l.stackrest(), res.push(l.top())));}}
	catch(Exception e) {
		System.out.println("Error StackNMTLIST append: "+ e.getMessage());
		return this;}	}
	
	public ISTACK<X> reverse() {ISTACK<X> A = new MTSTACK<X>(); 
		return(revhelper(this, A));}
	
	public String ToString() {return "First Stack: "+this.car+""+this.cdr.ToString();}

	public static void main(String[] args) throws Exception {
		ISTACK<String> A = new MTSTACK<String>();
		ISTACK<String> A1 = A.push("Hans").push("there ").push("Hello ");
		ISTACK<String> A2 = A.push("Hello ").push("there ").push("Hans ");
		ISTACK<String> A3 = A.push("Hans").push("there ");
	
	
		System.out.println((A1.pop().ToString()));
		System.out.println(A3.ToString());
	}



}
