import java.util.Stack;

public class BalanceString {
    public static void main(String[] args) {
        String str = "[[]][][]";  // Ejemplo de cadena balanceada
        System.out.println(isBalanced(str));  // Debería imprimir true
    }

    // Función que verifica si la cadena de símbolos está balanceada
    public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();

        // Recorre cada carácter de la cadena
        for (char ch : str.toCharArray()) {
            // Si el carácter es un símbolo de apertura, lo apilamos
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Si el carácter es un símbolo de cierre, verificamos
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Si la pila está vacía, significa que hay un símbolo de cierre sin apertura
                if (stack.isEmpty()) {
                    return false;
                }
                // Desapilamos y verificamos si el símbolo de apertura coincide con el de cierre
                char top = stack.pop();
                if (!matches(top, ch)) {
                    return false;
                }
            }
        }

        // Si al final de la cadena la pila está vacía, está balanceada
        return stack.isEmpty();
    }

    // Función que verifica si el símbolo de apertura coincide con el de cierre
    public static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}

