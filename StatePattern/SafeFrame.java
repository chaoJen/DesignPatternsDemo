import java.awt.Frame;
import java.awt.Label;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements ActionListener, Context {

	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("使用金庫");
	private Button buttonAlarm = new Button("警鈴");
	private Button buttonPhone = new Button("一般通話");
	private Button buttonExit = new Button("結束");

	private State state = DayState.getInstance();

	public SafeFrame(String title) {

		super(title);
		setBackground(Color.lightGray);
		setLayout(new BorderLayout());

		add(textClock, BorderLayout.NORTH);
		textClock.setEditable(false);

		add(textScreen, BorderLayout.CENTER);
		textScreen.setEditable(false);

		Panel panel = new Panel();
		panel.add(buttonUse);
		panel.add(buttonAlarm);
		panel.add(buttonPhone);
		panel.add(buttonExit);

		add(panel, BorderLayout.SOUTH);

		pack();
		show();

		buttonUse.addActionListener(this);
		buttonAlarm.addActionListener(this);
		buttonPhone.addActionListener(this);
		buttonExit.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		System.out.println("" + e);

		if (e.getSource() == buttonUse) {
			
			state.doUse(this);
		
		} else if (e.getSource() == buttonAlarm) {
			
			state.doAlarm(this);
		
		} else if (e.getSource() == buttonPhone) {
			
			state.doPhone(this);
		
		} else if (e.getSource() == buttonExit) {
			
			System.exit(0);
		
		} else {

			System.out.println("?");
		}
	}

	public void setClock(int hour) {

		String clockstring = "現在時間是 ";

		if (hour < 10) {
			
			clockstring += "0" + hour + ":00";

		} else {

			clockstring += hour + ":00";
		}

		System.out.println(clockstring);

		textClock.setText(clockstring);
		state.doClock(this, hour);
	}

	public void changeState(State state) {

		System.out.println("狀態已從" + this.state + "變成" + state + "。");

		this.state = state;
	}

	public void callSecurityCenter(String msg) {

		textScreen.append("call! " + msg + "\n");
	}

	public void recordLog(String msg) {

		textScreen.append("record ... " + msg + "\n");
	}
}