package Day1_LinkedList;

import java.util.*;

class FriendNode {
    int friendId;
    FriendNode next;

    FriendNode(int friendId) {
        this.friendId = friendId;
        this.next = null;
    }
}

class UserNode {
    int id;
    String name;
    int age;
    FriendNode friendList;
    UserNode next;

    UserNode(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.friendList = null;
        this.next = null;
    }

    void addFriend(int friendId) {
        if (isAlreadyFriend(friendId))
            return;
        FriendNode newFriend = new FriendNode(friendId);
        newFriend.next = friendList;
        friendList = newFriend;
    }

    void removeFriend(int friendId) {
        if (friendList == null)
            return;
        if (friendList.friendId == friendId) {
            friendList = friendList.next;
            return;
        }
        FriendNode temp = friendList;
        while (temp.next != null && temp.next.friendId != friendId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    boolean isAlreadyFriend(int friendId) {
        FriendNode temp = friendList;
        while (temp != null) {
            if (temp.friendId == friendId)
                return true;
            temp = temp.next;
        }
        return false;
    }

    List<Integer> getFriendIds() {
        List<Integer> ids = new ArrayList<>();
        FriendNode temp = friendList;
        while (temp != null) {
            ids.add(temp.friendId);
            temp = temp.next;
        }
        return ids;
    }

    int countFriends() {
        int count = 0;
        FriendNode temp = friendList;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void displayFriends() {
        FriendNode temp = friendList;
        while (temp != null) {
            System.out.print(temp.friendId + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class FriendManager {
    UserNode head = null;

    public void addUser(int id, String name, int age) {
        if (findUserById(id) != null)
            return;
        UserNode newUser = new UserNode(id, name, age);
        newUser.next = head;
        head = newUser;
    }

    public void addFriendConnection(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null)
            return;
        user1.addFriend(id2);
        user2.addFriend(id1);
    }

    public void removeFriendConnection(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null)
            return;
        user1.removeFriend(id2);
        user2.removeFriend(id1);
    }

    public void findMutualFriends(int id1, int id2) {
        UserNode user1 = findUserById(id1);
        UserNode user2 = findUserById(id2);
        if (user1 == null || user2 == null)
            return;
        List<Integer> list1 = user1.getFriendIds();
        List<Integer> list2 = user2.getFriendIds();
        Set<Integer> set = new HashSet<>(list1);
        for (int id : list2) {
            if (set.contains(id))
                System.out.print(id + " ");
        }
        System.out.println();
    }

    public void displayFriendsOfUser(int userId) {
        UserNode user = findUserById(userId);
        if (user == null)
            return;
        System.out.print("Friends of " + user.name + ": ");
        user.displayFriends();
    }

    public void searchUserByName(String name) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println(temp.id + " " + temp.name + " " + temp.age);
            }
            temp = temp.next;
        }
    }

    public void searchUserById(int id) {
        UserNode user = findUserById(id);
        if (user != null) {
            System.out.println(user.id + " " + user.name + " " + user.age);
        }
    }

    public void countFriendsForAll() {
        UserNode temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.countFriends() + " friends.");
            temp = temp.next;
        }
    }

    public UserNode findUserById(int id) {
        UserNode temp = head;
        while (temp != null) {
            if (temp.id == id)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) {
        FriendManager manager = new FriendManager();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(
                    "1.Add User\n2.Add Friend\n3.Remove Friend\n4.Mutual Friends\n5.Display Friends\n6.Search by Name\n7.Search by ID\n8.Count Friends\n9.Exit");
            int ch = sc.nextInt();
            if (ch == 9)
                break;
            switch (ch) {
                case 1:
                    manager.addUser(sc.nextInt(), sc.next(), sc.nextInt());
                    break;
                case 2:
                    manager.addFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 3:
                    manager.removeFriendConnection(sc.nextInt(), sc.nextInt());
                    break;
                case 4:
                    manager.findMutualFriends(sc.nextInt(), sc.nextInt());
                    break;
                case 5:
                    manager.displayFriendsOfUser(sc.nextInt());
                    break;
                case 6:
                    manager.searchUserByName(sc.next());
                    break;
                case 7:
                    manager.searchUserById(sc.nextInt());
                    break;
                case 8:
                    manager.countFriendsForAll();
                    break;
            }
        }
        sc.close();
    }
}
