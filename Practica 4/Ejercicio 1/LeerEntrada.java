package ejercicio1;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LeerEntrada {
	private Reader stream;
	
	public LeerEntrada(InputStream Fuente) {
		stream = new InputStreamReader(Fuente);
	}
	
	public char getChar() throws IOException {
		return (char) this.stream.read();
	}
	
	public void procesar(char c) throws VocalException, NumeroException, EspacioException, SimboloException {
        if ("aeiouAEIOU".indexOf(c) != -1) {
            throw new VocalException(c);
        } else if (Character.isDigit(c)) {
            throw new NumeroException(c);
        } else if (Character.isWhitespace(c)) {
            throw new EspacioException();
        } else if (!Character.isLetterOrDigit(c)) {
            throw new SimboloException(c);
        }
    }

}
