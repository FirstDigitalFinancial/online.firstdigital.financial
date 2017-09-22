package financial.firstdigital.online.model;

import java.util.List;

/**
 * The GenericJsonResponse class.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2017-09-10
 */
public class GenericJsonResponse<T> extends JsonResponse {

    private List<T> result;

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "GenericJsonResponse{" +
                "status=" + super.getStatus() +
                ", result=" + result +
                ", message='" + super.getMessage() +
                '}';
    }
}