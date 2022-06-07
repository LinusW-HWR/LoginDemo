import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class LoginPanel extends JPanel {

    private final JTextField emailTextField;
    private final JTextField passwdTextField;
    private final JLabel feedbackLabel;

    public LoginPanel(){
        setLayout(null);
        setPreferredSize(new Dimension(575,660));
        setBounds(0,80,575,660);
        setBackground(Color.DARK_GRAY);
        addKeyListener(new KeyListener());


        JLabel header = new JLabel("Einloggen");
        header.setBounds(0,30,575,50);
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setForeground(Color.WHITE);
        add(header);

        JLabel email = new JLabel("E-Mail");
        email.setBounds(90,155,100,30);
        email.setHorizontalAlignment(SwingConstants.RIGHT);
        email.setForeground(Color.WHITE);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(197,155,170,30);
        add(emailTextField);

        JLabel passwd = new JLabel("Password");
        passwd.setBounds(90,195,100,30);
        passwd.setHorizontalAlignment(SwingConstants.RIGHT);
        passwd.setForeground(Color.WHITE);
        add(passwd);

        passwdTextField = new JTextField();
        passwdTextField.setBounds(197,195,170,30);
        passwdTextField.addKeyListener(new KeyListener());
        add(passwdTextField);

        JButton loginButton = new JButton("einloggen!");
        loginButton.addActionListener(new ButtonListener());
        loginButton.setBounds(197,300,170,30);
        add(loginButton);


        feedbackLabel = new JLabel("");
        feedbackLabel.setBounds(197,340,300,30);
        feedbackLabel.setForeground(Color.WHITE);
        add(feedbackLabel);
    }

    private class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            UserList userList = new UserList();
            String user = emailTextField.getText();
            String passwd = passwdTextField.getText();

            if(userList.hasUser(user)){
                if(userList.checkUserPasswd(user,passwd)){
                    feedbackLabel.setText("Erfolgreich eingeloggt");
                }
                else {
                    feedbackLabel.setText("Falsches Passwort");
                }
            }
            else{
                feedbackLabel.setText("Nicht registriert");
            }
        }
    }

    private class KeyListener implements java.awt.event.KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==10){
                UserList userList = new UserList();
                String user = emailTextField.getText();
                String passwd = passwdTextField.getText();

                if(userList.hasUser(user)){
                    if(userList.checkUserPasswd(user,passwd)){
                        feedbackLabel.setText("Erfolgreich eingeloggt");
                    }
                    else {
                        feedbackLabel.setText("Falsches Passwort");
                    }
                }
                else{
                    feedbackLabel.setText("Nicht registriert");
                }
            }
            System.out.println(e.getKeyCode());
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
}