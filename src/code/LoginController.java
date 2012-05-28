package code;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

public class LoginController {

    private Database database;
    private LoginFrame view;

    public LoginController(){
	database = new Database();
	view = new LoginFrame();

	initAllExistingAccount();
	addListener();

	view.setVisible(true);
    }

    private void initAllExistingAccount(){
	for(String name : database.getAllAccountNames()){
	    view.addAccountName(name); 
	}
    }

    private void addListener(){
	view.getLoginButton().addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent e){
		String name = null;
		try{
		    if(view.getUserComboBox().getSelectedIndex() == -1){
			JTextComponent tc = (JTextComponent)view.getUserComboBox().getEditor().getEditorComponent();
			name = tc.getText();
			database.createAccount(name);
		    } else{
			name = (String) view.getUserComboBox().getSelectedItem();
		    }


		    EventQueue.invokeLater(new Runnable() {
			public void run() {
			    try {
				//view.setVisible(false);
				//view.dispose();

				//TODO new MainController
			    }
			    catch (Exception e) {
				e.printStackTrace();
			    }
			}
		    });

		} catch(SQLException sqle){
		    JOptionPane.showMessageDialog(null, "Please use another name.", name + " exists", JOptionPane.ERROR_MESSAGE);
		}


	    }
	});
    }

    public static void main(String args[]){
	LoginController login = new LoginController();
    }
}
