package program4;

public class LinkedList {
    Node first;
    Node[] array = new Node[26];

    Node makeNode(String name) {
        Node newNode = new Node(name);
        return newNode;
    }

    public void init() {
        first = null;
    }

    public Node findTail() {
        Node current = first;
        while (current.next != null) {
            current = current.next;
        }
        return current;

    }

    public void buildIndex() {
        Node iterator = first;
        while (iterator != null) {
            int charac = iterator.name.charAt(0) - 'a';
            array[charac] = (array[charac] == null) ? iterator : array[charac];
            iterator = iterator.next;
        }

    }

    public void showList() {
        Node current = first;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }

    public int listLen() {
        int len = 0;
        Node current = first;
        while (current != null) {
            len++;
            current = current.next;
        }
        return len;

    }

    public void insertSorted(String name) {
        Node sorted = new Node(name);
        Node current = first;
        Node prev = current;
        if (first == null) {
            first = sorted;
        } else if (first.codeName > sorted.codeName) {

            sorted.next = first; // sorted.next will point to first
            first = sorted; // the current first will be sorted (swapped)
        } else {
            current = current.next;
            while (current != null && current.codeName < sorted.codeName) {
                current = current.next;
                prev = prev.next;

            }
            sorted.next = current;
            prev.next = sorted;
        }
    }

    public void remove(String name) {
        char startChar = name.charAt(0);
        Node thisSection = array[startChar - 'a'];
        boolean deleted = false;
        Node nextSection;
        if (startChar == 'z')
            nextSection = findTail().next;
        else
            nextSection = array[startChar - 'a' + 1];
        if (first.name.equals(name)) { // for the first name of the list
            first = first.next;
            deleted = true;
        }
        while (thisSection != nextSection && thisSection.name.charAt(0) == startChar && !deleted) {

            if (thisSection.next.name.equals(name)) {
                Node deleteNode = thisSection.next;
                thisSection.next = deleteNode.next;
                deleted = true;
            }
            thisSection = thisSection.next;
        }
        if (deleted) {
            System.out.println("Deleted " + name);

        } else {
            System.out.println("Could not delete b/c not could not find " + name);
        }
    }

    public void lengthSection(char alphabet) {
        int c = 0;
        Node thisSection = array[alphabet - 'a'];
        if (thisSection == null) {
            System.out.println("NO NAME WITH GIVEN ALPHABET");
        } else {

            while (thisSection != null && thisSection.name.charAt(0) == alphabet) {
                c++;
                thisSection = thisSection.next;
            }
            System.out.println("Length of section " + alphabet + " is " + c);

        }

    }

    public void showSection(char alphabet) {
        Node thisSection = array[alphabet - 'a'];
        if (thisSection == null) {
            System.out.println("NO NAMES FOUND");
        } else {
            while (thisSection != null && thisSection.name.charAt(0) == alphabet) {
                System.out.println(thisSection.name);
                thisSection = thisSection.next;
            }
        }

    }

}
