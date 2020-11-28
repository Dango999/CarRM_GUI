package com.car.view;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.car.dao.AdminDao;
import com.car.dao.CustomerDao;
import com.car.dao.EmployeeDao;
import com.car.model.Admin;
import com.car.model.Customer;
import com.car.model.Employee;
import com.car.model.UserType;
import com.car.util.StringUtil;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("\u767B\u5F55\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("\u6C7D\u8F66\u79DF\u8D41\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u6C7D\u8F66.png")));
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6    \u7801\uFF1A");
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u5BC6\u7801.png")));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u7C7B\u578B\uFF1A");
		label_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/\u7528\u6237\u7C7B\u578B.png")));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.EMPLOYYEE,UserType.CUSTOMER}));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginAct(e);
			}
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reatValue(e);
			}
		});
		
		JLabel label_3 = new JLabel("\u7528\u6237\u6CE8\u518C");
		label_3.addMouseListener(new MouseAdapter() {
			private Container desktopPane;

			@Override
			public void mouseClicked(MouseEvent e) {
				RegisteredFrame registeredFrame = new RegisteredFrame();
				registeredFrame.setVisible(true);
				desktopPane.add(registeredFrame);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(128)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(147))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(userNameTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
						.addComponent(userTypeComboBox, 0, 152, Short.MAX_VALUE)
						.addComponent(passwordTextField, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
					.addGap(101))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(121)
					.addComponent(loginButton)
					.addGap(50)
					.addComponent(cancelButton)
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(352, Short.MAX_VALUE)
					.addComponent(label_3)
					.addGap(24))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(cancelButton))
					.addGap(36))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_3)
					.addContainerGap(251, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent e) {
		// TODO Auto-generated method stub
		String userName = userNameTextField.getText().toString();
		String password = passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空！");
			return;
		}
		if(StringUtil.isEmpty(password)) {
			JOptionPane.showMessageDialog(this, "密码不能为空！");
			return;
		}
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())) {      //系统管理员登录
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setName(userName);
			adminTmp.setPassword(password);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getName()+"登录本系统！");
			this.dispose();
			new MaimFrame(selectedItem, admin).setVisible(true);
		}else if("员工".equals(selectedItem.getName())) {     //员工登录
			Employee employee = null;
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employeeTmp = new Employee();
			employeeTmp.setName(userName);
			employeeTmp.setPassword(password);
			employee = employeeDao.login(employeeTmp);
			employeeDao.closeDao();
			if(employee == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+employee.getName()+"登录本系统！");
			this.dispose();
			new MaimFrame(selectedItem, employee).setVisible(true);
		}else {	    //客户登录
			Customer customer = null;
			CustomerDao customerDao = new CustomerDao();
			Customer customerTmp = new Customer();
			customerTmp.setName(userName);
			customerTmp.setPassword(password);
			customer = customerDao.login(customerTmp);
			customerDao.closeDao();
			if(customer == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+customer.getName()+"登录本系统！");
			this.dispose();
			new MaimFrame(selectedItem, customer).setVisible(true);
		}
	}

	protected void reatValue(ActionEvent e) {
		// TODO Auto-generated method stub
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
	}
}