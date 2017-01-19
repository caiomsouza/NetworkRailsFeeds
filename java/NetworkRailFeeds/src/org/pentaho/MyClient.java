package org.pentaho;


import net.ser1.stomp.Client;
import net.ser1.stomp.Listener;

/**
 * Example client that connects to the Network Rail ActiveMQ
 * and subscribes a listener to receive real-time messages
 * 
 * @author Martin.Swanson@blackkitetechnology.com
 */
public class MyClient {

	//Network Rail ActiveMQ server
	private static final String SERVER = "datafeeds.networkrail.co.uk";
	
	// Server port for STOMP clients
	private static final int PORT = 61618;
	
	// Your account username, typically an email address
	private static final String USERNAME = "cmoreno@pentaho.com";
	
	// Your account password
	private static final String PASSWORD = "YOUR_PASSWORD";
	
	// Example topic (this one is for Southern Train Movements)
//	private static final String TOPIC = "/topic/TRAIN_MVT_ALL_TOC"; 

//	private static final String TOPIC = "/topic/VSTP_ALL"; 
	
// http://nrodwiki.rockshore.net/index.php/RTPPM	
//	private static final String TOPIC = "/topic/RTPPM_ALL"; 

// TD_ALL_SIG_AREA	
	private static final String TOPIC = "/topic/TD_ALL_SIG_AREA"; 

	
	
	public static void main(String[] args) throws Exception {
		new MyClient().go();
	}
	
	/*
	 * Connect to a single topic and subscribe a listener
	 * @throws Exception Too lazy to implement exception handling....
	 */
	private void go() throws Exception {
		System.out.println("| Connecting...");
		Client client = new Client(SERVER, PORT, USERNAME, PASSWORD);
		if (client.isConnected()) {
			System.out.println("| Connected to " + SERVER + ":" + PORT);
		} else {
			System.out.println("| Could not connect");
			return;
		}
		System.out.println("| Subscribing...");
		Listener listener = new MyListener();
		client.subscribe(TOPIC , listener);
		System.out.println("| Subscribed to " + TOPIC);
		System.out.println("| Waiting for message...");
	}	
}