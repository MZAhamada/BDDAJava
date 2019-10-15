package manager;

public class DBDef {
	// ajouter un cstr si beesoin
	int compteur = 0;
	RelDef[] reldef = new RelDef[10];


	private DBDef() {
	}
	private static DBDef INSTANCE = new DBDef();

	public static DBDef getInstance()
	{   return INSTANCE;
	}
	
	private RelDef [] dbDef;
	private int cptRelEntier=0;
	/*private final instance = new manager.DBDef();
	
	private manager.DBDef(manager.RelDef [] dbDef,int cptRelEntier) {
		this.dbDef = dbDef;
		this.cptRelEntier = cptRelEntier;
	}
	private manager.DBDef() {
		this.dbDef = new manager.RelDef[100];
		this.cptRelEntier = 0;
	}
	
	*/

	public int getCompteur() {
		return compteur;
	}

	public void setCompteur(int compteur) {
		this.compteur = compteur;
	}

	public RelDef[] getReldef() {
		return reldef;
	}

	public void setReldef(RelDef[] reldef) {
		this.reldef = reldef;
	}

	public void init(){
		
	}
	
	public void finish() {
		
	}
	
	public void addRel (RelDef relation) {
		dbDef[cptRelEntier++] = relation ;
		
	}
}