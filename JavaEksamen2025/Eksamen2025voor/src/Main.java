import java.io.FileNotFoundException;
import java.sql.SQLException;

//kandidatnummer 573


public class Main {
    public static void main(String[] args) {

        Program program = new Program();
        try {
            program.run();
        }catch (SQLException e) {
            throw new RuntimeException();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    }
