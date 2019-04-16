package xunit;

public class WasRun {

	private String log;
	private boolean wasRun;
	private boolean wasSetUp;

	public WasRun(String name) {
		this.log = name;
		this.wasSetUp = true;
	}

	public void run() {
		this.wasRun = true;
	}

	public boolean wasRun() {
		this.log += "testMethod";
		return this.wasRun;
	}

	public String getLog() {
		return log;
	}

	public boolean wasSetUp() {
		return this.wasSetUp;
	}

}
