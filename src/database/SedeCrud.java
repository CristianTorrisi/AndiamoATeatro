package database;

import entity.Sede;
import entity.Utente;
import interfaces.Dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SedeCrud implements Dao<Sede> {
    @Override
    public boolean insert(Sede entity) throws IOException, SQLException {
        return false;
    }

    @Override
    public boolean update(Sede entity) {
        return false;
    }

    @Override
    public boolean delete(Sede entity) {
        return false;
    }

    @Override
    public Optional<Sede> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Sede> getAll() {
        return null;
    }
}
