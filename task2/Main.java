import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;


public class Main {
    public static void main(String[] args) throws UnexpectedCharacterException {
        try {
            Stack<Integer> stack = new Stack<>();
            LinkedList<Token> tokens = new LinkedList<>();
            File text = new File("Calc1.stk");
            Scanner scanner = new Scanner(text);
            while(scanner.hasNext()) {
                String inp = scanner.next();
                if(inp.matches("-?\\d+")) {
                    tokens.add(new Token(TokenType.NUM, inp));
                }else {
                    char aux = inp.charAt(0);
                    TokenType aux2;
                    if(aux == '-'){
                      aux2 =  TokenType.MINUS;
                    }else if(aux == '+'){
                      aux2 = TokenType.PLUS;
                    }else if(aux == '*'){
                      aux2 = TokenType.SLASH;
                    }else if(aux == '/'){
                      aux2 = TokenType.STAR;
                    }else{
                      throw new UnexpectedCharacterException("Error: Unexpected character: "+ String.valueOf(aux));
                    }
                    tokens.add(new Token(aux2, inp));
                }
            }
            tokens.forEach((temp) -> {
                System.out.println(temp.toString());
                if(temp.type == TokenType.NUM) {
                    stack.push(Integer.parseInt(temp.lexeme));
                }else{
                    Integer y = stack.pop();
                    Integer x = stack.pop();
                    char aux = (temp.lexeme.charAt(0));
                    Integer aux2; 
                    if(aux == '-'){
                      aux2 =  x - y;
                    }else if(aux == '+'){
                      aux2 = x + y;
                    }else if(aux == '/'){
                      aux2 = x / y;
                    }else{
                      aux2 = x * y;
                    }
                    stack.push(aux2);
                }
            });
            System.out.println("\nSaida: " + stack.peek());
            scanner.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not readble.");
        }
    }
}
