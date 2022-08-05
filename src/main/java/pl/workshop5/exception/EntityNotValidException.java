package pl.workshop5.exception;

import java.util.Set;

public class EntityNotValidException extends RuntimeException {
    private Set<String> errorList;

    public EntityNotValidException(Set<String> errorList) {
        this.errorList = errorList;
    }

    public void setErrorList(Set<String> errorList) {
        this.errorList = errorList;
    }

    public Set<String> getErrorList() {
        return errorList;
    }
}
