package Stack;

public class StackMTLIST<X> implements StackIList<X>{
	public StackMTLIST() {}
	
	public StackIList<X> cons(X v){return(new StackNMTLIST<X>(v,this));}
	
	public int lenght() {return 0;}
	
	public boolean isEmpty() {return true;}
	
	public boolean equals(StackIList<X> l) {return l.isEmpty();}
	
	public X first() throws Exception{
		throw new Exception("Method first applied to an empty list");}
	
	public StackIList<X> rest() throws Exception{
		throw new Exception("Method rest applied to an empty list");}
	
	public X listref(int i) throws Exception{
		throw new Exception("Method listref applied to an empty list");	}
	
	public StackIList<X> append(StackIList<X>L){return L;}
	
	public StackIList<X> reverse() {return this;}
	
	public <R> StackIList<R> map(StackIFun<X,R>f){return new StackMTLIST<R>();}
	
	public StackIList<X> filter(StackIPred<X>p){return this;}
	
	public <R> R foldl(StackIFun2<X,R>f, R res) {return res;}
	
	public <R> R foldr(StackIFun2<X,R>f, R res) {return res;}

	public boolean ormap(StackIPred<X> p){return false;}
	
	public boolean andmap(StackIPred<X> p){return false;}
	
	public X second() throws Exception{
		throw new Exception("Method second applied to an empty list");}
	
	public X third() throws Exception{
		throw new Exception("Method third applied to an empty list");}
	
	public boolean member(StackIPred<X> p) {return false;}
	
	public StackIList<X> remove(X v) {return this;}

}
