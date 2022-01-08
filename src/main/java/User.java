//ToDo: more safety when db collects massages than users sends, because of access to db

import org.bson.Document;

public class User {
    private String nickname;

    public User(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public void sendMassage(Massage massage){
        DatabaseConnection dbAccess = new DatabaseConnection("infoexchanger");
        dbAccess.putMassageIntoChatCollection(massage);
    }

}

