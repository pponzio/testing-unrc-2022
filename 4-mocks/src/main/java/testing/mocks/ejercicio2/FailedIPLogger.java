package testing.mocks.ejercicio2;

import java.util.LinkedList;


public class FailedIPLogger {
	
	private LinkedList<String> failedIPsLog;
	
	private LoginService service;

	public FailedIPLogger() {
		failedIPsLog = new LinkedList<String>();
	}
	
	public void setService(LoginService service) {
		this.service = service;
	}
	
	public boolean login(String ip, String userName, String password) {
		String passwordHash = Utils.getPasswordHashMD5(password);

		if(service.login(ip, userName, passwordHash)) {
			return true;
		}
		else {
			logFailedIP(ip);
			return false;
		}
	}
	
	private void logFailedIP(String ip) {
		if (!failedIPsLog.contains(ip))
			failedIPsLog.add(ip);
	}
	
	public boolean loginFailed(String ip) {
		return failedIPsLog.contains(ip);
	}
     
     
}     
