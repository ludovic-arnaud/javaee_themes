 /* To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.arnaud.ludovic.themes.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 
 */
public class DAOUtil {
    
    private static EntityManagerFactory emf = null;

    private DAOUtil() {
    }
    
    public static synchronized EntityManagerFactory getEmf() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("gestInscriptionJPA");
        }
        return emf;
    }
    
    public static synchronized void close(){
        if(emf != null){
            emf.close();
            emf = null;
        }
    }
    
    
}
