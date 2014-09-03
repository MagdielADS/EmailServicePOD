package persistence;

import br.edu.ifpb.emailsharedpod.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author magdiel-bruno
 */
public class PersonDAO {

    public PersonDAO() {
    }

    public boolean add(Pessoa p) {
        try {
            Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = null;

            String sql = "insert into pessoa (nome, email) values (?,?)";
            try {
                ps = con.prepareStatement(sql);
                ps.setString(1, p.getNome());
                ps.setString(2, p.getEmail());

                int aux = ps.executeUpdate();

                if (aux == 1) {
                    return true;
                }
            } finally {
                ps.close();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean remover(int id) {
        try {
            Connection con = DBConnection.getInstance().getConnection();
            PreparedStatement ps = null;
            String sql = "delete from pessoa where id = ?";
            try {
                ps = con.prepareStatement(sql);
                ps.setInt(1, id);

                ps.executeUpdate();
            } finally {
                ps.close();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Pessoa> listar() {
        try {
            Connection con = DBConnection.getInstance().getConnection();
            Statement stat = null;

            try {
                stat = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "select * from pessoa";

                ResultSet rs = stat.executeQuery(sql);
                List<Pessoa> pessoas = new ArrayList<Pessoa>();

                while (rs.next()) {
                    Pessoa p = new Pessoa();
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setEmail(rs.getString("email"));

                    pessoas.add(p);
                }
                return pessoas;
            } finally {
                stat.close();
                con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
