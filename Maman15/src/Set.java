/**
 * @author Amit Nahmias
 * @version 31.5.2022
 */
public class Set {
    private IntNode _head;
    private int _length;

    /**
     * Empty constructor for Set object.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(1)
     * </p>
     */
    public Set() {
        _head = null;
        _length = 0;
    }

    /**
     * Copy constructor for Set object.
     * <p>
     * The memory complexity and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to copy.
     */
    public Set(Set other) {
        _length = other._length;
        if (other.isEmpty()) return;

        int val = other._head.getValue();
        _head = new IntNode(val, null);

        for (IntNode tempOther = other._head.getNext(), temp = _head; tempOther != null; tempOther = tempOther.getNext()) {
            int value = tempOther.getValue();
            temp.setNext(new IntNode(value, null));
            temp = temp.getNext();
        }

    }


    /**
     * Returns true if the Set is empty.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(1).
     * </p>
     *
     * @return True if the Set is empty.
     */
    public boolean isEmpty() {
        return (_length == 0);
    }

    /**
     * Return true if input number is in current set.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n), n is Set's length.
     * </p>
     *
     * @param num Number to search.
     * @return True if input number is in current set.
     */
    public boolean isMember(int num) {
        IntNode tempNode = _head;
        for (int index = 0; index < _length; index++) {
            if (tempNode.getValue() == num) return true;
            tempNode = tempNode.getNext();
        }
        return false;
    }

    /**
     * Returns the number of elements in the set.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(1).
     * </p>
     *
     * @return Number of elements in the set
     */
    public int numOfElements() {
        return _length;
    }

    /**
     * Add element to the current Set.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n).
     * </p>
     *
     * @param x Element to insert.
     */
    public void addToSet(int x)
    {
        if (x % 2 == 0 || isMember(x) || x < 0) // In case of even number or already inside the set or negative number.
            return;
        else if (isEmpty())
        { // In case the set is empty.
            _head = new IntNode(x, null);
        }
        else if (x < _head.getValue())
        { // Smaller than head.
            _head = new IntNode(x, _head);
        }
        else
        { // In case of _head value's < x
            for (IntNode temp = _head; temp != null; temp = temp.getNext())
            {
                if (temp.getNext() == null)
                { // In case the number than bigger all elements and should be last.
                    IntNode newNode = new IntNode(x, temp.getNext());
                    temp.setNext(newNode);
                    break;
                }
                else if (temp.getNext().getValue() > x)
                { // In case the number is between two elements.
                    IntNode newNode = new IntNode(x, temp.getNext());
                    temp.setNext(newNode);
                    break;
                }
            }
        }
        _length++; // Increase the length of the Set.
    }

    /**
     * Remove element from the current Set.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n).
     * </p>
     *
     * @param x Element to remove.
     */
    public void removeFromSet(int x) {
        if (x % 2 == 0 || !isMember(x) || isEmpty() || x < 0) // In case of even number\not in current set\empty set\negetive number.
            return;
        else if (_head.getValue() == x) { // In case the _head is equal to the number.
            _head = _head.getNext();
        } else {
            for (IntNode temp = _head; temp != null; temp = temp.getNext()) {
                if (temp.getNext().getValue() == x) { // Found the node to remove.
                    temp.setNext(temp.getNext().getNext());
                    break;
                }
            }
        }
        _length--; // Decrease the length of the Set.
    }

    /**
     * Check if two sets are equals.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to compare with.
     * @return True if equals.
     */
    public boolean equals(Set other) {
        if (other.isEmpty() && isEmpty()) // Both sets are empty.
            return true;
        else if (_length == other._length) {
            IntNode temp = _head, tempOther = other._head;
            while (temp != null) {
                if (temp.getValue() == tempOther.getValue()) {
                    temp = temp.getNext();
                    tempOther = tempOther.getNext();
                } else // In case found two different elements
                    return false;
            }
            return true; // Sets are equals.
        } else // Sets are not in the same length.
            return false;
    }

    /**
     * Check if input set is a subset of current set.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to check.
     * @return True if he is a subset.
     */
    public boolean subSet(Set other) {
        if (other.isEmpty()) // The empty set is subset of all possible sets.
            return true;
        else if (other.numOfElements() > _length) // Bigger set can't be subset.
            return false;
        else { // Other set's length <= current length.
            IntNode temp = _head, tempOther = other._head;
            while (tempOther != null) {
                if (temp == null) // Not found element in current list.
                    return false;
                else if (temp.getValue() == tempOther.getValue()) // Found temp element in current list.
                    tempOther = tempOther.getNext();
                temp = temp.getNext();
            }
            return true;
        }
    }

    /**
     * Representation of current set, separated by ','.
     * <p>
     * The memory complexity is O(1) and the runtime efficiency is O(n).
     * </p>
     *
     * @return String representation of current set
     */
    public String toString() {
        String result = new String("{");
        for (IntNode node = _head; node != null; node = node.getNext()) {
            result = result + node.getValue();
            if (node.getNext() != null) result = result + ",";
        }
        return result + "}";
    }

    /**
     * Returns the intersection of two sets.
     * <p>
     * The memory complexity and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to cross with.
     * @return New set of the intersection.
     */
    public Set intersection(Set other) {
        if (other.isEmpty() || isEmpty()) // If one is empty the intersection is empty.
            return new Set();
        else if (this.equals(other) || this.subSet(other)) // Sets are equal or input set is subset of current set.
            return new Set(other);
        else if (other.subSet(this)) // Current set is subset of input set.
            return new Set(this);
        else {
            IntNode prevNode = _head;
            IntNode prevOtherNode = other._head;
            Set result = new Set();

            while (prevNode != null && prevOtherNode != null && prevNode.getValue() != prevOtherNode.getValue()) { // Find the first intersection.
                if (prevNode.getValue() < prevOtherNode.getValue()) prevNode = prevNode.getNext();
                else prevOtherNode = prevOtherNode.getNext();
            }

            if (prevNode == null || prevOtherNode == null) // In case of empty intersection.
                return new Set();

            result._head = new IntNode(prevNode.getValue(), null);
            result._length++;
            IntNode tempNode = result._head;

            for (IntNode node = prevNode.getNext(), otherNode = prevOtherNode.getNext(); otherNode != null && node != null; ) {
                if (node.getValue() == otherNode.getValue()) {
                    tempNode.setNext(new IntNode(node.getValue(), null));
                    tempNode = tempNode.getNext();
                    result._length++;
                    node = node.getNext();
                    otherNode = otherNode.getNext();
                } else if (node.getValue() < otherNode.getValue()) node = node.getNext();
                else otherNode = otherNode.getNext();
            }
            return result;
        }
    }

    /**
     * Returns the union of two sets.
     * <p>
     * The memory complexity and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to unite with.
     * @return New set of the union.
     */
    public Set union(Set other) {
        if (other.isEmpty() || this.equals(other) || this.subSet(other))
            // If other set is empty the union is current set or sets are equal or input set is subset of current set.
            return new Set(this);
        else if (this.isEmpty() || other.subSet(this))
            // If current set is empty the union is other set or current set is subset of input set.
            return new Set(other);
        else {
            Set result = new Set();
            IntNode node = _head;
            IntNode otherNode = other._head;
            IntNode temp;

            // Find the head of the union
            if (node.getValue() == otherNode.getValue()) {
                result._head = new IntNode(node.getValue(), null);
                node = node.getNext();
                otherNode = otherNode.getNext();
            } else if (node.getValue() < otherNode.getValue()) {
                result._head = new IntNode(node.getValue(), null);
                node = node.getNext();
            } else {
                result._head = new IntNode(otherNode.getValue(), null);
                otherNode = otherNode.getNext();
            }

            temp = result._head;
            result._length++;

            while (node != null || otherNode != null) {
                if (node == null) {
                    temp.setNext(new IntNode(otherNode.getValue(), null));
                    otherNode = otherNode.getNext();
                    temp = temp.getNext();
                } else if (otherNode == null) {
                    temp.setNext(new IntNode(node.getValue(), null));
                    node = node.getNext();
                    temp = temp.getNext();
                } else {
                    if (node.getValue() == otherNode.getValue()) {
                        temp.setNext(new IntNode(node.getValue(), null));
                        node = node.getNext();
                        otherNode = otherNode.getNext();
                    } else if (node.getValue() < otherNode.getValue()) {
                        temp.setNext(new IntNode(node.getValue(), null));
                        node = node.getNext();
                    } else {
                        temp.setNext(new IntNode(otherNode.getValue(), null));
                        otherNode = otherNode.getNext();
                    }
                }
                temp = temp.getNext();
                result._length++;
            }
            return result;
        }
    }

    /**
     * Return the difference between current set to input set.
     * <p>
     * The memory complexity and the runtime efficiency is O(n).
     * </p>
     *
     * @param other Set to compare with.
     * @return New set without the common elements.
     */
    public Set difference(Set other) {
        if (other.isEmpty() || this.isEmpty())
            // If one of the sets is empty the difference will be the current set.
            return new Set(this);
        else if (this.equals(other) || other.subSet(this))
            // If sets are equal or current set is subset of other set the difference is empty set.
            return new Set();
        else {
            Set intersection = intersection(other);
            Set copy = new Set(this);
            if (intersection.isEmpty()) { // If intersection is empty returns current set.
            } else {
                IntNode temp = new IntNode(2, copy._head);
                copy._head = temp;
                IntNode interNode = intersection._head;
                IntNode copyNode = temp.getNext();

                while (interNode != null) {
                    if (interNode.getValue() == copyNode.getValue()) {
                        temp.setNext(copyNode.getNext());
                        interNode = interNode.getNext();
                        copy._length--;
                    } else temp = temp.getNext();
                    copyNode = copyNode.getNext();
                }
                copy._head = copy._head.getNext(); // First element is not relevant.
            }
            return copy;
        }
    }

    public IntNode getHead() {
        return _head;
    }
}

