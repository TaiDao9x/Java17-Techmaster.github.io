package dependency_injection;

public class Client {
    AbtractDAO dao;

    public Client() {
        dao = FactoryDAO.getDAO();
    }

    public AbtractDAO getDao() {
        return dao;
    }

    public void setDao(AbtractDAO dao) {
        this.dao = dao;
    }

    public void execute() {
        dao.insert();
        dao.delete();
        dao.update();
    }
}
