public class Director {

	private Builder builder;

	public Director(Builder builder) {

		this.builder = builder;
	}

	public Object construct() {

		builder.makeTitle("Greeting");
		builder.makeString("until tomorrow");
		builder.makeItems(new String[] {
			"morning", "evening"
		});
		builder.makeString("is night");
		builder.makeItems(new String[] {
			"good night", "have a nice dream", "see you"
		});
		return builder.getResult();
	}
}