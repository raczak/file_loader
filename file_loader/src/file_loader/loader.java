package file_loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class loader 
{
	public static void main(String[] args) 
	{
		String filePath = "../fichier.txt";
		 
		try
		{
			// Cr�ation du flux buff�ris� sur un FileReader, imm�diatement suivi par un 
			// try/finally, ce qui permet de ne fermer le flux QUE s'il le reader
			// est correctement instanci� (�vite les NullPointerException)
			BufferedReader buff = new BufferedReader(new FileReader(filePath));
			 
			try 
			{
				String line;
				// Lecture du fichier ligne par ligne. Cette boucle se termine
				// quand la m�thode retourne la valeur null.
				while ((line = buff.readLine()) != null) 
				{
					//System.out.println(line);
			         String ligneInverse = "";
			         int ligneLg = line.length(); // taille de ligne
			         System.out.println("\nLigne non invers�       : " + line);
			         for(int i = ligneLg -1; i>-1; i--)
			         {
			        	 ligneInverse+= line.substring(i, i +1);
			         }
			         System.out.println("Ligne invers�: " + ligneInverse);
				}
			} 
			finally 
			{
				// dans tous les cas, on ferme nos flux
				buff.close();
			}
		} 
		catch (IOException ioe) 
		{
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
		}
	}
}
