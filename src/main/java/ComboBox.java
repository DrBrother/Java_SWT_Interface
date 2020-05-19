import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

public class ComboBox {

	private  Text nameField;
	private  Combo combo;
	private  Button addInComboBox;

	public Text getNameField() {
		return nameField;
	}

	public Combo getCombo() {
		return combo;
	}

	public Button getAddInComboBox() {
		return addInComboBox;
	}

	void getComboBoxTask(Shell shell)
	{


			combo = new Combo(shell, SWT.DROP_DOWN);
			addInComboBox = new Button(shell, SWT.PUSH);
		    addInComboBox.setText("Click");
		    addInComboBox.setBounds(50, 120, 70, 40);
		    MessageBox box = new MessageBox(shell, SWT.ICON_ERROR);

		    
		    combo.setBounds(50, 90, 70, 20);
		     nameField = new Text(shell, SWT.CENTER);
		    nameField.setBounds(50, 70, 70, 20);
		    addInComboBox.addSelectionListener(new SelectionAdapter() {
		    	
	            @Override
	            public void widgetSelected(SelectionEvent e) {
	            	String temp = nameField.getText();
	            	String[] array = combo.getItems();
	            		for(String a: array) {
	            			if(a.equals(temp)) {
	            				box.setMessage("Нельзя добавить данный текст");
	            				box.open();
	            				return;
	            			}
	            		}
	            	
	                combo.add(temp);
	            }
	        });
	}
}
