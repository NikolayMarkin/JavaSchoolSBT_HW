package ru.sbt.model;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(String name, boolean man) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife.
     * Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (this.isMan() != person.isMan()) {
            if (this.getSpouse() != person) {
                divorce();
                this.spouse = person;
                person.marry(this);
                return true;
            }
        }
        return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        if (this.spouse != null) {
            Person spouse = this.spouse;
            this.spouse = null;
            spouse.divorce();
            return true;
        }
        return false;
    }

    public boolean isMan() {
        return man;
    }

    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\n\tName: " + name +
                "\n\tisMan: " + man +
                (spouse != null ? "\n\tis married to " + spouse.getName() : "");
    }
}
