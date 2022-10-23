package program4;

public class Node {
    public String name;
    public Node next;
    public int codeName;

    Node(String name){
        this.name = name;
        this.codeName = codeName(name);
    }

    public int codeName(String name){
        name = name.toLowerCase();
        int value = (((name.charAt(0) - 'a')*(26*26)) + ((name.charAt(1) - 'a')*(26))+ ((name.charAt(2)-'a')*(1)));
        return(value);
    }
}
    
    
