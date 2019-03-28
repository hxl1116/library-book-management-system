package Responses;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Parent class for all response objects.
 * Provides a parent class for generic deserialization.
 *
 * @author Henry Larson
 */
public abstract class LibraryResponse implements Serializable {
    public abstract String toString();
}
