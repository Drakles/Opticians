package pio.visit;

public class VisitErrorCodes {

  private static int errorIter = 0;
  public final static int VISIT_OK = errorIter++;
  public final static int WORKING_DATE_FOR_GIVEN_DOCTOR_NOT_FOUND = errorIter++;
  public final static int VISIT_NOT_IN_RANGE_OF_WORKING_DAY_FOR_GIVEN_DOCTOR = errorIter++;
  public final static int OTHER_VISIT_IN_THIS_TIME_FOUND = errorIter++;
  public final static int CLIENT_HAVE_VISIT_AT_GIVEN_DATE = errorIter++;
}
