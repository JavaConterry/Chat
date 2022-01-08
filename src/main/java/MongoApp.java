import java.util.Scanner;

public class MongoApp {
    public static void main(String[] args) {
        User user1 = new User("Cherepashkins");
        User user2 = new User("Chashechka007");
        while(true) { //Todo: solve read/write problem
            Scanner in = new Scanner(System.in);
            String text = in.nextLine();
            Massage massage = new Massage(user1, user2, text);
            user1.sendMassage(massage);
        }
    }
}
