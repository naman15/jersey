package quickwork.dataService;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDbService 
{
	private static MongoClient mongoClient;
    
	 private static MongoDatabase db ;
	 
	 private static MongoDbService mDbSingleton;
	 
	 private static final String dbHost = "localhost";
	 private static final int dbPort = 27017;
	 private static final String dbName = "quickwork";

	 private MongoDbService(){};
	 
	public static MongoDbService getInstance() {
		if (mDbSingleton == null) {
			mDbSingleton = new MongoDbService();
		}
		return mDbSingleton;
	} 
	 
	public MongoDatabase getdb() {
		if (mongoClient == null) {
			mongoClient = new MongoClient(dbHost, dbPort);
		}
		if (db == null) {
			db = mongoClient.getDatabase(dbName);
		}
		return db;
	}
}
