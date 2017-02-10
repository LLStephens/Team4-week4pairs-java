import java.io.FileNotFoundException;

import com.techelevator.Transact;
import com.techelevator.VendingMachineCLI;
import com.techelevator.view.Menu;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
		Transact transact = new Transact();
		transact.writeFile();
	}
}
