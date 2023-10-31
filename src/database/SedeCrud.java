package database;

import entity.Sede;
import entity.Utente;
import interfaces.Dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SedeCrud implements Dao<Sede> {

    @Override
    public boolean insert(Sede entity) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"SEDE\" VALUES (?,?,?,?,?);";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1, entity.getId());
        ps.setString(2,entity.getNome());
        ps.setString(3,entity.getIndirizzo());
        ps.setString(4,entity.getComune());
        ps.setBoolean(5, entity.isAl_chiuso());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean update(Sede entity) throws IOException, SQLException {
        String sql = "UPDATE public.\"SEDE\" SET " +
                "nome=?, indirizzo=?, comune=?, al_chiuso=? " +
                "WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setString(1,entity.getNome());
        ps.setString(2,entity.getIndirizzo());
        ps.setString(3,entity.getComune());
        ps.setBoolean(4,entity.isAl_chiuso());
        ps.setInt(5,entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean delete(Sede entity) throws IOException, SQLException {
        String sql = "DELETE FROM public.\"SEDE\" WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public Optional<Sede> getById(int id) throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"SEDE\" WHERE id=" + id +";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ResultSet r = ps.executeQuery();
        Sede sede = new Sede(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getBoolean(5));
        ch.closeConnection();
        ps.close();
        return Optional.of(sede);
    }

    @Override
    public List<Sede> getAll() throws IOException, SQLException{
        return null;
    }

}