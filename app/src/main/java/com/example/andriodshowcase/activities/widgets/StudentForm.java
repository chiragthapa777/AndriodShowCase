package com.example.andriodshowcase.activities.widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.andriodshowcase.R;

public class StudentForm extends AppCompatActivity {
    TextView result;
    EditText edtTxtName;
    CheckBox cbJava, cbJs;
    Button btnSubmit;
    Spinner spFaculty;
    RadioGroup rgGender;
    RadioButton rbMale, rbFemale;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_form);

        edtTxtName = findViewById(R.id.edit_txt_name);
        cbJava = findViewById(R.id.checkbox_java);
        cbJs = findViewById(R.id.checkbox_js);
        btnSubmit = findViewById(R.id.btn_submit);
        spFaculty = findViewById(R.id.select_faculty);
        rgGender = findViewById(R.id.radio_gender);
        rbMale = findViewById(R.id.rb_male);
        rbFemale = findViewById(R.id.rb_female);
        result = findViewById(R.id.text_result);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResultDetail();
            }
        });
    }

    protected boolean validateForm(){
        if(edtTxtName.getText().toString().trim().length()<=0){
            edtTxtName.setError("Name is required");
            return false;
        }
        if(!cbJava.isChecked() && !cbJs.isChecked()){
            cbJava.setError("Favorite programming language is required is required");
            return false;
        }
        if(!rbMale.isChecked() && !rbFemale.isChecked()){
            rbMale.setError("Gender is required");
            return false;
        }
        return true;
    }

    protected void setResultDetail(){
        if(!validateForm()){
            return;
        }
        String result = "";

        String favPro =cbJs.isChecked() ? "JavaScript " : "";
        favPro += cbJava.isChecked() ? "Java " : "";

        String gender = rbMale.isChecked() ? "Male" : "";
        gender = rbFemale.isChecked() ? "Female" : gender;



        result += "Name  :  "+edtTxtName.getText() + "\n";
        result += "Favorite programming language  :  " + favPro + "\n";
        result += "Gender  :  " + gender + "\n";
        result += "Faculty  :  " + spFaculty.getSelectedItem() + "\n";

        this.result.setText(result);
    }


}