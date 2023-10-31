package database;

import entity.Sala;
import entity.Sede;
import interfaces.Dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalaCrud implements Dao<Sala> {
    @Override
    public boolean insert(Sala entity) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"SALA\" VALUES (?,?,?,?);";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1, entity.getId());
        ps.setString(2,entity.getNome());
        ps.setInt(3,entity.getN_posti());
        ps.setInt(4,entity.getSede());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean update(Sala entity) throws IOException, SQLException {
        String sql = "UPDATE public.\"SALA\" SET " +
                "nome=?, n_posti=?, sede=? " +
                "WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setString(1,entity.getNome());
        ps.setInt(2,entity.getN_posti());
        ps.setInt(3,entity.getSede());
        ps.setInt(4, entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public boolean delete(Sala entity) throws IOException, SQLException {
        String sql = "DELETE FROM public.\"SALA\" WHERE id=?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,entity.getId());
        int affected = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affected > 0;
    }

    @Override
    public Optional<Sala> getById(int id) throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"SALA\" WHERE id=" + id +";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ResultSet r = ps.executeQuery();
        Sala sala = new Sala();
        if(r.next()) sala = new Sala(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4));
        ch.closeConnection();
        ps.close();
        return Optional.of(sala);
    }

    @Override
    public List<Sala> getAll() throws IOException, SQLException{
        String sql = "SELECT * FROM public.\"SALA\"";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        List<Sala> sale = new ArrayList<>();
        ResultSet r = ps.executeQuery();
        while (r.next()) {
            sale.add(new Sala(r.getInt(1), r.getString(2), r.getInt(3), r.getInt(4)));
        }
        ch.closeConnection();
        ps.close();
        return sale;
    }

    public static void main(String[] args) throws SQLException, IOException {
        SalaCrud crud = new SalaCrud();
        List<Sala> rs = crud.getAll();
        for (Sala r : rs) {
            System.out.println(r.getId());
        }
        System.out.println(crud.getById(1).orElse(null));
    }

}
