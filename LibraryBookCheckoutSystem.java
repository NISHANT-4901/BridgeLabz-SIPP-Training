import java.util.LinkedList;
import java.util.Queue;

public class LibraryBookCheckoutSystem {
    interface Book {
        String getTitle();
    }

    static class EBook implements Book {
        private String title;

        EBook(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title + " (E-Book)";
        }
    }

    static class HardCopyBook implements Book {
        private String title;

        HardCopyBook(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title + " (Hardcopy)";
        }
    }

    static class AudioBook implements Book {
        private String title;

        AudioBook(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title + " (Audio Book)";
        }
    }

    static class Request<T extends Book> {
        private String userName;
        private T book;

        Request(String userName, T book) {
            this.userName = userName;
            this.book = book;
        }

        String getUserName() {
            return userName;
        }

        T getBook() {
            return book;
        }
    }

    static class LibrarySystem {
        private Queue<Request<? extends Book>> requestQueue = new LinkedList<>();

        void addRequest(Request<? extends Book> request) {
            requestQueue.offer(request);
        }

        void processRequests() {
            while (!requestQueue.isEmpty()) {
                Request<? extends Book> req = requestQueue.poll();
                System.out.println("Processing request for " + req.getUserName() + ": " + req.getBook().getTitle());
            }
        }
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        Request<EBook> r1 = new Request<>("User A", new EBook("Clean Code"));
        Request<HardCopyBook> r2 = new Request<>("User B", new HardCopyBook("Design Patterns"));
        Request<AudioBook> r3 = new Request<>("User C", new AudioBook("Atomic Habits"));

        library.addRequest(r1);
        library.addRequest(r2);
        library.addRequest(r3);

        library.processRequests();
    }
}
