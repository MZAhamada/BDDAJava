package manager;

import java.io.*;

public class DBDef implements Serializable {
	// ajouter un cstr si beesoin
	int compteur = 0;
	RelDef[] reldef = new RelDef[10];
	ObjectOutputStream oos;
	ObjectInputStream ois;

	private DBDef() {
	}
	private static DBDef INSTANCE = new DBDef();

	public static DBDef getInstance()
	{   return INSTANCE;
	}

	private RelDef [] dbDef;
	private int cptRelEntier=0;
	// modifié pour rendre plus propre
	File fichier = new File("Catalog.def");
	{
		try{
			oos = new ObjectOutputStream(new FileOutputStream(fichier));
		}catch(IOException e) {
			System.out.println("Le flux de sortie n'a pas été créé");
		}
	}
	{
		try {
			ois = new ObjectInputStream(new FileInputStream(fichier));
		}catch(IOException e)
		{
			System.out.println("Le flux d'entrée n'a pas été créé");
		}
	}

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
		try{
			INSTANCE = (DBDef)ois.readObject();
			oos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void finish() {
		try{
			oos.writeObject(INSTANCE);
			oos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void addRel (RelDef relation) {
		dbDef[cptRelEntier++] = relation ;

	}


}
