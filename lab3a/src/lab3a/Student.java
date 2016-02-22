package lab3a;

/**
 *
 * @author
 */
public class Student {

    private int classYear;
    private String major;
    private String name;
    private int age;

    /**
     * getName
     *
     * Description: Returns the student's name
     * @return The student's name
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     *
     * Description: Sets the student's name
     * @param studentName
     */
    public void setName(String studentName) {
        name = studentName;
    }

    /**
     * getMajor
     *
     * Description: Returns the student's major Parameters: none Returns: the
     * student's major
     * @return The student's major
     */
    public String getMajor() {
        return major;
    }

    /**
     * setMajor
     *
     * Description: Sets the student's major
     * @param studentMajor
     */
    public void setMajor(String studentMajor) {
        major = studentMajor;
    }

    /**
     * getAge
     *
     * Description: Returns the student's age
     * @return The student's age
     */
    public int getAge() {
        return age;
    }

    /**
     * setAge
     *
     * Description: Sets the student's age
     * @param studentAge
     */
    public void setAge(int studentAge) {
        age = studentAge;
    }

    /**
     * setClassYear
     *
     * Description: set the student's class year to the specified year If the
     * specified year is > 4, the student's class year is set to 4. If the
     * specified year is < 1, the student's class year is set to 1. Parameters:
     * year - the year to set the student's class year to Returns: nothing
     * @param year
     */
    public void setClassYear(int year) {
        if (year < 1) {
            classYear = 1;
        } else if (year > 4) {
            classYear = 4;
        } else {
            classYear = year;
        }
    }
    
    /**
     * getClassYear
     *
     * Description: Returns the students class year
     * @return classYear
     */
    public int getClassYear() {
        return classYear;
    }

    /**
     * inceaseYear
     *
     * Description: increase student's class year by the specified amount.
     * @param numYears
     */
    public void increaseYear(int numYears) {
        setClassYear(getClassYear() + numYears);
    }

    /**
     * printInfo
     *
     * Description: print student information to the console
     */
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Major: " + major);
        System.out.println("Class year: " + classYear);
        System.out.println();
    }
}
