package xunit;

public class WasRun {

	private String name;
	private boolean wasRun;
	private boolean wasSetUp;

	public WasRun(String name) {
		this.name = name;
		this.wasSetUp = true;
	}

	public void run() {
		this.wasRun = true;
	}

	public boolean wasRun() {
		return this.wasRun;
	}

	public boolean wasSetUp() {
		return this.wasSetUp;
	}

}
