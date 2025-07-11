package Day1_LinkedList;

import java.util.*;

class Process {
    int id;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnAroundTime;
    Process next;

    Process(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnAroundTime = 0;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    Process head = null;
    Process tail = null;

    public void addProcess(int id, int burstTime, int priority) {
        Process newProcess = new Process(id, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
    }

    public void removeProcess(int id) {
        if (head == null)
            return;
        if (head == tail && head.id == id) {
            head = tail = null;
            return;
        }
        if (head.id == id) {
            head = head.next;
            tail.next = head;
            return;
        }
        Process temp = head;
        while (temp.next != head && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next.id == id) {
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
    }

    public void simulate(int quantum) {
        if (head == null)
            return;
        List<Process> finished = new ArrayList<>();
        int time = 0;
        Process current = head;
        while (head != null) {
            if (current.remainingTime <= quantum) {
                time += current.remainingTime;
                current.remainingTime = 0;
                current.turnAroundTime = time;
                current.waitingTime = current.turnAroundTime - current.burstTime;
                finished.add(current);
                int removeId = current.id;
                current = current.next;
                removeProcess(removeId);
                if (head == null)
                    break;
            } else {
                time += quantum;
                current.remainingTime -= quantum;
                current = current.next;
            }
            displayProcesses();
        }
        double totalWaiting = 0;
        double totalTurnaround = 0;
        for (Process p : finished) {
            totalWaiting += p.waitingTime;
            totalTurnaround += p.turnAroundTime;
        }
        System.out.println("Average Waiting Time: " + (totalWaiting / finished.size()));
        System.out.println("Average Turnaround Time: " + (totalTurnaround / finished.size()));
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No active processes.");
            return;
        }
        Process temp = head;
        do {
            System.out.println("P" + temp.id + " BT:" + temp.burstTime + " RT:" + temp.remainingTime + " Priority:"
                    + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println("---");
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1.Add Process\n2.Run Round Robin\n3.Display\n4.Exit");
            int ch = sc.nextInt();
            if (ch == 4)
                break;
            switch (ch) {
                case 1:
                    scheduler.addProcess(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;
                case 2:
                    scheduler.simulate(sc.nextInt());
                    break;
                case 3:
                    scheduler.displayProcesses();
                    break;
            }
        }
        sc.close();
    }
}
