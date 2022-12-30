//���
package observer;

import java.util.ArrayList;
import java.util.HashMap;

public class GroupAdmin implements Sender{

	//The message group will be built from a linked list of members
	// and an UndoableStringBuilder created in Matala number 0
	private ArrayList<Member> listOfFriends = new ArrayList<>();
	private UndoableStringBuilder a;
	//A constructor that initializes the parameters
	//if the created group type object is empty
	public GroupAdmin() {
		this.listOfFriends = new ArrayList<>();;
		this.a = new UndoableStringBuilder();
	}
	//The person who keeps the list of friends is listOfFriends and
	//this operation performs registration
	//and if the user sees that the friend is not registered,
	//he can register him in the listOfFriends.
	@Override
	public void register(Member obj) {
		if (!listOfFriends.contains(obj))
		{
			this.listOfFriends.add(obj);
		}
	}
	//If the object is contained,
	// it is possible to delete it from the listOfFriends
	@Override
	public void unregister(Member obj) {
		if (listOfFriends.contains(obj))
		{
			this.listOfFriends.remove(obj);
		}
	}
	//An insertion operation of a place in the UndoableStringBuilder from a certain index and
	//the UndoableStringBuilder that represents the UndoableStringBuilder is a.
	@Override
	public void insert(int offset, String obj) {
		this.a.insert(offset , obj);
	}
	//append operation in UndoableStringBuilder and
	//who represents UndoableStringBuilder is - a.
	@Override
	public void append(String obj) {
		this.a.append(obj);
	}
	//A deletion operation in UndoableStringBuilder is an operation that deletes from a certain member to a certain member and
	//who represents UndoableStringBuilder is - a.
	@Override
	public void delete(int start, int end) {
		this.a.delete(start , end);
	}
	//The notifylistOfFriends action updates
	// the UndoableStringBuilder to all friends in the list.
	public void notifylistOfFriends()
	{
		listOfFriends.forEach((n) -> n.update(this.a));
	}
	//Prints all group members
	public String toString()
	{
		String s = "";
		for (Member m: this.listOfFriends)
			s = s + m.toString() + ",";
		System.out.println(s);	
		return s;
	}


//previuos action in USB
	@Override
	public void undo() {
		this.a.undo();

	}
	//return USB
	public UndoableStringBuilder getUndoableStringBuilder() {
		return this.a;
	}
	//return listOfFriends
	public ArrayList<Member> listOfFriends() {
		return this.listOfFriends;
	}

}
