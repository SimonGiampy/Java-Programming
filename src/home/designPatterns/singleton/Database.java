package home.designPatterns.singleton;

/**
 * Singleton class that creates a unique private instance that is shared among classes and can only be duplicated. Only one instance of this class
 * is accepted, the others will refer to the initial object.
 */
class Database {
	
	//unique singleton instance
	private static Database dbObject;
	
	//attributes of the singleton class
	private final String dbName;
	private int queryId;
	
	/**
	 * private constructor only to be accessed from the static context in the protected static method in this class. Prevents making new instances.
	 */
	private Database() {
		this.dbName = "my database";
		this.queryId = 0;
	}
	
	/**
	 * creates a new Database object if it has not been created yet. Otherwise returns the initial instance.
	 * @return the singleton instance
	 */
	protected static Database getSingletonInstance() {
		if (dbObject == null) {
			dbObject = new Database();
		}
		return dbObject;
	}
	
	protected void executeQuery() {
		//does something relevant here
		this.queryId++;
	}
	
	protected String getDbName() {
		return dbName;
	}
	
	protected int getQueryId() {
		return queryId;
	}
	
	
}
