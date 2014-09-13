package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by gsayers on 13/09/2014.
 */
@Entity
public class Patient extends Model {

    @Id
    public String id;

    public String name;
}
