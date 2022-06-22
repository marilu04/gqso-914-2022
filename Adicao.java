import static java.net.HttpURLConnection.HTTP_OK;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Adicao implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        try{
            String[] partes = exchange.getRequestURI().getPath().split("/");
            float n1 = Float.parseFloat(partes[2]);
            float n2 = Float.parseFloat(partes[3]);
            float soma = n1+n2;
            byte[] resposta = Float.toString(soma).getBytes();

            exchange.sendResponseHeaders(HTTP_OK, resposta.length);

            Headers headers = exchange.getResponseHeaders();
            headers.add("Content-Type", "text/html; charset=UTF-8");

            OutputStream out = exchange.getResponseBody();
            out.write(resposta);
        }finally{
            exchange.close();
        }
        
    }
    
}
