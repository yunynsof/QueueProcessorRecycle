package hn.com.tigo.queue.utils;

/**
 * This class provides a set of constants that are used in the process.
 * 
 * @author Leonardo Vijil
 * @version 1.0.0
 */
public final class QueueConstantListener {	
	
	/** Attribute that determine the Constant DATASOURCE_CPE. */
	public static final String DATASOURCE_CPE = "OCEP";
	 
	/** Attribute that determine the Constant MESSAGE_ERROR_PROCESS. */
	public static final String MESSAGE_ERROR_PROCESS = " No se encontro nada en la cola";
	
	/** Attribute that determine the Constant MESSAGE_ERROR_PERSISTENCE. */
	public static final String MESSAGE_ERROR_PERSISTENCE = " Error conexion";
	
	/** Attribute that determine the Constant NAME_LISTENER. */
	public static final String NAME_LISTENER = "QueueProcessorRecycleListener ";
	
	/** Attribute that determine the Constant MESSAGE_REQUEST_PROCESS. */
	public static final String MESSAGE_REQUEST_PROCESS = "processed request";
	
	/** Attribute that determine the Constant RUN_INIT. */
	public static final String RUN_INIT = "ProcessQueueRecycleWorker.run()";
	
	/** Attribute that determine the Constant TERMINATE_EXCEPTION. */
	public static final String TERMINATE_EXCEPTION = "terminated. Exception: ";
	
	/** Attribute that determine the Constant CODE_EXITO. */
	public static final int CODE_EXITO = 0;
	
	/** Attribute that determine the Constant MESSAGE_SUCESS. */
	public static final String MESSAGE_SUCESS = "OPERATION SUCESS";
	
	/** Attribute that determine the Constant CODE_ERROR. */
	public static final int CODE_ERROR = 1;
	
	/** Attribute that determine the Constant MESSAGE_ERROR. */
	public static final String MESSAGE_ERROR = "ERROR TRANSACTION: ";
	
	/** Attribute that determine the Constant TITLE_COMMAND. */
	public static final String TITLE_COMMAND = "COMMAND";
	
	/** Attribute that determine the Constant TITLE_SLEEP. */
	public static final String TITLE_SLEEP = "TIME_SLEEP";
	
	/** Attribute that determine the Constant CODE_ERROR_INT. */
	public static final int CODE_ERROR_INT = 2;
	
	/** Attribute that determine the Constant ACL_ID. */
	public static final long ACL_ID = 22;
	
	/** Attribute that determine the Constant CODE_ERROR_INT. */
	public static final long STATE_DELETE = 0;
	
	/** Attribute that determine the Constant CODE_ERROR_INT. */
	public static final long STATE_EXIST = 1;
	
	/** Attribute that determine the Constant CODE_ERROR_INT. */
	public static final long STATE_NEW = 2;
	
	/** Attribute that determine the Constant MESSAGE_EXIST. */
	public static final String MESSAGE_EXIST = "Thread already ";
	
	/** Attribute that determine the Constant MESSAGE_EXIST. */
	public static boolean BOOLEAN_THREAD_ACTIVO = false;
	
	/** Attribute that determine a Constant of SCHEMA. */
	public static final String SCHEMA = "INVOICE_CONFIG";
	
	/** Attribute that determine a Constant of HIBERNATE_LAZY_INITIALIZER. */
	public static final String HIBERNATE_LAZY_INITIALIZER = "hibernateLazyInitializer";

	/** Attribute that determine a Constant of HANDLER. */
	public static final String HANDLER = "handler";
	
	/** The Constant UNABLE_INITIALIZE. */
	public static final String UNABLE_INITIALIZE = "Unable to initialize : ";
	
	/** The Constant COULD_NOT_CLOSE. */
	public static final String COULD_NOT_CLOSE = "Could not close the database";
	
	/** The Constant TRANSACTION_ID. */
	public static final String TRANSACTION_ID = "Transaction id cpe: ";
	
	/** The Constant CODE. */
	public static final String CODE = ", code: ";
	
	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = ", description: ";
	
	/** The Constant ERROR_CONNECTION. */
	public static final String ERROR_CONNECTION = "No se logro realizar conexion a base de datos ";
}