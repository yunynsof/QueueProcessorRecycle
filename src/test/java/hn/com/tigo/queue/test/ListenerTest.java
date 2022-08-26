package hn.com.tigo.queue.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import hn.com.tigo.queue.dto.DetailQueueDTO;
import hn.com.tigo.queue.listener.ProcessQueueRecycleMasterThread;
import hn.com.tigo.queue.utils.ReadFilesConfig;

/**
 * ListenerTest.
 *
 * @author Yuny Rene Rodriguez Perez {@literal<mailto: yrodriguez@hightech-corp.com />}
 * @version  1.0.0
 * @since 08-25-2022 12:07:31 PM 2022
 */
public class ListenerTest {

	/**
	 * Test.
	 */
	@Test
	public void test() {
		DetailQueueDTO queue = new DetailQueueDTO();
		queue.setQueueIPAddress("192.168.0.231");
		queue.setQueueUser("USRCPE");
		queue.setQueuePassword("SRCP2015");
		queue.setQueuelibName("V4STCD");
		queue.setQueueName("MGTEL006I");
		queue.setQueueSplit("|");
		
		ProcessQueueRecycleMasterThread thread = new ProcessQueueRecycleMasterThread(queue);
		Map<String, String> params = new HashMap<String, String>();
		params.put("SUBSCRIBER_SPLIT", "=");
		params.put("URL_NOTIFY_EVENT", "http://192.168.159.46:7004/NotifyEvent/NotifyQueue/dist");
		thread.setParams(params);
		thread.run();
		
		ReadFilesConfig readConfig = new ReadFilesConfig();
		long startTime = 0;
		String tramaComplete = "RECICLAJE|RECICLAJE|MSISDN=94517500|CUENTA_CLIENTE=0801198716839CCHN|CUENTA_FACTURACION=8000066364|ID_PEDIDO_VENTA=1521895736507599298|NUMERO_FACTURA=3330|FECHAEMISION=20200213|IMEI=869175040414278|TOTAL_FACTURADO=100.00|TIPO_FACTURA=FC2|USUARIO=HCORDERO|MOTIVO=PAGO|TEST_QA|                 123432 ";
		String tramaComplete1 = "SEGUROS|SEGUROS|MSISDN=|CUENTA_CLIENTE=0801198716839CCHN|CUENTA_FACTURACION=8000066364|ID_PEDIDO_VENTA=1521895736507599298|NUMERO_FACTURA=3330|FECHAEMISION=20200213|IMEI=869175040414278|TOTAL_FACTURADO=100.00|TIPO_FACTURA=FC2|USUARIO=HCORDERO|MOTIVO=PAGO|TEST_QA|                 123432 ";
		String tramaComplete2 = "RECICLAJE|RECICLAJE|MSISDN=|CUENTA_CLIENTE=0801198716839CCHN|CUENTA_FACTURACION=8000066364|ID_PEDIDO_VENTA=1521895736507599298|NUMERO_FACTURA=3330|FECHAEMISION=20200213|IMEI=869175040414278|TOTAL_FACTURADO=100.00|TIPO_FACTURA=FC2|USUARIO=HCORDERO|MOTIVO=PAGO|TEST_QA|                 123432 ";
	
		List<String> list = new ArrayList<String>();
		list.add(tramaComplete);
		list.add(tramaComplete1);
		list.add(tramaComplete2);
		list.add("");
		
		for(int i=0; i<list.size(); i++) {
			
			try {
				thread.processTrama(readConfig, startTime, list.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
