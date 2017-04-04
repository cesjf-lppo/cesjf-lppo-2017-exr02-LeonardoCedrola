package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditaReclamacaoServlet", urlPatterns = {"/edita.html"})
public class EditaReclamacaoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reclamacao reclamacao = new Reclamacao();
        Long id = Long.parseLong(request.getParameter("id"));

        try {
            //Pegar os dados do banco
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM reclamacao WHERE id=" + id);
            if (resultado.next()) {
                //contato = new Contato();
                reclamacao.setId(resultado.getLong("id"));
                reclamacao.setNome(resultado.getString("nome"));
                reclamacao.setEmail(resultado.getString("email"));
                reclamacao.setDescricao(resultado.getString("descricao"));
                reclamacao.setStatus(Integer.parseInt(resultado.getString("status")));
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        request.setAttribute("reclamacao", reclamacao);
        request.getRequestDispatcher("WEB-INF/edita-registro.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Reclamacao reclamacao = new Reclamacao();
        reclamacao.setId(Long.parseLong(request.getParameter("id")));
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
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE reclamacao SET     nome='"
                    + reclamacao.getNome() + "', email='"
                    + reclamacao.getEmail() + "', descricao='"
                    + reclamacao.getDescricao()+ "', status="
                    + reclamacao.getStatus()+ " WHERE id="
                    + reclamacao.getId()
            );

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListaReclamacaoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        response.sendRedirect("lista.html");
    }

}
