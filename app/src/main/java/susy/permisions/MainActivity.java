package susy.permisions;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final private int REQUEST_PERMISSIONS = 101;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;

        //Request Permissions
        requestPermissions();

    }

    //Method to request permissons
    private void requestPermissions() {
            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.GET_ACCOUNTS,
                        Manifest.permission.READ_CALENDAR,
                        Manifest.permission.READ_SMS},
                REQUEST_PERMISSIONS);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //granted
                    Toast.makeText(context, "Todos los permisos aceptados", Toast.LENGTH_SHORT).show();

                } else {
                    //not granted
                    Toast.makeText(context, "Faltan permisos por aceptar", Toast.LENGTH_SHORT).show();

                }

                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
        }
    }

