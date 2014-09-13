package models;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by gsayers on 13/09/2014.
 */
@Entity
public class Patient extends Model {

    @Id
    public String id;

    public String name;

    public Calendar dob;

    public String address;

    public String gp;

    @ManyToOne(cascade= CascadeType.ALL)
    public String doctorId;

    @OneToOne(cascade= CascadeType.ALL)
    public String previousDocId;

    public String ailment;

    public String allergies;

    public String notes;

    @OneToOne(cascade= CascadeType.ALL)
    public Bed bed;

    public static Finder<String, Patient> find = new Finder<>(
            String.class, Patient.class
    );

}
