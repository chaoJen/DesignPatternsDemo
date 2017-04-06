public class NightState implements State {

	private static NightState singleton = new NightState();

	private NightState() {

	}

	public static State getInstance() {

		return singleton;
	}

	public void doClock(Context context, int hour) {

		if (9 <= hour && hour < 17) {
			
			context.changeState(DayState.getInstance());
		}
	}

	public void doUse(Context context) {

		context.callSecurityCenter("異常：晚間使用金庫！");
	}

	public void doAlarm(Context context) {

		context.callSecurityCenter("警鈴(Night)");
	}

	public void doPhone(Context context) {

		context.recordLog("晚間的通話錄音");
	}

	public String toString() {

		return "[Night]";
	}
}