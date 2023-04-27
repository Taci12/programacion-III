package prog3.listagenerica;

public class TestBalanceo {
    public boolean estaBalanceado(String string) {
        if (string.charAt(0) == string.charAt(string.length())) {
            return true;
        } else {
            return false;
        }
    }
}
