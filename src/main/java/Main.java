public class Main {
    public static void main(String[] args) {
        Connection connection = new Connection();
        Connection.getDBInfo(Connection.mgCli);
        Connection.getPelisAny(Connection.mgCli, 1999);
        Connection.getPelisEntre();
    }
}
