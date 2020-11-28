package com.car.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.car.dao.AdminDao;
import com.car.dao.CustomerDao;
import com.car.dao.EmployeeDao;
import com.car.model.Admin;
import com.car.model.Customer;
import com.car.model.Employee;

public class EditPassword extends JInternalFrame {

	private JPanel contentPane;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;
	private JLabel currentUserLabel;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { EditPassword frame = new
	 * EditPassword(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the frame.
	 */
	public EditPassword() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		setBounds(100, 100, 408, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true);
		setIconifiable(true);
		
		JLabel label = new JLabel("\u539F\u5BC6\u7801\uFF1A");
		label.setIcon(new ImageIcon(EditPassword.class.getResource("/images/\u5BC6\u7801.png")));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(EditPassword.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPassword.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		
		JLabel label_3 = new JLabel("\u5F53\u524D\u7528\u6237\uFF1A");
		label_3.setIcon(new ImageIcon(EditPassword.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		currentUserLabel = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(label_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(32)
							.addComponent(submitButton))
						.addComponent(label)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(oldPasswordTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(cancelButton)
							.addGap(18))
						.addComponent(newPasswordTextField, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
						.addComponent(confirmPasswordTextField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))
					.addGap(73))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(cancelButton)
						.addComponent(submitButton))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(MaimFrame.userType.getName())) {
			Admin admin = (Admin)MaimFrame.userObject;
			currentUserLabel.setText("【系统管理员】"+admin.getName());			
		}else if("客户".equals(MaimFrame.userType.getName())) {
			Customer customer = (Customer)MaimFrame.userObject;
			currentUserLabel.setText("【客户】"+customer.getName());
		}else {
			Employee employee = (Employee)MaimFrame.userObject;
			currentUserLabel.setText("【员工】"+employee.getName());
		}
	}

	protected void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String confirmPassword = confirmPasswordTextField.getText().toString();
		if(com.car.util.StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码！");
			return;
		}
		if(com.car.util.StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码！");
			return;
		}
		if(com.car.util.StringUtil.isEmpty(confirmPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码！");
			return;
		}
		if(!newPassword.equals(confirmPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致！");
			return;
		}
		if("系统管理员".equals(MaimFrame.userType.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MaimFrame.userObject;
			adminTmp.setName(admin.getName());
			adminTmp.setId(admin.getId());
			adminTmp.setPassword(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		if("客户".equals(MaimFrame.userType.getName())){
			CustomerDao customerDao = new CustomerDao();
			Customer customerTmp = new Customer();
			Customer customer = (Customer)MaimFrame.userObject;
			customerTmp.setName(customer.getName());
			customerTmp.setPassword(oldPassword);
			customerTmp.setId(customer.getId());
			JOptionPane.showMessageDialog(this, customerDao.editPassword(customerTmp, newPassword));
			customerDao.closeDao();
			return;
		}
		if("员工".equals(MaimFrame.userType.getName())){
			EmployeeDao employeeDao = new EmployeeDao();
			Employee employeeTmp = new Employee();
			Employee employee = (Employee)MaimFrame.userObject;
			employeeTmp.setName(employee.getName());
			employeeTmp.setPassword(oldPassword);
			employeeTmp.setId(employee.getId());
			JOptionPane.showMessageDialog(this, employeeDao.editPassword(employeeTmp, newPassword));
			employeeDao.closeDao();
			return;
		}
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		oldPasswordTextField.setText("");
		newPasswordTextField.setText("");
		confirmPasswordTextField.setText("");
	}
}
