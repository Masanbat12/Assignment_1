package observer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcteteMemberTest {
	ConcreteMember Yossi = new ConcreteMember();
	ConcreteMember j = new ConcreteMember();
	ConcreteMember r = new ConcreteMember();
	ConcreteMember jr = new ConcreteMember();
	@Test
	void update()
	{
		UndoableStringBuilder s1= new UndoableStringBuilder();
		s1.append("Yossi");
		UndoableStringBuilder s2= new UndoableStringBuilder();
		s2.append("j");
		Yossi.update(s1);
		j.update(s2);
		assertEquals(Yossi.copy.toString(), "Yossi");
		assertNotEquals(Yossi.copy.toString(), "iYossi");
		assertEquals(j.copy.toString(), "j");
		assertNotEquals(j.copy.toString(), "ij");
	}

}
