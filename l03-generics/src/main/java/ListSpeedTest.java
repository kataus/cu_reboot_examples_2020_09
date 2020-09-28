import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ListSpeedTest {

    public static void main( String[] args ) {
        while ( true ) {
            List<BigInteger> list = new LinkedList<>();
            Date startDate = new Date();
            addLotElements( list, 4_000_000 );
            Date endDate = new Date();
            System.out.println( "LinkedList :" + ( endDate.getTime() - startDate.getTime() ) );

            list = new ArrayList<>();
            startDate = new Date();
            addLotElements( list, 4_000_000 );
            endDate = new Date();
            System.out.println( "ArrayList :" + ( endDate.getTime() - startDate.getTime() ) );
        }
    }

    public static void addLotElements( List<BigInteger> list, long size ) {
        for ( long i = 0; i < size; i++ ) {
            list.add( BigInteger.valueOf( i ) );
        }
    }
}
