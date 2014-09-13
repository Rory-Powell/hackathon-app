package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by martinmckeaveney on 13/09/2014.
 */
@Entity
public class Ward extends Model {

    @Id
    public String id;

    public String name;

    public static Model.Finder<String, Ward> find = new Model.Finder<>(
            String.class, Ward.class
    );
}
