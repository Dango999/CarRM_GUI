package com.car.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.car.dao.CustomerDao;
import com.car.model.Customer;
import com.car.util.StringUtil;

public class AddCustomerFrame extends JInternalFrame {
	private JTextField customerNameTextField;
	private JPasswordField customerPasswordField;
	private JTextField customerLicenseTextField;
	private JTextField customerIdentityTextField;
	private JTextField customerAgeTextField;
	private JTextField customerPhoneTextField;
	private JTextField customerAddressTextField;
	private JTextField customerMailTextField;
	private ButtonGroup sexButtonGroup;
	private JRadioButton customerSexManRadioButton;
	private JRadioButton customerSexFemalRadioButton;
	private JRadioButton customerSexUnknowRadioButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomerFrame frame = new AddCustomerFrame();
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
	public AddCustomerFrame() {
		setTitle("\u6DFB\u52A0\u5BA2\u6237");
		setBounds(100, 100, 451, 342);
		setClosable(true );
		setIconifiable(true);
		
		JLabel label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		customerNameTextField = new JTextField();
		customerNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_1.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u5BC6\u7801.png")));
		
		customerPasswordField = new JPasswordField();
		
		JLabel lblNewLabel = new JLabel("\u9A7E\u9A76\u8BC1\u53F7\uFF1A");
		lblNewLabel.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u9A7E\u9A76\u8BC1.png")));
		
		customerLicenseTextField = new JTextField();
		customerLicenseTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u8EAB\u4EFD\u8BC1.png")));
		
		customerIdentityTextField = new JTextField();
		customerIdentityTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BA2\u6237\u6027\u522B\uFF1A");
		label_3.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u6027\u522B.png")));
		
		customerSexManRadioButton = new JRadioButton("\u7537");
		
		JLabel label_4 = new JLabel("\u5BA2\u6237\u5E74\u9F84\uFF1A");
		label_4.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u5E74\u9F84.png")));
		
		customerAgeTextField = new JTextField();
		customerAgeTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_5.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u7535  \u8BDD.png")));
		
		customerPhoneTextField = new JTextField();
		customerPhoneTextField.setColumns(10);
		
		JLabel label_6 = new JLabel("\u5BA2\u6237\u5730\u5740\uFF1A");
		label_6.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u5730\u5740.png")));
		
		customerAddressTextField = new JTextField();
		customerAddressTextField.setColumns(10);
		
		JLabel label_7 = new JLabel("\u7535\u5B50\u90AE\u7BB1\uFF1A");
		label_7.setIcon(new ImageIcon(AddCustomerFrame.class.getResource("/images/\u90AE\u7BB1.png")));
		
		customerMailTextField = new JTextField();
		customerMailTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u5B9A");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerAddAct(e);
			}
		});
		
		JButton cancelButton = new JButton("\u53D6\u6D88");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		
		customerSexFemalRadioButton = new JRadioButton("\u5973");
		
		customerSexUnknowRadioButton = new JRadioButton("\u4FDD\u5BC6");
		
		sexButtonGroup = new ButtonGroup();
		sexButtonGroup.add(customerSexManRadioButton);
		sexButtonGroup.add(customerSexFemalRadioButton);
		sexButtonGroup.add(customerSexUnknowRadioButton);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(84)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(customerSexManRadioButton)
									.addGap(18)
									.addComponent(customerSexFemalRadioButton)
									.addGap(18)
									.addComponent(customerSexUnknowRadioButton))
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_7)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerMailTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_6)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerAddressTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_5)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerPhoneTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_4)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerAgeTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addComponent(label_2)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(customerIdentityTextField))
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(label_1)
											.addComponent(lblNewLabel)
											.addComponent(label))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
											.addComponent(customerLicenseTextField)
											.addComponent(customerPasswordField)
											.addComponent(customerNameTextField, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(131)
							.addComponent(submitButton)
							.addGap(49)
							.addComponent(cancelButton)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(customerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(customerPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(customerLicenseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(customerIdentityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(customerSexManRadioButton)
						.addComponent(customerSexFemalRadioButton)
						.addComponent(customerSexUnknowRadioButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(customerAgeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(customerPhoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(customerAddressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_7)
						.addComponent(customerMailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(cancelButton))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void customerAddAct(ActionEvent e) {
		// TODO Auto-generated method stub
		String customerName = customerNameTextField.getText().toString();
		String customerPassword = customerPasswordField.getText().toString();
		String customerLicense = customerLicenseTextField.getText().toString();
		String customerIdentity = customerIdentityTextField.getText().toString();
		String customerAge = customerAgeTextField.getText().toString();
		String customerPhone = customerPhoneTextField.getText().toString();
		String customerAddress = customerAddressTextField.getText().toString();
		String customerMail = customerMailTextField.getText().toString();
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "请输入客户姓名!");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "请输入登录密码!");
			return;
		}
        if(StringUtil.isEmpty(customerLicense)){
			JOptionPane.showMessageDialog(this, "请输入驾驶证号!");
			return;
		}
        if(StringUtil.isEmpty(customerIdentity)){
			JOptionPane.showMessageDialog(this, "请输入身份证号!");
			return;
		}
        if(StringUtil.isEmpty(customerAge)){
			JOptionPane.showMessageDialog(this, "请输入年龄!");
			return;
		}
        if(StringUtil.isEmpty(customerPhone)){
			JOptionPane.showMessageDialog(this, "请输入电话号码!");
			return;
		}
        if(StringUtil.isEmpty(customerAddress)){
			JOptionPane.showMessageDialog(this, "请输入现住地址!");
			return;
		}
        if(StringUtil.isEmpty(customerMail)){
			JOptionPane.showMessageDialog(this, "请输入电子邮箱!");
			return;
		}
        String sex = customerSexManRadioButton.isSelected() ? customerSexManRadioButton.getText() : (customerSexFemalRadioButton.isSelected() ? customerSexFemalRadioButton.getText() : customerSexUnknowRadioButton.getText());
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setPassword(customerPassword);
        customer.setLicense(customerLicense);
        customer.setIdentity(customerIdentity);
        customer.setAge(customerAge);
        customer.setPhone(customerPhone);
        customer.setAddress(customerAddress);
        customer.setMail(customerMail);
		customer.setSex(sex);
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.addCustomer(customer)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		resetValue(e);        
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		customerNameTextField.setText("");
		customerPasswordField.setText("");
		customerLicenseTextField.setText("");
		customerIdentityTextField.setText("");
		customerAgeTextField.setText("");
		customerPhoneTextField.setText("");
		customerAddressTextField.setText("");
		customerMailTextField.setText("");
		sexButtonGroup.clearSelection();
		customerSexManRadioButton.setSelected(true);
	}
}
