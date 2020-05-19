import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class TableWidget {
	
	private  String it;
	private  String it2;
	private  int index;
	private Button reverse;
	private Button rreverse;
	private Button inputInTable;
	private Text nameField;
	private Table table;

	public Button getReverse() {
		return reverse;
	}

	public Button getRreverse() {
		return rreverse;
	}

	public Button getInputInTable() {
		return inputInTable;
	}

	public Text getNameField() {
		return nameField;
	}

	public Table getTable() {
		return table;
	}



	public void getTableTask(Shell shell) {
		
		 nameField = new Text(shell, SWT.CENTER);
		nameField.setBounds(450, 60, 200, 30);
		 inputInTable= new Button(shell, SWT.PUSH);
		 reverse = new Button(shell, SWT.PUSH);
		 rreverse= new Button(shell, SWT.PUSH);
		inputInTable.setText("Button1");
		inputInTable.setBounds(450, 110, 80, 40);
		reverse.setText("Button2");
		reverse.setBounds(450, 150, 80, 40);
		rreverse.setText("Button3");
		rreverse.setBounds(450, 190, 80, 40);
		 table = new Table(shell, SWT.MULTI | SWT.BORDER | SWT.FULL_SELECTION);
	    //table.setLinesVisible(true);
		table.setHeaderVisible(true);
		String[] names = {"1", "2"};
		for (int i = 0; i < names.length; i++) {
		      TableColumn column = new TableColumn(table, SWT.NONE);
		      column.setText(names[i]);
		      
		}
		
		 for(int i = 0; i < 4; ++i)
		 {
			 TableItem item = new TableItem(table, SWT.NONE);
			 table.getItem(i).setText(0, "");
			 table.getItem(i).setText(1, "");
		 }
		 		 for (int i = 0; i < names.length; i++) {
		      table.getColumn(i).pack();
		    }
		
		table.setBounds(550, 110, 100, 140);

		inputInTable.addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	String line = nameField.getText();
            	table.getItem(0).setText(0, line);
            	
            }
        });
		reverse.addSelectionListener(new SelectionAdapter() {
	    	
            @Override
            public void widgetSelected(SelectionEvent e) {
            	if(it.equals(""))
            		return;
            	for(int i = 0; i < table.getItemCount(); ++i)
            	{
            		table.getItem(i).setText("");
            	}
            	
            	table.getItem(index).setText(1, it);
            }
        });
		 table.addListener(SWT.MouseDown, new Listener() {
		      public void handleEvent(Event event) {
		    	  Point pt = new Point(event.x, event.y);
		          TableItem item = table.getItem(pt);
		          if (item == null)
		            return;
		          for (int i = 0; i < table.getItemCount(); i++) {
		            Rectangle rect = item.getBounds(i);
		            if (rect.contains(pt)) {
		              index = table.indexOf(item);
		              it = table.getItem(index).toString();
		              it2 = table.getItem(index).getText(1);
		              it = it.substring(11,it.length() - 1);
		              
		          }
		        }
		          
		      }
		    });
		 rreverse.addSelectionListener(new SelectionAdapter() {
		    	
	            @Override
	            public void widgetSelected(SelectionEvent e) {
	            	if(it2.equals(""))
	            		return;
	            	for(int i = 0; i < table.getItemCount(); ++i)
	            	{
	            		table.getItem(i).setText(1, "");
	            	}
	            	table.getItem(index).setText(it2);
	            }
	            
	        });
	}
		 }

	
