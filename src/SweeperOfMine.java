import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class SweeperOfMine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		View view = new View();
		Model model = new Model();
		
		Controller controller = new Controller();
		controller.setViewModel(view, model);
		
		JFrame frame = new JFrame("Sweeper Of Mine");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		//addMenu(frame);
		frame.add(view);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private static void addMenu(JFrame frame) {
		
		JMenu menu = new JMenu("Options");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
	}
}