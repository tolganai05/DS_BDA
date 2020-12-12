

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.spark.connector.cql.CassandraConnector;
import org.apache.spark.SparkContext;

public class CassandraUtils {

    /**
     * Initialize session in Cassandra
     *
     * @param sparkContext Spark Context
     */
    public static void init(SparkContext sparkContext) {
        CassandraConnector connector = CassandraConnector.apply(sparkContext.getConf());
        CqlSession session = connector.openSession();
        ResultSet execute = session.execute(("CREATE TABLE IF NOT EXISTS human.report ( age varint PRIMARY KEY , avgsalary varint, avgtrips varint)"));
    }



}
