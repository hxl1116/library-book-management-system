package Responses;

/**
 * LibraryResponse enumeration used for getting LibraryResponse sub-classes.
 *
 * @author Henry Larson
 */
public enum ResponseType {
    BookPurchaseResponse,
    BookStoreSearchResponse,
    BorrowBookResponse,
    QueryBorrowedBooksResponse,
    ReturnBookResponse,
    AdvanceTimeResponse,
    CurrentDateTimeResponse,
    LibraryBookSearchResponse,
    LibraryStatisticsReportResponse,
    BeginVisitResponse,
    EndVisitResponse,
    PayFineResponse,
    RegisterVisitorResponse,
    PartialResponse;
}
