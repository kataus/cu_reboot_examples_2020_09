package home;

public class Square extends Rectagle{

    public void setA( Integer a ) {
        super.setA( a );
        super.setB( a );
    }

    public void setB( Integer b ) {
        super.setA( b );
        super.setB( b );
    }
}
