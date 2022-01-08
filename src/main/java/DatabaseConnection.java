import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.BSONObject;
import org.bson.Document;

public class DatabaseConnection {

    private MongoClient mongoClient = new MongoClient("localhost", 27017);
    private MongoDatabase mongoDatabase = mongoClient.getDatabase("local");
    private static MongoCollection collection;

    public DatabaseConnection(String collectionName){
        collection = mongoDatabase.getCollection(collectionName);
    }

    public static void putMassageIntoChatCollection(Massage massage){
        DBObject document = new BasicDBObject("sender", massage.sender.getNickname())
                .append("recipient", massage.recipient.getNickname())
                .append("text", massage.text);

        collection.insertOne(document);
    }

    public String getMassageTextInChatCollectionWith(User user){
        BasicDBObject obj = new BasicDBObject();
        obj.put("sender", user.getNickname());
        MongoCursor<Document> cursor = collection.find(obj).iterator();
        Document foundMassage = cursor.next();
        return foundMassage.get("text").toString();
    }

}
