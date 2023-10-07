import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ToDoListApp extends JFrame implements ActionListener {
private JTextField taskInput;
private DefaultListModel<String> taskListModel;
private JList<String> taskList;
private JButton addButton, completeButton, deleteButton;
private JPanel inputPanel, buttonPanel;

public ToDoListApp() {
setTitle(title:"To-Do List");
setSize(width:400, height:400);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

taskInput = new JTextField(columns:20);
addButton = new JButton(text:"Add Task");
completeButton = new JButton(text:"Mark as Completed");
deleteButton = new JButton(text:"Delete Task");

addButton.addActionListener(this);
completeButton.addActionListener(this);
deleteButton.addActionListener(this);

taskListModel = new DefaultListModel<>();
taskList = new JList<>(taskListModel);
taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

inputPanel = new JPanel();
inputPanel.add(new JLabel(text:"Task: "));
inputPanel.add(taskInput);
inputPanel.add(addButton);

buttonPanel = new JPanel();
buttonPanel.setLayout(new GridLayout(rows:1, cols:2));
buttonPanel.add(completeButton);
buttonPanel.add(deleteButton);

Container contentPane = getContentPane();
contentPane.setLayout(new BorderLayout());
contentPane.add(inputPanel, BorderLayout.NORTH);
contentPane.add(new JScrollPane(taskList), BorderLayout.CENTER);
contentPane.add(buttonPanel, BorderLayout.SOUTH);

setVisible(b:true);
}

public void actionPerformed(ActionEvent e) {
if (e.getSource() == addButton) {
String task = taskInput.getText().trim();
if (!task.isEmpty()) {
taskListModel.addElement(task);
taskInput.setText(t:"");
}
} else if (e.getSource() == completeButton) {
int selectedIndex = taskList.getSelectedIndex();
if (selectedIndex != -1) {
String task = taskListModel.getElementAt(selectedIndex);
taskListModel.setElementAt("[Completed] " + task, selectedIndex);
}
} else if (e.getSource() == deleteButton) {
int selectedIndex = taskList.getSelectedIndex();
if (selectedIndex != -1) {
taskListModel.remove(selectedIndex);
}
}
}

public static void main(String[] args) {
SwingUtilities.invokeLater(() -> new ToDoListApp());
}
}

// program created by arpitbatra01
