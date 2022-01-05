//ToDO more safety when db collects massages than users sends, because of access to db

import org.bson.Document;

public class User {
    private String nickname;

    public User(String nickname){
        this.nickname = nickname;
    }

    public void sendMassage(Massage massage){
        Document document = new Document();
        document.put("sender", massage.sender);
        document.put("recipient", massage.recipient);
        document.put("text", massage.text);
        Database.putIntoChatCollection(document);
    }

}

