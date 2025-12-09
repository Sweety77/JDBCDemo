public class ExplainClass_forName {

    /**
     The CLass.forName is a reflection API.
     When we just need to load the class but not instantiate the class - to call its static block or static method.
     Class.forName() - Loads the class without creating their object.

     */

    public static void main(String[] args) throws ClassNotFoundException {

        //As soon as we instantiate the class Pqr - its loads the class so while loading the class it calls its static blocks and fieled first.
        // so when we

//        Create object of Pqr
        /*
        Pqr obj= new Pqr();

        /
         */

        /**
        but suppose if we don't want to create the object still we want to load the static block,
        in that case we can use Class.forName() method to load the class.
         */

//        Class.forName("Pqr");

        /*
        If you want to register a driver, it is not class.forName() who registers the driver it just loads the Driver class.
        Then who loads the driver - it is a static block in the Driver Class who loads the Driver.

        ##################### SAMPLE ########################
        To verify goto Driver Class and see the static block.

        static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (SQLException var1) {
            throw new RuntimeException("Can't register driver!");
        }
    }
        ######################################################


         */
        Class.forName("com.mysql.cj.jdbc.Driver");



    }
}

class Pqr{
    static {
        System.out.println("in static");

    }
    {
        System.out.println("in instance");
    }
}
