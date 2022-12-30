//���
package observer;

public class ConcreteMember implements Member {
	//the UndoableStringBuilder
	UndoableStringBuilder copy;
	
	//the constructor for class ConcreteMember
	public ConcreteMember() {
		this.copy = null;
		
	}
	// update for all ConcreteMember the messege
	@Override
	public void update(UndoableStringBuilder usb) {
		this.copy = usb;
	}
	
}



