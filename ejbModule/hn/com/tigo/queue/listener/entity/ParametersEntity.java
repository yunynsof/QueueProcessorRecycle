package hn.com.tigo.queue.listener.entity;

import hn.com.tigo.josm.persistence.core.EntityBase;
import hn.com.tigo.josm.persistence.core.SessionBase;
import hn.com.tigo.josm.persistence.exception.PersistenceError;
import hn.com.tigo.josm.persistence.exception.PersistenceException;
import hn.com.tigo.queue.dto.ParametersDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class provides the entity for the ParameterDTO object, it contains series of sql queries.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:08:03 PM 2022
 */
public class ParametersEntity extends EntityBase<ParametersDTO> {
	
	/** The core select. */
	private String _coreSelect;

	/**
	 * Instantiates a new parameters entity.
	 *
	 * @param sessionBase the session base
	 * @throws PersistenceException the persistence exception
	 */
	public ParametersEntity(final SessionBase sessionBase)throws PersistenceException {
		super(sessionBase);
		_coreSelect = "SELECT * FROM CONFIG_PARAMETERS";
	}

	/**
	 * Fill list.
	 *
	 * @param result the result
	 * @return the array list
	 * @throws PersistenceException the persistence exception
	 */
	@Override
	protected final ArrayList<ParametersDTO> fillList(ResultSet result) throws PersistenceException {
		ParametersDTO dto;
		ArrayList<ParametersDTO> lista = new ArrayList<ParametersDTO>();
		try {
			while(result.next()){
				dto = new ParametersDTO();
				dto.setIdApplication(result.getLong("ID_APPLICATION"));
				dto.setName(result.getString("NAME"));
				dto.setValue(result.getString("VALUE"));
				dto.setDescription(result.getString("DESCRIPTION"));
				dto.setCreatedDate(result.getDate("CREATED_DATE"));
				lista.add(dto);
			}
			return lista;
		} catch (SQLException e) {
			throw new PersistenceException(PersistenceError.SQL,e);
		}
	}
	
	/**
	 * List all param.
	 *
	 * @return the hash map
	 * @throws PersistenceException the persistence exception
	 */
	public final HashMap<String,String> listAllParam() throws PersistenceException {
		final HashMap<String,String> param = new HashMap<>();
		final List<ParametersDTO> list = executeSelectStatement(_coreSelect);
		for (ParametersDTO parametersModel : list) {
			param.put(parametersModel.getName(), parametersModel.getValue());
		}
		return param;
	}

}