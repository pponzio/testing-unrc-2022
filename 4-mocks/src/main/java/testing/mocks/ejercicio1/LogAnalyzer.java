package testing.mocks.ejercicio1;


public class LogAnalyzer {
	private IWebService service;

	private IEmailService email;

	public void setWebService(IWebService service) {
		this.service = service;
	}

	public void setEmailService(IEmailService email) {
		this.email = email;
	}

	public void analyze(String fileName) {
		if(fileName.length()<8) {
			try {
				service.logError("Filename too short:" + fileName);
			}
			catch (Exception e) {
				email.sendEmail("a","subject",e.getMessage());
			}
		}
	}
}

