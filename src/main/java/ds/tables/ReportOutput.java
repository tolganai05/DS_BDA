
import java.io.Serializable;

public class ReportOutput implements Serializable {

    private Integer age;
    private Integer avgsalary;
    private Integer avgtrips;


    public ReportOutput() {
    }

    /**
     *  Constructor for all arguments in the report table
     *  @param age Age category
     *  @param avgsalary average salary
     *  @param avgtrips average number of abroad trips
     */

    public ReportOutput(Integer age, Integer avgsalary, Integer avgtrips) {
        this.age = age;
        this.avgsalary = avgsalary;
        this.avgtrips = avgtrips;
    }

    /**

     * @return Age category
     */
    public Integer getAge() {
        return age;
    }


    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     average salary
     */
    public Integer getAvgsalary() {
        return avgsalary;
    }


    public void setAvgsalary(Integer avgsalary) {
        this.avgsalary = avgsalary;
    }

    /**

     * average number of abroad trips
     */
    public Integer getAvgtrips() {
        return avgtrips;
    }


    public void setAvgtrips(Integer avgtrips) {
        this.avgtrips =avgtrips;
    }



}
