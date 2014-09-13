import models.Bed;
import models.Patient;
import models.Staff;
import models.Ward;
import play.Application;
import play.GlobalSettings;

import java.util.Calendar;

/**
 * Created by gsayers on 13/09/2014.
 */
public class Global extends GlobalSettings {

    @Override
    public final void onStart(final Application app) {

        if(Staff.find.all().isEmpty()) {
            for (int i = 1; i < 11; i++) {
                Staff staff = new Staff();
                staff.isDoctor = i % 2 == 0;
                staff.password = "password";
                staff.save();
            }
        }

        if(Patient.find.all().isEmpty()) {
            for (int i = 1; i < 10; i++) {
                Patient patient = new Patient();
                patient.address = "address" + i;
                patient.ailment = "ailment" + i;
                patient.allergies = "allergies" + i;
                patient.dob = Calendar.getInstance();
                patient.gp = "belfast" + i;
                patient.name = "name" + i;
                patient.notes = "notes" + 1;
                patient.save();
            }
        }
        if(Ward.find.all().isEmpty()) {
            for (int i = 1; i < 10; i++) {
                Ward ward = new Ward();
                ward.name = "Ward" +i;
                ward.save();
            }
        }
        if(Bed.find.all().isEmpty()) {
            for(int i =1; i < 10; i++) {
                Bed bed = new Bed();
                bed.ward = Ward.find.byId(Integer.toString(i));
                bed.save();
            }
        }


    }
}
