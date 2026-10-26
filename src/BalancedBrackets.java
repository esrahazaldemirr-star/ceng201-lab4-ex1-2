public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        BracketStack stack = new BracketStack();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // 1. Açılış parantezi ise stack'e at
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // 2. Kapanış parantezi ise stack durumunu kontrol et
            else if (ch == ')' || ch == '}' || ch == ']') {
                // Eğer kapatacak açılış parantezi yoksa dengesizdir
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                // Eşleşme uyuşmuyorsa dengesizdir
                if (!isMatchingPair(topChar, ch)) {
                    return false;
                }
            }
            // Parantez dışındaki harf/rakam gibi karakterler göz ardı edilir
        }

        // Tüm metin bittiğinde yığın tamamen boş kalmış olmalıdır
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char opening, char closing) {
        if (opening == '(' && closing == ')') return true;
        if (opening == '[' && closing == ']') return true;
        if (opening == '{' && closing == '}') return true;
        return false;
    }
}