package models;

import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by martinmckeaveney on 13/09/2014.
 */
@Entity
public class Bed extends Model {

    @Id
    public String id;

    @ManyToOne(cascade= CascadeType.ALL)
    public Ward ward;

    public static Finder<String, Bed> find = new Finder<>(
            String.class, Bed.class
    );

}
