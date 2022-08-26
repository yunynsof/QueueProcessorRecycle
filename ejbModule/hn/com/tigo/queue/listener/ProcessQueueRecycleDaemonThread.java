package hn.com.tigo.queue.listener;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.apache.log4j.Logger;

import hn.com.tigo.queue.dto.ConfigQueueDTO;
import hn.com.tigo.queue.dto.DetailQueueDTO;
import hn.com.tigo.queue.utils.ReadFilesConfig;

/**
 * .
 * Class that allows you to start the process of Read Queue AS400.
 *
 * @author Leonardo Vijil
 * @version 1.0.0
 * @since 11/02/2020 11:10:03 AM 2020
 */
@Singleton
@Startup
public class ProcessQueueRecycleDaemonThread {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = Logger.getLogger(ProcessQueueRecycleDaemonThread.class);

	/** The thread. */
	private Thread thread;
	
	/** The runnable. */
	ProcessQueueRecycleMasterThread runnable = null;
	
	/**
	 * Initialize.
	 */
	@PostConstruct
	public void initialize() {
		final ReadFilesConfig readConfig = new ReadFilesConfig();
		ConfigQueueDTO configQueue = null;
		try {
			configQueue = readConfig.readConfigQueue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (DetailQueueDTO queue : configQueue.getConfigQueue()) {
			runnable = new ProcessQueueRecycleMasterThread(queue);
			thread = new Thread(runnable);
			thread.setName("ProcessQueueRecycleMasterThread_executor: " + queue.getQueueName());
			thread.start();
			LOGGER.info("ProcessQueueRecycleMasterThread " + thread.hashCode() + " has been started: " + queue.getQueueName());
		}

	}

	/**
	 * Terminate.
	 */
	@PreDestroy
	public void terminate() {
		runnable.shutdown();
		this.thread.interrupt();
		LOGGER.info("ProcessQueueRecycleMasterThread " + thread.hashCode() + " has been stopped");
	}

}
