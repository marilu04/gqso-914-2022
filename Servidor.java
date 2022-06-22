import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import com.sun.net.httpserver.HttpServer;

public class Servidor {

    // Número máximo de conexões que devem abertas no servidor.
    // Caso o número seja atingido, novas conexões serão rejeitadas.
    public static final int TAMANHO_BACKLOG = 100;

    public static void main(String[] args) throws IOException {
        InetSocketAddress porta = new InetSocketAddress(8080);
        HttpServer servidor = HttpServer.create(porta, TAMANHO_BACKLOG);
        servidor.setExecutor(Executors.newSingleThreadExecutor());

        servidor.createContext("/adicao", new Adicao());
        
        servidor.start();

        System.out.printf("Servidor ouvindo requisições na porta %s\n\n", servidor.getAddress().getPort());
    }
}