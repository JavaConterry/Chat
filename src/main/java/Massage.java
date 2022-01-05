public class Massage {

    public String text;
    public User sender;
    public User recipient;

    public Massage(User sender, User recipient, String text){
        this.sender = sender;
        this.recipient = recipient;
        this.text = text;
    }
}
