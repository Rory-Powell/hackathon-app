package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by martinmckeaveney on 13/09/2014.
 */
@Entity
public class Staff extends Model {

    @Id
    public String id;

    public String password;

    public boolean isDoctor;

    public static Finder<String, Staff> find = new Finder<>(
            String.class, Staff.class
    );
}
