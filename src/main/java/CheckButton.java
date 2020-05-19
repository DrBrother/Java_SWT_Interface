import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;

public class CheckButton {
	private  Text nameField;
	private  Button firstCheckButton;
	private  Button secondCheckButton;
	private  Button thirdCheckButton;
	private  Button buttonForAddMark;

	public Text getNameField() {
		return nameField;
	}

	public Button getFirstCheckButton() {
		return firstCheckButton;
	}

	public Button getSecondCheckButton() {
		return secondCheckButton;
	}

	public Button getThirdCheckButton() {
		return thirdCheckButton;
	}

	public Button getButtonForAddMark() {
		return buttonForAddMark;
	}



	void getCheckButtonTask(Shell shell)
	{
		buttonForAddMark = new Button(shell, SWT.PUSH);
		nameField = new Text(shell, SWT.CENTER);
	    buttonForAddMark.setBounds(350, 50, 70, 40);
	    nameField.setBounds(350, 90, 90, 20);
	    buttonForAddMark.setText("Button");
	    firstCheckButton = new Button(shell, SWT.CHECK);
	    secondCheckButton = new Button(shell, SWT.CHECK);
	    thirdCheckButton = new Button(shell, SWT.CHECK);
	    firstCheckButton.setBounds(350, 110, 100, 20);
	    firstCheckButton.setText("1");
	    secondCheckButton.setBounds(350, 130, 100, 20);
	    secondCheckButton.setText("2");
	    thirdCheckButton.setBounds(350, 150, 100, 20);
	    thirdCheckButton.setText("3");
	    buttonForAddMark.addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	MessageBox box = new MessageBox(shell, SWT.ICON_ERROR);
            	ArrayList<String> list = new ArrayList<>();
            	boolean flag = false;
            	String temp = nameField.getText();
            	int value = 0;
            	
            	list.add(firstCheckButton.getText());
            	list.add(secondCheckButton.getText());
            	list.add(secondCheckButton .getText());
            	for(int i = 0; i < list.size(); ++i) {
            		if(list.get(i).equals(temp))
            		{
            			flag = true;
            			value = i + 1;
            		}
            	}
            	if(flag == false)
            	{
            		box.setMessage("Ошибка");
            		box.open();
            		return;
            	}
            	if(value == 1) {
            		if(firstCheckButton.getSelection() == true)
            			firstCheckButton.setSelection(false);
            		else
            			firstCheckButton.setSelection(true);
            	}
            	else if(value == 2) {
            		if(secondCheckButton.getSelection() == true)
            			secondCheckButton.setSelection(false);
                		else
                			secondCheckButton.setSelection(true);
            	}
            	else if(value == 3) {
            		if(secondCheckButton .getSelection() == true)
            			secondCheckButton .setSelection(false);
                		else
                			secondCheckButton .setSelection(true);
            	}
            }
        });
	    	
	}
}
