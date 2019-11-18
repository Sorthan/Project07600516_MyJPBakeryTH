package su.ac.th.projectmyjpbakeryth.USERdb;

import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

public class USERRepository {
    private Context mContext;

    public USERRepository(Context mContext) {
        this.mContext = mContext;
    }

    public void getUser(Callback callback) {
        GetTask getTask = new GetTask(mContext, callback);
        getTask.execute();
    }

    public void insertUser(UserClass user, InsertCallback callback) {
        InsertTask insertTask = new InsertTask(mContext, callback);
        insertTask.execute(user);
    }

    private static class GetTask extends AsyncTask<Void, Void, List<UserClass>> {

        private Context mContext;
        private Callback mCallback;

        public GetTask(Context context, Callback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected List<UserClass> doInBackground(Void... voids) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            List<UserClass> usernameList = db.userDao().getAllUser();
            return usernameList;
        }

        @Override
        protected void onPostExecute(List<UserClass> userList) {
            super.onPostExecute(userList);

            mCallback.onGetLedger(userList);
        }
    }

    public interface Callback {
        void onGetLedger(List<UserClass> userList);
    }

    private static class InsertTask extends AsyncTask<UserClass, Void, Void> {

        private Context mContext;
        private InsertCallback mCallback;

        public InsertTask(Context context, InsertCallback callback) {
            this.mContext = context;
            this.mCallback = callback;
        }

        @Override
        protected Void doInBackground(UserClass... UserLists) {
            AppDatabase db = AppDatabase.getInstance(mContext);
            db.userDao().insertUser(UserLists[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mCallback.onInsertSuccess();
        }
    }

    public interface InsertCallback {
        void onInsertSuccess();
    }
}

