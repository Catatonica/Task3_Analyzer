package analyzer.interactor;

import com.sun.istack.internal.NotNull;

import java.util.List;

/**
 * Is used in Controller class to set parameters we need for analyzing.
 * In our case, it's three-cased switch – OneUser(id), SeveralUsers(ids) and AllUsers.
 *
 * @author Lizaveta Havina
 */
public final class RequestModel {
    private Requested requested;

    public RequestModel(@NotNull final Requested requested) {
        this.requested = requested;
    }

    public Requested getRequested() {
        return requested;
    }

    public void setRequested(@NotNull final Requested requested) {
        this.requested = requested;
    }

    public interface Requested {
        int ONE_USER = 0;
        int SEVERAL_USERS = 1;
        int ALL_USERS = 2;

        int getType();
    }

    public static class OneUser implements Requested {
        private int userId;

        public OneUser(int userId) {
            this.userId = userId;
        }

        @Override
        public int getType() {
            return ONE_USER;
        }

        public int getUserId() {
            return userId;
        }
    }

    public static class SeveralUsers implements Requested {
        private List<Integer> userIds;

        public SeveralUsers(List<Integer> userIds) {
            this.userIds = userIds;
        }

        @Override
        public int getType() {
            return SEVERAL_USERS;
        }

        public List<Integer> getUserIds() {
            return userIds;
        }
    }

    public static class AllUsers implements Requested {
        public AllUsers() {
        }

        @Override
        public int getType() {
            return ALL_USERS;
        }
    }
}
