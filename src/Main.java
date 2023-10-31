import database.UserCrud;
import entity.Utente;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {
        UserCrud userCrud = new UserCrud();
        userCrud.insert(new Utente(5,"Filippo","Stanco",
                "Via USA","123456780","email5@gmail.com",30));
    }

}
