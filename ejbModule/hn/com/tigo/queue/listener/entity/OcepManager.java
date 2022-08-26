package hn.com.tigo.queue.listener.entity;

import java.util.HashMap;

import javax.sql.DataSource;

import hn.com.tigo.josm.persistence.core.SessionBase;
import hn.com.tigo.josm.persistence.exception.PersistenceException;

/**
 * This class contains methods for using entities and making database calls.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:07:56 PM 2022
 */
public class OcepManager extends SessionBase {

	/**
	 * Instantiates a new ocep manager.
	 *
	 * @param dataSource the data source
	 * @throws PersistenceException the persistence exception
	 */
	public OcepManager(final DataSource dataSource) throws PersistenceException {
        super(dataSource);
	}
	
    /**
     * List all param.
     *
     * @return the hash map
     * @throws PersistenceException the persistence exception
     */
    public HashMap<String, String> listAllParam() throws PersistenceException {
        ParametersEntity entity = null;
        try {
            entity = new ParametersEntity(this);
            HashMap<String, String> response = entity.listAllParam();
            return response;
        } catch (PersistenceException e) {
            throw new PersistenceException(e.getMessage());
        }
    }
}