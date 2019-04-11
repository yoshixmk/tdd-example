package xunit;

public class WasRun {

	private String name;
	private boolean wasRun;

	public WasRun(String name) {
		this.name = name;
	}

	public void run() {
		this.wasRun = true;
	}

	public boolean wasRun() {
		return this.wasRun;
	}

}
