package Swing;

import javax.swing.JFrame;
/*GUI 创建一个空白窗口*/
public class TestJFrame {
	public static void main(String[] args) {
		JFrame f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setVisible(true);
	}
}
