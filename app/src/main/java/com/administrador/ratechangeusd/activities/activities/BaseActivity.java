package com.administrador.ratechangeusd.activities.activities;

/**
 * Created by Administrador on 10/07/2017.
 */

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateFormat;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import com.administrador.ratechangeusd.R;
import com.administrador.ratechangeusd.activities.utils.BaseUtils;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import okhttp3.internal.http.RetryAndFollowUpInterceptor;

/**
 * @author Rony Diaz
 * @version %I, %G
 * @since 1.0
 */
public class BaseActivity extends AppCompatActivity {

    private BaseUtils mSlashBaseUtils;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init base utils
        mSlashBaseUtils = new BaseUtils(BaseActivity.this);
    }

    public ProgressDialog prepareProgressDialog(String message, boolean indeterminate, boolean cancelable) {
        ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage(message);
        progress.setCancelable(cancelable);
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(indeterminate);
        progress.setProgress(0);
        return progress;
    }

    /**
     * Muestra un progress dialog que puede ser cancelable o no
     *
     * @param cancelable
     */
    public void showProgressDialog(boolean cancelable) {
        mSlashBaseUtils.showProgressDialog(cancelable);
    }

    /**
     * Oculta el progress dialog si se está mostrando
     */
    public void hideProgressDialog() {
        mSlashBaseUtils.hideProgressDialog();
    }

    /**
     * Muestra un dialogo con el mensaje pasado por parametro
     *
     * @param message
     */
    public void showMessageDialog(String message) {
        mSlashBaseUtils.showMessageDialog(null, message, true);
    }

    /**
     * Muestra un dialogo con el mensaje pasado por parametro
     *
     * @param message
     * @param cancelable
     */
    protected void showMessageDialog(String message, boolean cancelable) {
        mSlashBaseUtils.showMessageDialog(null, message, cancelable);
    }

    /**
     * Muestra un dialogo con el titulo y mensaje pasado por parametro
     *
     * @param title
     * @param message
     * @param cancelable
     */
    public void showMessageDialog(String title, String message, boolean cancelable) {
        mSlashBaseUtils.showMessageDialog(title, message, cancelable);
    }

    /**
     * Ocultar el mensaje
     */
    public void hideMessageDialog() {
        mSlashBaseUtils.hideMessageDialog();
    }

    /**
     * Oculta el teclado del editText pasado por parámetro en caso de que esté abierto
     *
     * @param editText
     */
    protected void hideKeyboard(EditText editText) {
        mSlashBaseUtils.hideKeyboard(editText);
    }

    public void openActivity(Class<?> calledActivity) {
        Intent myIntent = new Intent(this, calledActivity);
        this.startActivity(myIntent);
    }

    public void openActivity(Class<?> calledActivity, Bundle bundle) {
        Intent myIntent = new Intent(this, calledActivity);
        myIntent.putExtras(bundle);
        this.startActivity(myIntent);
    }

    public void openActivityForResult(int requestCode, Class<?> calledActivity, Bundle bundle) {
        Intent myIntent = new Intent(this, calledActivity);
        myIntent.putExtras(bundle);
        this.startActivityForResult(myIntent, requestCode);
    }

    public void changeColorBarNotification(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(this, color));
        }
    }

   /* public void changeToFragment(Fragment fragment) {
        if (fragment != null) {
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }*/

    public MultiplePermissionsReport reportPermissions;

    public void configPermissions(Activity activity) {

        Dexter.withActivity(activity)
                .withPermissions(
                        Manifest.permission.CAMERA,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                ).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                reportPermissions = report;
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                token.continuePermissionRequest();

            }
        }).check();

    }

    public boolean hasCamera() {
        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)) {

            return true;
        } else {
            return false;
        }
    }


    public ArrayList datesOfInquiries (){
        Integer currenDay;
        Integer currenMont;
        String day;
        String nextDate;
        String currenDate = (DateFormat.format("yyyy-MM-dd", new java.util.Date()).toString());
        ArrayList <String> dates = new ArrayList<>();
        currenDay = Integer.parseInt(currenDate.substring(8, 10));
        currenMont = Integer.parseInt(currenDate.substring(5, 7));
             Calendar cal = Calendar.getInstance();
             cal.set(Calendar.MONTH, currenMont -1);
             cal.set(Calendar.DAY_OF_MONTH,1);
         //    int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
             SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
             for (int i = 0; i < currenDay; i++) {
                 cal.set(Calendar.DAY_OF_MONTH, i + 1);
                 nextDate = df.format(cal.getTime());
                 dates.add(nextDate);
             }

         return dates;
    }

public Double stringNumeric(String symbolvalue)
{
    String doubleValue;
    doubleValue = symbolvalue.substring(7,symbolvalue.length()-1);
    return Double.parseDouble(doubleValue);

}





    public String getAlbumName() {
        return getString(R.string.app_name);
    }

}


