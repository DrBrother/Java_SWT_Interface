import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;
import java.util.Collections;

public class SwapNames {
	private Button replaceForSecondButton;
	private Button replaceForFirstButton;
	private Text nameField;

	public Button getReplaceForSecondButton() {
		return replaceForSecondButton;
	}

	public Button getReplaceForFirstButton() {
		return replaceForFirstButton;
	}

	public Text getNameField() {
		return nameField;
	}

	void getSwapNamesTask(Shell shell) {
		
	     replaceForSecondButton = new Button(shell, SWT.PUSH);
	     replaceForFirstButton = new Button(shell, SWT.PUSH);
	     nameField = new Text(shell,SWT.CENTER);
	    nameField.setBounds(150, 120, 70, 40);
	    replaceForSecondButton .setText("JButton1");
	    replaceForFirstButton.setText("JButton2");
	    replaceForSecondButton .setBounds(150, 90, 70, 40);
	    replaceForFirstButton.setBounds(150, 50, 70, 40);
	    
	    
	    replaceForSecondButton .addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	String temp = nameField.getText();
            	replaceForFirstButton.setText(temp);
            }
        });
	    replaceForFirstButton.addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	ArrayList<String> list = new ArrayList<>();
            	list.add(replaceForSecondButton .getText());
            	list.add(replaceForFirstButton.getText());
            	Collections.swap(list, 0, 1);
            	replaceForSecondButton .setText(list.get(0));
            	replaceForFirstButton.setText(list.get(1));
            	list.clear();
            	
            }
        });
	   
	}
}
