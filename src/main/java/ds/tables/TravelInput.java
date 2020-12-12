
import java.io.Serializable;

public class TravelInput implements Serializable {

    private Integer passport;
    private Integer month;
    private Integer salary;
    private Integer age;
    private Integer trips;


    public TravelInput() {
    }

    /**
     * Constructor for all arguments in the travel table
     * @param passport Passport number
     * @param month Month (1-12)
     * @param salary Salary data
     * @param age Age category
     * @param trips number of abroad trips
     */

    public TravelInput (Integer passport, Integer month, Integer salary,Integer age,Integer trips) {
        this.passport = passport;
        this.month = month;
        this.salary = salary;
        this.age = age;
        this.trips = trips;

    }

    /**

     * @return Passport number
     */
    public Integer getPassport() {
        return passport;
    }

    /**

     * @param passport new Passport number
     */
    public void setPassport(Integer passport) {
        this.passport = passport;
    }

    /**

     * @return Month (1-12)
     */
    public Integer getMonth() {
        return month;
    }

    /**

     * @param month  new Month (1-12)
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**

     * @return Salary data
     */
    public Integer getSalary() {
        return salary;
    }

    /**

     * @param salary new Salary data
     */
    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    /**

     * @return Age category
     */
    public Integer getAge() {
        return age;
    }

    /**

     * @param age Age category
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**

     * @return number of abroad trips
     */
    public Integer getTrips() {
        return trips;
    }

    /**

     * @param trips new number of abroad trips
     */
    public void setTrips(Integer trips) {
        this.trips = trips;
    }
}


























