public class EquationReverser {

    public static String reverseEquation(String equation) {
        TokenStack stack = new TokenStack();
        int n = equation.length();
        int i = 0;

        // 1. Soldan sağa denklemi tara
        while (i < n) {
            char current = equation.charAt(i);

            // Rakam ise basamakları birleştirip tek bir sayı olarak push et
            if (Character.isDigit(current)) {
                int start = i;
                while (i < n && Character.isDigit(equation.charAt(i))) {
                    i++;
                }
                String number = equation.substring(start, i);
                stack.push(number);
            }
            // Operatör ise doğrudan push et
            else {
                stack.push(String.valueOf(current));
                i++;
            }
        }

        // 2. Yığındaki tüm elemanları pop edip StringBuilder ile birleştir
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }
}
