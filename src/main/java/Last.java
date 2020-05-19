

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;
import java.util.List;


public class Last {

    public static boolean TO_OPEN = false;
    public static boolean TO_CONTINUE = false;

    public static boolean OPENED = false;
    public static boolean TO_STOP = false;
    public static boolean WAIT_A_SECOND = false;

    public static Long START_TIME = 0L;
    public static int idx =0;

    public static void shellSwap(ArrayList<Control> taskElements) throws InterruptedException {
        int[] xCoordinate = {50,50,50,300,300,300,550,550,550,550,800,800,800,800,800,950,950,950,950,950};
        int[] yCoordinate = {50,250,450,50,250,450,50,250,450,650,50,250,450,650,750,50,250,450,650,750};


        for (Control temp : taskElements) {
           temp.setLocation(xCoordinate[idx],yCoordinate[idx]);
            idx++;
            if (idx == 20) idx = 0;
        }
    }



    public static boolean oneSecondPassCheck() {
        if (START_TIME == 0) {
            START_TIME = System.currentTimeMillis();
        }
        Long endTime = System.currentTimeMillis();

        if (endTime - START_TIME < 100) {
            return false;
        } else {
            START_TIME = 0L;
            return true;
        }

    }


    public static void main(String[] args) throws InterruptedException {

        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Main");
        shell.setSize(550, 550);
        shell.open();

        ArrayList<Control> taskElements = new ArrayList<>();

        ComboBox comboBox = new ComboBox();
        comboBox.getComboBoxTask(shell);
        SwapNames swap = new SwapNames();
        swap.getSwapNamesTask(shell);
        RadioButton radioButton = new RadioButton();
        radioButton.getRadioButtonTask(shell);
        CheckButton checkButton = new CheckButton();
        checkButton.getCheckButtonTask(shell);
        TableWidget tableWidget = new TableWidget();
        tableWidget.getTableTask(shell);

        taskElements.add(comboBox.getNameField());
        taskElements.add(comboBox.getCombo());
        taskElements.add(comboBox.getAddInComboBox());

        taskElements.add(swap.getReplaceForFirstButton());
        taskElements.add(swap.getReplaceForSecondButton());
        taskElements.add(swap.getNameField());

        taskElements.add(radioButton.getAddMark());
        taskElements.add(radioButton.getFirstRadioButton());
        taskElements.add(radioButton.getSecondRadioButton());
        taskElements.add(radioButton.getThirdRadioButton());

        taskElements.add(checkButton.getButtonForAddMark());
        taskElements.add(checkButton.getNameField());
        taskElements.add(checkButton.getFirstCheckButton());
        taskElements.add(checkButton.getSecondCheckButton());
        taskElements.add(checkButton.getThirdCheckButton());

        taskElements.add(tableWidget.getNameField());
        taskElements.add(tableWidget.getInputInTable());
        taskElements.add(tableWidget.getReverse());
        taskElements.add(tableWidget.getRreverse());
        taskElements.add(tableWidget.getTable());

//20

        display.addFilter(SWT.KeyDown, new Listener() {
            @Override
            public void handleEvent(final Event ke) {
                List<String> list = new ArrayList<>();

                if ((ke.stateMask & SWT.CTRL) != 0) {
                    list.add("CTRL");
                }

                list.add(Character.toString((char) ke.keyCode));


                if ((list.size() == 2) & !OPENED) {
                    if ((list.get(0).equals("CTRL"))
                            & (list.get(1).equals("r"))) {
                        System.out.println("Check1");

                        if (TO_STOP) {
                            TO_CONTINUE = true;
                        } else {
                            TO_OPEN = true;
                        }
                    }

                    if ((list.get(0).equals("CTRL"))
                            & (list.get(1).equals("s"))) {
                        System.out.println("Stop!");
                        TO_STOP = true;
                    }

                    System.out.println(list);
                    System.out.println(list.get(0));
                }
            }
    
        });


        while (!shell.isDisposed()) {

            if (TO_CONTINUE & TO_STOP & display.readAndDispatch()) {
                System.out.println("Check2");
                TO_STOP = false;
            }

            if (TO_STOP) {

                display.sleep();

            } else {

                if (WAIT_A_SECOND) {
                    WAIT_A_SECOND = !oneSecondPassCheck();
                }


                if (!WAIT_A_SECOND) {
                    shellSwap(taskElements);
                    WAIT_A_SECOND = true;
                    idx++;
                    if (idx == 20) idx = 0;

                }
            }
        }
        display.dispose();
    }
}