import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class DatabaseConnection {

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
    private static MongoCollection collection;

    public DatabaseConnection(String collectionName){
        collection = mongoDatabase.getCollection(collectionName);
    }

    public static void putMassageIntoChatCollection(Massage massage){
        Document document = new Document();
        document.put("sender", massage.sender.getNickname());
        document.put("recipient", massage.recipient.getNickname());
        document.put("text", massage.text);

        collection.insertOne(document);
    }

}
