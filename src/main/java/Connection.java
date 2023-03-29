import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Connection {
    static ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
    static MongoClient mgCli = MongoClients.create(connectionString);

    public static void getDBInfo(MongoClient mgCli) {
        //Recorrem les bases de dades que hi ha al servidor - bucle for each
        for (String dbname : mgCli.listDatabaseNames()) {
            //Mostrem els noms de les bases de dades am system out println
            System.out.println(dbname);
            //Obtenim una referència a la base de dades
            MongoDatabase mgDB = mgCli.getDatabase(dbname);
            //Obtenim els noms de les col·leccions de la base de dades a partir de la interficie MongoIterable
            MongoIterable<String> colecciones = mgDB.listCollectionNames();
            for (String collec : colecciones) {
                System.out.println("\t>" + collec);
            }
        }
    }

    public static void getPelisAny(MongoClient mgCli, int anyEstrena) {
        MongoDatabase mgDB = mgCli.getDatabase("moviedb");
        MongoCollection<Document> colMovies = mgDB.getCollection("movies");
        FindIterable<Document> docMovie = colMovies.find(Filters.eq(""));

        for (Document doc : docMovie) {
            System.out.println("Pel·licules: " + doc.toString());
        }
    }

    public static void getPelisEntre() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introdueix primer any: ");
        try {
            String anyPrimer = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
