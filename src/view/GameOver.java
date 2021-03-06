package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class GameOver extends Dialog {

	protected Object result;
	protected Shell shlGameover;
	private int rounds;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 * @param style 
	 */
	public GameOver(Shell parent, int rounds, int style) {
		super(parent, style);
		setText("Game Over");
		this.rounds = rounds;
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlGameover.open();
		shlGameover.layout();
		Display display = getParent().getDisplay();
		while (!shlGameover.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlGameover = new Shell(getParent(), SWT.BORDER | SWT.TITLE | SWT.SYSTEM_MODAL);
		shlGameover.setMinimumSize(new Point(344, 184));
		shlGameover.setSize(296, 161);
		shlGameover.setText("GameOver!");
		shlGameover.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_2 = new SashForm(shlGameover, SWT.VERTICAL);
		
		SashForm sashForm = new SashForm(sashForm_2, SWT.VERTICAL);
		
		Composite composite = new Composite(sashForm, SWT.NONE);
		
		Label endText = new Label(sashForm, SWT.NONE);
		endText.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		endText.setFont(SWTResourceManager.getFont("Rockwell", 23, SWT.NORMAL));
		endText.setAlignment(SWT.CENTER);
		endText.setText("Du bist pleite !!!");
		
		Label lblNewLabel = new Label(sashForm, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setText("Nach " + rounds +" Runden");
		sashForm.setWeights(new int[] {1, 3, 2});
		
		SashForm sashForm_1 = new SashForm(sashForm_2, SWT.NONE);
		
		Composite composite_1 = new Composite(sashForm_1, SWT.NONE);
		
		Button finishGame = new Button(sashForm_1, SWT.NONE);
		finishGame.setText("Spiel beenden");
		finishGame.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					System.exit(0);
					break;
				}
			}
		});
		
		Composite composite_2 = new Composite(sashForm_1, SWT.NONE);
		sashForm_1.setWeights(new int[] {1, 1, 1});
		sashForm_2.setWeights(new int[] {5, 3});

	}
}
