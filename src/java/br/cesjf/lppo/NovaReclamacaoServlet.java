package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author igor
 */
@WebServlet(name = "NovaReclamacaoServlet", urlPatterns = {"/novo.html"})
public class NovaReclamacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/novo-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reclamacao reclamacao = new Reclamacao();
        reclamacao.setNome(request.getParameter("nome"));
        reclamacao.setEmail(request.getParameter("email"));
        reclamacao.setDescricao(request.getParameter("descricao"));
        Integer codStatus = Integer.parseInt(request.getParameter("status"));
        if (codStatus == -1) {
            reclamacao.setStatus(-1);
        } else {
            reclamacao.setStatus(codStatus);
        }

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/lppo-2017-1";
            Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
            Statement operacao = conexao.createStatement();
            String sql = "INSERT INTO reclamacao(nome, email, descricao, status) VALUES('"
                    + reclamacao.getNome() + "', '"
                    + reclamacao.getEmail()+ "','"
                    + reclamacao.getDescricao()+ "',"
                    + reclamacao.getStatus()+ ")";
            operacao.executeUpdate(sql);
        } catch (Exception e) {
            Logger.getLogger(NovaReclamacaoServlet.class.getName()).log(Level.SEVERE, "Erro ao inserir o registro!" + e);
        }
        response.sendRedirect("lista.html");

    }
}
