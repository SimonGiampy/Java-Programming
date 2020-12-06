package home.designPatterns.singleton;

/**
 * starter class for using and accessing a singleton instance. The purpose is to show that only one instance can be created, and the others will be
 * a copy of the original one, with the same parameters.
 */
class Main {
	
	public static void main(String[] args) {
		
		Database db = Database.getSingletonInstance(); //unique instance of the singleton class
		System.out.println(db.getDbName());
		db.executeQuery();
		System.out.println("query #" + db.getQueryId() + " executed");
		
		Database db2 = Database.getSingletonInstance(); //db2 = db1 because it has already been instantiated
		System.out.println("nothing changed: the last query id is still " + db2.getQueryId());
		
		
	}

}
