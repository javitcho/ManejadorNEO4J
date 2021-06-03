import org.neo4j.driver.*;

import javax.swing.table.DefaultTableModel;
import java.util.*;

import static org.neo4j.driver.Values.parameters;

public class Manejador implements AutoCloseable{
    private Driver driver;

    @Override
    public void close() throws Exception {
        driver.close();
    }

    public Manejador(String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {

                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (a:Greeting) " +
                                    "SET a.message = $message " +
                                    "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }

    public void anadirCurso(String nombre, Object curso){
        Map<String, Object> paramis = new HashMap<>();
        paramis.put("curso", curso);
        paramis.put("nombre", nombre);
        try ( Session session = driver.session() )
        {
            String tutoria = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "MATCH (t:Tutor {Nombre : $nombre}), (c:curso {Nombre : $curso})" +
                                    " CREATE (t)-[r:ENSENA]->(c)" +
                                    "RETURN t.Nombre ",
                            paramis );
                    return "";
                }
            } );
            System.out.println( tutoria );
        }
    }

    public void createEstudiante(String nombre, int carne){
        Map<String, Object> paramis = new HashMap<>();
        paramis.put("nombre", nombre);
        paramis.put("carne", carne);
        try ( Session session = driver.session() )
        {
            String student = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (e:Estudiante) " +
                                    "SET e.Nombre = $nombre , e.Carne = $carne " +
                                    "RETURN e.Nombre ",
                            paramis );
                    return "";
                }
            } );
            System.out.println( student );
    }}

    public void createTutor(String nombre, int carne, String carrera, String correo, int telefono, Object[] cursos){
        Map<String, Object> paramis = new HashMap<>();
        paramis.put("nombre", nombre);
        paramis.put("carrera", carrera);
        paramis.put("correo", correo);
        paramis.put("telefono", telefono);
        paramis.put("carne", carne);
        try ( Session session = driver.session() )
        {
            String tutor = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "CREATE (t:Tutor) " +
                                    "SET t.Nombre = $nombre , t.Carne = $carne , t.Correo = $correo , t.Telefono = $telefono , t.Carrera=$carrera " +
                                    "RETURN t.Nombre ",
                            paramis );
                    return "";
                }
            } );
            for(int i = 0; i< cursos.length;i++){
                anadirCurso(nombre,cursos[i]);
            }
            System.out.println( tutor );
        }
    }

    public void registrarTutoria(String tutor, int carne, String curso, int claridad, int dominio , int horas, int puntualidad){
        Map<String, Object> paramis = new HashMap<>();
        paramis.put("tutor", tutor);
        paramis.put("curso", curso);
        paramis.put("claridad", claridad);
        paramis.put("dominio", dominio);
        paramis.put("eclaridad", 3-claridad);
        paramis.put("edominio", 5-dominio);
        paramis.put("carne", carne);
        paramis.put("horas", horas);
        paramis.put("puntualidad", puntualidad);
        try ( Session session = driver.session() )
        {
            String tutoria = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    Result result = tx.run( "MATCH (t:Tutor {Nombre : $tutor}), (e:Estudiante {Carne : $carne})" +
                                    " CREATE (e)-[r:TUTORIA {Curso:$curso, Claridad:$claridad,Dominio:$dominio, Horas:$horas}]->(t) " +
                                    " SET t.Claridad = $claridad, t.Dominio = $dominio, t.HorasDisponibles = $horas, t.Puntualidad = $puntualidad "+
                                    " SET e.ExigenciaDeClaridad = $eclaridad, e.ExigenciaDeDominio = $edominio , e.Puntualidad = $puntualidad, e.HorasDeTutoria = $horas " +
                                    " ",
                            paramis );
                    return "";
                }
            } );
            System.out.println( tutoria );
        }
    }

    public List<Record> encontrarTutor(int carne, String curso){
        Map<String, Object> paramis = new HashMap<>();
        paramis.put("curso", curso);
        paramis.put("carne", Integer.toString(carne));
        try ( Session session = driver.session() ) {
            List<Record> tutoria = session.writeTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction tx) {
                    Result result = tx.run("MATCH (t:Tutor)-[r:ENSENA]->(c:curso {Nombre : $curso}) WITH t.Nombre AS Nombre, t.Dominio AS Dominio, t.Claridad AS Claridad, t.Puntualidad AS Puntualidad, t.Telefono AS Telefono " +
                                    " RETURN Nombre, Dominio, Claridad, Puntualidad, Telefono ",
                            paramis);
                    return result.list();
                }
            });
            return tutoria;
        }
    }

    public DefaultTableModel tablaDeTutores(int carne, String curso){
        String cols[] = {"Nombre","Dominio","Claridad","Puntualidad","Telefono"};
        DefaultTableModel model = new DefaultTableModel(cols,0);
        List<Record> recordList = encontrarTutor(carne,curso);
        int i = 0;
        for(Record record: recordList){
            if(i<5){
                Object[] row = new Object[cols.length];
                for(int k = 0;k<cols.length;k++){
                    row[k] = record.get(cols[k]);
                }
                model.addRow(row);
            }
            i++;
        }
        return model;
    }

    public Vector<String> tutores(){
        Vector res = new Vector();
        try ( Session session = driver.session() ) {
            List<Record> tutoria = session.writeTransaction(new TransactionWork<List<Record>>() {
                @Override
                public List<Record> execute(Transaction tx) {
                    Result result = tx.run("MATCH (t:Tutor) WITH t.Nombre AS Nombre " +
                                    " RETURN Nombre ");
                    return result.list();
                }
            });
            for(Record record: tutoria){
                res.add(record.get("Nombre").asString());
            }
        }
        return res;
    }

    public static void main( String... args ) throws Exception
    {
        try ( Manejador greeter = new Manejador( "bolt://localhost:7687", "javi", "123" ) )
        {
            greeter.encontrarTutor(21001,"Razonamiento Cuantitativo");
        }
    }


}
