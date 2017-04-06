public class DayState implements State {

	private static DayState singleton = new DayState();

	private DayState() {

	}

	public static State getInstance() {

		return singleton;
	}

	public void doClock(Context context, int hour) {

		if (hour < 9 || 17 <= hour) {
			
			context.changeState(NightState.getInstance());
		}
	}

	public void doUse(Context context) {

		context.recordLog("使用金庫(Day)");
	}

	public void doAlarm(Context context) {

		context.callSecurityCenter("警鈴(Day)");
	}

	public void doPhone(Context context) {

		context.callSecurityCenter("一般通話(Day)");
	}

	public String toString() {

		return "[Day]";
	}
}