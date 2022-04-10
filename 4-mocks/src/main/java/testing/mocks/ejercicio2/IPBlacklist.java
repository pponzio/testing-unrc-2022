package testing.mocks.ejercicio2;

import java.util.LinkedList;

public class IPBlacklist {
	
	private static final int maxRetries = 3;
	
	private LinkedList<String> IPblacklist;
	
	String lastip;
	int numOfRetries;
	
	private LoginService service;

	public IPBlacklist() {
		IPblacklist = new LinkedList<String>();
	}
	
	public void setService(LoginService service) {
		this.service = service;
	}
	
	public boolean login(String ip, String userName, String password) {
		if(blacklisted(ip)) {
			lastip = ip;
			numOfRetries = 0;
			return false;
		}
		
		String passwordHash = Utils.getPasswordHashMD5(password);
		
		if(service.login(ip, userName, passwordHash)) {
			lastip = ip;
			numOfRetries = 0;
			return true;
		} else {
			if (ip.equals(lastip)) {
				numOfRetries++;
				if (numOfRetries == maxRetries) {
					blacklistIP(ip);
				}
			} else {
				lastip = ip;
				numOfRetries = 1;
			}
			return false;
		}
		
	}
	
	private void blacklistIP(String ip) {
			IPblacklist.add(ip);
	}
	
	public boolean blacklisted(String ip) {
		return IPblacklist.contains(ip);
	}
	

}
