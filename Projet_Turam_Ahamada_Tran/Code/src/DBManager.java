import java.util.Scanner;
import java.util.StringTokenizer;

public class DBManager {
// une seule instance
	
	public static RelDef createRelation (String nomRel,int nbCol, String [] typeCol) {
		RelDef relation = new RelDef(nomRel,nbCol,typeCol);
		return relation;
	}
	
	public static void init() {
		/*
		 * saisie();
		 */
		DBDef.init();
	}
	
	public void finish() {
		DBDef.finish();
	}
	
	public void processCommand(String s) { //ptt return String plus tard
		
		/*
		StringTokenizer st = new StringTokenizer(s," ");
		return ;
		*/
	}
	
	/*
	public static String saisie() {
		Scanner sc = new Scanner (System.in);
		String s = sc.nextLine();
		sc.close();
		return s;	
	}
	*/
}
