package money;

public class Pair {

	private String from;
	private String to;

	public Pair(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	
	@Override
	public boolean equals(Object obj) {
		Pair pair = (Pair) obj;
		return this.from.equals(pair.from) && this.to.equals(pair.to);
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
