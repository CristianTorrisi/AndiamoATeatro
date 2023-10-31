package database;

import entity.Utente;
import interfaces.Dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserCrud implements Dao<Utente> {
    @Override
    public boolean insert(Utente entity) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"UTENTE\" VALUES (?,?,?,?,?,?,?); ";
            ConnectionHandler ch = new ConnectionHandler();
            PreparedStatement ps = ch.getPreparedStatement(sql);
            ps.setInt(1, entity.getId());
            ps.setString(2,entity.getNome());
            ps.setString(3,entity.getCognome());
            ps.setString(4,entity.getIndirizzo());
            ps.setString(5,entity.getEmail());
            ps.setString(6,entity.getTelefono());
            ps.setInt(7,entity.getEta());
            int affectedrows = ps.executeUpdate();
            ch.closeConnection();
            ps.close();
            return affectedrows > 0;
    }

    @Override
    public boolean update(Utente entity) {
        return false;
    }

    @Override
    public boolean delete(Utente entity) {
        return false;
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
