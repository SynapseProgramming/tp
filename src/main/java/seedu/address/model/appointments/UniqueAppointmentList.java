package seedu.address.model.appointments;

import static java.util.Objects.requireNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.UniquePatientList;
import seedu.address.model.person.dentist.Dentist;
import seedu.address.model.person.patients.Patient;

public class UniqueAppointmentList implements Iterable<Appointment> {
    private final ObservableList<Appointment> internalList = FXCollections.observableArrayList();
    private final ObservableList<Appointment> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public void add(Appointment toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);

    }

    public ObservableList<Appointment> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Appointment> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UniqueAppointmentList)) {
            return false;
        }

        UniqueAppointmentList otherUniqueAppointmentList = (UniqueAppointmentList) other;
        return internalList.equals(otherUniqueAppointmentList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

}
