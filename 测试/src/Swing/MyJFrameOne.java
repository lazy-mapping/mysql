package Swing;
/**  Graphical User Interface 图形用户界面编程
 *创建容器
 *为容器设置布局
 *创建组件，将其添加进容器
 *为组件添加事件处理代码
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*通过继承JFrame创建一个GUI窗口*/

public class MyJFrameOne extends JFrame {
	
	/**
	 * 一个警告，所以这样处理；似乎是，为了在序列化和反序列化时，确保版本的兼容性！！！
	 */
	private static final long serialVersionUID = -7270715855802177023L;
	
	JButton button;
	JLabel label;
	MyJFrameOne(String title){
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		button =new JButton("按钮");
		button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				label.setForeground(Color.red);
			}
		});//按钮--事件处理：标签变红色
		label =new JLabel("标签");
		add(button);
		add(label);
		setSize(300,300);
		setVisible(true);
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")//未使用警告
		MyJFrameOne myf=new MyJFrameOne("MyJFrame");
		
	}
}