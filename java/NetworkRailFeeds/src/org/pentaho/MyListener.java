package org.pentaho;

import net.ser1.stomp.Listener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
 
/**
 * Example listener process that receives messages 
 * in JSON format from the Network Rail ActiveMQ
 * 
 * @author Martin.Swanson@blackkitetechnology.com
 */
public class MyListener implements Listener {
    
	@Override
	public void message(Map header, String body) {
		
		
		System.out.println("| Got header: " + header);
		System.out.println("| Got body: " + body);
		
		try {
			
			Files.write(Paths.get("TD_ALL_SIG_AREA.json"), body.getBytes() 
					,StandardOpenOption.APPEND
//					StandardOpenOption.WRITE, 
//	                StandardOpenOption.APPEND,
//	                ,StandardOpenOption.CREATE
					);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
