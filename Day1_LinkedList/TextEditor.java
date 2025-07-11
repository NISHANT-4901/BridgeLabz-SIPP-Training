package Day1_LinkedList;

import java.util.Scanner;

class TextState {
    String content;
    TextState next, prev;

    TextState(String content) {
        this.content = content;
        this.next = null;
        this.prev = null;
    }
}

public class TextEditor {
    TextState head = null, tail = null, current = null;
    int maxSize = 10, size = 0;

    public void addState(String newContent) {
        TextState newState = new TextState(newContent);
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }
        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
            tail = current;
            size++;
            if (size > maxSize) {
                head = head.next;
                head.prev = null;
                size--;
            }
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        }
    }

    public void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Type/Action\n2.Undo\n3.Redo\n4.Display Current\n5.Exit");
            int ch = sc.nextInt();
            sc.nextLine();
            if (ch == 5)
                break;
            switch (ch) {
                case 1:
                    editor.addState(sc.nextLine());
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
            }
        }
        sc.close();
    }
}
