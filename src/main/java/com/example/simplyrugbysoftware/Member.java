package com.example.simplyrugbysoftware;


/**
 *
 * Member class, the class that holds member details.
 * @author Bartlomiej Klich
 * @version
 *
 *
 */

public class Member {
    //date regex and uk address regex
    private String DateRegex = ("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");

    private String ukAddressregex = ("([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|(([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})");

    //member variables
    private String Fname;
    private String Sname;
    private String Sex;
    private String Email;
    private String HomeAddress;
    private int MemberID;
    static int NextID = 0;

    private String Dob;

    //member constructor

    /**
     *
     * Member constructor ensures that all the details are validated through the use of setters.
     * @author Bartlomiej Klich
     * @version
     * @param fname the variable used for holding the forename.
     * @param sname the variable used for holding the surname.
     * @param sex the variable used for holding the sex.
     * @param email the variable used for holding the email.
     * @param homeAddress the variable used for holding the home address.
     * @param memberID the variable used for holding the member id.
     * @param Dob the variable used for holding the date of birth.
     *
     */
    public Member(String fname, String sname, String sex, String email, String homeAddress, int memberID, String Dob) {
        try {
        setFname(fname);
        setSname(sname);
        setSex(sex);
        setEmail(email);
        setHomeAddress(homeAddress);
        setMemberID(memberID);
        setDob(Dob);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //empty member constructor
    /**
     *
     * Empty Member constructor.
     * @author Bartlomiej Klich
     * @version
     *
     */
    public Member() {

    }
    //getters and setters
    /**
     *
     * Method for getting the forename.
     * @author Bartlomiej Klich
     * @version
     * @return Fname the variable used for holding the forename.
     *
     *
     */
    public String getFname() {
        return Fname;
    }

    /**
     *
     * Method for setting the forename.
     * @author Bartlomiej Klich
     * @version
     * @param fname the variable used for holding the forename.
     */
    public void setFname(String fname) throws Exception{


        try {

            if (fname.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
                Fname = fname;}
            else {
                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the fname has to contain only letters");
        }



    }
    /**
     *
     * Method for getting the surname.
     * @author Bartlomiej Klich
     * @version
     * @return Sname the variable used for holding the surname.
     */
    public String getSname() {
        return Sname;
    }
    /**
     *
     * Method for setting the surname.
     * @author Bartlomiej Klich
     * @version
     * @param sname the variable used for holding the surname.
     */
    public void setSname(String sname) throws Exception{

        try {
        if (sname.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")){
            Sname = sname;}
        else {
            throw new Exception();
        }
        } catch(Exception e){
            throw new Exception("the sname has to contain only letters");
    }
   }


    /**
     *
     * Method for getting the sex.
     * @author Bartlomiej Klich
     * @version
     * @return Sex the variable used for holding the sex.
     */
    public String getSex() {
        return Sex;
    }
    /**
     *
     * Method for setting the sex.
     * @author Bartlomiej Klich
     * @version
     * @param sex the variable used for holding the sex.
     */
    public void setSex(String sex) throws Exception{

        try {

//            (sex == "M" || sex == "F")

            sex.toUpperCase();
            if (sex.equals("M") || sex.equals("F")){
                Sex = sex;} else {
                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the sex field has either M(male) or F(female)");
        }
    }
    /**
     *
     * Method for getting the email.
     * @author Bartlomiej Klich
     * @version
     * @return Email the variable used for holding the email.
     */
    public String getEmail() {
        return Email;
    }
    /**
     *
     * Method for setting the email.
     * @author Bartlomiej Klich
     * @version
     * @param email the variable used for holding the email.
     */
    public void setEmail(String email) throws Exception{


        try {


            if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$*")){
                Email = email;} else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the email contains '@' and '.'");
        }


    }
    /**
     *
     * Method for getting the home address.
     * @author Bartlomiej Klich
     * @version
     * @return HomeAddress the variable used for holding the home address.
     */
    public String getHomeAddress() {
        return HomeAddress;
    }
    /**
     *
     * Method for setting the home address.
     * @author Bartlomiej Klich
     * @version
     * @param homeAddress the variable used for holding the home address.
     */
    public void setHomeAddress(String homeAddress) throws Exception{

        try {

            if (homeAddress.matches(ukAddressregex)){
                HomeAddress = homeAddress;} else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("make sure that the address field is a uk postcode");
        }
    }
    /**
     *
     * Method for getting the member id.
     * @author Bartlomiej Klich
     * @version
     * @return MemberID the variable used for holding the member id.
     */
    public int getMemberID() {
        return MemberID;
    }
    /**
     *
     * Method for setting the member id.
     * @author Bartlomiej Klich
     * @version
     * @param memberID the variable used for holding the member id.
     */
    public void setMemberID(int memberID) throws Exception {


        try {
            if (memberID >= 0){
                MemberID = memberID;
            } else {

                throw new Exception();
            }
        }catch (Exception e){

            throw new Exception("the member id cannot be less than 1");
        }


    }
    /**
     *
     * Method for getting the date of birth.
     * @author Bartlomiej Klich
     * @version
     * @return Dob the variable used for holding the date of birth.
     */
    public String getDob() {
        return Dob;
    }
    /**
     *
     * Method for setting the date of birth.
     * @author Bartlomiej Klich
     * @version
     * @param dob the variable used for holding the date of birth.
     */
    public void setDob(String dob) throws Exception {

        try {

            if (dob.matches(DateRegex)){
                Dob = dob;} else{ new Exception();}
        }catch (Exception e){
            throw new Exception("the date field is not correct");
        }
    }

    //tostring method
    /**
     *
     * Method for converting the member to a string to be displayed.
     * @author Bartlomiej Klich
     * @version
     * @return toString string.
     */
    @Override
    public String toString() {
        return "Member{" +
                "Fname='" + Fname + '\'' +
                ", Sname='" + Sname + '\'' +
                ", Sex='" + Sex + '\'' +
                ", Email='" + Email + '\'' +
                ", HomeAddress='" + HomeAddress + '\'' +
                ", MemberID=" + MemberID +
                ", Dob=" + Dob +
                '}';
    }
}
