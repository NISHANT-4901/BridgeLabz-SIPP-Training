import java.util.Stack;

// Interface for Navigation Manager
interface NavigationManager {
    void moveTo(String url);

    void backTo();

    void forwardTo();
}

// Concrete implementation for desktop browser navigation
class DesktopNavigationManager implements NavigationManager {
    private Stack<String> forwardStack;
    private Stack<String> backwardStack;

    public DesktopNavigationManager() {
        forwardStack = new Stack<>();
        backwardStack = new Stack<>();
    }

    @Override
    public void moveTo(String url) {
        if (!forwardStack.isEmpty()) {
            backwardStack.push(forwardStack.peek());
        }
        forwardStack.push(url);
        System.out.println("Current tab --> " + url);
    }

    @Override
    public void backTo() {
        if (forwardStack.size() <= 1) {
            System.out.println("No previous tab to go back to.");
            return;
        }
        backwardStack.push(forwardStack.pop());
        System.out.println("Current tab (after Back) --> " + forwardStack.peek());
    }

    @Override
    public void forwardTo() {
        if (backwardStack.isEmpty()) {
            System.out.println("No forward tab to go to.");
            return;
        }
        String url = backwardStack.pop();
        forwardStack.push(url);
        System.out.println("Current tab (after Forward) --> " + url);
    }
}

public class WebBrowserTabNavigation {
    public static void main(String[] args) {
        NavigationManager browser = new DesktopNavigationManager();

        browser.moveTo("https://www.google.com/");
        browser.moveTo("https://4anime.gg/");
        browser.moveTo("https://github.com/NISHANT-4901/BridgeLabz-SIPP-Training");

        browser.backTo(); // Back to 4anime.gg
        browser.forwardTo(); // Forward to GitHub again
    }
}
