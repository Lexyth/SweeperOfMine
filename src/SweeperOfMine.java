import javax.swing.JFrame;

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
		
		frame.add(view);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
