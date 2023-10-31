package database;

import entity.Utente;
import interfaces.Dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UtenteCrud implements Dao<Utente> {
    @Override
    public boolean insert(Utente utente) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"UTENTE\" VALUES (?,?,?,?,?,?,?); ";
            ConnectionHandler ch = new ConnectionHandler();
            PreparedStatement ps = ch.getPreparedStatement(sql);
            ps.setInt(1, utente.getId());
            ps.setString(2,utente.getNome());
            ps.setString(3,utente.getCognome());
            ps.setString(4,utente.getIndirizzo());
            ps.setString(5,utente.getEmail());
            ps.setString(6,utente.getTelefono());
            ps.setInt(7,utente.getEta());
            int affectedrows = ps.executeUpdate();
            ch.closeConnection();
            ps.close();
            return affectedrows > 0;
    }

    @Override
    public boolean update(Utente utente) throws IOException, SQLException {
        String sql = "UPDATE public.\"UTENTE\"  " +
                " SET  nome=?, cognome=?, indirizzo=?, email=?, telefono=?, eta=? WHERE id ="+
                utente.getId() + ";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setString(1,utente.getNome());
        ps.setString(2,utente.getCognome());
        ps.setString(3,utente.getIndirizzo());
        ps.setString(4,utente.getEmail());
        ps.setString(5,utente.getTelefono());
        ps.setInt(6,utente.getEta());
        int affectedrows = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affectedrows > 0;
    }

    @Override
    public boolean delete(Utente utente) throws IOException, SQLException {
        String sql = "DELETE FROM public.\"UTENTE\" WHERE id = ?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,utente.getId());
        int affectedrows = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affectedrows > 0;
    }

    @Override
    public Optional<Utente> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Utente> getAll() {
        return null;
    }
}
