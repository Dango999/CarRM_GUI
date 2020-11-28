package com.car.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.car.dao.EmployeeDao;
import com.car.model.Employee;
import com.car.util.StringUtil;

public class AddEmployeeFrame extends JInternalFrame {
	private JTextField employeeNameTextField;
	private JPasswordField employeePasswordField;
	private JTextField employeePhoneTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeFrame frame = new AddEmployeeFrame();
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
	public AddEmployeeFrame() {
		setTitle("\u6DFB\u52A0\u5458\u5DE5");
		setBounds(100, 100, 389, 246);
		setClosable(true );
		setIconifiable(true);
		
		JLabel label = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddEmployeeFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		employeeNameTextField = new JTextField();
		employeeNameTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddEmployeeFrame.class.getResource("/images/\u5BC6\u7801.png")));
		
		employeePasswordField = new JPasswordField();
		
		JLabel label_1 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(AddEmployeeFrame.class.getResource("/images/\u7535  \u8BDD.png")));
		
		employeePhoneTextField = new JTextField();
		employeePhoneTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addEmployeeAct(e);
			}
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(submitButton)
							.addGap(45)
							.addComponent(cancelButton)
							.addGap(25))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(label)
								.addComponent(lblNewLabel)
								.addComponent(label_1))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(employeePhoneTextField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(employeePasswordField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(employeeNameTextField, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))
					.addGap(90))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(employeeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(employeePasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(employeePhoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(cancelButton))
					.addGap(40))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		employeeNameTextField.setText("");
		employeePasswordField.setText("");
		employeePhoneTextField.setText("");
	}

	protected void addEmployeeAct(ActionEvent e) {
		// TODO Auto-generated method stub
		String employeeName = employeeNameTextField.getText().toString();
		String employeePassword = employeePasswordField.getText().toString();
		String employeePhone = employeePhoneTextField.getText().toString();
		if(StringUtil.isEmpty(employeeName)){
			JOptionPane.showMessageDialog(this, "请输入员工姓名!");
			return;
		}
		if(StringUtil.isEmpty(employeePassword)){
			JOptionPane.showMessageDialog(this, "请输入登录密码!");
			return;
		}
		if(StringUtil.isEmpty(employeePhone)){
			JOptionPane.showMessageDialog(this, "请输入电话号码!");
			return;
		}
		Employee employee = new Employee();
		employee.setName(employeeName);
		employee.setPassword(employeePassword);
		employee.setPhone(employeePhone);
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.addEmployee(employee)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(e);        
	}

}
