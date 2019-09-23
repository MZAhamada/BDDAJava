
public class DBDef {
	// ajouter un cstr si beesoin
	
	RelDef [] dbDef;
	int cptRelEntier;
	/*private static final instance = new DBDef();
	
	private DBDef(RelDef [] dbDef,int cptRelEntier) {
		this.dbDef = dbDef;
		this.cptRelEntier = cptRelEntier;
	}
	private DBDef() {
		this.dbDef = new RelDef[100];
		this.cptRelEntier = 0;
	}
	
	*/
	
	
	public static void init(){ 
		
	}
	
	public static void finish() {
		
	}
	
	public /*static*/ void addRel (RelDef relation) {
		dbDef[cptRelEntier++] = relation ;
		
	}
}
