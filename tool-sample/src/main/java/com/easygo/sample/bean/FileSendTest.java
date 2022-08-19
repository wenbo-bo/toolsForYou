package com.easygo.sample.bean;

import com.easygo.common.utils.StringUtil;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Objects;

public class FileSendTest {//发送方

	public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
		//ReceiveFileThread rf=new ReceiveFileThread();
		SendFileThread sf=new SendFileThread();
		//rf.start();
		sf.start();

		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//JFrame.setDefaultLookAndFeelDecorated(true);
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		//new JFrameTest();

	}
	static class JFrameTest {
		public JFrameTest(){

			JFrame.setDefaultLookAndFeelDecorated(true);
			JFrame frame = new JFrame("面板测试");
			frame.setSize(972, 621);
			frame.setLocation(2809, 533);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JLabel label = new JLabel("Hello World");
			frame.getContentPane().add(label);
			JPanel panel = new JPanel();
			frame.add(panel);
			placeComponents(frame,panel);
			frame.setVisible(true);
		}
	}
	private static void placeComponents(JFrame frame,JPanel panel) {

		/* 布局部分我们这边不多做介绍
		 * 这边设置布局为 null
		 */
		panel.setLayout(null);

		// 创建 JLabel
		JLabel userLabel = new JLabel("User:");
		/* 这个方法定义了组件的位置。
		 * setBounds(x, y, width, height)
		 * x 和 y 指定左上角的新位置，由 width 和 height 指定新的大小。
		 */
		userLabel.setBounds(10,20,80,25);
		panel.add(userLabel);

		/*
		 * 创建文本域用于用户输入
		 */
		JTextField userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		panel.add(userText);

		// 输入密码的文本域
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);

		/*
		 *这个类似用于输入的文本域
		 * 但是输入的信息会以点号代替，用于包含密码的安全性
		 */
		JPasswordField passwordText = new JPasswordField(20);
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);

		// 创建登录按钮
		JButton loginButton = new JButton("登录");
		loginButton.setBounds(10, 90, 80, 25);
		panel.add(loginButton);
		loginButton.addActionListener((ActionEvent e)->{
			String text = userText.getText();
			String data = "用户名 " + text;
			if (StringUtil.isEmpty(text)){
				JOptionPane.showMessageDialog(frame,"输入用户名","",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			String pwd = new String(passwordText.getPassword());
			if (StringUtil.isEmpty(pwd)){
				JOptionPane.showMessageDialog(frame,"输入密码","",JOptionPane.PLAIN_MESSAGE);
				return;
			}
			data += ", 密码: " + pwd;
			//statusLabel.setText(data);
			String msg = "";
			if ("123456".equals(pwd)){
				msg = "登录成功!";
			}else {
				msg = "登录失败!";
			}
			JOptionPane.showMessageDialog(frame,msg,"",JOptionPane.PLAIN_MESSAGE);
			System.out.println(data);

		});

		JButton cancelButton  = new JButton("取消");
		cancelButton.setBounds(185, 90, 80, 25);
		cancelButton.setVerticalTextPosition(AbstractButton.CENTER);
		cancelButton.setHorizontalTextPosition(AbstractButton.LEADING);
		cancelButton.setMnemonic(KeyEvent.VK_I);
		panel.add(cancelButton);
		JLabel label = new JLabel();
		cancelButton.addActionListener((ActionEvent e)-> {
			//JOptionPane.showMessageDialog(frame,"取消登录","警告!",JOptionPane.WARNING_MESSAGE);
			String[] options = {"是的，马上走起!", "不是，等一下！"};
			int result = JOptionPane.showOptionDialog(frame,"确定要退出?", "Swing对话框",
							JOptionPane.YES_NO_CANCEL_OPTION,
							JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					if(result == JOptionPane.YES_OPTION){
						label.setText("你选择了: 是");
					}else if (result == JOptionPane.NO_OPTION){
						label.setText("你选择了: 否");
					}else if (result == JOptionPane.CANCEL_OPTION){
						label.setText("你选择了: 取消");
					}else {
						label.setText("什么也没有选择！");
					}

	});

		JToggleButton toggleButton = new JToggleButton("点击我!");
		toggleButton.setBounds(300, 90, 80, 25);
		panel.add(toggleButton);
		toggleButton.addActionListener((ActionEvent e)-> {
			JToggleButton source = (JToggleButton) e.getSource();
			JOptionPane.showMessageDialog(frame, (source.isSelected()));
		});


		//展示网页
//		JEditorPane jEditorPane = new JEditorPane();
//		jEditorPane.setEditable(false);
//		//jEditorPane.setBounds(10, 100, 80, 25);
//		try {
//			jEditorPane.setPage("https://www.baidu.com");
//		} catch (IOException e) {
//			jEditorPane.setContentType("text/html");
//			jEditorPane.setText("<html>Page not found.</html>");
//		}
//
//		JScrollPane jScrollPane = new JScrollPane(jEditorPane);
//		jScrollPane.setPreferredSize(new Dimension(540,400));
//
//		panel.add(jScrollPane);

//		JToolBar toolBar = new JToolBar("工具栏");
//		toolBar.setBounds(10,200,300,25);
//		JButton buttonA = new JButton("按钮-A");
//		JButton buttonB = new JButton("按钮-B");
//		JButton buttonC = new JButton("按钮-C");
//		toolBar.add(buttonA);
//		toolBar.add(buttonB);
//		toolBar.addSeparator(new Dimension(100,10));
//		toolBar.add(buttonC);
//		panel.add(toolBar);


	}
}