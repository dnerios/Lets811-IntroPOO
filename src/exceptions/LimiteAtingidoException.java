package exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class LimiteAtingidoException extends Exception {

    public final String TITLE = "[ERROR] Limite de carros atingido";

    public LimiteAtingidoException(String message) {
        super(message);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("log-letscode.txt", "UTF-8");
            writer.println("LOGGER DO CONSTRUTOR - " + LocalDateTime.now() + " - Antes existiam: X carros - Compra efetuada com sucesso. Seu estoque agora é de X veículos");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
