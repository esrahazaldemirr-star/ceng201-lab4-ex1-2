public class BracketStack {

    private class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public BracketStack() {
        top = null;
    }

    // TODO 1: Yığının en üstüne eleman ekleme (push)
    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    // TODO 2: En üstteki elemanı çıkarıp döndürme (pop)
    public char pop() {
        if (isEmpty()) {
            return '\0'; // Boş yığın durumunda null karakter döndürülür
        }
        char val = top.data;
        top = top.next;
        return val;
    }

    // TODO 3: En üstteki elemanı çıkarmadan okuma (peek)
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return top.data;
    }

    // TODO 4: Yığının boş olup olmadığını kontrol etme
    public boolean isEmpty() {
        return top == null;
    }
}