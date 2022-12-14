package com.example.customcontentprovider

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.contentValuesOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var helper = MyHelper(applicationContext)
        var db: SQLiteDatabase = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM SIDDESH", null)
//        if(rs.moveToFirst()){
//            Toast.makeText(applicationContext, rs.getString(1)+"\n"+rs.getString(2), Toast.LENGTH_LONG).show()
//        }


//        var rs = contentResolver.query(AcronymProvider.CONTENT_URI,
//            arrayOf(AcronymProvider._ID, AcronymProvider.NAME, AcronymProvider.MEANING),
//            null, null, null)

        val buttonNext = findViewById<Button>(R.id.button)
        val buttonClear = findViewById<Button>(R.id.button6)
        val buttonPrevious = findViewById<Button>(R.id.button2)
        val buttonInsert = findViewById<Button>(R.id.button3)
        val buttonUpdate = findViewById<Button>(R.id.button4)
        val buttonDelete = findViewById<Button>(R.id.button5)






        val editText: EditText = findViewById(R.id.editText)
        val editText2: EditText = findViewById(R.id.editText2)

        buttonNext.setOnClickListener{
            if(rs?.moveToNext() == true && rs != null){
                editText.setText(rs.getString(1))
                editText2.setText(rs.getString(2))


            }else if(rs?.moveToNext()==false){
                Toast.makeText(this, "You have reached the end of Database", Toast.LENGTH_LONG).show()
            }
        }

        buttonClear.setOnClickListener{
            editText.setText("")
            editText2.setText("")
            editText.requestFocus()

        }

        buttonPrevious.setOnClickListener{
            if(rs?.moveToPrevious()!!){
                editText.setText(rs.getString(1))
                editText2.setText(rs.getString(2))
            }else if(rs?.moveToPrevious()==false){
                Toast.makeText(this, "You have reached the start of Database", Toast.LENGTH_SHORT).show()
            }
        }
        buttonInsert.setOnClickListener{
            var cv = ContentValues()
            cv.put(AcronymProvider.NAME, editText.text.toString())
            cv.put(AcronymProvider.MEANING, editText2.text.toString())
            contentResolver.insert(AcronymProvider.CONTENT_URI, cv)
            rs.requery()
            Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show()

        }

        buttonUpdate.setOnClickListener{
            var cv = ContentValues()
            cv.put(AcronymProvider.MEANING, editText2.toString())
            contentResolver.update(AcronymProvider.CONTENT_URI,cv, "NAME=?", arrayOf(editText.text.toString()))
            rs?.requery()
            Toast.makeText(this, "Data Updated", Toast.LENGTH_LONG).show()
        }

        buttonDelete.setOnClickListener{
            contentResolver.delete(AcronymProvider.CONTENT_URI, "NAME = ?", arrayOf(editText.text.toString()))
            rs?.requery()
            Toast.makeText(this, "Data Deleted", Toast.LENGTH_LONG).show()
        }






    }
}