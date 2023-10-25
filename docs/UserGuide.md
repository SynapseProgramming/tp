---
layout: page
title: User Guide
---

ToothTracker is an **All-in-One solution for Effortless Dental Clinic Record Management**.
From adding new patient and dentist profiles to seamlessly deleting records,
ToothTracker is engineered to simplify every aspect of your administrative responsibilities.

Table of Contents
- TOC
  {:toc}


--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `ToothTracker.jar` from [here]().

1. Copy the file to the folder you want to use as the _home folder_ for your ToothTracker.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar ToothTracker.jar`
   command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `list-dentists` : Lists all dentists.

    * `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces` : Adds a dentist named `Bob`
      to the ToothTracker.

    * `delete-dentist 3` : Deletes the dentist with id 3.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be
  ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.

</div>

### Viewing help : `help`

Shows a message explaning how to access the help page.

![help message](images/helpMessage.png)

Format: `help`

## Part 1 - Dentist Features

### Adding a dentist : `add-dentist`
Adds a dentist to ToothTracker list of dentists. This is helpful when:

* You are using ToothTracker for the first time, and you have to add your dentists' particulars.
* You are adding a new dentist who has joined your dental clinic.

**Format:** `add-dentist n/NAME p/PHONE s/SPECIALIZATION y/YOE [e/EMAIL] [h/ADDRESS] [t/TAG]…​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A dentist can have any number of <code>TAG</code>s (including zero tags).

<code>EMAIL</code> and <code>ADDRESS</code> are optional to be put.
You may use `edit-dentist` command to update them in the future.
</div>

Examples:

* `add-dentist n/Xavier Roald p/99773311 s/Whitening y/1 e/roaldxavier@hotmail.com
h/Yishun Street 72, Blk 742, #03-354, Singapore 512742 t/Undergraduate Trainee`
This adds a dentist named 'Xavier Roald' with phone number '99773311', email 'roaldxavier@hotmail.com',
address 'Yishun Street 72, Blk 742, #03-354, Singapore 512742',
specialising in 'Whitening' with 1 year of experience, who is undergoing University Training program under Dentistry.


* `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`  
This adds a dentist named 'Bob' with phone number '12345678' and email ‘bobjune@gmail.com’,
who has 6 years of experience and specializing in 'braces' into ToothTracker dentist list.


* `add-dentist n/Emmanuel Chua p/99887766 y/8 s/surgery t/extraction` 
This adds a dentist named 'Emmanuel Chua' with phone number '99887766' who has 8 years of experience
specializing in 'surgery' with a tag of 'extraction' into ToothTracker dentist list.

### Editing a dentist: `edit-dentist`

Edits one or more details of the dentist at the specified Dentist ID. This is helpful when:
* The particulars of a dentist need to be updated.
* Optional dentist details were not provided previously.
* You accidentally entered incorrect information about a dentist into the ToothTrack database.

**Format:** `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​`

Examples:

* `edit-dentist 1 p/98987676 e/bobjuly@gmail.com` edits the phone number and email of the dentist with Dentist ID of 1
  into 98987676 and bobjuly@gmail.com respectively.
* `edit-dentist 2 n/Emmanuel Alexandra t/` edits the name of the dentist with Dentist ID of 2 into ‘Emmanual Alexandra’
  and removes all tags of the dentist.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
You can edit the particulars in any order and you can edit more than one detail of the dentist.
</div>

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
To check the Dentist ID for a dentist, you can simply enter the command `list-dentists`.
</div>

<div markdown="block" class="alert alert-info">
**:information_source: Notes about editing tags:**<br>
When editing tags, you have to include any previous tags that was already included in the dentist, or else these tags will be removed. 
This also means that you can use `t/` to remove all tags from a dentist using the <code>edit-dentist</code> command.
</div>

### Searching a dentist by Dentist ID: `search-dentist DENTIST_ID`

Searches for the dentist with the specified Dentist ID in ToothTracker. 
**This search returns one unique dentist.** This is helpful when:
* You want quick access to one specific Dentist's particulars.
* You want to confirm the identity of a Dentist before using further commands.

<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `search-dentist DENTIST_ID`

### Searching a dentist by name: `search-dentist NAME`

Searches for dentists whose name contains `NAME`  in ToothTracker. 
**This search may return more than one dentist.** This is helpful when:
* You want quick access to one or more specific Dentists particulars, **but you forgot the `Dentist ID` of the dentists** you are searching for.
* You want to confirm the identity of a Dentist before using further commands.

<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `search-dentist NAME`

### Deleting a dentist: `delete-dentist DENTIST_ID`

Deletes the specified dentist from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE!
Dentists deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>


<div markdown="block" class="alert alert-info">
The `DENTIST_ID` refers to the index number shown in the displayed list of dentists.
You may use `list-dentists` to check out the dentists' ID first.
</div>

**Format:** `delete-dentist DENTIST_ID`

Examples:

* `delete-dentist 2` deletes dentist with DENTIST_ID 2 from ToothTracker.

### Listing all dentists : `list-dentists`

Shows a list of all dentists in ToothTracker. This is useful when:

* You want to retrieve the information of all dentists.
* You want to verify a dentist is added successfully in ToothTracker.
* You want to verify a dentist is updated successfully in ToothTracker.

**Format:** `list-dentists` (No extra parameters required)


## Part 2 - Patient Features

### Adding a patient: `add-patient`

Adds a patient to ToothTracker list of patients. This is helpful when:
- You are using ToothTracker for the first time and you have to add your patients' particulars.
- A new patient has joined your clinic.

Format: `add-patient n/NAME p/PHONE e/EMAIL b/BIRTHDATE g/GENDER r/REMARK s/SERVICE h/ADDRESS `

Examples:

* `Add-patient n/John Tan p/90676622 e/johntan@gmail.com b/06-06-1998 g/M r/heavy smoker s/Cleaning h/60 Jalan Kempinski Road` <br>
Adds a new patient named ‘John Tan’, with phone number ‘90676622’ and email of ‘johntan@gmail.com’,
birthdate of 06 June 1998, Gender Male, remark that he is a heavy smoker, requesting for cleaning treatment
and with an address at 60 Jalan Kempinski Road.
* `Add-patient n/Megan Chua p/88756298 e/megan@outlook.com b/10-09-1993 g/F s/Cleaning h/34 Changi Rise` <br>
Adds a new patient named ‘Megan Chua’, with phone number ‘88756298’ and email of ‘megan@outlook.com’,
birthdate of 10 Sep 1993, Gender Female, no remark specified, requesting for cleaning treatment and with
an address at 34 Changi Rise.


### Listing all patients : `list-patient`

Shows a list of all patients in ToothTracker.

Format: `list-patient`

Examples:

* `list-patient 296` shows the details of the patient with PATIENT_ID 296 from ToothTracker.


### Deleting a patient : `delete-patient`

Deletes the specified patient from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE! Dentists deleted will need to be added back and their previous records may be removed.
**Proceed with caution!**
</div>

* Deletes the patient at the specified `INDEX`.
* The index refers to the index number shown in the displayed patient list.
* The index **must be a positive integer** 1, 2, 3, …​
* You may use `list-patient` to obtain the patient's ID first.

Format: `delete-patient PATIENT_ID`

Examples:

* `delete-patient 034` deletes patient with PATIENT_ID 34 from ToothTracker.


### Searching patients by ID or keyword: `search-patient`

Searches for the patient with the specified ID or patients that matches the keyword. This command allows you to find patient records that match your
search criteria.

Format: `search-patient [KEYWORD]`, `search-patient [PATIENT_ID]`

<div markdown="block" class="alert alert-info">
The `PATIENT_ID` refers to the index number shown in the displayed list of patients. <br>
You may use `list-patients` to check out the patient' ID first.
</div>

**Important Notes:**

* The search is case-insensitive, meaning that the search will match both uppercase and lowercase characters. For
  example, searching for `Thomas` will match both `Thomas` and `thomas`.
* The order of the keywords in the name does not matter. For instance, searching for `Thomas Tan` will
  match `Tan Thomas` as well.
* The search is performed only on the patient's name.
* Only full words will be matched. For example, if you search for `Mel`, it will not match `Melissa`.


Examples:

* `search-patient Thomas` searches for patients with the name containing the keyword `Thomas`.
* `search-patient 088` searches for a patient with the ID `088`. If one or more matching patients are found based on
  your search criteria, the system will list the matching patients along with their details.

## Part 3 - Appointment Features

### Adding an appointment: `add-appointment`

You can add a new dental appointment to the ToothTracker system using the `add-appointment` command.
This command allows you to specify the dentist, patient, start time and duration of the appointment.
You can also specify the treatment of the appointment.

Format: `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_TIME duration/DURATION s/TREATMENT`

Examples:

* `add-appointment dentist/0 patient/0 start/2023-10-12 16:00 duration/PT1H30M s/Braces`
  adds an appointment with patient whose ID is 0, dentist whose ID is 0.
  The appointment starts on 12 October 2023, lasting for 1.5 hours. Treatment provided during the appointment is braces.

**Important Notes:**

- The system will not allow the addition of appointments that
  clashes with existing appointments with the same dentist or patient.

### Deleting an appointment: `delete-appointment`

Deletes the specified appointment from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE!
Appointments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>


<div markdown="block" class="alert alert-info">
The `APPOINTMENT_ID` refers to the index number shown in the displayed list of appointments.
You may use `list-appointments` to check out the appointment's ID first.
</div>


**Format:** `delete-appointment APPOINTMENT_ID`

Examples:

* `delete-appointment 2` deletes appointment with APPOINTMENT_ID 2 from ToothTracker.


### Listing all appointments : `list-appointments`
Shows a list of all appointments in ToothTracker.

Format: `list-appointments`

### Filter Appointments by service type, date or dentist: `filter KEYWORD`

You can filter appointments by their service type, date or dentists in the ToothTracker system
using the `filter` command.

Format: `filter s/SERVICE_TYPE`, `filter t/DATE`, `filter d/DENTIST`

Examples:

* `filter s/Tooth Extraction` returns all Tooth Extraction appointments.
* `filter t/20-11-2023` returns all appointments happening on 20 November 2023.
* `filter d/Tom` returns all appointments with Tom as the dentist.


## Part 4 - Treatment Features

### Adding a treatment: `add-treatment`

You can add a new dental treatment to the ToothTracker system using the `add-treatment` command. This command allows you
to specify the name of the treatment and its associated price, and how long the treatment would take. The treatment would
be stored in ToothTrackers internal storage.

Format: `add-treatment name price duration`

Examples:

* `add-treatment tr/Tooth Extraction cs/1080 ti/10:30` adds a tooth extraction treatment to ToothTracker with a cost of $1080 sgd, and
  duration of 10 hours and 30 minutes.

**Important Notes:**

- Ensure that you provide treatment name, its cost and its duration when using the `add-treatment` command.
- The system will not allow duplicate treatment names. If a treatment with the same name already exists, you will be
  prompted to provide a unique name.


### Deleting a treatment: `delete-treatment TREATMENT_NAME`

Deletes the specified treatment from ToothTracker.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
This command is DESTRUCTIVE!
Treaments deleted will need to be added back and their previous records may be removed.
Proceed with caution!
</div>

<div markdown="block" class="alert alert-info">
TREATMENT_NAME must be an exact match
</div>

**Format:** `delete-treatment TREATMENT_NAME`

Examples:

* `delete-treatment Braces` deletes treatment with name: Braces from ToothTracker.

## Part 5 - General Features

### Clearing all entries : `clear`

Clears all entries from ToothTracker.

Format: `clear`

### Exiting the program : `exit`

Exits the program.

Format: `exit`

### Saving the data

ToothTracker data is saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file

ToothTracker data is saved automatically as a JSON file `[JAR file location]/data/toothtracker.json`. Advanced users are
welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, ToothTracker will discard all data and start with an empty
data file at the next run. Hence, it is recommended to take a backup of the file before editing it.
</div>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous ToothTracker home folder.

**Q**: Why do I get an error while trying to edit an existing dentist/patient?<br>
**A**: The dentist/patient to be edited may not be shown in ToothTracker. 
To display the to-be-edited dentist/patient, you may use these commands:
1. `list-dentists` or `list-patients`
2. `search-dentist` or `search-patient`

Afterwards, you may edit the particulars using `edit-dentist` or `edit-patient` with their corresponding IDs.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                                 | Format, Examples                                                                                                                                                                                                               |
|----------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Dentist**                        | `add-dentist n/NAME p/PHONE e/EMAIL s/SPECIALIZATION y/YOE [t/TAG]…​` <br> e.g., `add-dentist n/Bob p/12345678 e/bobjune@gmail.com y/6 s/braces`                                                                               |
| **Edit Dentist**                       | `edit-dentist DENTIST_ID [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [s/SPECIALIZATION] [y/YOE] [t/TAG]…​` <br> e.g., `edit-dentist 1 p/98987676 e/bobjuly@gmail.com`                                                             |
| **Delete Dentist**                     | `delete-dentist DENTIST_ID`<br> e.g., `delete-dentist 3`                                                                                                                                                                       |
| **List Dentists**                      | `list-dentists`                                                                                                                                                                                                                |
| **Search Dentist by Dentist ID**       | `search-dentist DENTIST_ID` <br> e.g., `search-dentist 2`                                                                                                                                                                      |
| **Search Dentist by Name**             | `search-dentist NAME` <br> e.g., `search-dentist Tom`                                                                                                                                                                          |
| **Add Patient**                        | `add-patient n/NAME p/PHONE e/EMAIL b/BIRTHDATE g/GENDER r/REMARK s/SERVICE h/ADDRESS` <br> e.g., `add-patient n/John Tan p/90676622 e/johntan@gmail.com b/06-06-1998 g/M r/corn allergy s/Cleaning h/60 Jalan Kempinski Road` |
| **Delete Patient**                     | `delete-patient PATIENT_ID`<br> e.g., `delete-patient 3`                                                                                                                                                                       |
| **List Patients**                      | `list-patients`                                                                                                                                                                                                                |
| **Search Patient by Patient ID**       | `search-patient PATIENT_ID`  <br> e.g., `search-patient 3`                                                                                                                                                                     |
| **Search Patient by Name**             | `search-patient NAME` <br> e.g., `search-patient John`                                                                                                                                                                         |
| **Add a Treatment**                    | `add-treatment [NAME] [PRICE]` <br> e.g., `add-treatment "Tooth Extraction" 150`                                                                                                                                               |
| **Delete a Treatment**                 | `delete-treatment NAME` <br> e.g., `delete-treatment Braces`                                                                                                                                                                   |
| **Add Appointment**                    | `add-appointment dentist/DENTIST_ID patient/PATIENT_ID start/START_TIME duration/DURATION s/TREATMENT` <br> e.g.,`add-appointment dentist/0 patient/0 start/2023-10-12 16:00 duration/PT1H30M s/Braces`                        |
| **Delete Appointment**                 | `delete-appointment APPOINTMENT_ID`<br> e.g., `delete-appointment 3`                                                                                                                                                           |
| **List Appointments**                  | `list-appointments`                                                                                                                                                                                                            |
| **Filter Appointments by Service Type** | `filter s/SERVICE_TYPE` <br> e.g., `filter s/Tooth Extraction`                                                                                                                                                                 |
| **Filter Appointments by Date**        | `filter t/DATE` <br> e.g., `filter t/20-11-2023`                                                                                                                                                                               |
| **Filter Appointments by Dentist**     | `filter d/DENTIST_ID` <br> e.g., `filter d/Tom`                                                                                                                                                                                |
| **Clear all Profiles**                 | `clear`                                                                                                                                                                                                                        |
| **Exit Programme**                     | `exit`                                                                                                                                                                                                                         |
| **Help**                               | `help`                                                                                                                                                                                                                         |



