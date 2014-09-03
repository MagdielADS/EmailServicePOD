/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import br.edu.ifpb.emailsharedpod.Email;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmailDAO {

    public boolean save(Email email) {
        String sql = "INSERT INTO EMAIL(remetente,destinatarios,assunto,ipServidor,status,mensagem) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                stmt.setString(1, email.getRemetente());
                stmt.setString(2, email.getDestinatarios());
                stmt.setString(3, email.getAssunto());
                stmt.setString(4, email.getIpServidor());
                stmt.setBoolean(5, email.isStatus());
                stmt.setString(6, email.getMensagem());
                stmt.executeUpdate();
                return true;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateStatusToSent(int id) {
        String sql = "UPDATE EMAIL SET status=true WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Email> getUnsentEmails() {
        String sql = "SELECT id,remetente,destinatarios,assunto,status,mensagem,ipServidor FROM email WHERE status = false";
        List<Email> emails = new ArrayList<Email>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                ResultSet rs = stmt.executeQuery();
                Email email = new Email();
                while (rs.next()) {
                    email.setId(rs.getInt("id"));
                    email.setMensagem(rs.getString("mensagem"));
                    email.setRemetente(rs.getString("remetente"));
                    email.setDestinatarios(rs.getString("destinatarios"));
                    email.setAssunto(rs.getString("assunto"));
                    email.setStatus(rs.getBoolean("status"));
                    email.setIpServidor(rs.getString("ipServidor"));
                    emails.add(email);
                    email = new Email();
                }
                return emails;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean saveCliente(Email email) {
        String sql = "INSERT INTO emailCliente(remetente,destinatarios,assunto,ipServidor,status,mensagem) VALUES(?,?,?,?,?,?)";
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                stmt.setString(1, email.getRemetente());
                stmt.setString(2, email.getDestinatarios());
                stmt.setString(3, email.getAssunto());
                stmt.setString(4, email.getIpServidor());
                stmt.setBoolean(5, email.isStatus());
                stmt.setString(6, email.getMensagem());
                stmt.executeUpdate();
                return true;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateStatusToSentEmailCliente(int id) {
        String sql = "UPDATE emailCliente SET status=true WHERE id = ?";
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                return true;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Email> getUnsentEmailsCliente() {
        String sql = "SELECT id,remetente,destinatarios,assunto,status,mensagem,ipServidor FROM emailCliente WHERE status = false";
        List<Email> emails = new ArrayList<Email>();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            try {
                ResultSet rs = stmt.executeQuery();
                Email email = new Email();
                while (rs.next()) {
                    email.setId(rs.getInt("id"));
                    email.setMensagem(rs.getString("mensagem"));
                    email.setRemetente(rs.getString("remetente"));
                    email.setDestinatarios(rs.getString("destinatarios"));
                    email.setAssunto(rs.getString("assunto"));
                    email.setStatus(rs.getBoolean("status"));
                    email.setIpServidor(rs.getString("ipServidor"));
                    emails.add(email);
                    email = new Email();
                }
                return emails;
            } finally {
                stmt.close();
                connection.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmailDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
