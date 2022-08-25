
package hn.com.tigo.queue.listener;

import com.newrelic.api.agent.NewRelic;


/**
 * NewRelicImpl.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:06:59 PM 2022
 */
public class NewRelicImpl {

	/**
	 * The method register metric in newrelic.
	 *
	 * @param appId the app id
	 * @param time the time
	 */
    public static void addNewRelicMetric(String appId, float time) {
        try {
        	NewRelic.recordMetric(appId, time);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * The method register errors in metric the new relic.
     *
     * @param message the message
     */
    public static void addNewRelicError(Throwable message) {
        try {
			NewRelic.noticeError(message);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
    
    /**
     * The method register errors in metric the new relic.
     *
     * @param message the message
     */
    public static void addNewRelicErrorMessage(String message) {
        try {
			NewRelic.noticeError(message);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
