package PIOl.visit;

public class VisitErrorCodes {
    private static int errorIter = 0;
    public final static int VISIT_CONFIRMED = errorIter++;
    public final static int DOCTOR_NOT_FOUND = errorIter++;
    public final static int WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND = errorIter++;
    public final static int FREE_WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND = errorIter++;
    public final static int CLIENT_NOT_FOUND = errorIter++;
    public final static int CLIENT_HAVE_VISIT_AT_GIVEN_DATE = errorIter++;
}
