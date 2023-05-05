package dependency_injection;


public class FactoryDAO {
    public static AbtractDAO getDAO() {
        String[] db = {"1", "2", "3"};
        int ran = (int) (Math.random() * 3 );
        String database = db[ran];

        if (database.equals("1")) return new MySQLDAO();
        if (database.equals("2")) return new PostgreDAO();
        if (database.equals("3")) return new MSSQLDAO();

        return null;
    }
}
