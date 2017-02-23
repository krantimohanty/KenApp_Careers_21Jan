package com.swashconvergence.apps.user.Fragment_individual;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageView;

import com.joanzapata.iconify.IconDrawable;
import com.swashconvergence.apps.user.R;
import com.swashconvergence.apps.user.app_util.ValidationUtil;
import com.swashconvergence.apps.user.icon_util.IcoMoonIcons;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Personal extends Fragment {
    private String imgString = "";
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private View rootView;
    private ImageView profile_Pic;
    private AppCompatButton btnNext;
    private AppCompatEditText nameApp,nameGuadian,nameMother,   emailid, editDob, phone, cellular, incpdate;
    private Calendar myCalendar = Calendar.getInstance();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_personal, container, false);
        profile_Pic = (ImageView) rootView.findViewById(R.id.profilepic);
        profile_Pic.setImageDrawable(new IconDrawable(getActivity(), IcoMoonIcons.ic_user)
                .colorRes(R.color.white)
                .sizePx(70));
        profile_Pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });


        nameApp = (AppCompatEditText) rootView.findViewById(R.id.name_applicant);
        ValidationUtil.removeWhiteSpaceFromFront(nameApp);
        nameApp.setFilters(new InputFilter[]{ValidationUtil.filter});
        nameApp.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        nameApp.setLongClickable(false);


        nameGuadian = (AppCompatEditText) rootView.findViewById(R.id.name_guardian);
        ValidationUtil.removeWhiteSpaceFromFront(nameGuadian);
        nameGuadian.setFilters(new InputFilter[]{ValidationUtil.filter});
        nameGuadian.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        nameGuadian.setLongClickable(false);

        nameMother = (AppCompatEditText) rootView.findViewById(R.id.name_mother);
        ValidationUtil.removeWhiteSpaceFromFront(nameMother);
        nameMother.setFilters(new InputFilter[]{ValidationUtil.filter});
        nameMother.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
        nameMother.setLongClickable(false);


        editDob = (AppCompatEditText) rootView.findViewById(R.id.dob);
        editDob.setKeyListener(null);
        editDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getActivity(), date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

//        btnNext=(AppCompatButton)rootView.findViewById(R.id.next);
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Contact fragmentTwo = new Contact();
////
////                fragmentTransaction.replace(R.id.frameLayoutFragmentContainer, fragmentTwo);
////                fragmentTransaction.addToBackStack(null);
////
////                fragmentTransaction.commit();
//            }
//        });
//
        return  rootView;
    }
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    private void updateLabel() {
        String myFormat = "MM/dd/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat);
        editDob.setText(sdf.format(myCalendar.getTime()));
    }
    //getting profile pic
    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Gallery",
                "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Select File"),
                            SELECT_FILE);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);

        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");

        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        profile_Pic.setImageBitmap(thumbnail);

        imgString = getImageString(thumbnail);
    }

    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] projection = {MediaStore.MediaColumns.DATA};
        Cursor cursor = this.getActivity().managedQuery(selectedImageUri, projection, null, null,
                null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();

        String selectedImagePath = cursor.getString(column_index);

        Bitmap bm;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(selectedImagePath, options);
        final int REQUIRED_SIZE = 200;
        int scale = 1;
        while (options.outWidth / scale / 2 >= REQUIRED_SIZE
                && options.outHeight / scale / 2 >= REQUIRED_SIZE)
            scale *= 2;
        options.inSampleSize = scale;
        options.inJustDecodeBounds = false;
        bm = BitmapFactory.decodeFile(selectedImagePath, options);

        profile_Pic.setImageBitmap(bm);
        imgString = getImageString(bm);
    }
    //converting bitmap to base64 string
    private String getImageString(Bitmap bm) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String img = Base64.encodeToString(byteArray, Base64.DEFAULT);
        return img;
    }
}

