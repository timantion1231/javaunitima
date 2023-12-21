import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
    public static void mainFrame() {
        JFrame frame = new JFrame("DB connection");
        JButton btnAdd = new JButton("Add");
        JButton btnFind = new JButton("Find");
        JButton btnDelete = new JButton("Delete");
        JButton btnUpdate = new JButton("Update");
        JButton btnExit = new JButton("Exit");

        btnAdd.setBounds(10, 20, 100, 40);
        btnFind.setBounds(130, 20, 100, 40);
        btnDelete.setBounds(10, 70, 100, 40);
        btnExit.setBounds(130, 70, 100, 40);
        btnUpdate.setBounds(10, 120, 100, 40);

        frame.add(btnAdd);
        frame.add(btnFind);
        frame.add(btnDelete);
        frame.add(btnUpdate);
        frame.add(btnExit);

        frame.setSize(260, 240);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.addFrame();
                frame.dispose();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.deleteFrame();
                frame.dispose();
            }
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.findFrame();
                frame.dispose();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.updateFrame();
                frame.dispose();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }

    public static void addFrame() {
        JFrame frame = new JFrame("Add new user");
        JLabel labelName = new JLabel("Name");
        JLabel labelLast = new JLabel("Last name");
        JLabel labelUser = new JLabel("Username");
        JLabel labelExp = new JLabel("Experience");
        JLabel labelPos = new JLabel("Position");
        JLabel labelSal = new JLabel("Salary");

        JTextField tfName = new JTextField();
        JTextField tfLast = new JTextField();
        JTextField tfUser = new JTextField();
        JTextField tfExp = new JTextField();
        JTextField tfPos = new JTextField();
        JTextField tfSal = new JTextField();

        JButton btnCancel = new JButton("Cancel");
        JButton btnAdd = new JButton("Add");

        labelName.setBounds(10, 20, 160, 20);
        labelLast.setBounds(190, 20, 160, 20);
        labelUser.setBounds(370, 20, 160, 20);

        tfName.setBounds(10, 45, 160, 20);
        tfLast.setBounds(190, 45, 160, 20);
        tfUser.setBounds(370, 45, 160, 20);

        labelExp.setBounds(10, 75, 160, 20);
        labelPos.setBounds(190, 75, 160, 20);
        labelSal.setBounds(370, 75, 160, 20);

        tfExp.setBounds(10, 100, 160, 20);
        tfPos.setBounds(190, 100, 160, 20);
        tfSal.setBounds(370, 100, 160, 20);

        btnCancel.setBounds(10, 125, 100, 50);
        btnAdd.setBounds(430, 125, 100, 50);

        frame.add(labelName);
        frame.add(labelLast);
        frame.add(labelUser);
        frame.add(labelExp);
        frame.add(labelPos);
        frame.add(labelSal);
        frame.add(tfName);
        frame.add(tfLast);
        frame.add(tfUser);
        frame.add(tfExp);
        frame.add(tfPos);
        frame.add(tfSal);
        frame.add(btnAdd);
        frame.add(btnCancel);


        frame.setSize(600, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.mainFrame();
                frame.dispose();
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbConnector con = new DbConnector();
                String name, lastname, username,
                        position;
                int id, salary;
                float experience;

                name = tfName.getText();
                lastname = tfLast.getText();
                username = tfUser.getText();
                experience = Float.parseFloat(tfExp.getText());
                position = tfPos.getText();
                salary = Integer.parseInt(tfSal.getText());
                con.createConnection();
                con.addUser(name, lastname, username, experience, position, salary);
            }
        });


    }

    public static void deleteFrame() {
        JFrame frame = new JFrame("Delete user");
        JLabel labelId = new JLabel("Id");

        JButton btnCancel = new JButton("Cancel");
        JButton btnDel = new JButton("Delete");

        JTextField tfId = new JTextField();

        labelId.setBounds(10, 20, 50, 20);

        btnCancel.setBounds(10, 75, 100, 50);
        btnDel.setBounds(130, 75, 100, 50);

        tfId.setBounds(10, 45, 130, 20);

        frame.add(labelId);
        frame.add(tfId);
        frame.add(btnDel);
        frame.add(btnCancel);

        frame.setSize(260, 230);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.mainFrame();
                frame.dispose();
            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DbConnector con = new DbConnector();
                con.createConnection();
                con.deleteUser(Integer.parseInt(tfId.getText()));
            }
        });
    }

    public static void updateFrame() {
        JFrame frame = new JFrame("Add new user");
        JLabel labelName = new JLabel("Name");
        JLabel labelLast = new JLabel("Last name");
        JLabel labelUser = new JLabel("Username");
        JLabel labelExp = new JLabel("Experience");
        JLabel labelPos = new JLabel("Position");
        JLabel labelSal = new JLabel("Salary");
        JLabel labelId = new JLabel("Id");

        JTextField tfName = new JTextField();
        JTextField tfLast = new JTextField();
        JTextField tfUser = new JTextField();
        JTextField tfExp = new JTextField();
        JTextField tfPos = new JTextField();
        JTextField tfSal = new JTextField();
        JTextField tfId = new JTextField();

        JButton btnCancel = new JButton("Cancel");
        JButton btnFind = new JButton("Add");
        JButton btnUpdate = new JButton("Update");

        labelName.setBounds(10, 20, 160, 20);
        labelLast.setBounds(190, 20, 160, 20);
        labelUser.setBounds(370, 20, 160, 20);

        tfName.setBounds(10, 45, 160, 20);
        tfLast.setBounds(190, 45, 160, 20);
        tfUser.setBounds(370, 45, 160, 20);

        labelExp.setBounds(10, 75, 160, 20);
        labelPos.setBounds(190, 75, 160, 20);
        labelSal.setBounds(370, 75, 160, 20);

        tfExp.setBounds(10, 100, 160, 20);
        tfPos.setBounds(190, 100, 160, 20);
        tfSal.setBounds(370, 100, 160, 20);

        labelId.setBounds(10, 125, 160, 20);
        tfId.setBounds(10, 150, 160, 20);

        btnCancel.setBounds(10, 175, 100, 50);
        btnFind.setBounds(430, 175, 100, 50);
        btnUpdate.setBounds(310, 175, 100, 50);

        frame.add(labelName);
        frame.add(labelLast);
        frame.add(labelUser);
        frame.add(labelExp);
        frame.add(labelPos);
        frame.add(labelSal);
        frame.add(labelId);
        frame.add(tfName);
        frame.add(tfLast);
        frame.add(tfUser);
        frame.add(tfExp);
        frame.add(tfPos);
        frame.add(tfSal);
        frame.add(tfId);
        frame.add(btnFind);
        frame.add(btnCancel);
        frame.add(btnUpdate);

        frame.setSize(650, 280);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.mainFrame();
                frame.dispose();
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name, lastname, username,
                        position;
                int id, salary;
                float experience;

                name = tfName.getText();
                lastname = tfLast.getText();
                username = tfUser.getText();
                experience = Float.parseFloat(tfExp.getText());
                position = tfPos.getText();
                salary = Integer.parseInt(tfSal.getText());
                id = Integer.parseInt(tfId.getText());
                boolean b;

                DbConnector con = new DbConnector();
                con.createConnection();
                b = con.updateUser(id, name, lastname, username,
                        experience, position, salary);

            }
        });
    }

    public static void findFrame() {
        JFrame frame = new JFrame("Add new user");
        JLabel labelName = new JLabel("Name");
        JLabel labelLast = new JLabel("Last name");
        JLabel labelUser = new JLabel("Username");
        JLabel labelExp = new JLabel("Experience");
        JLabel labelPos = new JLabel("Position");
        JLabel labelSal = new JLabel("Salary");
        JLabel labelId = new JLabel("Id");

        JTextField tfName = new JTextField();
        JTextField tfLast = new JTextField();
        JTextField tfUser = new JTextField();
        JTextField tfExp = new JTextField();
        JTextField tfPos = new JTextField();
        JTextField tfSal = new JTextField();
        JTextField tfId = new JTextField();
        JTextArea ta = new JTextArea();

        JButton btnCancel = new JButton("Cancel");
        JButton btnFind = new JButton("Find");

        labelName.setBounds(10, 20, 160, 20);
        labelLast.setBounds(190, 20, 160, 20);
        labelUser.setBounds(370, 20, 160, 20);

        tfName.setBounds(10, 45, 160, 20);
        tfLast.setBounds(190, 45, 160, 20);
        tfUser.setBounds(370, 45, 160, 20);

        labelExp.setBounds(10, 75, 160, 20);
        labelPos.setBounds(190, 75, 160, 20);
        labelSal.setBounds(370, 75, 160, 20);

        tfExp.setBounds(10, 100, 160, 20);
        tfPos.setBounds(190, 100, 160, 20);
        tfSal.setBounds(370, 100, 160, 20);

        labelId.setBounds(10, 125, 160, 20);
        tfId.setBounds(10, 150, 160, 20);
        ta.setBounds(190, 150, 350, 140);

        btnCancel.setBounds(10, 175, 100, 50);
        btnFind.setBounds(10, 235, 100, 50);

        frame.add(labelName);
        frame.add(labelLast);
        frame.add(labelUser);
        frame.add(labelExp);
        frame.add(labelPos);
        frame.add(labelSal);
        frame.add(labelId);
        frame.add(tfName);
        frame.add(tfLast);
        frame.add(tfUser);
        frame.add(tfExp);
        frame.add(tfPos);
        frame.add(tfSal);
        frame.add(tfId);
        frame.add(btnFind);
        frame.add(btnCancel);
        frame.add(ta);

        frame.setSize(650, 340);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UI.mainFrame();
                frame.dispose();
            }
        });

        btnFind.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id, name, lastname, username, experience, position,
                        salary;

                id = tfId.getText();
                name = tfName.getText();
                lastname = tfLast.getText();
                username = tfUser.getText();
                experience = tfExp.getText();
                position = tfPos.getText();
                salary = tfSal.getText();

                DbConnector con = new DbConnector();
                ta.setText(con.findUsers(name, lastname, username, experience, position,
                        salary, id));
            }
        });
    }
}
