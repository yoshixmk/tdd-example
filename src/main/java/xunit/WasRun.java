package xunit;

public class WasRun {

	private String log;
	private boolean wasRun;
	private boolean wasSetUp;

	public WasRun() {
		this.log = "";
		this.wasSetUp = true;
	}

	public void run() {
		this.wasRun = true;
	}

	public boolean wasRun() {
		return this.wasRun;
	}
	
	public void addLog(String log) {
		this.log += log;
	}

	public String getLog() {
		return log;
	}

	public boolean wasSetUp() {
		return this.wasSetUp;
	}

}
