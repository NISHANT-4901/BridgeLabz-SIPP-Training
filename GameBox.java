import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

interface IDownloadable {
    void download();

    void playDemo();
}

abstract class Game implements IDownloadable {
    protected String title;
    protected String genre;
    protected double price;
    protected double rating;

    public Game(String title, String genre, double price, double rating) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public abstract void playDemo();

    public void download() {
        System.out.println(title + " is downloading...");
    }

    public void applySeasonalOffer(double discountPercentage) {
        price -= price * (discountPercentage / 100);
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}

class ArcadeGame extends Game {
    public ArcadeGame(String title, double price, double rating) {
        super(title, "Arcade", price, rating);
    }

    public void playDemo() {
        System.out.println("Playing arcade demo of " + title);
    }
}

class User {
    public String name;
    private List<Game> ownedGames;

    public User(String name) {
        this.name = name;
        this.ownedGames = new ArrayList<>();
    }

    public void buyGame(Game game) {
        ownedGames.add(game);
    }

    public List<Game> getOwnedGames() {
        return ownedGames;
    }
}

public class GameBox {
    public static void main(String[] args) {
        // this section create games for user
        Game arcade = new ArcadeGame("JetRush", 200.0, 4.5);
        Game arcade1 = new ArcadeGame("WarPlan", 300.0, 4.7);
        Game arcade2 = new ArcadeGame("Sample", 0.0, 4.7);

        // handle seasonal discount
        arcade.applySeasonalOffer(20);
        arcade1.applySeasonalOffer(15);

        arcade.download();
        arcade.playDemo();

        arcade1.download();
        arcade1.playDemo();

        // User handling
        User user = new User("Nishant");
        System.out.println("Current user : - " + user.name);
        user.buyGame(arcade);
        user.buyGame(arcade1);
        user.buyGame(arcade2);

        // It display list in ascending price order  
        List<Game> ownedGames = user.getOwnedGames();
        ownedGames.sort(Comparator.comparingDouble(Game::getPrice));

        for (Game g : ownedGames) {
            System.out.println("Owned: " + g.getTitle() + " - " + g.getPrice());
        }

    }
}
