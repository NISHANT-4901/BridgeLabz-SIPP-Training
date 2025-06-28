package Day4_ObjectOrientedDesignPrincles.ObjectModeling;

import java.util.ArrayList;
import java.util.List;

// Doctor class
class Doctor {
    String name;
    List<Patient> patients = new ArrayList<>();

    Doctor(String name) {
        this.name = name;
    }

    void consult(Patient patient) {
        patients.add(patient);
        patient.doctors.add(this);
        System.out.println("Doctor " + name + " is consulting Patient " + patient.name);
    }
}

// Patient class
class Patient {
    String name;
    List<Doctor> doctors = new ArrayList<>();

    Patient(String name) {
        this.name = name;
    }
}

// Hospital class
public class Hospital {
    public static void main(String[] args) {
        Doctor drJohn = new Doctor("Dr. John");
        Doctor drEmma = new Doctor("Dr. Emma");

        Patient p1 = new Patient("Alice");
        Patient p2 = new Patient("Bob");

        // Doctor consulting patients
        drJohn.consult(p1);
        drJohn.consult(p2);

        drEmma.consult(p2); // Bob consulted by two doctors
    }
}
