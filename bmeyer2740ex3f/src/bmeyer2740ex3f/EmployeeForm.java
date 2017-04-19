package bmeyer2740ex3f;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class EmployeeForm extends JFrame {

	private JPanel contentPane;
	private JTextField empIDTextField;
	private JTextField empNameTextField;
	private JTextField positionTextField;
	private JList employeeList;
	private JComboBox deptComboBox;
	private DefaultListModel employeeListModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeForm frame = new EmployeeForm();
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
	public EmployeeForm() {
		setTitle("Exercise 3F: Overloaded Constructors");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 11, 398, 122);
		contentPane.add(scrollPane);
		
		employeeListModel = new DefaultListModel();
		employeeList = new JList(employeeListModel);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID:");
		lblEmployeeId.setBounds(20, 144, 89, 14);
		contentPane.add(lblEmployeeId);
		
		empIDTextField = new JTextField();
		lblEmployeeId.setLabelFor(empIDTextField);
		empIDTextField.setText("101");
		empIDTextField.setBounds(119, 144, 97, 20);
		contentPane.add(empIDTextField);
		empIDTextField.setColumns(10);
		
		JLabel lblEmployeeName = new JLabel("Employee Name:");
		lblEmployeeName.setBounds(20, 181, 89, 14);
		contentPane.add(lblEmployeeName);
		
		empNameTextField = new JTextField();
		lblEmployeeName.setLabelFor(empNameTextField);
		empNameTextField.setText("Brandon Meyer");
		empNameTextField.setBounds(119, 178, 97, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department: ");
		lblDepartment.setBounds(20, 213, 89, 14);
		contentPane.add(lblDepartment);
		
		deptComboBox = new JComboBox();
		deptComboBox.setModel(new DefaultComboBoxModel(new String[] {"Business Office", "Human Resources", "Manufacturing", "Shipping", "Maintenance"}));
		lblDepartment.setLabelFor(deptComboBox);
		deptComboBox.setBounds(117, 209, 139, 22);
		contentPane.add(deptComboBox);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(20, 245, 65, 14);
		contentPane.add(lblPosition);
		
		positionTextField = new JTextField();
		lblPosition.setLabelFor(positionTextField);
		positionTextField.setText("Software Engineer");
		positionTextField.setBounds(119, 242, 137, 20);
		contentPane.add(positionTextField);
		positionTextField.setColumns(10);
		
		JButton noArgConstructorButton = new JButton("No Arg");
		noArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_noArgConstructorButton_actionPerformed(arg0);
			}
		});
		noArgConstructorButton.setBounds(257, 143, 91, 23);
		contentPane.add(noArgConstructorButton);
		
		JButton twoArgConstructorButton = new JButton("2 Arg");
		twoArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_twoArgConstructorButton_actionPerformed(e);
			}
		});
		twoArgConstructorButton.setBounds(257, 177, 91, 23);
		contentPane.add(twoArgConstructorButton);
		
		JButton fourArgConstructorButton = new JButton("4 Arg");
		fourArgConstructorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_fourArgConstructorButton_actionPerformed(e);
			}
		});
		fourArgConstructorButton.setBounds(287, 209, 91, 23);
		contentPane.add(fourArgConstructorButton);
	}
	protected void do_noArgConstructorButton_actionPerformed(ActionEvent arg0) {
		//Call appropriate constructor
		Employee emp = new Employee();
		//System.out.println(emp);
		//Add employee to employeeListModel
		employeeListModel.addElement(emp);
	}
	protected void do_twoArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get empID from empIDTextField, convert to int
		int id = Integer.parseInt(empIDTextField.getText());
		//Call appropriate constructor
		Employee emp = new Employee(id, empNameTextField.getText());
		//System.out.println(emp);
		//Add employee to employeeListModel
		employeeListModel.addElement(emp);
	}
	protected void do_fourArgConstructorButton_actionPerformed(ActionEvent e) {
		//Get empID from empIDTextField, convert to int
		int id = Integer.parseInt(empIDTextField.getText());
		//Get selected string from deptComboBox:
		String dept = (String) deptComboBox.getSelectedItem();
		String position = positionTextField.getText();
		//Call appropriate constructor
		Employee emp = new Employee(id, empNameTextField.getText(), dept, position);
		
		//Add employee to employeeListModel
		employeeListModel.addElement(emp);
		
	}
}
