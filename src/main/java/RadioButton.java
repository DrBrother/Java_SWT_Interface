import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;

public class RadioButton {
	private Button firstRadioButton;
	private Button secondRadioButton;
	private Button thirdRadioButton;
	private Button addMark;

	public Button getFirstRadioButton() {
		return firstRadioButton;
	}

	public Button getSecondRadioButton() {
		return secondRadioButton;
	}

	public Button getThirdRadioButton() {
		return thirdRadioButton;
	}

	public Button getAddMark() {
		return addMark;
	}


	void getRadioButtonTask(Shell shell)
	{
		addMark = new Button(shell, SWT.PUSH);
	    Text text3 = new Text(shell, SWT.CENTER);
	    firstRadioButton = new Button(shell, SWT.RADIO);
	    secondRadioButton = new Button(shell, SWT.RADIO);
	    thirdRadioButton = new Button(shell, SWT.RADIO);
	    firstRadioButton.setBounds(250, 100, 100, 20);
	    secondRadioButton.setBounds(250, 130, 100, 20);
	    thirdRadioButton .setBounds(250, 160, 100, 20);
	    addMark .setBounds(250, 50, 70, 40);
	    addMark .setText("JButton");
	    firstRadioButton.setText("1");
	    secondRadioButton.setText("2");
	    thirdRadioButton .setText("3");
	    text3.setBounds(250, 70, 70, 20);
	    addMark .addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	firstRadioButton.setSelection(false);
            	secondRadioButton.setSelection(false);
            	thirdRadioButton .setSelection(false);
            	MessageBox box = new MessageBox(shell, SWT.ICON_ERROR);
            	boolean flag = false;
            	int value = 0;
            	ArrayList<String> list = new ArrayList<>();
            	String temp = text3.getText();
            	list.add(firstRadioButton.getText());
            	list.add(secondRadioButton.getText());
            	list.add(thirdRadioButton .getText());
            	for(int i = 0; i < list.size(); ++i) {
            		if(list.get(i).equals(temp)){
            			flag = true;     
            			value = i + 1;
            		}
            	}
            	if(flag == false) {
            		box.setMessage("Ошибка");
    				box.open();
    				return;
            	}
            	if(value == 1) {
            		firstRadioButton.setSelection(flag);
            	}
            	else if(value == 2) {
            		secondRadioButton.setSelection(flag);
            	}
            	else if(value == 3) {
            		thirdRadioButton .setSelection(flag);
            	}
            		
            }
        });
	    
	}
}
