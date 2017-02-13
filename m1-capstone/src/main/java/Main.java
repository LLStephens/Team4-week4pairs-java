
import java.io.IOException;


import com.techelevator.VendingMachineCLI;
import com.techelevator.view.Menu;

public class Main {

	public static void main(String[] args) throws IOException {

		Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	
	}
}
		
	