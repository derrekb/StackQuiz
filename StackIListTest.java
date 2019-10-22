package Stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class StackIListTest {

	@Test
	void test() {
		
		StackIList<String> E = new StackMTLIST<String>();
		StackIList<String> L0 = new StackMTLIST<String>();
		StackIList<String> L1 = new StackMTLIST<String>();
		StackIList<String> L2 = new StackMTLIST<String>();
		StackIList<Integer> N = new StackMTLIST<Integer>();
		StackIList<Integer> N1 = N.cons(new Integer(4)).cons(new Integer(6)).cons(new Integer(3));
		StackIList<Integer> N2 = N.cons(new Integer(1)).cons(new Integer(30)).cons(new Integer(30));
		StackIList<Integer> N3 = N.cons(new Integer(5)).cons(new Integer(31)).cons(new Integer(39));
		StackIList<Integer> N4 = N.cons(new Integer(6)).cons(new Integer(30)).cons(new Integer(40));
		StackIList<Integer> N5 = N.cons(new Integer(6)).cons(new Integer(40));
		StackIList<Integer> N6 = N.cons(new Integer(6)).cons(new Integer(30));
		L0 = L0.cons("pal!").cons("there ").cons("Hi ");
		L1 = L1.cons("you?").cons("are ").cons("How ");
		L2 = (new StackMTLIST<String>()).cons("you?").cons("are ").cons("How ").cons("pal!").cons("there ").cons("Hi ");
		try {
			assertEquals(E.lenght(), 0);
			assertEquals(L0.lenght(), 3);
			assertEquals(E.isEmpty(), true);
			assertEquals(L0.isEmpty(), false);
			assertEquals(L0.first(), "Hi ");
			assertEquals(L0.rest().rest().first(), "pal!");
			assertEquals(L0.listref(1), "there ");
			assertEquals(L1.equals(E.append(L1)), true);
			assertEquals(L2.equals(L0.append(L1)), true);
			assertEquals(E.reverse().equals(E), true);
			assertEquals(L0.reverse().equals(E.cons("Hi ").cons("there ").cons("pal!")), true);
			
			assertEquals(E.map(s -> s.length()).equals(N), true);
			assertEquals(L0.map(s -> s.length()).equals(N1), true);
			
			assertEquals(N.filter(n -> n%2==0).equals(N), true);
			assertEquals(N2.filter(n -> n%2==0).equals(N.cons(new Integer(30)).cons(new Integer(30))), true);
			assertEquals(N4.filter(n -> n!= 30).equals(N5), true);
			
			assertEquals(N4.remove(30).equals(N5), true);
			assertEquals(N4.remove(40).equals(N6), true);
						
			assertEquals(N.foldl((n,r) -> r.cons(n), N).equals(N), true);
			assertEquals(N2.foldl((n,r) -> r.cons(n), N).equals(N2.reverse()), true);
			
			assertEquals(N.foldr((n,r) -> r.cons(n), N).equals(N), true);
			assertEquals(N2.foldr((n,r) -> r.cons(n), N).equals(N2), true);
			
			assertEquals(N.ormap(n -> n%2 == 0), false);
			assertEquals(N2.ormap(n -> n%2 == 0), true);
			assertEquals(N3.ormap(n -> n%2 == 0), false);
			
			assertEquals(N.andmap(n -> n%2 == 0), false);
			assertEquals(N2.andmap(n -> n%2 == 0), false);
			assertEquals(N4.andmap(n -> n%2 == 0), true);
			
			assertEquals(L2.second(), "there ");
			assertEquals(L2.third(), "pal!");
			
			assertEquals(L2.member(n -> n == "there "), true);
			assertEquals(L1.member(n -> n == "there "), false);
			
			
	}
		catch(Exception e) {
			System.out.println("Error ListTests: "+ e.getMessage());
		}

}

}
