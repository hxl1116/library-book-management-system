package Requests;

import Responses.LibraryResponse;

import java.io.Serializable;

/**
 * Parent class for all request objects.
 * Provides a parent class for generic deserialization.
 *
 * @author Henry Larson
 */
public abstract class LibraryRequest implements Serializable {
    public abstract LibraryResponse execute();
}
