//áñã
package observer;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GroupAdminTest{
	GroupAdmin GroupAdmin1 = new GroupAdmin();
	GroupAdmin GroupAdmin2 = new GroupAdmin();
	GroupAdmin GroupAdmin3 = new GroupAdmin();
	ConcreteMember Yossi = new ConcreteMember();
	ConcreteMember j = new ConcreteMember();
	ConcreteMember r = new ConcreteMember();
	ConcreteMember jr = new ConcreteMember();
	@Test
	void notifyClients(){
		GroupAdmin1.register(Yossi);
		GroupAdmin1.register(j);
		GroupAdmin1.notifylistOfFriends();
		int sizeOfA = 2;
		int counter = 0;
		for (Member client : GroupAdmin1.listOfFriends()){
			counter++;
		}
		assertEquals(sizeOfA , counter);
	}
	@Test
	void unregister(){
		GroupAdmin1.register(Yossi);
		GroupAdmin1.register(j);
		GroupAdmin1.unregister(j);
		assertNotEquals(GroupAdmin1.listOfFriends().get(0), j);
		assertNotEquals(GroupAdmin1.listOfFriends().size(), 2);
	}
	@Test
	void insert(){
		GroupAdmin1.append("ThisIsUndo");
		GroupAdmin1.insert(0, "Yes");
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "YesThisIsUndo");
		GroupAdmin1.insert(0, "Yes");
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "YesYesThisIsUndo");
		assertNotEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "1YesYesThisIsUndo");
	}
	@Test
	void append(){
		GroupAdmin1.append("start&end");
		GroupAdmin2.append("thist");
		GroupAdmin3.append("t");
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "start&end");
		assertEquals(GroupAdmin2.getUndoableStringBuilder().toString(), "thist");
		assertEquals(GroupAdmin3.getUndoableStringBuilder().toString(), "t");
		assertNotEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "s");
		assertNotEquals(GroupAdmin2.getUndoableStringBuilder().toString(), "tt");
		assertNotEquals(GroupAdmin3.getUndoableStringBuilder().toString(), "td");
	}
	@Test
	void register(){
		GroupAdmin1.register(Yossi);
		GroupAdmin1.register(j);
		assertEquals(GroupAdmin1.listOfFriends().get(0), Yossi);
		GroupAdmin1.register(Yossi);
		assertEquals(GroupAdmin1.listOfFriends().size(), 2);
		GroupAdmin1.register(r);
		GroupAdmin1.register(jr);
		assertNotEquals(GroupAdmin1.listOfFriends().size(), 2);
	}
	@Test
	void undo(){
		GroupAdmin1.append("IsNotNull");
		GroupAdmin1.undo();
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "null");
	}
	@Test
	void delete(){
		GroupAdmin1.append("start&end");
		GroupAdmin1.delete(0, 1);
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "tart&end");
		GroupAdmin1.delete(0, 2);
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "rt&end");
		GroupAdmin1.delete(0, 3);
		assertEquals(GroupAdmin1.getUndoableStringBuilder().toString(), "end");
	}
	@Test
	void update(){
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
