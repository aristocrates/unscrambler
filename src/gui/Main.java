package gui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

import javax.swing.JFileChooser;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import core.Anagram;
import core.Wordlist;

public class Main {

	protected Shell shlWordUnscrambler;
	private Text text;
	private Wordlist wordlist;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Main()
	{
		wordlist = new Wordlist();
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlWordUnscrambler.open();
		shlWordUnscrambler.layout();
		while (!shlWordUnscrambler.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlWordUnscrambler = new Shell();
		shlWordUnscrambler.setSize(309, 244);
		shlWordUnscrambler.setText("Word Unscrambler");
		
		text = new Text(shlWordUnscrambler, SWT.BORDER);
		text.setBounds(85, 37, 145, 27);
		
		StyledText styledText = new StyledText(shlWordUnscrambler, SWT.BORDER | SWT.V_SCROLL);
		styledText.setLocation(15, 80);
		styledText.setSize(282, 103);
		styledText.setEditable(false);
		
		Button btnGo = new Button(shlWordUnscrambler, SWT.NONE);
		btnGo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				styledText.setText("");
				String s = text.getText();
				List<Anagram> anagrams = wordlist.getWords(s);
				if (anagrams != null) {
					String message = "";
					for (Anagram a : anagrams) {
						message += a.getWord() + "\n";
					}
					styledText.setText(message);
				}
			}
		});
		btnGo.setEnabled(false);
		btnGo.setBounds(236, 35, 63, 29);
		btnGo.setText("Go");
		
		CLabel lblWord = new CLabel(shlWordUnscrambler, SWT.NONE);
		lblWord.setBounds(15, 39, 63, 23);
		lblWord.setText("Word:");
		
		Label label = new Label(shlWordUnscrambler, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 68, 289, 2);
		
		Menu menu = new Menu(shlWordUnscrambler, SWT.BAR);
		shlWordUnscrambler.setMenuBar(menu);
		
		MenuItem mntmFile = new MenuItem(menu, SWT.CASCADE);
		mntmFile.setText("File");
		
		Menu menu_1 = new Menu(mntmFile);
		mntmFile.setMenu(menu_1);
		
		MenuItem mntmConfigure = new MenuItem(menu_1, SWT.NONE);
		mntmConfigure.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Config c = new Config(shlWordUnscrambler, SWT.OK);
				c.open();
			}
		});
		mntmConfigure.setText("Configure");
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlWordUnscrambler.dispose();
			}
		});
		mntmExit.setText("Exit");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmLicense = new MenuItem(menu_2, SWT.NONE);
		mntmLicense.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new License(shlWordUnscrambler, SWT.OK).open();
			}
		});
		mntmLicense.setText("License");
		
		MenuItem mntmAbout = new MenuItem(menu_2, SWT.NONE);
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				new About(shlWordUnscrambler, SWT.OK).open();
			}
		});
		mntmAbout.setText("About");
		
		Button btnSelectWordList = new Button(shlWordUnscrambler, SWT.NONE);
		btnSelectWordList.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				readFile();
				btnGo.setEnabled(true);
			}
		});
		btnSelectWordList.setBounds(15, 2, 124, 29);
		btnSelectWordList.setText("Select Word List");

	}
	
	public void readFile()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				wordlist.addList(new File(chooser.getSelectedFile().getPath()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void save()
	{
		
	}
	
	public void load()
	{
		
	}
}
