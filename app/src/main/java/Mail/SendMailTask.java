package Mail;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class SendMailTask extends AsyncTask {

    private ProgressDialog statusDialog;
    private Activity sendMailActivity;
    public static boolean isMailSend = false;
    public SendMailTask(Activity activity) {
        sendMailActivity = activity;

    }

    protected void onPreExecute() {
        statusDialog = new ProgressDialog(sendMailActivity);
        statusDialog.setMessage("Getting ready...");
        statusDialog.setIndeterminate(false);
        statusDialog.setCancelable(false);
        statusDialog.show();
    }

    @Override
    protected Object doInBackground(Object... args) {
        try {
            isMailSend = false;
            Log.i("SendMailTask", "About to instantiate GMail...");
            publishProgress("Processing input....");
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(), (List) args[2], args[3].toString(),
                    args[4].toString());
            publishProgress("Preparing mail message....");
            androidEmail.createEmailMessage();
            publishProgress("Sending email....");
            isMailSend = false;
            androidEmail.sendEmail();
            isMailSend = true;
            publishProgress("Email Sent.");
            Log.i("SendMailTask", "Mail Sent.");
            isMailSend = true;
        } catch (Exception e) {
            isMailSend = false;
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void onProgressUpdate(Object... values) {
        try {
            statusDialog.setMessage(values[0].toString());
        } catch (Exception e) {
            isMailSend = false;
        }
    }

    @Override
    public void onPostExecute(Object result) {
        statusDialog.dismiss();
    }

}
