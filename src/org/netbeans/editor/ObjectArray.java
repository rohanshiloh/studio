/*
 *                 Sun Public License Notice
 * 
 * The contents of this file are subject to the Sun Public License
 * Version 1.0 (the "License"). You may not use this file except in
 * compliance with the License. A copy of the License is available at
 * http://www.sun.com/
 * 
 * The Original Code is NetBeans. The Initial Developer of the Original
 * Code is Sun Microsystems, Inc. Portions Copyright 1997-2003 Sun
 * Microsystems, Inc. All Rights Reserved.
 */

package org.netbeans.editor;

/**
 * Interface that allows to bridge various implementations
 * of the arrays of objects (especially gap arrays).
 * <p>Once an object implements this interface
 * it's easy to build a list on top of it by using
 * {@link org.netbeans.spi.lexer.util.LexerUtilities#createList(ObjectArray)}.
 *
 * @author Miloslav Metelka
 * @version 1.00
 */

public interface ObjectArray {

    /** Get the item at the given index.
     * @param index &gt;=0 and &lt;{@link #getItemCount()} index at which the item
     *  should be obtained.
     * @return the item at the requested index.
     * @throws IndexOutOfBoundsException if the index is &lt;0
     * or &gt;={@link #getItemCount()}
     */
    public Object getItem(int index);
    
    /**
     * @return &gt;=0 Number of items in the object array.
     */
    public int getItemCount();


    /**
     * Interface allowing more efficient getting of the objects
     * from the object array. If the particular object array
     * does not implement this interface then its items
     * are accessed by {@link ObjectArray.getItem(int)} calls.
     * The {@link ObjectArrayUtilities.copyItems(ObjectArray, int, int, Object[], int)}
     * presents uniform access for obtaining of the items.
     */
    public interface CopyItems {
        
        /**
         * Copy the items in the given index range from the object array into destination array.
         * @param srcStartIndex index of the first item in the object array to get.
         * @param srcEndIndex end index in the object array of the items to get.
         * @param dest destination array of objects. The length of the array
         *  must be at least <CODE>destIndex + (srcEndIndex - srcStartIndex)</CODE>.
         * @param destIndex first destination index at which the items are being stored.
         */
        public void copyItems(int srcStartIndex, int srcEndIndex,
        Object[] dest, int destIndex);

    }

}
