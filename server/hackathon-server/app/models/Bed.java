package models;

import play.db.ebean.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by martinmckeaveney on 13/09/2014.
 */
@Entity
public class Bed extends Model {

    @Id
    public String id;

    @OneToOne(cascade= CascadeType.ALL)
    public Ward ward;

    public static Finder<String, Bed> find = new Finder<>(
            String.class, Bed.class
    );

}
