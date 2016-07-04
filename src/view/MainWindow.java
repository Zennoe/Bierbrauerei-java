package view;

import org.eclipse.swt.*;
import org.eclipse.swt.custom.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

import model.*;

public class MainWindow {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	
	private static RoundManager roundmanager;
	
	// constructor
	public MainWindow(RoundManager roundmanager) {
		this.roundmanager = roundmanager;
	}
	
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow(roundmanager);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setMinimumSize(new Point(600, 400));
		shell.setSize(509, 401);
		shell.setText("SWT Application");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite GameView = new Composite(shell, SWT.NONE);
		GameView.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm = new SashForm(GameView, SWT.VERTICAL);
		
		Composite Head = new Composite(sashForm, SWT.NONE);;
		
		Button buttonNextRound = new Button(Head, SWT.CENTER);
		buttonNextRound.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		buttonNextRound.setText("Zum n\u00E4chster Tag");
		
		Composite Top = new Composite(sashForm, SWT.NONE);
		Top.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group TopLeft = new Group(Top, SWT.NONE);
		TopLeft.setText("Markt");
		TopLeft.setLayout(new FillLayout(SWT.VERTICAL));
		
		SashForm sashForm_2 = new SashForm(TopLeft, SWT.VERTICAL);
		
		Label beerPrice = new Label(sashForm_2, SWT.NONE);
		beerPrice.setText("Bierpreis");
		
		SashForm price = new SashForm(sashForm_2, SWT.NONE);
		
		Scale price_scale = new Scale(price, SWT.NONE);
		
		Spinner price_spinner = new Spinner(price, SWT.BORDER);
		price.setWeights(new int[] {4, 1});
		
		Label beerAmount = new Label(sashForm_2, SWT.NONE);
		beerAmount.setText("Biermenge");
		
		SashForm amount = new SashForm(sashForm_2, SWT.NONE);
		
		Scale amount_scale = new Scale(amount, SWT.NONE);
		
		Spinner amount_spinner = new Spinner(amount, SWT.BORDER);
		amount.setWeights(new int[] {4, 1});
		sashForm_2.setWeights(new int[] {1, 2, 1, 2});
		
		Group TopRight = new Group(Top, SWT.NONE);
		TopRight.setText("B\u00FCro");
		
		Label konto = new Label(TopRight, SWT.NONE);
		konto.setText("Konto: xyz");
		
		Label kosten = new Label(TopRight, SWT.NONE);
		kosten.setText("Kosten: xyz");
		
		Group grpAuftrage = new Group(TopRight, SWT.NONE);
		grpAuftrage.setText("Auftr\u00E4ge");
		grpAuftrage.setLayout(new FillLayout(SWT.VERTICAL));
		
		Label pendingEvents = new Label(grpAuftrage, SWT.NONE);
		pendingEvents.setText("New Label");
		
		Composite Bottom = new Composite(sashForm, SWT.NONE);
		Bottom.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Group BottomLeft = new Group(Bottom, SWT.NONE);
		BottomLeft.setText("Brauerei");
		
		Label capacity = new Label(BottomLeft, SWT.NONE);
		capacity.setBounds(10, 25, 55, 15);
		capacity.setText("Kapazit\u00E4t");
		
		Label storage = new Label(BottomLeft, SWT.NONE);
		storage.setBounds(10, 46, 55, 15);
		storage.setText("Lager");
		
		Group BottomRight = new Group(Bottom, SWT.NONE);
		BottomRight.setText("Upgrade");
		BottomRight.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Button LagerButton = new Button(BottomRight, SWT.NONE);
		LagerButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		LagerButton.setText("Lager");
		
		Button btnNewButton_1 = new Button(BottomRight, SWT.NONE);
		btnNewButton_1.setText("Produkte");
		sashForm.setWeights(new int[] {2, 5, 5});
	}
}
