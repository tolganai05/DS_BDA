
import ds.tables.ReportOutput;
import ds.tables.TravelInput;
import ds.utils.CassandraUtils;
import com.datastax.spark.connector.japi.CassandraJavaUtil;
import lombok.extern.log4j.Log4j;
import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

@Log4j

public class SparkSQLApp {

    public static void main(String[] args) throws Exception {

        SparkConf conf = new SparkConf()
                .setAppName("SparkSQLApp")
                .setMaster("local[*]")
                .set("spark.cassandra.connection.host", "127.0.0.1");
        SparkContext sparkContext = new SparkContext(conf);
        SparkSession sparkSession = new SparkSession(sparkContext)
                .builder()
                .getOrCreate();
        CassandraUtils.init(sparkContext);
        JavaRDD javaRDD = CassandraJavaUtil.javaFunctions(sparkContext)
                .cassandraTable("human", "travel", CassandraJavaUtil.mapRowTo(TravelInput.class))
                .select("passport", "month", "salary", "age","trips");
        Encoder<TravelInput> TravelInputEncoder = Encoders.bean(TravelInput.class);
        Dataset<TravelInput> TravelInputDataset = sparkSession.createDataset(javaRDD.rdd(),TravelInputEncoder);
        Encoder<ReportOutput> reportOutputEncoder = Encoders.bean(ReportOutput.class);
        Dataset<ReportOutput> reportOutputDatasetDataset = travelInputDataset;
        reportOutputDatasetDataset.createOrReplaceTempView("table");
        reportOutputDatasetDataset.sqlContext().sql("SELECT age,  Avg(salary), Avg(trips) as avg FROM travel group by age")
                .write()
                .mode("append")
                .format("org.apache.spark.sql.cassandra")
                .option("keyspace", "human")
                .option("table", "report")
                .save();

    }
}


