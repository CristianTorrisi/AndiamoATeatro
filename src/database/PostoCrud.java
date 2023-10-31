package database;
import entity.Posto;
import entity.Utente;
import interfaces.Dao;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostoCrud implements Dao<Posto> {
    @Override
    public boolean insert(Posto posto) throws IOException, SQLException {
        String sql = "INSERT INTO public.\"POSTO\" VALUES (?,?,?,?); ";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,posto.getId());
        ps.setString(2,posto.getFila());
        ps.setInt(3,posto.getSedia());
        ps.setInt(4,posto.getSala());
        int affectedrows = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affectedrows > 0;
    }

    @Override
    public boolean update(Posto posto) throws IOException, SQLException {
        String sql = "UPDATE public.\"UTENTE\"  " +
                " SET  fila=?, sedia=?, sala=? WHERE id ="+
                posto.getId() + ";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setString(1,posto.getFila());
        ps.setInt(2,posto.getSedia());
        ps.setInt(3,posto.getSala());
        int affectedrows = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affectedrows > 0;
    }

    @Override
    public boolean delete(Posto posto) throws IOException, SQLException {
        String sql = "DELETE FROM public.\"POSTO\" WHERE id = ?;";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ps.setInt(1,posto.getId());
        int affectedrows = ps.executeUpdate();
        ch.closeConnection();
        ps.close();
        return affectedrows > 0;
    }

    @Override
    public Optional<Posto> getById(int id) throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"UTENTE\" WHERE id="+id+";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ResultSet set_utent = ps.executeQuery();

        int id_p = 0,sala = 0, sedia = 0;
        String fila = null;
        while (set_utent.next()){
            id_p = set_utent.getInt(1);
            fila = set_utent.getString(2);
            sedia = set_utent.getInt(3);
            sala = set_utent.getInt(4);
        }
        Posto posto = new Posto(id_p,fila,sedia,sala);
        Optional<Posto> opt = Optional.ofNullable(posto);
        ch.closeConnection();
        ps.close();

        if (opt.isPresent())
            return opt;
        else
            return Optional.ofNullable(null);
    }

    @Override
    public List<Posto> getAll() throws IOException, SQLException {
        String sql = "SELECT * FROM public.\"POSTO\";";
        ConnectionHandler ch = new ConnectionHandler();
        PreparedStatement ps = ch.getPreparedStatement(sql);
        ResultSet set_utent = ps.executeQuery();

        List<Posto> posti = new ArrayList<>();
        while (set_utent.next()){
          int  id_p = set_utent.getInt(1);
          String  fila = set_utent.getString(2);
          int  sedia = set_utent.getInt(3);
           int sala = set_utent.getInt(4);
           posti.add(new Posto(id_p,fila,sedia,sala));
        }
        return posti;
    }
}
