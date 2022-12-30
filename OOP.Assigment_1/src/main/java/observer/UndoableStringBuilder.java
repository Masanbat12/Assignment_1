package observer;

import java.util.LinkedList;
import java.util.Objects;

public class UndoableStringBuilder {

    StringBuilder str;
    LinkedList<StringBuilder> donelist;

    public UndoableStringBuilder() {
        this.str = new StringBuilder();
        this.donelist = new LinkedList<>();
    }

    /**
     *
     * @param str  the string that is received by the user
     * @return  'UndoableStringBuilder' appended variable
     */
    public UndoableStringBuilder append(String str){
        this.str.append(str);
        this.donelist.addLast(new StringBuilder(this.str));
        return this;
    }
    /**
     * [start, finish)
     * @param start deletes a sub-string from index 'start' value
     * @param end  deletes 1 before 'last' value
     * @return  'UndoableStringBuilder' deleted variable
     */

    public UndoableStringBuilder delete(int start, int end){
        this.str.delete(start, end);
        this.donelist.addLast(new StringBuilder(this.str));
        return this;
    }

    /**
     *
     * @param offset  the starting point of the insertion in the StringBuilder
     * @param str  the String to be added
     * @return  'UndoableStringBuilder' inserted variable
     */

    public UndoableStringBuilder insert(int offset, String str){
        this.str.insert(offset, str);
        this.donelist.addLast(new StringBuilder(this.str));
        return this;
    }

    /**
     *
     * @param start  the starting point of the replacement in the StringBuilder
     * @param end  the ending -1  point of the replacement in the StringBuilder
     * @param str  the replacement string
     * @return  'UndoableStringBuilder' replaced variable
     */

    public UndoableStringBuilder replace(int start, int end, String str){
        this.str.replace(start, end, str);
        this.donelist.addLast(new StringBuilder(this.str));
        return this;
    }

    /**
     *
     * @return  reversed 'UndoableStringBuilder'
     */

    public UndoableStringBuilder reverse(){
        this.str.reverse();
        this.donelist.addLast(new StringBuilder(this.str));
        return this;
    }

    /**
     * undoes the last operation
     */

    public void undo(){
        this.donelist.removeLast();
        this.str = this.donelist.getLast();
    }

    @Override
    public String toString() {
        return this.str.toString();
    }


    public boolean equals(Object obj) {
        UndoableStringBuilder usb = (UndoableStringBuilder) obj;

        if(!this.str.equals(usb.str)){
            return false;
        }

        if(!this.donelist.equals(usb.donelist)){
            return false;
        }
        return true;
    }
}
