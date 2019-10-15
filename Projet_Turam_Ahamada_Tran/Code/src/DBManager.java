package manager;

import java.util.StringTokenizer;

public class DBManager {
// une seule instance
	private DBManager() {
	}
	private static DBManager INSTANCE = new DBManager();
	
	public RelDef createRelation (String nomRel, int nbCol, String [] typeCol) {
		RelDef relation = new RelDef(nomRel,nbCol,typeCol);
		return relation;
	}
	
	public void init() {
		/*
		 * saisie();
		 */
		DBDef.getInstance().init();
	}
	
	public void finish() {
		DBDef.getInstance().finish();
		BufferManager.getInstance().FlushAll();
	}
	
	public void processCommand(String s) { //ptt return String plus tard

		StringTokenizer st = new StringTokenizer(s," ");
		String token = st.nextToken();
		if (token.equals("exit")){ //finish
		}
		else {
			switch(token){
			case "create" :
				// Bien verifié que les arguments se de bons types
				/*
				 * if hasmoretoken error ( on peut le mettre dès l'entrée du nb de colonne)
				 * appeler le constructeur de reldef
				 * stocker dans des cases differentes les manager.RelDef
				 */
				String nomRelation = st.nextToken();
				// Chaine de caractere de taille fixe TP1 J1
				int nbColonne = Integer.parseInt(st.nextToken());
				String[] typeCol = new String[nbColonne];
				for (int i=0;i<nbColonne;i++) {
					typeCol[i]=st.nextToken();
				}
				RelDef create = createRelation (nomRelation,nbColonne,typeCol);
				break;
			case "delete" ://
				break;
			default : System.out.println("Erreur vous n'avez entrez aucune instuction valide.")
				;
			}
		}
		
	}	
	public static DBManager getInstance()
    {   return INSTANCE;
    }
	
	/*
	public  String saisie() {
		Scanner sc = new Scanner (System.in);
		String s = sc.nextLine();
		sc.close();
		return s;	
	}
	*/
}