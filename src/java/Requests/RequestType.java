package Requests;

/**
 * LibraryRequest enumeration used for getting LibraryRequest sub-classes.
 *
 * @author Henry Larson
 */
public enum RequestType {
    BookPurchaseRequest,
    BookStoreSearchRequest,
    BorrowBookRequest,
    QueryBorrowedBooksRequest,
    ReturnBookRequest,
    AdvanceTimeRequest,
    CurrentDateTimeRequest,
    LibraryBookSearchRequest,
    LibraryStatisticsReportRequest,
    BeginVisitRequest,
    EndVisitRequest,
    PayFineRequest,
    RegisterVisitorRequest,
    PartialRequest;
}
