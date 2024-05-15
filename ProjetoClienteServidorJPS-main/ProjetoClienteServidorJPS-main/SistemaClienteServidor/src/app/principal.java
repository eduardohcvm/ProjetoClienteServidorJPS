package app;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/somaNotas")
public class SomaNotas extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recebendo as notas do formulário HTML
        String nota1Str = request.getParameter("txtNota1");
        String nota2Str = request.getParameter("txtNota2");

        // Verificando se as notas foram fornecidas e se são números válidos
        double nota1 = 0, nota2 = 0;
        boolean error = false;
        try {
            nota1 = Double.parseDouble(nota1Str);
            nota2 = Double.parseDouble(nota2Str);
        } catch (NumberFormatException e) {
            error = true;
        }

        // Configurando o tipo de conteúdo da resposta
        response.setContentType("text/html");

        // Escrevendo a resposta
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Soma de Notas</title></head><body>");

        // Verificando se houve algum erro ao processar as notas
        if (error || nota1 < 0 || nota2 < 0) {
            out.println("<h2>Erro: As notas devem ser números válidos maiores ou iguais a zero.</h2>");
        } else {
            // Calculando a soma das notas
            double soma = nota1 + nota2;
            out.println("<h2>Soma das Notas:</h2>");
            out.println("<p>Nota 1: " + nota1 + "</p>");
            out.println("<p>Nota 2: " + nota2 + "</p>");
            out.println("<p>Soma: " + soma + "</p>");
        }

        out.println("</body></html>");
    }
}
