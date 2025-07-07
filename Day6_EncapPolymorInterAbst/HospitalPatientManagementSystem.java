package Day6_EncapPolymorInterAbst;

import java.util.*;

abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

// InPatient subclass
class InPatient extends Patient implements MedicalRecord {
    private int numberOfDays;
    private double roomChargePerDay;
    private List<String> records = new ArrayList<>();

    public InPatient(int patientId, String name, int age, int numberOfDays, double roomChargePerDay) {
        super(patientId, name, age);
        this.numberOfDays = numberOfDays;
        this.roomChargePerDay = roomChargePerDay;
    }

    @Override
    public double calculateBill() {
        return numberOfDays * roomChargePerDay;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Medical Records:");
        for (String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

// OutPatient subclass
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> records = new ArrayList<>();

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Medical Records:");
        for (String rec : records) {
            System.out.println("- " + rec);
        }
    }
}

// Driver class
public class HospitalPatientManagementSystem {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient inPatient = new InPatient(101, "Ravi Kumar", 45, 5, 2000.0);
        inPatient.addRecord("Admitted for fever and dehydration");
        inPatient.addRecord("IV fluids administered");
        patients.add(inPatient);

        OutPatient outPatient = new OutPatient(202, "Sneha Verma", 30, 500.0);
        outPatient.addRecord("Consultation for back pain");
        outPatient.addRecord("Painkillers prescribed");
        patients.add(outPatient);

        for (Patient p : patients) {
            System.out.println("-----------");
            p.getPatientDetails();
            System.out.println("Bill Amount: " + p.calculateBill());
            if (p instanceof MedicalRecord) {
                ((MedicalRecord) p).viewRecords();
            }
        }
    }
}
