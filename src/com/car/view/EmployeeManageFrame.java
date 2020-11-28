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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.car.dao.EmployeeDao;
import com.car.model.Employee;
import com.car.util.StringUtil;

public class EmployeeManageFrame extends JInternalFrame {
	private JTable employeeListTable;
	private JTextField searchEmployeeNameTextField;
	private JTextField editEmployeeNameTextField;
	private JPasswordField editEmployeePasswordField;
	private JTextField editEmployeePhoneTextField;
	private JButton deleteEmployeeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManageFrame frame = new EmployeeManageFrame();
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
	public EmployeeManageFrame() {
		setTitle("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 549, 383);
		setClosable(true);
		setIconifiable(true);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(EmployeeManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		searchEmployeeNameTextField = new JTextField();
		searchEmployeeNameTextField.setColumns(10);
		
		JButton searchEmployeeButton = new JButton("\u67E5\u8BE2");
		searchEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEmployee(e);
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5458\u5DE5\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchEmployeeNameTextField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(74)
							.addComponent(searchEmployeeButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(40)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(panel, 0, 0, Short.MAX_VALUE)
								.addComponent(scrollPane))))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchEmployeeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchEmployeeButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(EmployeeManageFrame.class.getResource("/images/\u7528\u6237\u540D.png")));
		
		editEmployeeNameTextField = new JTextField();
		editEmployeeNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EmployeeManageFrame.class.getResource("/images/\u65B0\u5BC6\u7801.png")));
		
		editEmployeePasswordField = new JPasswordField();
		
		JLabel label_3 = new JLabel("\u7535\u8BDD\u53F7\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(EmployeeManageFrame.class.getResource("/images/\u7535  \u8BDD.png")));
		
		editEmployeePhoneTextField = new JTextField();
		editEmployeePhoneTextField.setColumns(10);
		
		JButton editEmployeeSubmitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		editEmployeeSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editEmployeeAct(e);
			}
		});
		
		deleteEmployeeButton = new JButton("\u5220\u9664\u5458\u5DE5");
		deleteEmployeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteEmployee(e);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editEmployeeNameTextField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editEmployeePhoneTextField)))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(editEmployeeSubmitButton)
						.addComponent(label_2))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addComponent(deleteEmployeeButton))
						.addGroup(gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editEmployeePasswordField, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addGap(22))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editEmployeeNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2)
						.addComponent(editEmployeePasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editEmployeePhoneTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editEmployeeSubmitButton)
						.addComponent(deleteEmployeeButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		employeeListTable = new JTable();
		employeeListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedTableRow(e);
			}
		});
		employeeListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5458\u5DE5\u7F16\u53F7", "\u5458\u5DE5\u59D3\u540D", "\u767B\u5F55\u5BC6\u7801", "\u7535\u8BDD\u53F7\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(employeeListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Employee());
		setAuthority();
	}
	protected void editEmployeeAct(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = employeeListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String employeeName = editEmployeeNameTextField.getText().toString();
		String employeePassword = editEmployeePasswordField.getText().toString();
		String employeePhone = editEmployeePhoneTextField.getText().toString();
		if(StringUtil.isEmpty(employeeName)){
			JOptionPane.showMessageDialog(this, "请填写员工姓名！");
			return;
		}
		if(StringUtil.isEmpty(employeePassword)){
			JOptionPane.showMessageDialog(this, "请填写登录密码！");
			return;
		}
		if(StringUtil.isEmpty(employeePhone)){
			JOptionPane.showMessageDialog(this, "请填写电话号码！");
			return;
		}
		
		Employee employee = new Employee();
		employee.setName(employeeName);
		employee.setPassword(employeePassword);
		employee.setPhone(employeePhone);
		employee.setId(Integer.parseInt(employeeListTable.getValueAt(row, 0).toString()));
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.update(employee)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		employeeDao.closeDao();
		setTable(new Employee());
	}

	protected void searchEmployee(ActionEvent e) {
		// TODO Auto-generated method stub
		Employee employee = new Employee();
		employee.setName(searchEmployeeNameTextField.getText().toString());
		setTable(employee);
	}

	protected void deleteEmployee(ActionEvent e) {
		// TODO Auto-generated method stub
		int row = employeeListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		EmployeeDao employeeDao = new EmployeeDao();
		if(employeeDao.delete(Integer.parseInt(employeeListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		employeeDao.closeDao();
		setTable(new Employee());
	}

	private void setTable(Employee employee){
		if("员工".equals(MaimFrame.userType.getName())){
			Employee e = (Employee)MaimFrame.userObject;
			employee.setName(e.getName());
		}
		DefaultTableModel dft = (DefaultTableModel) employeeListTable.getModel();
		dft.setRowCount(0);
		EmployeeDao employeeDao = new EmployeeDao();
		List<Employee> employeeList = employeeDao.getEmployeeList(employee);
		for (Employee e : employeeList) {
			Vector v = new Vector();
			v.add(e.getId());
			v.add(e.getName());
			v.add(e.getPassword());
			v.add(e.getPhone());
			dft.addRow(v);
		}
		employeeDao.closeDao();
	}
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) employeeListTable.getModel();
		editEmployeeNameTextField.setText(dft.getValueAt(employeeListTable.getSelectedRow(), 1).toString());
		editEmployeePasswordField.setText(dft.getValueAt(employeeListTable.getSelectedRow(), 2).toString());
		editEmployeePhoneTextField.setText(dft.getValueAt(employeeListTable.getSelectedRow(), 3).toString());
	}
	private void setAuthority(){
		if("员工".equals(MaimFrame.userType.getName())){
			Employee e = (Employee)MaimFrame.userObject;
			searchEmployeeNameTextField.setText(e.getName());
			searchEmployeeNameTextField.setEnabled(false);
			deleteEmployeeButton.setEnabled(false);
		}
	}
}
