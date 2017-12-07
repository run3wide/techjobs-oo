package org.launchcode.models;

/**
 * Created by LaunchCode
 */
public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    public Job() {
        id = nextId;
        nextId++;
    }

    public Job(String aName, Employer aEmployer, Location aLocation,
               PositionType aPositionType, CoreCompetency aSkill) {

        this();

        name = aName;
        employer = aEmployer;
        location = aLocation;
        positionType = aPositionType;
        coreCompetency = aSkill;

    }


    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Job.nextId = nextId;
    }

    public String getName() {
        return name;
    }

    public Job setName(String name) {
        this.name = name;
        return this;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Job setEmployer(Employer employer) {
        this.employer = employer;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Job setLocation(Location location) {
        this.location = location;
        return this;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public Job setPositionType(PositionType positionType) {
        this.positionType = positionType;
        return this;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public Job setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
        return this;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;

        return id == job.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
