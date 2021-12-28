import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {

	public static void main(String[] args) {
		try {
            Stack<Integer> stack = new Stack<>();
			File text = new File("Calc1.stk");
			Scanner scanner = new Scanner(text);

			while(scanner.hasNext()) {
				String inp = scanner.next();

				if(inp.matches("-?\\d+")) {
					stack.push(Integer.parseInt(inp));
				}else {
					Integer y = stack.pop();
					Integer x = stack.pop();
					stack.push(op(x,y,inp.charAt(0)));
				}
			}

			System.out.println("Saída: " + stack.peek());
			scanner.close();

		}catch (FileNotFoundException e) {
		      System.out.println("File not readble.");
	    }
		
	}

	public static Integer op(Integer a, Integer b, char symbol) {
		if(symbol == '-'){
			return a - b;
		}else if(symbol == '+'){
			return a + b;
		}
		else if(symbol == '/'){
			return a / b;
		}
		return a * b;
	}

}