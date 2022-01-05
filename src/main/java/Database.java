import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {



    public static void putIntoChatCollection(Document document){
        com.mongodb.MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase processes = mongoClient.getDatabase("local");
        MongoCollection<Document> collection = processes.getCollection("infoexchanger");

        collection.insertOne(document);
    }

}
