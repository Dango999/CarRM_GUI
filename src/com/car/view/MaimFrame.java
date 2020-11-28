package com.car.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.car.view.MaimFrame;
import com.car.model.UserType;

public class MaimFrame extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	public static UserType userType;
	public static Object userObject;
	private JMenuItem addCustomerMenuItem;
	private JMenu employeeMenu;
	private JMenuItem addEmployeeMenuItem;
	private JMenuItem addCarMenuItem;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				MainFrm frame = new MainFrm(null,null);
//				frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}

	/**
	 * Create the frame.
	 */
	public MaimFrame(UserType userType,Object userObject) {
		this.userType = userType;
		this.userObject = userObject;
		setTitle("\u6B22\u8FCE\u8FDB\u5165\u6C7D\u8F66\u79DF\u8D41\u7CFB\u7EDF\uFF01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editPassword(e);
			}
		});
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MaimFrame.this, "确定退出么嘛？") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5BA2\u6237\u7BA1\u7406");
		menu_1.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u5BA2\u6237\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		addCustomerMenuItem = new JMenuItem("\u5BA2\u6237\u6DFB\u52A0");
		addCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerFrame addCustomerFrame = new AddCustomerFrame();
				addCustomerFrame.setVisible(true);
				desktopPane.add(addCustomerFrame);
			}
		});
		menu_1.add(addCustomerMenuItem);
		
		JMenuItem manageCustomerMenuItem = new JMenuItem("\u5BA2\u6237\u5217\u8868");
		manageCustomerMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManageFrame customerManageFrame = new CustomerManageFrame();
				customerManageFrame.setVisible(true);
				desktopPane.add(customerManageFrame);
			}
		});
		menu_1.add(manageCustomerMenuItem);
		
		employeeMenu = new JMenu("\u5458\u5DE5\u7BA1\u7406");
		employeeMenu.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u5458\u5DE5\u7BA1\u7406.png")));
		menuBar.add(employeeMenu);
		
		JMenuItem manageEmployeeMenuItem = new JMenuItem("\u5458\u5DE5\u5217\u8868");
		manageEmployeeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManageFrame employeeManageFrame = new EmployeeManageFrame();
				employeeManageFrame.setVisible(true);
				desktopPane.add(employeeManageFrame);
			}
		});
		
		addEmployeeMenuItem = new JMenuItem("\u5458\u5DE5\u6DFB\u52A0");
		addEmployeeMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployeeFrame addEmployeeFrame = new AddEmployeeFrame();
				addEmployeeFrame.setVisible(true);
				desktopPane.add(addEmployeeFrame);
			}
		});
		employeeMenu.add(addEmployeeMenuItem);
		employeeMenu.add(manageEmployeeMenuItem);
		
		JMenu menu_3 = new JMenu("\u6C7D\u8F66\u7BA1\u7406");
		menu_3.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u6C7D\u8F66\u7BA1\u7406.png")));
		menuBar.add(menu_3);
		
		addCarMenuItem = new JMenuItem("\u6C7D\u8F66\u6DFB\u52A0");
		addCarMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCarFrame addCarFrame = new AddCarFrame();
				addCarFrame.setVisible(true);
				desktopPane.add(addCarFrame);
			}
		});
		menu_3.add(addCarMenuItem);
		
		JMenuItem menuItem_7 = new JMenuItem("\u6C7D\u8F66\u5217\u8868");
		menuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarManageFrame carManageFrame = new CarManageFrame();
				carManageFrame.setVisible(true);
				desktopPane.add(carManageFrame);
			}
		});
		menu_3.add(menuItem_7);
		
		JMenu menu_5 = new JMenu("\u79DF\u8D41\u7BA1\u7406");
		menu_5.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u79DF\u8D41\u7BA1\u7406.png")));
		menuBar.add(menu_5);
		
		JMenuItem menuItem_10 = new JMenuItem("\u79DF\u8D41\u4E1A\u52A1");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RentalCarManageFrame rentalCarManageFrame = new RentalCarManageFrame();
				rentalCarManageFrame.setVisible(true);
				desktopPane.add(rentalCarManageFrame);
			}
		});
		menu_5.add(menuItem_10);
		
		JMenu menu_4 = new JMenu("\u5E2E\u52A9");
		menu_4.setIcon(new ImageIcon(MaimFrame.class.getResource("/images/\u5E2E \u52A9.png")));
		menuBar.add(menu_4);
		
		JMenuItem menuItem_8 = new JMenuItem("\u5173\u4E8E\u6211\u4EEC");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aboutUs(e);
			}
		});
		
		JMenuItem menuItem_9 = new JMenuItem("\u7591\u95EE\u89E3\u7B54");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuestionManageFrame questionManageFrame = new QuestionManageFrame();
				questionManageFrame.setVisible(true);
				desktopPane.add(questionManageFrame);
			}
		});
		menu_4.add(menuItem_9);
		menu_4.add(menuItem_8);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(0, 128, 128));
		desktopPane.setBounds(0, 0, 784, 491);
		contentPane.add(desktopPane,BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void editPassword(ActionEvent e) {
		// TODO Auto-generated method stub
		EditPassword editPassword = new EditPassword();
		editPassword.setVisible(true);
		desktopPane.add(editPassword);
	}

	protected void aboutUs(ActionEvent e) {
		// TODO Auto-generated method stub
		String info = "【超级赛亚蛋】出品\n";
		info += "好好学习，天天向上！";
		JOptionPane.showMessageDialog(this, info);
	}
	private void setAuthority(){
		if("客户".equals(userType.getName())){
			addCustomerMenuItem.setEnabled(false);
			employeeMenu.setEnabled(false);
			addCarMenuItem.setEnabled(false);
		}
		if("员工".equals(userType.getName())){
			addEmployeeMenuItem.setEnabled(false);
			addCustomerMenuItem.setEnabled(false);
		}
	}
}
