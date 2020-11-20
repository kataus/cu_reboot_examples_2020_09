package ru.sbrf.cu.core.model;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "number")
    private String number;

    public Phone() {
    }

    public Phone( long id, String number ) {
        this.id = id;
        this.number = number;
    }

    public long getId() {
        return id;
    }

    public void setId( long id ) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder( "Phone{" );
        sb.append( "id=" ).append( id );
        sb.append( ", number='" ).append( number ).append( '\'' );
        sb.append( '}' );
        return sb.toString();
    }
}
