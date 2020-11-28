package com.car.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import com.car.dao.CustomerDao;
import com.car.model.Customer;
import com.car.util.StringUtil;

public class CustomerManageFrame extends JInternalFrame {
	private JTextField serachCustomerNameTextField;
	private JTable customerListTable;
	private JTextField editCustomerNameTextField;
	private JPasswordField editCustomerPasswordField;
	private JButton deleteCustomerButton;
	private JButton submitEditButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerManageFrame frame = new CustomerManageFrame();
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
	public CustomerManageFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u5BA2\u6237\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 790, 430);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(CustomerManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		serachCustomerNameTextField = new JTextField();
		serachCustomerNameTextField.setColumns(10);
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchCustomer(e);
			}
		});
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(CustomerManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		editCustomerNameTextField = new JTextField();
		editCustomerNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(CustomerManageFrame.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		
		submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEditAct(e);
			}
		});
		
		deleteCustomerButton = new JButton("\u5220\u9664\u5BA2\u6237");
		deleteCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteCustomer(e);
			}
		});
		
		editCustomerPasswordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(104)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(serachCustomerNameTextField, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(179)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(107)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCustomerNameTextField, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCustomerPasswordField)))
							.addGap(174)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(submitEditButton)
								.addComponent(deleteCustomerButton)))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(21, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(serachCustomerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editCustomerNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editCustomerPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteCustomerButton))
					.addGap(43))
		);
		
		customerListTable = new JTable();
		customerListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		customerListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5BA2\u6237\u7F16\u53F7", "\u5BA2\u6237\u59D3\u540D", "\u767B\u5F55\u5BC6\u7801", "\u9A7E\u9A76\u8BC1\u53F7", "\u8EAB\u4EFD\u8BC1\u53F7", "\u5BA2\u6237\u6027\u522B", "\u5BA2\u6237\u5E74\u9F84", "\u7535\u8BDD\u53F7\u7801", "\u73B0\u4F4F\u5730\u5740", "\u7535\u5B50\u90AE\u7BB1"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(customerListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Customer());
		setAuthority();
	}
	protected void submitEditAct(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = customerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String customerName = editCustomerNameTextField.getText().toString();
		String customerPassword = editCustomerPasswordField.getText().toString();
		if(StringUtil.isEmpty(customerName)){
			JOptionPane.showMessageDialog(this, "请填写客户姓名！");
			return;
		}
		if(StringUtil.isEmpty(customerPassword)){
			JOptionPane.showMessageDialog(this, "请填写登录密码！");
			return;
		}
		
		Customer customer = new Customer();
		customer.setName(customerName);
		customer.setPassword(customerPassword);
		customer.setId(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()));
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.update(customer)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		customerDao.closeDao();
		setTable(new Customer());
	}

	protected void deleteCustomer(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = customerListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		CustomerDao customerDao = new CustomerDao();
		if(customerDao.delete(Integer.parseInt(customerListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		customerDao.closeDao();
		setTable(new Customer());
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		editCustomerNameTextField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 1).toString());
		editCustomerPasswordField.setText(dft.getValueAt(customerListTable.getSelectedRow(), 2).toString());
	}

	protected void searchCustomer(ActionEvent e) {
		// TODO Auto-generated method stub
		Customer customer = new Customer();
		customer.setName(serachCustomerNameTextField.getText().toString());
		setTable(customer);
	}

	private void setTable(Customer customer){
		if("客户".equals(MaimFrame.userType.getName())){
			Customer c = (Customer)MaimFrame.userObject;
			customer.setName(c.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) customerListTable.getModel();
		dft.setRowCount(0);
		CustomerDao customerDao = new CustomerDao();
		List<Customer> customerList = customerDao.getCustomerList(customer);
		for (Customer c : customerList) {
			Vector v = new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(c.getPassword());
			v.add(c.getLicense());
			v.add(c.getIdentity());
			v.add(c.getSex());
			v.add(c.getAge());
			v.add(c.getPhone());
			v.add(c.getAddress());
			v.add(c.getMail());
			dft.addRow(v);
		}
		customerDao.closeDao();
	}
	private void setAuthority(){
		if("客户".equals(MaimFrame.userType.getName())){
			Customer c = (Customer)MaimFrame.userObject;
			serachCustomerNameTextField.setText(c.getName());
			serachCustomerNameTextField.setEnabled(false);
			deleteCustomerButton.setEnabled(false);
		}
		if("员工".equals(MaimFrame.userType.getName())){
			submitEditButton.setEnabled(false);
			deleteCustomerButton.setEnabled(false);
		}
	}
}
